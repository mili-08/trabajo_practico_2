package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
	private DecimalFormat decimalFormato = new DecimalFormat("#,###.00");
	
	@Override
	public void realizarPago(double monto) {
	 this.montoPagado=(monto*0.15)+monto;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\n---- RECIBO DE COMPRA ----\n");
		System.out.println("Número de tarjeta: " + this.numeroTarjeta);
		System.out.println("Fecha de pago: " + this.fechaPago.format(formato));
		System.out.println("Monto Pagado: " + decimalFormato.format(this.montoPagado));
		System.out.println("\n-------------------------------\n");
	}
	
	public PagoTarjeta() {
		
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPago) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPago;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPago() {
		return montoPagado;
	}

	public void setMontoPago(double montoPago) {
		this.montoPagado = montoPago;
	}

	@Override
	public String toString() {
		return "PagoTarjeta [numeroTarjeta=" + numeroTarjeta + ", fechaPago=" + fechaPago + ", montoPago=" + montoPagado
				+ "]";
	}
	
	

}
