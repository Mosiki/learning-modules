package pw.nullpointer.validator.handler;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pw.nullpointer.validator.vo.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WeJan
 * @since 2020-02-04
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result validateErrorHandler(BindException e) {
        ObjectError error = e.getAllErrors().get(0);
        return Result.fail(error.getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<?> validateErrorHandler(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return Result.fail(error.getDefaultMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result<?> handleException(HttpServletRequest request, Throwable ex) {
        return Result.fail(ex.getMessage());
    }
}
