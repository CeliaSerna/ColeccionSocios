package com.cursoceat.modell;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class Socios implements Comparable<Socios>, Serializable{

	protected String nombre;
	protected String dni;
	protected LocalDate fechaAlta;
	
	public Socios(String nombre, String dni, String fechaAlta) {
		
		this.nombre = nombre;
		this.dni = dni;
		DateTimeFormatter f= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.fechaAlta =LocalDate.parse(fechaAlta, f);
		
	}
	public Socios (String dni) {
		this.dni=dni;
	}
	//metodo antigüedad
	
	public int antiguedad() {
		
		//devuelve el calculo
		return (int)this.fechaAlta.until(LocalDate.now(), ChronoUnit.YEARS);
		
		
	}


	@Override
	public int compareTo(Socios o) {
		
		return this.dni.compareTo(o.dni);
	}
	
	//metodo manual
	@Override
	 public boolean equals(Object obj) {
		 return dni.equals(((Socios)obj).dni);

	}
	@Override
	public String toString() {
		return "Socio [Nombre= " + nombre + ", DNI= " + dni + ", Fecha de Alta= " + fechaAlta + ", Antiguedad= "
				+ antiguedad() + " años]\n";
	}





}
