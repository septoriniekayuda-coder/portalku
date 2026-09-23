package id.ac.polinema.lumajang.portalku.pengumuman;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PengumumanService {

    private final PengumumanRepository pengumumanRepository;

    // 1. Operasi BACA
    public List<PengumumanDto> cariSemua() {
        // Ambil data Entity dari database (sudah JOIN FETCH)
        List<Pengumuman> daftarEntity = pengumumanRepository.findAllWithKategori();
        
        // Terjemahkan setiap Entity menjadi DTO menggunakan Stream
        return daftarEntity.stream().map(entitas -> {
            PengumumanDto dto = new PengumumanDto();
            dto.setId(entitas.getId());
            dto.setJudul(entitas.getJudul());
            dto.setIsi(entitas.getIsi());
            dto.setTanggalTerbit(entitas.getTanggalTerbit());
            dto.setJumlahDilihat(entitas.getJumlahDilihat());
            
            // Mengambil nama kategori dari objek Kategori yang terelasi
            dto.setNamaKategori(entitas.getKategori().getNama());
            // Menghitung jumlah lampiran berdasarkan ukuran list lampiran
            dto.setJumlahLampiran(entitas.getDaftarLampiran().size());
            
            return dto;
        }).collect(Collectors.toList());
    }

    // 2. Operasi TAMBAH
    public void tambah(Pengumuman pengumuman) {
        pengumuman.setId(null); 
        pengumumanRepository.save(pengumuman);
    }

    // 3. Operasi HAPUS
    public void hapus(Integer id) {
        // Validasi: Cek dulu apakah datanya ada sebelum dihapus
        if (!pengumumanRepository.existsById(id)) {
            throw new RuntimeException("Pengumuman tidak ditemukan.");
        }
        pengumumanRepository.deleteById(id);
    }
}