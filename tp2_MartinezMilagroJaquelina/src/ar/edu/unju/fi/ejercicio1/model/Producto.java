package ar.edu.unju.fi.ejercicio1.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Producto {
	private Integer codigo;
	private String descripcion;
	private Double precio;
	private OrigenDeFabricacion origenFabricacion;
	private Categoria categoria;
	
	private Scanner sc = new Scanner(System.in);
	
	private enum OrigenDeFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	private enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
		
	}

	public Producto(Integer codigo, String descripcion, Double precio, OrigenDeFabricacion origenFabricacion,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	

	@Override
	public String toString() {
		return "Codigo: " + codigo + "\nDscripcion: " + descripcion + "\nPrecio: " + precio
				+ "\nOrigen de Fabricacion: " + origenFabricacion + "\nCategoria: " + categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public OrigenDeFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenDeFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * 
	 * @param "cadena" es el valor para completar la oracion de ingreso
	 * @return el un valor de codigo valido 
	 */
	
	public Integer verificarValorEntero (String cadena) {
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
	
	/**
	 * 
	 * @return el valor del precio valido
	 */
	
	public Double verificarPrecio () {
		Double valor = 0.0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese el precio: " );
			try {
				valor=sc.nextDouble();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- El precio debe ser un valor decimal -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	/**
	 * Verifica que el valor que elija el usuario se un valor valido dentro de los
	 * posibles valores del enumerado
	 * @return "valor" el numero correcto de acuerdo a la opcion señalada
	 */
	
	public Integer obtenerOrigenFabricacion () {
		boolean band;
		Integer valor=0;
		do
		{
			band=false;
			System.out.println("\n------ Origen de Fabricacion -----\n");
			System.out.println("1- Argentina");
			System.out.println("2- China");
			System.out.println("3- Brasil");
			System.out.println("4- Uruguay");
			System.out.print("\nElegir una opcion: ");
			try {
				valor=sc.nextInt();
				sc.nextLine();
				if (!(valor > 0 && valor <= 4)) {
					System.out.println("\n----- Valor invalido ------\n");
					band=false;
				}else 
					band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- Valor invalido, elija una opcion correcta ------\n");
			    sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	
	public Integer obtenerCategoria () {
		boolean band;
		Integer valor=0;
		do
		{
			band=false;
			System.out.println("\n------ Categoria -----\n");
			System.out.println("1- Telefónia");
			System.out.println("2- Informatica");
			System.out.println("3- Electro Hogar");
			System.out.println("4- Herramientas");
			System.out.print("\nElegir una opcion: ");
			try {
				valor=sc.nextInt();
				sc.nextLine();
				if (!(valor > 0 && valor <= 4)) {
					System.out.println("\n----- Valor invalido ------\n");
					band=false;
				}
				else 
					band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- Valor invalido, elija una opcion correcta ------\n");
			    sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	/**
	 * Se encarga de cargar el objeto producto;
	 */
	
	public void cargarProducto () {
		Integer valor;
	    System.out.println("Ingrese la descripcion: ");
	    this.setDescripcion(sc.nextLine());
	    this.setPrecio(verificarPrecio());
	    valor=obtenerOrigenFabricacion();
	    this.setOrigenFabricacion(valor == 1 ? origenFabricacion.ARGENTINA : valor ==2 ? origenFabricacion.CHINA   // asigna el valor al atributo origen de fabricacion
	    	: valor ==3 ? origenFabricacion.BRASIL : origenFabricacion.URUGUAY);
	    valor=obtenerCategoria();
	    this.setCategoria(valor==1 ? categoria.TELEFONIA : valor==2 ? categoria.INFORMATICA : valor==3 ? categoria.ELECTROHOGAR : categoria.HERRAMIENTAS);
	}
	
	public String menuModificar () {
		System.out.println("\n\n---- MENU DE MODIFICACIONES -----\n");
		System.out.println("1- Descripcion");
		System.out.println("2- Precio Unitario");
		System.out.println("3- Origen de Fabricacion");
		System.out.println("4- Categoria");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
	
	public void opcionesModificaciones() {
		String op=menuModificar();
		Integer valor=0;
		switch (op) {
		case "1": 
			sc.nextLine();
			System.out.println("Ingrese la descripcion: ");
		    this.setDescripcion(sc.nextLine());
			break;
		case "2": this.setPrecio(verificarPrecio()); break;
		case "3": 
			valor=obtenerOrigenFabricacion();
		    this.setOrigenFabricacion(valor == 1 ? origenFabricacion.ARGENTINA : valor ==2 ? origenFabricacion.CHINA  
		    	: valor ==3 ? origenFabricacion.BRASIL : origenFabricacion.URUGUAY);	
			break;
		case "4":
			valor=obtenerCategoria();
		    this.setCategoria(valor==1 ? categoria.TELEFONIA : valor==2 ? categoria.INFORMATICA : valor==3 ? categoria.ELECTROHOGAR : categoria.HERRAMIENTAS);
			break;
		default:
			System.err.println("\n------ Opcion Invalida --------\n");
		}
	}

}
