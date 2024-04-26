package ar.edu.unju.fi.ejercicio4.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Double estatura;
	private Double peso;
	private Posicion posicion;
	
	private Scanner sc = new Scanner(System.in);
	private DateTimeFormatter fomato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Jugador() {
		
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Double estatura,
			Double peso, Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nApellido: " + apellido + "\nFecha de Nacimiento: " + fechaNacimiento.format(fomato)
				+ "\nEdad: " +this.calcularEdad()+ " años\nNacionalidad: " + nacionalidad + "\nEstatura: " + estatura + " cm\nPeso: " + peso + " kg\nPosicion: "
				+ posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		return Period.between(this.fechaNacimiento, hoy ).getYears();
	}
	
	public LocalDate verificarFecha () {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.now();
		boolean band;
		do
		{
			band=false;
			System.out.print("Ingrese la fecha de Nacimiento con este formato 'dd/mm/yyyy': ");
			try {
				fecha = LocalDate.parse(sc.next(),formato);
				sc.nextLine();
				band=true;
			}catch (DateTimeException e) {
				System.out.println("\n---- INVALIDO, debe ser este formato 'dd/mm/yyyy' -----\n");
				sc.nextLine();
			}
		}while(!band);	
		return fecha;
	}
	
	
	public Double verificarDouble (String cadena) {
		Double valor = 0.0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese" + cadena);
			try {
				valor=sc.nextDouble();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n----  Debe ser un valor decimal -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	public void verificarPosicion() {
		boolean band;
		Integer posicion=0;
		do
		{
			band=false;
			System.out.println("\n--- POSICIONES ------\n");
			System.out.println("1- Delantero\n2- Medio\n3- Defensa\n4- Arquero");
			System.out.print("\nElegir el numero de la posicion: ");
			try {
				posicion=sc.nextInt();
				sc.nextLine();
				band=posicion>=1 && posicion<=4;
				if(!band)
					System.out.println("\n---- Valor Invalido, elija una posicion valida -----");
			} catch (InputMismatchException e) {
				System.out.println("\n---- Valor Invalido, elija una posicion valida -----");
				sc.next();
			}
		}while(!band);
		this.setPosicion(Posicion.values()[posicion-1]);   //Coloca el valor correspondiente segun el numero ingresado -1 
	}
	
	public String verificarNoNulo(String cadena) {
		String valor="";
		do
		{
			System.out.print(cadena);
			valor=sc.nextLine();
			if(valor.isBlank())
				System.out.println("\n--- Complete el campo ------\n");
		}while(valor.isBlank());
		return valor;
	}
	
	public void cargarJugador() {
		this.setNombre(verificarNoNulo("\nIngrese el nombre: "));
		this.setApellido(verificarNoNulo("Ingrese el apellido: "));
		this.setFechaNacimiento(verificarFecha());
		this.setNacionalidad(verificarNoNulo("Ingrese la nacionalidad: "));
		this.setEstatura(verificarDouble(" la estatura: "));
		this.setPeso(verificarDouble(" el peso: "));
		verificarPosicion();
	}
}
