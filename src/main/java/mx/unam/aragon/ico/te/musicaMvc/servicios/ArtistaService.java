package mx.unam.aragon.ico.te.musicaMvc.servicios;

import mx.unam.aragon.ico.te.musicaMvc.modelos.Artista;
import mx.unam.aragon.ico.te.musicaMvc.repositorios.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public boolean guardarArtista(Artista artista){
        Artista result = artistaRepository.save(artista);
        return result != null;
    }
    public Artista getArtista(Integer id){
        return artistaRepository.getById(id);
    }
}
