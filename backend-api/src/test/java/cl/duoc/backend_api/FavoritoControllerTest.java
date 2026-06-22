package cl.duoc.backend_api;

import cl.duoc.backend_api.controller.FavoritoController;
import cl.duoc.backend_api.model.Favorito;
import cl.duoc.backend_api.service.FavoritoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FavoritoController.class)
public class FavoritoControllerTest {

    @Autowired
    private MockMvc mockMvc;

  @MockBean
    private FavoritoService favoritoService;

    @Test
    public void testCrearFavoritoExitoso() throws Exception {
        Favorito favorito = new Favorito();
        favorito.setId(1L);

        Mockito.when(favoritoService.guardar(Mockito.any(Favorito.class))).thenReturn(favorito);
        mockMvc.perform(post("/favorito")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1}"))
                .andExpect(status().isOk());
    }
}