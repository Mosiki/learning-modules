package pw.nullpointer.example;

import lombok.Data;

/**
 * @author WeJan
 * @since 2020-05-14
 */
@Data
public class Result<T> {
    private T data;
    private boolean success;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }
}
