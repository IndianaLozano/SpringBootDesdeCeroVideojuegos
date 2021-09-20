package com.indiana.videojuegos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Crearemos una página que liste videojuegos.
//1) Lograremos que el navegador acceda a nuestra aplicación mediante una URL.
//2) Una clase en Java procesa esa URL para, por ejemplo, crear objetos.
//3) Pase esos objetos a una página que los va a mostrar.
@SpringBootApplication
public class VideojuegosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideojuegosApplication.class, args);
    }

}
