package cl.duoc.backend_api.controller;

import cl.duoc.backend_api.model.Favorito;
import cl.duoc.backend_api.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/favorito")
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public List<Favorito> obtenerTodos() {
        return favoritoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> obtenerPorId(@PathVariable Long id){
            Favorito fav = favoritoService.buscarPorId(id);
            if(fav != null){
                return ResponseEntity.ok(fav);
            } else{
                return ResponseEntity.notFound().build();
            }
    }
    @PostMapping
    public Favorito crear(@RequestBody Favorito favorito){
        return favoritoService.guardar(favorito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        favoritoService.eliminar(id);
        return ResponseEntity.ok(" Eliminado correctamente ");
    }
}