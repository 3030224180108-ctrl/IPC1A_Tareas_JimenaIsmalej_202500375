
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
        System.out.println("¿Me puedes brindar tu numero de placa?");
        placa = teclado.nextLine().toUpperCase();
        System.out.println("nombre:" + nombre);
        System.out.println("placa:"+placa);
        
        
    }
    
}
