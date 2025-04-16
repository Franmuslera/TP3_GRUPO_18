package Ejercicio1;

import java.io.IOException;

public class DniInvalido extends IOException{
	
	public DniInvalido() {}
	
	@Override
	public String getMessage() {
		return "El DNI ingresado es Invalido";
	}

	   public static void verificarDniInvalido(String dni) throws DniInvalido {
	        if (!dni.matches("\\d{8}")) {
	            throw new DniInvalido();
	        }
	    }
}
