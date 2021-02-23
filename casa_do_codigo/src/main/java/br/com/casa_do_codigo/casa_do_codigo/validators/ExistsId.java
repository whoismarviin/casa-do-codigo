package br.com.casa_do_codigo.casa_do_codigo.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsIdValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {
    String message() default "O elemento em questão possui um id";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
