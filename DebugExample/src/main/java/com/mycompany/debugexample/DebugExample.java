
package com.mycompany.debugexample;
public class DebugExample{

    public static void main(String[] args) {
        int[] numeros = {5, 8, 12, 20, 7};
        int suma = 0;
       

        
        System.out.println("Arreglo inicial:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // Accion 1: Observar el arreglo inicial
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];

            // Accion 2: Inspeccionar suma parcial
            System.out.println("Iteracion " + i
                    + ": suma parcial = " + suma);
        }

        // AGREGADO: Validar cantidad de elementos
        if (numeros.length == 0) {
            System.out.println("El arreglo esta vacio");
            return;
        }

       double promedio =
              calcularPromedio(suma, numeros.length);

        // Accion 3: Revisar promedio
        System.out.println("Promedio = " + promedio);

        int mayor = encontrarMayor(numeros);
        // Accion 4: Verificar numero mayor
        System.out.println("Numero mayor = " + mayor);

        // Accion 5: Confirmar resultado final
        System.out.println("Resultados finales -> Suma: " 
                + suma + ", Promedio: " + promedio
                + ", Mayor: " + mayor);
    }
    public static double calcularPromedio(
            int suma, int cantidad) {

        // AGREGADO: Evitar division entre cero
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "Cantidad invalida");
        }

        return (double) suma / cantidad;
    }

    public static int encontrarMayor(int[] arreglo) {

        // AGREGADO: Validar arreglo nulo o vacio
       if (arreglo == null || arreglo.length == 0) {
            throw new IllegalArgumentException(
                    "Arreglo invalido");
        
        int mayor = arreglo[0];

        for (int num : arreglo) {
            if (num > mayor) {
                mayor = num;
            }
        }

        return mayor;
    }
}