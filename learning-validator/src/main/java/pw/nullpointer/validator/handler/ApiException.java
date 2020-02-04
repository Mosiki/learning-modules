package pw.nullpointer.validator.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WeJan
 * @since 2020-02-04
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException{
    private String message;
}


