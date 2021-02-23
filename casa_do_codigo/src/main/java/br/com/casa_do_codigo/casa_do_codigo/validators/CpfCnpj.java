package br.com.casa_do_codigo.casa_do_codigo.validators;


import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@CPF
@CNPJ
@Documented
public @interface CpfCnpj {
    String message() default "Cpf/Cnpj invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
