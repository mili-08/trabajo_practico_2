package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenDeFabricacion;

public class Main {

	private static Scanner sc;
	private static List<Producto> productos;
	private static Consumer<Producto> printConsumer = p -> System.out.println(p + "\n---------------------------------------\n");
   
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String op="";
		precargarProductos();
		do
		{
			op=menu();
			opciones(op);
		}while(!op.equals("7"));
		
		sc.close();
	}
	
	public static void precargarProductos() {
		if(productos==null) {
			productos = new ArrayList<>();
		}
		productos.add(new Producto(1, "Heladera Samsung", 1535000.0, OrigenDeFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(2, "Televisor LG", 120000.0, OrigenDeFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(3, "Lavadora Whirlpool", 95000.0, OrigenDeFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(4, "Aire Panasonic", 85000.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(5, "Taladro Makita", 250090.0, OrigenDeFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(6, "Sierra Bosch", 186700.0, OrigenDeFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(7, "Destornillador Stanley", 98000.0, OrigenDeFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto(8, "Martillo Stanley", 834000.0, OrigenDeFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(9, "iPhone 15 Pro", 232400.0, OrigenDeFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(10, "Samsung Galaxy S22 Ultra", 190300.0, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto(11, "LG Lavadora de Carga Frontal", 89219.99, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(12, "Xiaomi Mi 12", 350450.80, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(13, "Philips Aspiradora sin Bolsa", 143229.50, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto(14, "MacBook Pro 2024", 280310.20, OrigenDeFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto(15, "Dell XPS 17", 233100.20, OrigenDeFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
	}
	
	public static String menu() {
		System.out.println("=========== Menu ============\n");
		System.out.println("1- Mostrar productos");
		System.out.println("2- Mostrar productos sin stock");
		System.out.println("3- Incrementar los precios en un 20%");
		System.out.println("4- Mostrar los productos que corresponden a la categoría Electrohogar y tengan stock");
		System.out.println("5- Ordenar por precio de forma descendente");
		System.out.println("6- Mostrar los productos con los nombres en mayúsculas");
		System.out.println("7- Salir");
		System.out.print("\nElegir un opcion: ");
		return sc.next();
	}
	
	public static void opciones(String op) {
		switch (op) {
		case "1":mostrarProductos();break;
		case "2":mostrarProductosSinStock();break;
		case "3":incremetarPrecios();break;
		case "4":mostrarProductoEspecifico();break;
		case "5":ordernarDescendente();break;
		case "6":mostrarProductosNombresMayus();break;
		case "7":System.out.println("\n---- Fin del Programa ------\n");break;
		default:
			System.out.println("\n----- Opcion Invalida ------\n");
		}
	}
	
	public static void mostrarProductos() {
		System.out.println("\n--------- Productos con Stock -------------\n");
		productos.forEach(printConsumer);
		System.out.println("\n--------------------------------------------\n");
	}
	
	public static void mostrarProductosSinStock() {
		System.out.println("\n--------- Productos sin Stock -------------\n");
		Predicate<Producto> filterProductoSinStock = p -> !p.isEstado();
		productos.stream().filter(filterProductoSinStock).forEach(printConsumer);;
		System.out.println("\n--------------------------------------------\n");
	}
	
	public static void incremetarPrecios() {
		System.out.println("\n--------- Productos Incrementados -------------\n");
		List<Producto> productosIncrementados = new ArrayList<>();
		Function<Producto, Producto> funcionAumentarPrecio = (p) -> {
			p.setPrecio(p.getPrecio()+(p.getPrecio()*0.20));
			return p;
		};
	   productosIncrementados = productos.stream().map(funcionAumentarPrecio).collect(Collectors.toList());
	   productosIncrementados.forEach(printConsumer);
	   System.out.println("\n--------------------------------------------\n");
	}

	public static void mostrarProductoEspecifico() {
		System.out.println("\n--------- Productos Electrohogar -------------\n");
		Predicate<Producto> filterProductoElectrohogar = p -> (p.getCategoria().equals(Producto.Categoria.ELECTROHOGAR) && p.isEstado());
		productos.stream().filter(filterProductoElectrohogar).forEach(printConsumer);
		System.out.println("\n--------------------------------------------\n");
	}
	
	public static void ordernarDescendente() {
		System.out.println("\n--------- Ordenados Descendentemente -------------\n");
		 productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
		 productos.forEach(printConsumer);
	     System.out.println("\n--------------------------------------------\n");
	}
	
	public static void mostrarProductosNombresMayus() {
		System.out.println("\n--------- Productos Nombres con Mayusula -------------\n");
		Function<Producto, Producto> funcionMayuscula = (p) -> {
			p.setDescripcion(p.getDescripcion().toUpperCase());
			return p;
		};
		productos.stream().map(funcionMayuscula).forEach(printConsumer);
		System.out.println("\n--------------------------------------------\n");
	}
}
