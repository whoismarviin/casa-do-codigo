package br.com.casa_do_codigo.casa_do_codigo.validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueValuesValidator implements ConstraintValidator<UniqueValues, Object> {

    @PersistenceContext
    EntityManager manager;

    private List<String> fields;
    private List<String> aliases;
    private Class<?> klass;


    @Override
    public void initialize(UniqueValues constraintAnnotation) {
        fields = Arrays.asList(constraintAnnotation.fields());
        aliases = Arrays.asList(constraintAnnotation.aliases());
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String stringQuery = queryBuilder();

        Query query = manager.createQuery(stringQuery);

        for (int i =0 ; i < aliases.size();i++){
            query.setParameter(fields.get(i),
                    new BeanWrapperImpl(value).getPropertyValue(fields.get(i)));

        }

        return query.getResultList().isEmpty();


    }

    private String queryBuilder(){
        String filter= IntStream.range(0, aliases.size())
                .mapToObj(i -> " and " + aliases.get(i) + " = :" + fields.get(i))
                .collect(Collectors.joining())
                .replaceFirst("and", "where");

        return "select e from " +klass.getName() + filter;

    }
}
