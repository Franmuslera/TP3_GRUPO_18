package Ejercicio1;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Archivo archivo = new Archivo();
        archivo.setRuta("Personas.txt"); 
        
        // Leemos las personas del archivo
        Set<Persona> personasLeidas = archivo.leePersonas();

        // Ordenar por apellido usando el TreeSet(usamos el compareTo de Persona)
        Set<Persona> personasOrdenadas = new TreeSet<>(personasLeidas);

        // Leemos y mostramos las personas validas y ordenadas
        for (Persona persona : personasOrdenadas) {
            System.out.println(persona);
        }
        //Escribimos las personas ordenadas, en el archivo "Resultado.txt"
        Archivo.escribirPersonas(personasOrdenadas, "Resultado.txt");
    }
}
