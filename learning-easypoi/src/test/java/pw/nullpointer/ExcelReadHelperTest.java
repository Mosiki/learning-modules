package pw.nullpointer;

import org.junit.Assert;
import org.junit.Test;
import pw.nullpointer.easypoi.utils.ExcelReadHelper;

import java.io.InputStream;

/**
 * @author WeJan
 * @since 2020-08-21
 */
public class ExcelReadHelperTest {

    @Test
    public void testImport() {
        InputStream in = getClass().getResourceAsStream("/excel/示例Excel3.xlsx");
        ExcelReadHelper readHelper = new ExcelReadHelper(in);
        String b4 = readHelper.getValueAt("B", 4);
        String c23 = readHelper.getValueAt("C", 23);
        String c24 = readHelper.getValueAt("C", 24);
        String m4 = readHelper.getValueAt("M", 4);
        String m5 = readHelper.getValueAt("M", 5);
        Assert.assertEquals("一众科技有限公司", b4);
        Assert.assertEquals("13112345678", c23);
        Assert.assertEquals("370827198801021000", c24);
        Assert.assertEquals("XH-HZHY-20170504", m4);
        Assert.assertEquals("2017.5.4", m5);
        readHelper.close();
    }

}
