package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
	private Integer codigo;
	private String descripcion;
	private Double precio;
	private OrigenDeFabricacion origenFabricacion;
	private Categoria categoria;
	private boolean estado;
	
	public enum OrigenDeFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto() {
		
	}

	public Producto(Integer codigo, String descripcion, Double precio, OrigenDeFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + "\nDescripcion: " + descripcion + "\nPrecio: " + precio
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
