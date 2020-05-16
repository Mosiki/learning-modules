package pw.nullpointer.boot.autoconfigure.date;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WeJan
 * @since 2020-05-14
 */
@ConfigurationProperties("common.date-format")
public class DateFormatProperties {

    /**
     * Date Format Pattern
     */
    private String datePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * LocalDateTime Format Pattern
     */
    private String localDateTimePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * LocalDate Format Pattern
     */
    private String localDatePattern = "yyyy-MM-dd";

    /**
     * LocalTime Format Pattern
     */
    private String localTimePattern = "HH:mm:ss";

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public String getLocalDateTimePattern() {
        return localDateTimePattern;
    }

    public void setLocalDateTimePattern(String localDateTimePattern) {
        this.localDateTimePattern = localDateTimePattern;
    }

    public String getLocalDatePattern() {
        return localDatePattern;
    }

    public void setLocalDatePattern(String localDatePattern) {
        this.localDatePattern = localDatePattern;
    }

    public String getLocalTimePattern() {
        return localTimePattern;
    }

    public void setLocalTimePattern(String localTimePattern) {
        this.localTimePattern = localTimePattern;
    }

}
