package com.coches.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Marca.class)
public abstract class Marca_ {

	public static volatile SingularAttribute<Marca, Long> id;
	public static volatile SetAttribute<Marca, Modelo> modelos;
	public static volatile SingularAttribute<Marca, String> nombre;

	public static final String ID = "id";
	public static final String MODELOS = "modelos";
	public static final String NOMBRE = "nombre";

}

