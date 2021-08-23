package br.com.totemti.livraria.repositories;

import br.com.totemti.livraria.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
