
package sistemanotas;
import java.util.Scanner;

public class SistemaNotas {

  
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        String nombreUsuario;
        double Nota; 
        int opcion;
        String nombreEstudiante;
        String textoNota;
        String[] nombres = new String[50];
        double[] notas = new double[50];
        int cantidadEstudiantes = 0;  
        
        System.out.println("Bienvenido al sistema de notas");
        System.out.println("puedes ingresar tu nombre");
        nombreUsuario = entrada.nextLine();
        System.out.println("Bienvenido  "+ nombreUsuario);
        do{
            System.out.println("======Sistema de notas=======");
            System.out.println("1. Ingreso de estudiante");
            System.out.println("2. Mostrar estudiantes, por nota");
            System.out.println("3. calculo de promedio grupal");
            System.out.println("4. Guardar datos");
            System.out.println("5. Cargar datos");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opcion:");
            opcion= entrada.nextInt();
            entrada.nextLine();
            
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    nombreEstudiante=entrada.nextLine();
                    System.out.println(" Ingrese la nota del estudiante");
                   
                    textoNota=entrada.nextLine();
                    System.out.println("Estudiante ingresado y nota :"
                            + nombreEstudiante);
                    System.out.println("Nota ingresada:"+ textoNota);
                    //se empieza el try and catch, para identificar si el dormato es correcto 
                    try{
                        Nota= Double.parseDouble(textoNota);
                        
                        if (Nota>=0 && Nota<=100){
                        System.out.println("Formato correcto");
                        }else{
                        System.out.println("La nota debe ser entre 0 y 100");
                        nombres[cantidadEstudiantes]= nombreEstudiante;
                        notas[cantidadEstudiantes]= cantidadEstudiantes;
                        cantidadEstudiantes++;
                        }
                    }catch (NumberFormatException e){
                    System.out.println("La nota debe ser un numero valido");
                    }
                   break;
                    
                           
                    
                case 2:
               
                    
                    break;
                    
                case 3:
                    
                    break;
               
                case 4:
                    
                    break;
                
                case 5:
                
                    break;
                  
                case 6:
                    
                    break;
                
                
            
    }
        }while (opcion !=6);
            
        
        
    }
    }
    

