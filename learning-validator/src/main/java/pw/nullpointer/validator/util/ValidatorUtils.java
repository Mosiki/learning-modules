package pw.nullpointer.validator.util;

import org.hibernate.validator.HibernateValidator;
import pw.nullpointer.validator.handler.ApiException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * <p>
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws ApiException 校验不通过，则报ApiException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws ApiException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            constraintViolations.stream().findFirst()
                    .map(ConstraintViolation::getMessage)
                    .ifPresent(v1 -> {
                        throw new ApiException(v1);
                    });
        }
    }

}
