package id.ac.polinema.lumajang.portalku.kategori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Integer> {
}