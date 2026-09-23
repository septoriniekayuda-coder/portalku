package id.ac.polinema.lumajang.portalku.pengumuman;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pengumuman") // Semua URL akan diawali dengan ini
@RequiredArgsConstructor
public class PengumumanController {

    private final PengumumanService pengumumanService;

    // Menangani HTTP GET ke /api/pengumuman
    @GetMapping
    public List<PengumumanDto> ambilSemua() {
        return pengumumanService.cariSemua(); // Mengembalikan List DTO ke klien
    }

    // Menangani HTTP POST ke /api/pengumuman
    @PostMapping
    public void tambah(@RequestBody Pengumuman pengumuman) {
        pengumumanService.tambah(pengumuman);
    }

    // Menangani HTTP DELETE ke /api/pengumuman/{id}
    @DeleteMapping("/{id}")
    public void hapus(@PathVariable Integer id) {
        pengumumanService.hapus(id);
    }
}