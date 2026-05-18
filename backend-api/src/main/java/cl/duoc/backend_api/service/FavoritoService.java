package cl.duoc.backend_api.service;

import cl.duoc.backend_api.model.Favorito;
import cl.duoc.backend_api.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;
//Leemos todo
    public List<Favorito> listarTodos() {
        return favoritoRepository.findAll();
    }
//Buscamos solo con el id
    public Favorito buscarPorId(Long id){
        var resultado = favoritoRepository.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }else{
            return null;
        }
    }
//Aqui se crea otrp favorito    
    public Favorito guardar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }
//y se elimina aqui el favorito
    public void eliminar(Long id){
        favoritoRepository.deleteById(id);
    }

}
