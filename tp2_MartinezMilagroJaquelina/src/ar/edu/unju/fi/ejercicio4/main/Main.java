package ar.edu.unju.fi.ejercicio4.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	private static List<Jugador> jugadores;
	private static Scanner sc = new Scanner(System.in);
	private static String[] vector;

	public static void main(String[] args) {
     jugadores= new ArrayList<>();
		String rta = "";
		do {
			rta = menu();
			opciones(rta);
		} while (!rta.equals("5"));
		sc.close();
	}
	
	public static String menu() {
		System.out.println("**** MENU ******\n");
		System.out.println("1- Alta de Jugador");
		System.out.println("2- Mostrar todos los jugadores");
		System.out.println("3- Modificar la posicion de un jugador");
		System.out.println("4- Eliminar un jugador");
		System.out.println("5- Salir");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
	
	public static void opciones(String rta) {
		vector = new String[2];
		switch (rta) {
		case "1": agregarJugador();break;
		case "2": mostrarJugadores();break;
		case "3": modificarJugador();break;
		case "4": eliminarJugador();break;
		case "5": System.out.println("\n----- FIN DEL PROGRAMA ------\n");break;
		default:
			System.err.println("Opcion Invalida");
		}
	}
	
	public static void agregarJugador() {
		Jugador jugador = new Jugador();
		System.out.println("\n===== ALTA DE USUARIOS =======");
		jugador.cargarJugador();
		if(jugadores.add(jugador))
			System.out.println("\n ---- ALTA EXITOSA ----\n");
		else
			System.out.println("\n ---- ERROR EN EL ALTA ----\n");
		System.out.println("=================================\n");
	}
   
	public static void mostrarJugadores() {
		if (!jugadores.isEmpty()) {
			System.out.println("\n======= JUGADORES TOTALES =======\n");
			jugadores.forEach(jug -> System.out.println(jug + "\n-----------------------------\n"));
			System.out.println("===============================\n");
		}else 
			System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
	}
	
	public static void modificarJugador() {
		boolean band;
		if (!jugadores.isEmpty()) {
			band=false;
			System.out.println("\n===== MODIFICAR JUGADOR =====\n");
			ingresarNombreApellido();
			for(Jugador jug:jugadores) {
				if(jug.getNombre().equals(vector[0]) && jug.getApellido().equals(vector[1])) {
					jug.verificarPosicion();
					band=true;
					System.out.println("\n---- DATOS ACTULIZADOS -----\n");
					break;
				}
			}
			if(!band)
				System.out.println("\n--- NO HAY REGISTRO DE " + vector[1] + ", " + vector[0] + "-----\n");
			System.out.println("\n=====================================\n");	
		}else 
			System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
	}
	
	
	public static void ingresarNombreApellido() {
		sc.nextLine();
		System.out.print("Ingrese el nombre: ");
		vector[0] =  sc.nextLine();
		System.out.print("Ingrese el apellido: ");
		vector[1] = sc.nextLine();
	}
	
	public static void eliminarJugador() {
		if(!jugadores.isEmpty()) {
			boolean band=false;
			System.out.println("\n===== ELIMINAR JUGADOR =====\n");
			ingresarNombreApellido();
			Iterator<Jugador> iterator = jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador jug =iterator.next();
				if (jug.getNombre().equals(vector[0]) && jug.getApellido().equals(vector[1])) {
                     iterator.remove();
                     System.out.println("\n---- BORRADO CON EXITO ----\n");
 					  band=true;
 					  break;
				}
			}
			if(!band)
				System.out.println("\n--- NO HAY REGISTRO DE " + vector[1] + ", " + vector[0] + "-----\n");
			System.out.println("\n==============================\n");
		}else 
			System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");	
	}
}
