package ar.edu.unju.fi.ejercicio6.interfaces.funcionales;


@FunctionalInterface
public interface Converter<T, T1> {
	T1 convert(T t);

}
