package br.com.casa_do_codigo.casa_do_codigo.validators;

import br.com.casa_do_codigo.casa_do_codigo.repository.CountryRepository;
import br.com.casa_do_codigo.casa_do_codigo.requisicoes.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueStateValidator implements ConstraintValidator<UniqueState, EstadoRequest> {
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public boolean isValid(EstadoRequest value, ConstraintValidatorContext context) {
        return !countryRepository.existsByIdAndEstadoNome(value.getIdPais(), value.getNome());

    }
}
