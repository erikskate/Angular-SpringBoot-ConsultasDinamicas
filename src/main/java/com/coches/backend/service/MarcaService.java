package com.coches.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coches.backend.model.Marca;
import com.coches.backend.repository.MarcaRepository;

@Service
@Transactional(readOnly = true)
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }
}
