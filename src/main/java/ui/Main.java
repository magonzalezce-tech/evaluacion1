package ui;

import data.GestorEntidades;
import model.Direccion;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private GestorEntidades gestor;


    private JTextArea areaTextoOutput;
    private JButton botonRegistrarGuia;
    private JButton botonRegistrarVehiculo;
    private JButton botonMostrarTodo;

    public Main() {

        gestor = new GestorEntidades();


        Direccion dirBase = new Direccion("San Martín", "210", "Puerto Varas");
        gestor.agregarEntidad(new GuiaTuristico("14.555.666-7", "Alicia Gómez", "alicia@llanquihue.cl", dirBase, "REG-7741"));
        gestor.agregarEntidad(new Vehiculo("ABCD-12", "Mercedes-Benz Sprinter", 19));

        setTitle("Panel Administrativo - Llanquihue Tour App");
        setSize(700, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        JLabel etiquetaTitulo = new JLabel("Llanquihue Tour - Módulo de Control Visual", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setForeground(new Color(41, 128, 185));
        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));
        add(etiquetaTitulo, BorderLayout.NORTH);


        areaTextoOutput = new JTextArea();
        areaTextoOutput.setEditable(false);
        areaTextoOutput.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaTextoOutput.setBackground(new Color(248, 249, 250));

        JScrollPane panelDesplazable = new JScrollPane(areaTextoOutput);
        panelDesplazable.setBorder(BorderFactory.createTitledBorder("Consola de Registros en Tiempo Real"));
        add(panelDesplazable, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        botonRegistrarGuia = new JButton("➕ Registrar Guía");
        botonRegistrarVehiculo = new JButton("🚌 Registrar Vehículo");
        botonMostrarTodo = new JButton("🔄 Actualizar Listado");


        botonMostrarTodo.setBackground(new Color(41, 128, 185));
        botonMostrarTodo.setForeground(Color.WHITE);
        botonMostrarTodo.setFocusPainted(false);

        panelBotones.add(botonRegistrarGuia);
        panelBotones.add(botonRegistrarVehiculo);
        panelBotones.add(botonMostrarTodo);
        add(panelBotones, BorderLayout.SOUTH);


        actualizarPantallaVisual();


        botonRegistrarGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String rut = JOptionPane.showInputDialog(Main.this, "Ingrese el RUT del Guía:");
                if (rut == null || rut.trim().isEmpty()) return;

                String nombre = JOptionPane.showInputDialog(Main.this, "Ingrese Nombre Completo:");
                if (nombre == null || nombre.trim().isEmpty()) return;

                String email = JOptionPane.showInputDialog(Main.this, "Ingrese Correo Electrónico:");
                String certSernatur = JOptionPane.showInputDialog(Main.this, "Ingrese Código de Certificación SERNATUR:");


                Direccion dirAsignada = new Direccion("📍 Oficina de Guías", "S/N", "Puerto Varas");


                GuiaTuristico nuevoGuia = new GuiaTuristico(rut, nombre, email, dirAsignada, certSernatur);
                gestor.agregarEntidad(nuevoGuia);

                JOptionPane.showMessageDialog(Main.this, "¡Guía Turístico incorporado con éxito al sistema!");
                actualizarPantallaVisual();
            }
        });


        botonRegistrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = JOptionPane.showInputDialog(Main.this, "Ingrese Patente del Vehículo (Ej: ABCD-12):");
                if (patente == null || patente.trim().isEmpty()) return;

                String modelo = JOptionPane.showInputDialog(Main.this, "Ingrese Marca y Modelo:");
                if (modelo == null || modelo.trim().isEmpty()) return;

                String capStr = JOptionPane.showInputDialog(Main.this, "Ingrese Capacidad Máxima de Pasajeros:");

                try {

                    int capacidad = Integer.parseInt(capStr);

                    Vehiculo nuevoVehiculo = new Vehiculo(patente, modelo, capacidad);
                    gestor.agregarEntidad(nuevoVehiculo);

                    JOptionPane.showMessageDialog(Main.this, "¡Vehículo de Flota registrado con éxito!");
                    actualizarPantallaVisual();

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(Main.this, "Error: La capacidad debe ser un número entero válido.", "Fallo de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        botonMostrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPantallaVisual();
            }
        });
    }


    private void actualizarPantallaVisual() {
        String reporteActualizado = gestor.procesarYContarEntidades();
        areaTextoOutput.setText(reporteActualizado);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}


