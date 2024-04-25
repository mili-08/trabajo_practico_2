package ar.edu.unju.fi.ejercicio3.main;

import java.text.DecimalFormat;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;


public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Provincia[] provincias = Provincia.values();
		DecimalFormat df = new DecimalFormat("#,###.###");

		System.out.println("============= PROVINCIAS ==============\n");
		for (Provincia p : provincias) {
			System.out.println("Provincia: " + p + "\nCantidad Poblacional: " + df.format(p.getCantidadPoblacion()) + " habitantes");
			System.out.println("Superfice: " + df.format(p.getSuperficie()) + " km2\nDensidad Poblacional: "
					+ df.format(p.densidadPoblacional()) + " habitantes por km2");
			System.out.println("---------------------------------------\n");
		}
		System.out.println("=========================================\n");
		sc.close();
	}

}
