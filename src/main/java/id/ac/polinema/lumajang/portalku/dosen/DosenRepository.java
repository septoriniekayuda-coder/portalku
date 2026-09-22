package id.ac.polinema.lumajang.portalku.dosen;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DosenRepository extends JpaRepository<Dosen, Integer> {
    Optional<Dosen> findByNip(String nip);
}
