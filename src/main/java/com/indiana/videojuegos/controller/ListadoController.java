package com.indiana.videojuegos.controller;

import com.indiana.videojuegos.domain.Videojuego;
import com.indiana.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Controllers: atienden a las peticiones del navegador.

@Controller
public class ListadoController {

    private final VideojuegoService videojuegoService;

    public ListadoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    //Esta clase listará a los videojuegos a mostrar.
    //Crear método que procese la URL e indicarle con una anotación @RequestMapping que este método atiende cierta dirección.

    //El método que estoy indicando debajo va a atender a las peticiones que vengan a la raíz:

    @RequestMapping("/")
    public String listarVideojuegos(Model model){
        //Este método devolverá un string que será el nombre de la vista, o sea, la página a la cual va a redirigir luego de realizar el procesamiento.
        //Búsqueda de los videojuegos

        //Vamos a crear la página que va a ser un template, es decir, no solo va a renderizar HTML sino que, vía Thymeleaf, generará HTML de forma dinámica, es decir que creará listas que cambien y se reflejen los cambios en el contenido HTML. Para esto, voy a resources -> templates y creo listado.html

    //Haré que el Controller se comunique con una clase de negocio llamada Service y esta resuelva la búsqueda de videojuegos.

        //
        List<Videojuego> destacados = videojuegoService.buscarDestacados();

        //Agregar lista para pasársela a la vista. Al modelo, le creamos un atributo "videojuegos" que contiene a la lista de destacados que salió de una búsqueda en el service. Thymeleaf nos permite usar los atributos que subamos al modelo para renderizar HTML.
        model.addAttribute("videojuegos", destacados);

        return "listado";
    }


    // localhost:8080/videojuegosPorDistribuidor?distribuidorId=1
    @RequestMapping("/videojuegosPorDistribuidor")
    public String listarVideojuegosPorDistribuidor(int distribuidorId, Model model){
        List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }

    // localhost:8080/buscar?consulta=border
    // localhost:8080/buscar?q=border
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model){
        List<Videojuego> juegos = videojuegoService.buscar(consulta);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }

}
