package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoSalvaje salvaje = new FelinoSalvaje("tarner", (byte)20, 186f);
		if (Converter.isNotNull(salvaje)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico domestico = converter.convert(salvaje);
			converter.mostrarObjeto(domestico);
		}else 
			System.out.println("\n----- El objeto es nulo ------\n");
	}

}
