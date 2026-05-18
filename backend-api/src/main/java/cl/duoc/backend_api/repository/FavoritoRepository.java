package cl.duoc.backend_api.repository;

import cl.duoc.backend_api.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
}