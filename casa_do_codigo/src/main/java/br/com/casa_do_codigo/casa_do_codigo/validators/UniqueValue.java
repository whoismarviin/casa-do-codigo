package br.com.casa_do_codigo.casa_do_codigo.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "O elemento não é unico";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
