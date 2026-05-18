package cl.duoc.backend_api.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productoId;
    private String nombreProducto;
    private Double precio;

    
}
