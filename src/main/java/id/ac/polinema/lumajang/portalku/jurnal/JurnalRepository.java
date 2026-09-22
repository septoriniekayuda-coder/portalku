package id.ac.polinema.lumajang.portalku.jurnal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JurnalRepository extends JpaRepository<Jurnal, Integer> {
    List<Jurnal> findByPenerbit(String penerbit);
    List<Jurnal> findByJudulContainingIgnoreCase(String katakunci);
}