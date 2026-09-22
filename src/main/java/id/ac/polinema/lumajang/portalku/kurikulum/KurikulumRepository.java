package id.ac.polinema.lumajang.portalku.kurikulum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface KurikulumRepository extends JpaRepository<Kurikulum, Integer> {
    List<Kurikulum> findByProdiId(Integer idProdi);

    @Query("SELECT k FROM Kurikulum k JOIN FETCH k.prodi")
    List<Kurikulum> findAllWithProdi();
}
