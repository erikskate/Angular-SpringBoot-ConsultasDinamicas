package com.coches.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modelo.class)
public abstract class Modelo_ {

	public static volatile SingularAttribute<Modelo, Marca> marca;
	public static volatile SetAttribute<Modelo, Coche> coches;
	public static volatile SingularAttribute<Modelo, Long> id;
	public static volatile SingularAttribute<Modelo, String> nombre;

	public static final String MARCA = "marca";
	public static final String COCHES = "coches";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

}

