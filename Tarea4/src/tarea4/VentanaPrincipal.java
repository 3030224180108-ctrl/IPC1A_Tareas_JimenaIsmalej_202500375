/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package tarea4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class VentanaPrincipal extends JFrame {

    private ArrayList<Curso> cursos = new ArrayList<>();

    // Campos para cursos
    private JTextField txtCodigo = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtTutor = new JTextField();

    // Campos para tareas
    private JComboBox<String> cbCursos = new JComboBox<>();
    private JTextField txtTitulo = new JTextField();
    private JTextField txtDescripcion = new JTextField();
    private JTextField txtFecha = new JTextField();

    // Campos para temperaturas
    private JTextField txtCelsius = new JTextField();
    private JLabel lblResultado = new JLabel("Resultado: ");

    // Area de informacion
    private JTextArea areaInformacion = new JTextArea();

    public VentanaPrincipal() {
        setTitle("Gestor Academico - Tarea 4");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    // CREAR INTERFAZ
    private void iniciarComponentes() {

        JPanel principal = new JPanel(new BorderLayout(10, 10));
        principal.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JTabbedPane pestanias = new JTabbedPane();

        pestanias.addTab("Cursos", panelCursos());
        pestanias.addTab("Tareas", panelTareas());
        pestanias.addTab("Temperaturas", panelTemperaturas());

        principal.add(pestanias, BorderLayout.CENTER);

        JPanel panelInfo = new JPanel(new BorderLayout(5, 5));

        panelInfo.setBorder(
                BorderFactory.createTitledBorder("Informacion registrada")
        );

        JButton btnMostrar = new JButton("Mostrar informacion");

        btnMostrar.addActionListener(e -> mostrarInformacion());

        areaInformacion.setEditable(false);
        areaInformacion.setLineWrap(true);
        areaInformacion.setWrapStyleWord(true);

        panelInfo.add(btnMostrar, BorderLayout.NORTH);
        panelInfo.add(
                new JScrollPane(areaInformacion),
                BorderLayout.CENTER
        );

        panelInfo.setPreferredSize(new Dimension(0, 220));

        principal.add(panelInfo, BorderLayout.SOUTH);

        add(principal);
    }

    // MODULO DE CURSOS
    private JPanel panelCursos() {

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JButton btnRegistrar = new JButton("Registrar curso");

        panel.add(new JLabel("Codigo del curso:"));
        panel.add(txtCodigo);

        panel.add(new JLabel("Nombre del curso:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Tutor responsable:"));
        panel.add(txtTutor);

        panel.add(new JLabel(""));
        panel.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarCurso());

        return panel;
    }

    // REGISTRAR CURSO
    private void registrarCurso() {

        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String tutor = txtTutor.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || tutor.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        for (Curso curso : cursos) {
            if (curso.getCodigo().equalsIgnoreCase(codigo)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ya existe un curso con ese codigo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        Curso nuevo = new Curso(codigo, nombre, tutor);

        cursos.add(nuevo);

        cbCursos.addItem(codigo + " - " + nombre);

        JOptionPane.showMessageDialog(
                this,
                "Curso registrado correctamente."
        );

        txtCodigo.setText("");
        txtNombre.setText("");
        txtTutor.setText("");
    }

    // MODULO DE TAREAS
    private JPanel panelTareas() {

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JButton btnAgregar = new JButton("Agregar tarea");

        panel.add(new JLabel("Seleccionar curso:"));
        panel.add(cbCursos);

        panel.add(new JLabel("Titulo de la tarea:"));
        panel.add(txtTitulo);

        panel.add(new JLabel("Descripcion:"));
        panel.add(txtDescripcion);

        panel.add(new JLabel("Fecha de entrega (DD/MM/AAAA):"));
        panel.add(txtFecha);

        panel.add(new JLabel(""));
        panel.add(btnAgregar);

        btnAgregar.addActionListener(e -> registrarTarea());

        return panel;
    }

    // REGISTRAR TAREA
    private void registrarTarea() {

        int indice = cbCursos.getSelectedIndex();

        if (indice == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Primero debe registrar un curso.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String titulo = txtTitulo.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String fecha = txtFecha.getText().trim();

        if (titulo.isEmpty() || descripcion.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos de la tarea.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Validar fecha
        try {
            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

            LocalDate.parse(fecha, formato);

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una fecha valida (DD/MM/AAAA).",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        TareaAcademica nueva = new TareaAcademica(
                titulo, descripcion, fecha
        );

        cursos.get(indice).agregarTarea(nueva);

        JOptionPane.showMessageDialog(
                this,
                "Tarea agregada correctamente."
        );

        txtTitulo.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
    }

    // MOSTRAR INFORMACION
    private void mostrarInformacion() {

        areaInformacion.setText("");

        if (cursos.isEmpty()) {
            areaInformacion.setText("No hay cursos registrados.");
            return;
        }

        for (Curso curso : cursos) {
            areaInformacion.append(curso.mostrarInformacion());

            areaInformacion.append(
                    "\n-----------------------------\n"
            );
        }
    }

    // MODULO DE TEMPERATURAS
    private JPanel panelTemperaturas() {

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JButton btnFahrenheit = new JButton("Convertir a Fahrenheit");
        JButton btnKelvin = new JButton("Convertir a Kelvin");

        panel.add(new JLabel("Temperatura en Celsius:"));
        panel.add(txtCelsius);

        panel.add(btnFahrenheit);
        panel.add(btnKelvin);

        panel.add(new JLabel("Conversion:"));
        panel.add(lblResultado);

        btnFahrenheit.addActionListener(
                e -> convertirTemperatura(true)
        );

        btnKelvin.addActionListener(
                e -> convertirTemperatura(false)
        );

        return panel;
    }

    // CONVERTIR TEMPERATURAS
    private void convertirTemperatura(boolean fahrenheit) {

        String entrada = txtCelsius.getText().trim();

        if (entrada.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una temperatura.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            double celsius = Double.parseDouble(entrada);

            if (!Double.isFinite(celsius)) {
                throw new NumberFormatException();
            }

            double resultado;

            if (fahrenheit) {
                resultado = celsius * 9 / 5 + 32;

                lblResultado.setText(
                        String.format("%.2f °F", resultado)
                );

            } else {
                resultado = celsius + 273.15;

                lblResultado.setText(
                        String.format("%.2f K", resultado)
                );
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un numero valido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
