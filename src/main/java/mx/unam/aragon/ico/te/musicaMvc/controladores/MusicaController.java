package mx.unam.aragon.ico.te.musicaMvc.controladores;

import mx.unam.aragon.ico.te.musicaMvc.modelos.Artista;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tienda/")
public class MusicaController {
    @GetMapping("/home/")
    public String home(){
        return "home";
    }

    @GetMapping("/artista/")
    public String artista(Model model){
        Artista artista = new Artista(1,"Bad bunny","Reggeton",30,"mejor del genero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQr1Is12nqfQESLkC8eHesrar1Jy5AUaMFiRQ&s");
        model.addAttribute("artista",artista);
        return "artista";
    }
}
