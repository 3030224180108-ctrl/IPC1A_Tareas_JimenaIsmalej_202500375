
package practica_1_202500375;
import java.util.Scanner;
/**
 *
 * @author ismal
 */
public class Practica_1_202500375 {

    
    public static void main(String[] args) {
        // En esta parte declarare las variables que utilizare durante mi practica
        String nombre;
        Scanner teclado = new Scanner(System.in);
        String placa;
        
        //mensaje de bienvenida
        System.out.println("¡¡Bienvenidos a mi parqueo!!");
        System.out.println("¿Me puedes brindar tu nombre?");
        nombre = teclado.nextLine();
        //Debo asegurarme que el formato de la placa sea "P###LLL"
        do {
    System.out.println("¿Me puedes brindar tu número de placa? Por favor sigue el formato P###LLL");
    placa = teclado.nextLine().toUpperCase();

    if (!placa.matches("P[0-9]{3}[A-Z]{3}")) {
        System.out.println("El formato que ingresó es incorrecto");
    }

} while (!placa.matches("P[0-9]{3}[A-Z]{3}"));
        
    }
    
}
