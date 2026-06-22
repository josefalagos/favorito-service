package cl.duoc.backend_api.controller;

import cl.duoc.backend_api.model.Favorito;
import cl.duoc.backend_api.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/favorito")
@Tag(name = "Favoritos", description = "API para la gestión de productos favoritos de Amazorg")
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
    @Operation(summary = "Agregar un producto a favoritos", description = "Recibe los datos del producto y lo almacena en la base de datos relacional.")
@ApiResponse(responseCode = "201", description = "Producto agregado a favoritos exitosamente")
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