package com.coches.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coches.backend.model.Marca;
import com.coches.backend.service.MarcaService;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/list")

    public ResponseEntity<List<Marca>> list(){
        List<Marca> list = marcaService.findAll();
        return new ResponseEntity<List<Marca>>(list,HttpStatus.OK);
    }
}
