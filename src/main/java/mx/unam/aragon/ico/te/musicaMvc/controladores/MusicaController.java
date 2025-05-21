package mx.unam.aragon.ico.te.musicaMvc.controladores;

import mx.unam.aragon.ico.te.musicaMvc.modelos.Artista;
import mx.unam.aragon.ico.te.musicaMvc.servicios.ArtistaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tienda/")
public class MusicaController {
    @Autowired
    private ArtistaService artistaService;
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
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("artista", new Artista());
        return "formArtista";
    }
    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Artista artista
    ){
        LoggerFactory.getLogger(getClass()).info("Guardando Artista" + artista);
        //mandarlo a  bd
        artistaService.guardarArtista(artista);
        return "redirect:/tienda/nuevo?exito";
    }

    @GetMapping("/artista/{id}")
    public String artista(@PathVariable Integer id, Model model){
        model.addAttribute("artista",artistaService.getArtista(id));
        return "artista";
    }
}
