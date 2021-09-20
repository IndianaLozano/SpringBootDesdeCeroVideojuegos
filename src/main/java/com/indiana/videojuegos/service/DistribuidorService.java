package com.indiana.videojuegos.service;

import com.indiana.videojuegos.domain.Distribuidor;
import com.indiana.videojuegos.repository.DistribuidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorService {
    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }

    public List<Distribuidor> buscarTodos(){
        return distribuidorRepository.findAll();
    }
}
