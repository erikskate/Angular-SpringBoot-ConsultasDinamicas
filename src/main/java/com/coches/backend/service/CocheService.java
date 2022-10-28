package com.coches.backend.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coches.backend.criteria.CocheCriteria;
import com.coches.backend.model.Coche;
import com.coches.backend.model.Coche_;
import com.coches.backend.model.Marca_;
import com.coches.backend.model.Modelo_;
import com.coches.backend.repository.CocheRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class CocheService extends QueryService<Coche> {
    
    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> findByCriteria(CocheCriteria cocheCriteria){
        final Specification<Coche> specification = createSpecification(cocheCriteria);
        List<Coche> coches = cocheRepository.findAll(specification);
        return coches;
    }

    private Specification<Coche> createSpecification(CocheCriteria criteria){
        Specification<Coche> specification  = Specification.where(null);
        if(criteria != null){
            if(criteria.getVersion() != null){
                specification = specification.and(buildStringSpecification(criteria.getVersion(), Coche_.version));
            }

            if(criteria.getColor() != null){
                specification = specification.and(buildSpecification(criteria.getColor(), Coche_.color));
            }

            if(criteria.getKm() != null){
                specification = specification.and(buildRangeSpecification(criteria.getKm(), Coche_.km));
            }

            if(criteria.getColor() != null){
                specification = specification.and(buildSpecification(criteria.getCambio(), Coche_.cambio));
            }

            if(criteria.getModelo() != null){
                specification = specification.and(buildReferringEntitySpecification(criteria.getModelo(), Coche_.modelo, Modelo_.nombre));
            }

           /*  if(criteria.getModelo() != null){
                specification = specification.and(buildSpecification(criteria.getModelo(),
                                root -> root.join(Coche_.modelo,JoinType.LEFT).get(Modelo_.nombre)));
            } */

            if(criteria.getMarca() != null){
                specification = specification.and(buildSpecification(criteria.getMarca(),
                root -> root.join(Coche_.modelo, JoinType.LEFT)
                            .join(Modelo_.marca, JoinType.LEFT).get(Marca_.nombre)));
            }
        }
        return specification;
    }
}
