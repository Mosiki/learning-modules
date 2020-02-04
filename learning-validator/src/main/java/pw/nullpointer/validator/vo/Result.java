package pw.nullpointer.validator.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeJan
 * @since 2020-02-04
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private T data;
    private boolean success;
    private String msg;

    public static <T> Result<T> success(T data) {
        return new Result<>(data, true, "success");
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(null, false, msg);
    }
}
