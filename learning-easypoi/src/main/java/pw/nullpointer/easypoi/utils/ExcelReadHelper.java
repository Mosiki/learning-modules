package pw.nullpointer.easypoi.utils;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ExcelReadHelper {
    private Workbook workbook;
    private Sheet sheet;
    //Sheet总数
    private int sheetCount;
    //当前行
    private Row row;

    public ExcelReadHelper(InputStream is) {
        try {
            workbook = new XSSFWorkbook(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sheetCount = workbook.getNumberOfSheets();
        setSheetAt(0);
    }

    /**
     * 关闭工作簿
     *
     * @throws IOException
     */
    public void close() {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取单元格真实位置
     *
     * @param row 行索引
     * @param col 列索引
     * @return [行, 列]
     */
    public String getCellLoc(Integer row, Integer col) {
        return String.format("[%s,%s]", row + 1, CellReference.convertNumToColString(col));
    }

    /**
     * 根据标签设置Sheet
     *
     * @param labels
     */
    public void setSheetByLabel(String... labels) {
        Sheet sheet = null;
        for (String label : labels) {
            sheet = workbook.getSheet(label);
            if (sheet != null) {
                break;
            }
        }
        if (sheet == null) {
            StringBuilder sheetStr = new StringBuilder();
            for (String label : labels) {
                sheetStr.append(label).append(",");
            }
            sheetStr.deleteCharAt(sheetStr.lastIndexOf(","));
            throw new RuntimeException(sheetStr.toString() + "Sheet does not exist");
        }
        this.sheet = sheet;
    }

    /**
     * 根据索引设置Sheet
     *
     * @param index
     */
    public void setSheetAt(Integer index) {
        Sheet sheet = workbook.getSheetAt(index);
        if (sheet == null) {
            throw new RuntimeException(index + "Sheet does not exist");
        }
        this.sheet = sheet;
    }

    /**
     * 获取单元格内容并转为String类型
     *
     * @param row     行号，从1开始
     * @param colName 列号
     * @return
     */
    @SuppressWarnings("deprecation")
    public String getValueAt(String colName, int row) {
        int colIdx = CellReference.convertColStringToIndex(colName);
        int rowIdx = row < 0 ? 0 : row - 1;
        Cell cell = sheet.getRow(rowIdx).getCell(colIdx);
        String value = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue() + "";
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        value = cell.getDateCellValue().getTime() + "";
                    } else {
                        DecimalFormat df = new DecimalFormat("0");
                        return df.format(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    value = cell.getNumericCellValue() + "";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue() + "";
                    break;
            }
        }
        return (value == null || value.isEmpty()) ? null : value.trim();
    }

    /**
     * 获取当前行指定列内容
     *
     * @param col 列号，从1开始
     * @return
     */
    public String getValue(Integer col) {
        return getValueAt(CellReference.convertNumToColString(col + 1), col);
    }

    /**
     * 获取Sheet名称
     *
     * @return
     */
    public String getSheetLabel() {
        String label = null;
        if (sheet != null) {
            label = sheet.getSheetName();
        }
        return label;
    }

    /**
     * 行偏移
     *
     * @param offset 偏移量
     * @return
     */
    public Boolean offsetRow(Integer offset) {
        boolean state = true;
        if (row == null) {
            row = sheet.getRow(offset - 1);
        } else {
            row = sheet.getRow(row.getRowNum() + offset);
            if (row == null) {
                state = false;
            }
        }
        return state;
    }

    /**
     * 设置行
     *
     * @param index 索引
     * @return
     */
    public Boolean setRow(Integer index) {
        row = sheet.getRow(index);
        return row != null;
    }

    /**
     * 偏移一行
     *
     * @return
     */
    public Boolean nextRow() {
        return offsetRow(1);
    }

    /**
     * 偏移到下一个Sheet
     *
     * @return
     */
    public Boolean nextSheet() {
        boolean state = true;
        if (sheet == null) {
            sheet = workbook.getSheetAt(0);
        } else {
            int index = workbook.getSheetIndex(sheet) + 1;
            if (index >= sheetCount) {
                sheet = null;
            } else {
                sheet = workbook.getSheetAt(index);
            }

            if (sheet == null) {
                state = false;
            }
        }
        row = null;
        return state;
    }

}