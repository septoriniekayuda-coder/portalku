package id.ac.polinema.lumajang.portalku.pengumuman;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/percobaan")
@RequiredArgsConstructor
public class PercobaanController {

    private final PengumumanRepository pengumumanRepository;

    @GetMapping
    public List<Pengumuman> semua() {
        return pengumumanRepository.findAll(); // sengaja keliru
    }
}