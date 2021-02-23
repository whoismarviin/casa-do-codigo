package br.com.casa_do_codigo.casa_do_codigo.repository;

import br.com.casa_do_codigo.casa_do_codigo.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Autor, Integer> {
     Optional<Autor>findByEmail(String email);
}
