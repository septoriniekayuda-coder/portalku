package id.ac.polinema.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/halo")
public class HaloController {
    @GetMapping
    public String halo() {
        return "Layanan Portalku berjalan.";
    }
}