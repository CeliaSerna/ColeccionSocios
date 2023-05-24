package com.cursoceat.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import com.cursoceat.modell.Socios;
public class Controller {

///////////ACTIVIDAD 12.11///////////////////////
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Socios> miSocios= new TreeSet<>();
		
		//leemos el archivo
		try(ObjectInputStream in= new ObjectInputStream(new FileInputStream("C:\\Users\\PROGRAMACION\\Documentos\\JAVA\\ColeccionSocios\\archivos\\socios.dat"))){
			//vamos a insertar el contenido del archivo en el conjunto socios, si no es de tipo socio
			//con sus datos,daria una excepcion de tipo classNotFound
			miSocios = (TreeSet<Socios>)in.readObject();
		}catch (IOException e ) {
			System.out.println("Error 1 " + e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Error 2 " + e.getMessage());
		}
		
		int opcion =0;
		do {
	
		
		System.out.println("Elija una opción");
		System.out.println("1- Alta socio");
		System.out.println("2- Baja socio");
		System.out.println("3- Modificar socio");
		System.out.println("4- Mostrar socios por dni");
		System.out.println("5- Mostrar socios por antigüedad");
		System.out.println("6- Salir");
		try {
		opcion=new Scanner(System.in).nextInt();
		}catch (Exception e) {
			System.out.println("Opción no válida");
		}
		
		switch(opcion) {
		case 1-> {
			System.out.println("DNI: ");
			String dni= new Scanner(System.in).nextLine().toUpperCase();
			alta(dni, miSocios);
		}
		case 2-> {
			System.out.println("DNI: ");
			String dni= new Scanner(System.in).nextLine().toUpperCase();
			miSocios.remove(new Socios(dni));
			
			
		}
		case 3-> {
			System.out.println("DNI: ");
			String dni= new Scanner(System.in).nextLine().toUpperCase();
			miSocios.remove(new Socios(dni));
			alta(dni, miSocios);
		}
		case 4-> {
			System.out.println((miSocios));
		}
		case 5-> {
			Comparator<Socios> c= new Comparator<>() {
				public int compare(Socios o1, Socios o2) {
					return o1.antiguedad()-o2.antiguedad();
				}
			};
		Set<Socios> e= new TreeSet<>(c);
		e.addAll(miSocios);
			System.out.println(e);
			
		}
		}
		}while(opcion!=6);
		
		try(ObjectOutputStream out = new ObjectOutputStream(new
			FileOutputStream("C:\\Users\\PROGRAMACION\\Documentos\\JAVA\\ColeccionSocios\\archivos\\socios.dat"))){
			out.writeObject(miSocios);
		
		}catch (IOException e) {
			System.out.println("Error 3 "+e.getMessage());
		}
		
	
	
	}
	//metodo para altas
	static boolean alta(String dni, Set<Socios> SociosN) {
		System.out.println("Nombre: ");
		String nombre= new Scanner(System.in).nextLine();
		
		System.out.println("Fecha de alta (dd-mm-yyyy): ");
		String fechaAlta= new Scanner(System.in).nextLine();
		
		Socios nuevo= new Socios(nombre, dni, fechaAlta);
		return SociosN.add(nuevo);
	
	}
	//IMPLEMENTAR QUE LEA EL DNI EN UNA FUNCION APARTE Y SE LLAME CUANDO SEA NECESARIO
	
	
}
