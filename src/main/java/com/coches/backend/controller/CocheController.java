package com.coches.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coches.backend.criteria.CocheCriteria;
import com.coches.backend.dto.BusquedaDTO;
import com.coches.backend.enums.Color;
import com.coches.backend.model.Coche;
import com.coches.backend.service.CocheService;

import antlr.StringUtils;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@RestController
@RequestMapping("/coche")
@CrossOrigin(origins = "http://localhost:4200")
public class CocheController {
    
    @Autowired
    private CocheService cocheService;

    @PostMapping("/list")
    public ResponseEntity<List<Coche>> list(@RequestBody BusquedaDTO busquedaDTO){
        CocheCriteria cocheCriteria = createCriteria(busquedaDTO);
        List<Coche> list = cocheService.findByCriteria(cocheCriteria);

        return new ResponseEntity<List<Coche>>(list, HttpStatus.OK);
    }

    private CocheCriteria createCriteria(BusquedaDTO dto){
        CocheCriteria cocheCriteria = new CocheCriteria();
        if(dto != null){
            if(!org.apache.commons.lang3.StringUtils.isBlank(dto.getMarca())){
                StringFilter filter = new StringFilter();
                filter.setEquals(dto.getMarca());
                cocheCriteria.setMarca(filter);
            }

            if(!org.apache.commons.lang3.StringUtils.isBlank(dto.getModelo())){
                StringFilter filter = new StringFilter();
                filter.setEquals(dto.getModelo());
                cocheCriteria.setModelo(filter);
            }

            if(!org.apache.commons.lang3.StringUtils.isBlank(dto.getVersion())){
                StringFilter filter = new StringFilter();
                filter.setContains(dto.getVersion());
                cocheCriteria.setVersion(filter);
            }
            if(!org.apache.commons.lang3.StringUtils.isBlank(dto.getCambio())){
                BooleanFilter filter = new BooleanFilter();
                switch(dto.getCambio()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);
                }
                cocheCriteria.setCambio(filter);
            }

            if(!org.apache.commons.lang3.StringUtils.isBlank(dto.getColor())){
                CocheCriteria.ColorFilter filter = new CocheCriteria.ColorFilter();
                String color = dto.getColor().toUpperCase();
                filter.setEquals(Color.valueOf(color));
                cocheCriteria.setColor(filter);
            }

            if(dto.getKmDesde() != null ||  dto.getKmHasta() != null){
                IntegerFilter filter = new IntegerFilter();
                if(dto.getKmDesde() != null){
                    filter.setGreaterThanOrEqual(dto.getKmDesde());
                    cocheCriteria.setKm(filter);
                }

                if(dto.getKmHasta() != null){
                    filter.setLessThanOrEqual(dto.getKmHasta());
                    cocheCriteria.setKm(filter);
                }
            }

        }
        return cocheCriteria;
    }
}
