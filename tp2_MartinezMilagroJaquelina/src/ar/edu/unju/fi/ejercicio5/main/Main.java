package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenDeFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;


public class Main {
	
	private static List<Producto> productos;
	private static Scanner sc;

	public static void main(String[] args) {
	sc=new Scanner(System.in);
	precargarProductos();
	String op ="";
	do
	{
		op=menu();
		opciones(op);
	}while(!op.equals("3"));
	
	sc.close();

	}
	
	public static void precargarProductos() {
		if(productos==null) {
			productos = new ArrayList<>();
		}
		productos.add(new Producto(1, "Heladera Samsung", 1535000.0, OrigenDeFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(2, "Televisor LG", 120000.0, OrigenDeFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(3, "Lavadora Whirlpool", 95000.0, OrigenDeFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(4, "Aire Panasonic", 85000.0, OrigenDeFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto(5, "Taladro Makita", 250090.0, OrigenDeFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(6, "Sierra Bosch", 186700.0, OrigenDeFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(7, "Destornillador Stanley", 98000.0, OrigenDeFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto(8, "Martillo Stanley", 834000.0, OrigenDeFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(9, "iPhone 15 Pro", 232400.0, OrigenDeFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(10, "Samsung Galaxy S22 Ultra", 190300.0, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto(11, "Google Pixel 7", 153890.99, OrigenDeFabricacion.ARGENTINA, Categoria.TELEFONIA, false));
		productos.add(new Producto(12, "Xiaomi Mi 12", 350450.80, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(13, "Huawei P50 Pro", 170320.20, OrigenDeFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(14, "MacBook Pro 2024", 280310.20, OrigenDeFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto(15, "Dell XPS 17", 233100.20, OrigenDeFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
	}
	
	public static String menu () {
		System.out.println("------ 	MENU ---------\n");
		System.out.println("1- Mostrar Productos\n2- Realizar Compra\n3- Salir");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
	
	public static void opciones(String op) {
		switch (op) {
		case "1":mostrarProductos();break;
		case "2":comprarProductos();break;
		case "3":System.out.println("\n------ FIN DEL PROGRAMA ------------\n");break;
		default:
			System.err.println("\n------ Opcion Invalida ------\n");
		}
	}
	
	public static void mostrarProductos() {
		if (!productos.isEmpty()) {
			System.out.println("====== PRODUCTOS ======");
			for (Producto p: productos)
				System.out.println(p + "\n--------------------------------\n");
			System.out.println("=======================");
		}else 
			System.out.println("\n----- No hay productos cargados --------\n");
	}
	
	public static void comprarProductos() {
		List<Producto> productosSeleccionados = new ArrayList<>();
		String rta="";
		do
		{
			Integer codigo = verificarCodigo("\nIngrese el codigo del producto: ", 15);
			for(Producto p:productos) {
				if(p.getCodigo()==codigo) {
					if(verificarStock(p.isEstado())) {
						productosSeleccionados.add(p);
						System.out.println("\n----- Producto agregado al carrito -----\n");
					}else
						System.out.println("\n----- El producto selecionado no tiene stock ------\n");
					break;
				}
			}
			System.out.print("Desea agregar un producto S/N: ");
			rta=sc.next();
		}while(rta.toUpperCase().equals("S"));
		int valor=0;
		do
		{
			double totalCompra = resumenCompra(productosSeleccionados);
			valor=verificarCodigo("\n1- Realizar Pago\n2- Eliminar producto del carrito: \n\nElegir una opcion: ", 2);
	        switch (valor) {
				case 1: realizarPago(totalCompra);break;
				case 2: eliminarProductoCarrito(productosSeleccionados);break;
				default:
			     System.err.println("\n----  Opcion Invalida  -----\n");
		   }
		}while(valor!=1);
	}
	
	public static Integer verificarCodigo(String cadena, int numero) {
		Integer valor=0;
		boolean band;
		do
		{
			band=false;
			System.out.print(cadena);
			try {
				valor=sc.nextInt();
				sc.nextLine();
				band=valor>=1 && valor<=numero;
				if(!band)
				 System.out.println("\n---- El valor debe ser un valor numerico menor o igual que " + numero + " ------\n");
			} catch (InputMismatchException e) {
				System.out.println("\n---- El valor debe ser un valor numerico ------\n");
				sc.next();
			}
		}while(!band);
		
		return valor;
	}
	
	/**
	 * VERIFICA SI EL PRODUCTO SELECIONADO TIENE O NO STOCK
	 * @param stock es un boolean que deriva del produccto selecionado
	 * @return boolean que determina si el producto puede cargarse 
	 */
	public static boolean verificarStock(boolean stock) {
		return stock==true;
	}
	
	public static double resumenCompra(List<Producto> productosS) {
		double valor=0;
		System.out.println("\n------ Carrito de Compra ------\n");
		System.out.println("Cod        Descripcion                 Precio\n");
		for(Producto p: productosS) {
			//System.out.println(p.getCodigo() +"     "+ p.getDescripcion() + "                    $" + p.getPrecio());
			System.out.printf("%-7d %-30s $%,.2f%n", p.getCodigo(), p.getDescripcion(), p.getPrecio());  //alternatica mas optima
			valor=valor+p.getPrecio();
		}
		System.out.printf("\nTotal: $%,.2f%n", valor);
		return valor;
	}
	
	public static void  realizarPago(double total) {
		System.out.println("\n---- Metodos de pago ------");
		int valor=verificarCodigo("\n1- Pago Efectivo\n2- Pago con Tarjeta: \n\nElegir una opcion: ", 2);
		switch (valor) {
		case 1: 
			PagoEfectivo pagoEfectivo = new PagoEfectivo(0, LocalDate.now());
			pagoEfectivo.realizarPago(total);
			pagoEfectivo.imprimirRecibo();
			break;
		case 2: 
			PagoTarjeta pagoTarjeta = new PagoTarjeta();
		    System.out.print("Ingrese el numero de tarjeta: ");
		    pagoTarjeta.setNumeroTarjeta(sc.next());
		    pagoTarjeta.setFechaPago(LocalDate.now());
		    pagoTarjeta.setMontoPago(total);
		    pagoTarjeta.imprimirRecibo();
			break;
		default:
			System.out.println("\n---- Opcion Invalida -----\n");
		}
	}
	
	public static void  eliminarProductoCarrito (List<Producto> productosS) {
		boolean band=false;
		Integer codigo = verificarCodigo("Ingrese el codigo del producto a eliminar: ", 15);
		Iterator<Producto> iterator = productosS.iterator();
		 while(iterator.hasNext()) {
			 Producto p = iterator.next();
			 if(p.getCodigo() == codigo) {
				 iterator.remove();
				 System.out.println("\n--- Eliminado con exito del carrito---\n");
				 band=true;
				 break;
			 }
		 }
		 if(!band)
			 System.out.println("\n----- No existe el producto en el carrito ------\n");
	}

}



///verificar que muestra el true  o false cuadno se imprime
//hacer un buen resumen de la compra
