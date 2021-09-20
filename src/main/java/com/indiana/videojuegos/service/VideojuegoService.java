package com.indiana.videojuegos.service;

import com.indiana.videojuegos.domain.Videojuego;
import com.indiana.videojuegos.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideojuegoService {

    private final VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    public List<Videojuego> buscarDestacados(){
        return videojuegoRepository.buscarTodos();
    }

    public List<Videojuego> buscarPorDistribuidor(int distribuidorId){
        return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
    }

    public List<Videojuego> buscar(String consulta){
        return videojuegoRepository.findByNombreContaining(consulta);
    }

    public Videojuego guardarVideojuego(Videojuego videojuego){
        return videojuegoRepository.save(videojuego);
    }
}
