
package sistemanotas;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class SistemaNotas {

        // Método recursivo para sumar las notas.
    // En cada llamada se suma la última nota disponible y el método
    // se vuelve a llamar con una cantidad menor hasta llegar a 0.
    public static double sumarNotasRecursivo(double[] notas, int cantidad) {

        if (cantidad == 0) {
            return 0;
        }

        return notas[cantidad - 1] + sumarNotasRecursivo(notas, cantidad - 1);
    }
  
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
        double temporal;
        String nombreTemporal;
        double sumaNotas= 0;
        
        
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
                    System.out.println("Estudiante ingresado :"
                            + nombreEstudiante);
                    System.out.println("Nota ingresada:"+ textoNota);
                    //se empieza el try and catch, para identificar si el dormato es correcto 
                    try{
                        Nota= Double.parseDouble(textoNota);
                        
                        if (Nota>=0 && Nota<=100){
                        System.out.println("Formato correcto");
                        
                        nombres[cantidadEstudiantes]= nombreEstudiante;
                        notas[cantidadEstudiantes]= Nota;
                        cantidadEstudiantes++;
                        }else{
                        System.out.println("la nota debe estar entre 0 y 100");
                        }
                    }catch (NumberFormatException e){
                    System.out.println("La nota debe ser un numero valido");
                    }
                   break;
             
                case 2:
                    if (cantidadEstudiantes == 0){
                        System.out.println("No hay estudiantes registrados");
                       break;
                    }
                    // inicio del Bubble sort
                    //funciona recorriendo y comparando el arreglo
                    // nos ayuda a ordenar las notas y los estudiantes de mayor a menor 
                    for (int i =0; i< cantidadEstudiantes -1; i++){
                        for (int j=0; j < cantidadEstudiantes -1 -i; j++){
                            if (notas [j]< notas [j+1]){
                                double notaTemporal = notas [j];
                                notas[j]= notas [j+1];
                                notas[j+1]= notaTemporal;
                                nombreTemporal = nombres [j];
                               nombres[j]= nombres [j+1];
                               nombres [j+1] = nombreTemporal;
                                
                                }
                            }
                        }
                    for (int i = 0; i < cantidadEstudiantes; i++) {
                                    System.out.println((i + 1) + ". " + nombres[i] + " - " + notas[i]);
                    }
               
                    
                    break;
                    
                
                    case 3:
    if (cantidadEstudiantes == 0) {
        System.out.println("No hay estudiantes registrados");
        break;
    }
//
    sumaNotas = sumarNotasRecursivo(notas, cantidadEstudiantes);

    double promedio = sumaNotas / cantidadEstudiantes;

    System.out.println("Promedio del grupo: " + promedio);

    break;
               
                case 4:
                    if (cantidadEstudiantes ==0){
                        System.out.println("No hay estudiantes registrados");
                        break;
                        
                    }
                    try{
                        
                        PrintWriter archivo = new PrintWriter("estudiantes.txt");
                        
                        for ( int i = 0; i < cantidadEstudiantes; i++ ){
                        archivo.println(nombres[i]+ "," + notas [i]);
                    }
                        archivo.close();
                        System.out.println("Datos guardados correctamente");
                    }catch (Exception e){
                        System.out.println("Error al guardar los datos");
                        
                    }
                    
                    break;
                
                case 5:
       
    try {
        Scanner archivo = new Scanner(new File("estudiantes.txt"));

        cantidadEstudiantes = 0;

        while (archivo.hasNextLine()) {

            String linea = archivo.nextLine();
            String[] datos = linea.split(",");

            nombres[cantidadEstudiantes] = datos[0];
            notas[cantidadEstudiantes] = Double.parseDouble(datos[1]);

            cantidadEstudiantes++;
        }

        archivo.close();

        System.out.println("Datos cargados correctamente");

    } catch (Exception e) {
        System.out.println("Error al cargar los datos");
    }

    
                
                    break;
                  
                case 6:
                    
    System.out.println("Gracias por utilizar el sistema de notas");
    System.out.println("Hasta pronto");
    break;
                    
                   
                
                
            
    }
        }while (opcion !=6);
             
        
        
    }
    }
    

