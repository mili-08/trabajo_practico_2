package ar.edu.unju.fi.ejercicio2.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private Integer codigo;
	private Mes mes;
	private Integer dia;
	private String detalle;
	
	private Scanner sc = new Scanner(System.in);

	public Efemeride() {
		
	}

	public Efemeride(Integer codigo, Mes mes, Integer dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "\nCodigo: " + codigo + "\nMes: " + mes + "\nDia: " + dia + "\nDetalle: " + detalle;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	/**
	 * Muestra los meses de acuerdo al numero que le corresponde
	 */
	public Integer verificarMes () {
		boolean band;
		Integer valor=0;
		do
		{
			band=false;
			System.out.println("\n.... Meses .....");
			System.out.println("\n1- Enero\n2- Febrero\n3- Marzo\n4- Abril\n5- Mayo\n6- Junio "
					+ "\n7- Julio \n8- Agosto\n9- Septiembre\n10- Octubre\n11- Noviembre\n12- Diciembre");
			System.out.print("\nIngrese el numero del mes: ");
			try {
				valor=sc.nextInt();
				sc.nextLine();
				if(!(valor>0 && valor<=12)) {
					System.out.println("\n----- Mes invalido -----\n");
					band=false;
				}else 
					band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n----- Mes invalido -----\n");
				sc.next();
			}
		}while(!band);
		
	    this.setMes(valor==1 ? mes.ENERO : valor==2 ? mes.FEBRERO : valor==3 ? mes.MARZO : valor==4 ? mes.ABRIL : 
	    	valor==5 ? mes.MAYO : valor==6 ? mes.JUNIO : valor==7 ? mes.JULIO : valor==8 ? mes.AGOSTO : valor==9 ? mes.SEPTIEMBRE :
	    	valor==10 ? mes.OCTUBRE : valor==11 ? mes.NOVIEMBRE : mes.DICIEMBRE);
	   return valor;
	}
	
	/**
	 * 
	 * @param valor el dia ingresado por el usuario
	 * @param numMes el numero de mes cargado
	 * @return un booleano que determina si el dia es valido o no de acuerdo al mes
	 */
	
	public boolean validarDia (Integer valor, Integer numMes) {
		
		if (numMes == 2)
			return valor>=1 && valor<=28;
		else if (numMes==1 || numMes==3 || numMes==5 || numMes==7 || numMes==8 || numMes==10 || numMes==12) 
			return valor>=1 && valor<=31;
		else 
			return valor>=1 && valor<=30;
	}
	
	/**
	 * Permite el ingreso de un valor valido
	 * @return el dia valido
	 */
	
	public Integer verificarValorEntero (Integer numMes) {
		Integer dia = 0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese el dia del efeméride: ");
			try {
				dia=sc.nextInt();
				sc.nextLine();
				band=validarDia(dia, numMes);
				if (!band)
					System.out.println("\n----- El dia " + dia + " es invalido para el mes " + getMes() + "-----\n");
			}catch (InputMismatchException e) {
				System.out.println("\n---- Debe ser un valor entero -----\n");
				sc.nextLine();
			}
		}while(!band);
		return dia;
	}
	
	/**
	 * Cargar el objeto con los datos que se ingresan por consola
	 */
	
	public void cargarEfemeride() {
	   Integer valor=0;
	   valor=verificarMes();
	   this.setDia(verificarValorEntero(valor));
	   System.out.println("Ingrese los detalles: ");
	   this.setDetalle(sc.nextLine());
	}
	
	public String menuModificar() {
	    System.out.println("\n---- MENU DE MODIFICACIONES ----\n");
	    System.out.println("1- Mes\n2- Dia\n3- Detalle");
	    System.out.print("\nElegir una opcion: ");
	    return sc.next();
	}
	
	/**
	 * Permite modificar correctamente los datos de un objeto Efeméride
	 */
	
	public void modificarEfemeride () {
		 String op =menuModificar();
		 Integer valor=0;
		 switch (op) {
		case "1": 
			valor=verificarMes();
			if(!validarDia(this.getDia(),valor)) {   //Verifica si en el mes modificado existe el dia cambiado
				System.out.println("\n---- El dia cargado no existe en el mes modificado, por favor cambie el dia ----\n");
			    this.setDia(verificarValorEntero(valor));
			}
			break;
		case "2": 
			valor=this.getMes().ordinal() +1; // Devuelve el año que ya esta cargado en el objeto
			this.setDia(verificarValorEntero(valor));
			break;
		case "3": 
			sc.nextLine();
			System.out.println("Ingrese el detalle: ");
			this.setDetalle(sc.nextLine());
			break;
		default:
			System.out.println("\n---- Opcion Invalida ----\n");
		}
	}

}
