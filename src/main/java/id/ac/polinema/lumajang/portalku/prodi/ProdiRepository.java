package id.ac.polinema.lumajang.portalku.prodi;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProdiRepository extends JpaRepository<Prodi, Integer> {
    Optional<Prodi> findByKode(String kode);
}