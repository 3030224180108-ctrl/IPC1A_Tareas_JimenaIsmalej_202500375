
package tarea2;

import java.util.Scanner;

/*
 * Con este programa pretendo solicitarle a un estudiante 
 * 5 notas para validar si estan en el rango de 0 a 100
 * ver tambien cual fue su nota maxima y la minima 
 * para al final mostrarles una matriz con sus notas 
 */
public class Tarea2 {

    public static void main(String[] args) {

        // En estas primeras lineas estoy declarando las variables que utilizare

        int cantidadNotas = 5;
        int[] notas = new int[cantidadNotas];
        int suma = 0;
        double promedio = 0.0;
        char seccion = ' ';
        boolean datoValido = false;
        String nombre;
        String carnet;

        // AGREGADO: arreglo de dos dimensiones de 2 filas y 3 columnas
        int[][] matrizNotas = new int[2][3];

        Scanner teclado = new Scanner(System.in);

        // En estas lineas estoy imprimiendo un mensaje
        // para solicitarle al usuario sus datos

        System.out.println("Ingresa tu nombre");
        nombre = teclado.nextLine();

        System.out.println("Ingresa tu numero de carnet");
        carnet = teclado.nextLine();

        System.out.print("Ingresa tu seccion: ");
        seccion = teclado.next().charAt(0);

        // En estas lineas estoy solicitando y validando las notas

        for (int i = 0; i < cantidadNotas; i++) {

            System.out.print("Ingresa la nota " + (i + 1) + ": ");

            if (teclado.hasNextInt()) {

                notas[i] = teclado.nextInt();

                datoValido = notas[i] >= 0 && notas[i] <= 100;

                if (datoValido) {
                    System.out.println("Nota correcta.");
                } else {
                    System.out.println(
                            "Error: la nota debe estar entre 0 y 100."
                    );

                    // Permite volver a pedir la misma nota
                    i--;
                }

            } else {
                System.out.println(
                        "Error: debes ingresar un numero entero."
                );

                // Elimina el dato incorrecto ingresado
                teclado.next();

                // Permite volver a pedir la misma nota
                i--;
            }
        }

        // En estas lineas estoy realizando la suma para el promedio

        for (int i = 0; i < cantidadNotas; i++) {
            suma = suma + notas[i];
        }

        promedio = (double) suma / cantidadNotas;

        // En estas lineas estoy imprimiendo los datos del estudiante

        System.out.println("Nombre: " + nombre);
        System.out.println("Seccion ingresada: " + seccion);
        System.out.println("Carnet: " + carnet);
        System.out.println("promedio:"+promedio);

        // AGREGADO: método que muestra máximo, mínimo y promedio
        mostrarAnalisisNotas(notas, promedio);

        // AGREGADO: llenar y mostrar el arreglo de dos dimensiones
        llenarMatriz(teclado, matrizNotas);
        mostrarMatriz(matrizNotas);

        // AGREGADO: cerrar el Scanner al finalizar
        teclado.close();
    }

    /*
     * METODO 1:
     * Con este metodo utilizo el arreglo de una dimension 
     * para poder encontra o distinguir entre la notra maxima y la nota minima .
     * También muestra el promedio calculado en el main.
     */
    public static void mostrarAnalisisNotas(
            int[] notas, double promedio) {

        int notaMaxima = notas[0];
        int notaMinima = notas[0];

        for (int i = 0; i < notas.length; i++) {

            if (notas[i] > notaMaxima) {
                notaMaxima = notas[i];
            }

            if (notas[i] < notaMinima) {
                notaMinima = notas[i];
            }
        }
        System.out.println("Nota maxima: " + notaMaxima);
        System.out.println("Nota minima: " + notaMinima);
        System.out.println("Promedio: " + promedio);
    }

    /*
     * METODO 2:
     * con este metod solicito y realizo una validacion de los numero spreviamente solicitados 
     * los cuales se almacenaran en la matriz .
     */
    public static void llenarMatriz(
            Scanner teclado, int[][] matrizNotas) {

        boolean datoValido;

        System.out.println(
                "Ingresa las notas de 2 estudiantes "
                + "para 3 actividades."
        );

        for (int fila = 0;
                fila < matrizNotas.length;
                fila++) {

            for (int columna = 0;
                    columna < matrizNotas[fila].length;
                    columna++) {

                System.out.print(
                        "Estudiante " + (fila + 1)
                        + ", actividad " + (columna + 1)
                        + ": "
                );

                if (teclado.hasNextInt()) {

                    matrizNotas[fila][columna]
                            = teclado.nextInt();

                    datoValido
                            = matrizNotas[fila][columna] >= 0
                            && matrizNotas[fila][columna] <= 100;

                    if (datoValido) {
                        System.out.println("Nota correcta.");
                    } else {
                        System.out.println(
                                "Error: la nota debe estar "
                                + "entre 0 y 100."
                        );

                        // Repite la misma posición
                        columna--;
                    }

                } else {
                    System.out.println(
                            "Error:  ingresa un numero entero "
                            
                    );

                    teclado.next();

                    // Repite la misma posición
                    columna--;
                }
            }
        }
    }

    /*
     * METODO 3:
     * con este metodo se muestra la matriz ordenada 
     * por filas y columnas.
     */
    public static void mostrarMatriz(int[][] matrizNotas) {


        for (int fila = 0;
                fila < matrizNotas.length;
                fila++) {

            System.out.print(
                    "Estudiante " + (fila + 1) + ": "
            );

            for (int columna = 0;
                    columna < matrizNotas[fila].length;
                    columna++) {

                System.out.print(
                        matrizNotas[fila][columna] + " "
                );
            }

            // AGREGADO: llama al método que suma la fila
            int sumaFila = calcularSumaFila(
                    matrizNotas[fila]
            );

            System.out.println(
                    "| Suma de la fila: " + sumaFila
            );
        }
    }

    /*
     * METODO 4:
     * Este método recibe una fila de la matriz
     * y devuelve la suma de todos sus elementos.
     */
    public static int calcularSumaFila(int[] fila) {

        int sumaFila = 0;

        for (int i = 0; i < fila.length; i++) {
            sumaFila = sumaFila + fila[i];
        }

        return sumaFila;
    }
}
