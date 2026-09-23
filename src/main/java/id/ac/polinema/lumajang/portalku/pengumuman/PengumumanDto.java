package id.ac.polinema.lumajang.portalku.pengumuman;

import lombok.Data;
import java.time.LocalDate;

@Data // Anotasi ini otomatis membuatkan Getter dan Setter
public class PengumumanDto {
    private Integer id;
    private String judul;
    private String isi;
    private LocalDate tanggalTerbit;
    private Integer jumlahDilihat;
    
    // Ini adalah data tambahan yang diminta modul, 
    // yang aslinya tidak ada secara langsung di tabel pengumuman
    private String namaKategori;
    private Integer jumlahLampiran;
}