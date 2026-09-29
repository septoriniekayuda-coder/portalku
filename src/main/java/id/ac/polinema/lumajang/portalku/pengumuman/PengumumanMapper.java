package id.ac.polinema.lumajang.portalku.pengumuman;

import id.ac.polinema.lumajang.portalku.kategori.Kategori;
import id.ac.polinema.lumajang.portalku.pengumuman.dto.PengumumanRequest;
import id.ac.polinema.lumajang.portalku.pengumuman.dto.PengumumanResponse;
import id.ac.polinema.lumajang.portalku.pengumuman.dto.PengumumanRingkasResponse;
import org.springframework.stereotype.Component;

@Component
public class PengumumanMapper {

    public PengumumanResponse keResponse(Pengumuman p) {
        return new PengumumanResponse(
            p.getId(),
            p.getJudul(),
            p.getIsi(),
            p.getTanggalTerbit(),
            p.getJumlahDilihat(),
            p.getKategori() != null ? p.getKategori().getNama() : null,
            p.getDaftarLampiran() != null ? p.getDaftarLampiran().size() : 0
        );
    }

    public PengumumanRingkasResponse keRingkas(Pengumuman p) {
        return new PengumumanRingkasResponse(
            p.getId(),
            p.getJudul(),
            p.getKategori() != null ? p.getKategori().getNama() : null,
            p.getTanggalTerbit(),
            p.getJumlahDilihat()
        );
    }

    public Pengumuman keEntity(PengumumanRequest req, Kategori kategori) {
        Pengumuman p = new Pengumuman();
        p.setJudul(req.judul());
        p.setIsi(req.isi());
        p.setTanggalTerbit(req.tanggalTerbit());
        p.setKategori(kategori);
        p.setJumlahDilihat(0);
        return p;
    }

    public void terapkan(PengumumanRequest req, Pengumuman p, Kategori kategori) {
        p.setJudul(req.judul());
        p.setIsi(req.isi());
        p.setTanggalTerbit(req.tanggalTerbit());
        p.setKategori(kategori);
    }
}