package id.ac.polinema.lumajang.portalku.pengumuman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import id.ac.polinema.lumajang.portalku.kategori.Kategori;
import id.ac.polinema.lumajang.portalku.prodi.Prodi;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pengumuman")
@Getter
@Setter
@NoArgsConstructor
public class Pengumuman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 200)
    private String judul;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String isi;

    @Column(name = "tanggal_terbit", nullable = false)
    private LocalDate tanggalTerbit;

    @Column(name = "jumlah_dilihat", nullable = false)
    private Integer jumlahDilihat = 0;

    // Relasi ke Kategori (Many-to-One)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_kategori", nullable = false)
    private Kategori kategori;

    // Relasi ke Lampiran (One-to-Many)
    @OneToMany(mappedBy = "pengumuman", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Lampiran> daftarLampiran = new ArrayList<>();

    // Relasi ke Prodi (Many-to-Many)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pengumuman_prodi",
        joinColumns = @JoinColumn(name = "id_pengumuman"),
        inverseJoinColumns = @JoinColumn(name = "id_prodi")
    )
    private Set<Prodi> sasaranProdi = new HashSet<>();

    public void tambahLampiran(Lampiran lampiran) {
        daftarLampiran.add(lampiran);
        lampiran.setPengumuman(this);
    }
}