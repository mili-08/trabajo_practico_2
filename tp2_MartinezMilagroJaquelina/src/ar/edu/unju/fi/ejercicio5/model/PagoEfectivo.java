package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagado;
    private LocalDate fechaPago;
    
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
    private DecimalFormat decimalFormato = new DecimalFormat("#,###.00");
    
    
	@Override
	public void realizarPago(double monto) {
	 this.montoPagado=monto-(monto*0.10);
	}

	@Override
	public void imprimirRecibo() {
	 System.out.println("\n****** RECIBO DE COMPRA *****\n");
	 System.out.println("Fecha de pago: " + this.fechaPago.format(formato));
     System.out.println("Monto Pagado: " + decimalFormato.format(this.montoPagado));
     System.out.println("\n******************************\n");
	}
	
	public PagoEfectivo() {
		
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "PagoEfectivo [montoPagado=" + montoPagado + ", fechaPago=" + fechaPago + "]";
	}
	
	

}
