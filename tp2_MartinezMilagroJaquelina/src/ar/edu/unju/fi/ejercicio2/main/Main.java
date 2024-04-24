package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	private static List<Efemeride> efemerides;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	  efemerides = new ArrayList<>();
	  String op="";
	  do{
		  op=menu();
		  opciones(op);
	  }while(!op.equals("5"));
	  
     sc.close();
	}
	public static String menu() {
		System.out.println("***** MENU ******");
		System.out.println("1- Crear Efeméride");
		System.out.println("2- Mostrar Efemérides");
		System.out.println("3- Eliminar Efeméride");
		System.out.println("4- Modificar Efeméride");
		System.out.println("5- Salir");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
	
	public static void opciones(String op) {
		switch (op) {
		case "1": agregarEfemeride();break;
		case "2": mostrarEfemerides();break;
		case "3": eliminarEfemeride();break;
		case "4": modificarEfemeride();break;
		case "5": System.out.println("\n---- FIN DEL PROGRAMA -----\n");break;
		default:
			System.out.println("\n---- Opcion Invalida -------\n");
		}
	}
	
	public static void agregarEfemeride() {
		Efemeride efemeride = new Efemeride();
		Integer valor=0;
		System.out.println("\n====== ALTA DE EFEMÉRIDES ======\n");
		do
		{
			valor=verificarValorEntero();
			if (buscarCodigo(valor))
				System.out.println("\n--- El codigo ya esta registrado ------\n");
		}while(buscarCodigo(valor));
		efemeride.setCodigo(valor);
		efemeride.cargarEfemeride();
		efemerides.add(efemeride);
		System.out.println("\n------ Carga Exitosa ------");
		System.out.println("\n=================================\n");
	}
	
	public static Integer verificarValorEntero () {
		Integer valor = 0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese el codigo del producto: ");
			try {
				valor=sc.nextInt();
				sc.nextLine();
				band=!(valor<=0);   // No permite el ingreso de codigos menores o iguales a 0
				if(!band)
					System.out.println("\n---- Debe ser un valor entero -----\n");
			}catch (InputMismatchException e) {
				System.out.println("\n---- Debe ser un valor entero -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	public static Boolean buscarCodigo (Integer valor) {
		Boolean band=false;
		for (Efemeride e : efemerides) {
			if(e.getCodigo()==valor) {
				band=true;
				break;
			}
		}
		return band;
	}
	
	public static void mostrarEfemerides () {
		if (!efemerides.isEmpty()) {
			System.out.println("\n===== EFEMÉRIDES CARGADAS =====\n");
			for(Efemeride e : efemerides)
				System.out.println(e + "\n-----------------------------");
			System.out.println("\n======================================\n");
		}else 
			System.out.println("\n---- NO HAY EFEMÉRIDES CARGADAS ------\n");
	}
	
	public static void eliminarEfemeride() {
		if (!efemerides.isEmpty()) {
			System.out.println("\n===== ELIMINAR UN EFEMÉRIDE =======\n");
			boolean band=false;
			Integer valor = verificarValorEntero();
			Iterator<Efemeride> iterator = efemerides.iterator();
			while (iterator.hasNext()) {
				Efemeride ef = iterator.next();
				if (ef.getCodigo() == valor) {
					iterator.remove();
					System.out.println("\n--- Eliminado con exito ---\n");
					band=true;
					break;
				}
			}
			if(!band)
				 System.out.println("\n---- No hay ningun eferméride cargada con el codigo " + valor + " -----\n");
			System.out.println("===========================\n");
		}else 
			System.out.println("\n---- NO HAY EFEMÉRIDES CARGADAS ------\n");
	}
	
	public static void modificarEfemeride() {  
		if (!efemerides.isEmpty()) {
		boolean band=false;
		System.out.println("\n======= MODIFICAR EFEMERIDES =======\n");
		Integer valor = verificarValorEntero();
			for (Efemeride e: efemerides) {
				if(e.getCodigo()==valor) {
					e.modificarEfemeride();
					band=true;
					System.out.println("\n----- Modificado con exito -----\n");
					break;
				}
			}
		 if(!band)
			 System.out.println("\n---- No hay ningun eferméride cargada con el codigo " + valor + " -----\n");
		System.out.println("\n=====================================\n");
		}else 
			System.out.println("\n---- NO HAY EFEMÉRIDES CARGADAS ------\n");
	}

}
