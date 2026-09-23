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
    
    private String namaKategori;
    private Integer jumlahLampiran;
}