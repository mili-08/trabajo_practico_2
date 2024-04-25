package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611, 53219),
	SALTA(1441351, 155488), 
	TUCUMAN(1731820, 22524), 
	CATAMARCA(429562, 102602), 
	LA_RIOJA(383865, 89680), 
	SANTIAGO_DEL_ESTERO(1060906, 136351);
	
	private Integer cantidadPoblacion;
	private Integer superficie;
	
	private Provincia() {
		
	}

	private Provincia(Integer cantidadPoblacion, Integer superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}
	

	public Integer getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(Integer cantidadPoblacion) { //No hace falta los set porque son valores constantes
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) { //No hace falta los set porque son valores constantes
		this.superficie = superficie;
	}

	public Float densidadPoblacional() {
		return (float)this.cantidadPoblacion/(float)this.superficie;
	}
}
