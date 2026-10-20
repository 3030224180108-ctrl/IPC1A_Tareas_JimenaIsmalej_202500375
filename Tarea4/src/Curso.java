/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ismal
 */

package tarea4;

import java.util.ArrayList;

public class Curso {

    private String codigo;
    private String nombre;
    private String tutor;
    private ArrayList<TareaAcademica> tareas;

    public Curso(String codigo, String nombre, String tutor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tutor = tutor;
        this.tareas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTutor() {
        return tutor;
    }

    public ArrayList<TareaAcademica> getTareas() {
        return tareas;
    }

    public void agregarTarea(TareaAcademica tarea) {
        tareas.add(tarea);
    }

    public String mostrarInformacion() {
        String informacion = "Codigo: " + codigo + "\n"
                + "Curso: " + nombre + "\n"
                + "Tutor: " + tutor + "\n"
                + "Tareas:\n";

        if (tareas.isEmpty()) {
            informacion += "No hay tareas registradas.\n";
        } else {
            for (TareaAcademica tarea : tareas) {
                informacion += tarea.toString() + "\n";
            }
        }

        return informacion;
    }
}
