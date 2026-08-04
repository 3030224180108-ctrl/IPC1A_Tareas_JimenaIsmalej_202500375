
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
        
        int valor = 1;
        char seccion;
        double promedio= 0.0;
        boolean datoValido;
        String nombre;
        String carnet;
        Scanner teclado = new Scanner(System.in);
        //en estas lineas estoy imprimiendo un mensaje para solicitarle al usuario sus datos
        
        System.out.println("Ingresa tu nombre");
        nombre = teclado.nextLine();
        System.out.println("Ingresa tu numero de carnet");
        carnet = teclado.nextLine();
        System.out.println("nombre:"+nombre);
        System.out.println("carnet:"+carnet);
        
        
      
    }
    
}

