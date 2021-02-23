package br.com.casa_do_codigo.casa_do_codigo.repository;

import br.com.casa_do_codigo.casa_do_codigo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country,Long> {
    Boolean existsByIdAndEstadoNome(Long id, String Name);
}
