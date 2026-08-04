
package tarea2;
import java.util.Scanner;
/**
 *
 * @author ismal
 */
public class Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //En estas primeras lineas estoy declarando las variables que utlizare
        
        int cantidadNotas = 5;
        int[] notas = new int[cantidadNotas];
        int suma = 0;
        double promedio = 0.0;
        char seccion;
        boolean datoValido;
        String nombre;
        String carnet;
        Scanner teclado = new Scanner(System.in);
        //en estas lineas estoy imprimiendo un mensaje para solicitarle al usuario sus datos
        
        System.out.println("Ingresa tu nombre");
        nombre = teclado.nextLine();
        System.out.println("Ingresa tu numero de carnet");
        carnet = teclado.nextLine();
        //En estas lineas estoy realizando la operacion para el promedio
        
        for (int i = 0; i < cantidadNotas; i++) {
    System.out.print("Ingresa la nota " + (i + 1) + ": ");
    notas[i] = teclado.nextInt();
        }
        for (int i = 0; i < cantidadNotas; i++) {
        suma = suma + notas[i];
        }
        promedio = (double) suma / cantidadNotas;
        //en estas ultimas lineas estoy imprimiendo los resultados tanto como del promedio realizado como del nombre y carnet 
        System.out.println("El promedio es: " + promedio);
        System.out.println("nombre:"+nombre);
        System.out.println("carnet:"+carnet);
        System.out.println("promedio:"+promedio);
}
}
      
    
    


