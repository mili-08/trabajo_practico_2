package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	
	private static List<Producto> productos;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		productos = new ArrayList<>();
		String op="";
		do
		{
		  op=menu();
		  opciones(op);
		}while(!op.equals("4"));	
		sc.close();
	}
	
	public static String menu () {
		System.out.println("***** MENU ******");
		System.out.println("1- Crear Producto");
		System.out.println("2- Mostrar Productos");
		System.out.println("3- Modificar Producto");
		System.out.println("4- Salir");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
	
	public static void opciones (String op) {
		switch (op) {
		case "1": agregarProducto();break;
		case "2": mostrarProductos();break;
		case "3": modificarProducto();break;
		case "4": System.out.println("\n---- FIN DEL PROGRAMA -------\n");break;
		default:
			System.err.println("\n----- Opcion Invalida ------\n");
		}
	}
	
	public static void agregarProducto() {
		Integer valor=0;
		System.out.println("\n====== ALTA DE PRODUCTOS ======\n");
		Producto producto = new Producto();
		do
		{
			valor=verificarValorEntero(" el codigo del producto: ");
			if (buscarCodigo(valor))
				System.out.println("\n--- El codigo ya esta registrado ------\n");
		}while(buscarCodigo(valor));
		producto.setCodigo(valor);
		producto.cargarProducto();
		productos.add(producto);
		System.out.println("\n------ Producto cargado con exito ------\n");
		System.out.println("=====================================\n");
	}
	
	public static void mostrarProductos() {
		if (!productos.isEmpty()) {
			System.out.println("\n========== PRODUCTOS =========\n");
			for (Producto p: productos)
				System.out.println(p + "\n----------------------------------\n");
			System.out.println("=====================================\n");
		}else 
			System.out.println("\n---- NO HAY PRODUCTOS CARGADOS ------\n");
	}
	
	public static Integer verificarValorEntero (String cadena) {
		Integer valor = 0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese" + cadena);
			try {
				valor=sc.nextInt();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- Debe ser un valor entero -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	public static void  modificarProducto() {
		if (!productos.isEmpty()) {
			System.out.println("\n======== MODIFICAR PRODUCTO =============\n");
			boolean band=false;
			Integer codigo = verificarValorEntero(" el codigo del producto: ");
			for(Producto p : productos) {
				if(p.getCodigo()==codigo) {
					p.opcionesModificaciones();
					System.out.println("\n----- Modificacion Exitosa ------\n");
					band=true;
					break;
				}
			}
		 if (!band) 
			 System.out.println("\n--- No hay registro del producto con codigo "+ codigo + " -----\n");
		System.out.println("================================================\n");
		}else 
			System.out.println("\n---- NO HAY PRODUCTOS CARGADOS ------\n");
	}
	
	public static Boolean buscarCodigo (Integer valor) {
		Boolean band=false;
		for (Producto p : productos) {
			if(p.getCodigo()==valor) {
				band=true;
				break;
			}
		}
		return band;
	}
}
