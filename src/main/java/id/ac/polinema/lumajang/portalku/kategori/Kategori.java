package id.ac.polinema.lumajang.portalku.kategori;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import id.ac.polinema.lumajang.portalku.pengumuman.Pengumuman;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kategori")
@Getter
@Setter
@NoArgsConstructor
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String nama;

    @OneToMany(mappedBy = "kategori", fetch = FetchType.LAZY)
    private List<Pengumuman> daftarPengumuman = new ArrayList<>();
}