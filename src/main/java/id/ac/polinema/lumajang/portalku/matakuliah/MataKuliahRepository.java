package id.ac.polinema.lumajang.portalku.matakuliah;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MataKuliahRepository extends JpaRepository<MataKuliah, Integer> {
    List<MataKuliah> findByKurikulumId(Integer idKurikulum);
}
