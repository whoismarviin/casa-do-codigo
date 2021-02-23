package br.com.casa_do_codigo.casa_do_codigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueStateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueState {

    String message() default "O elemento não é unico";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

}
