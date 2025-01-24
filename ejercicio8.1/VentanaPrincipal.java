/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    private ListaPersonas lista;
    private Container contenedor;
    
    private JLabel nombre, apellidos, teléfono, dirección;
    private JTextField campoNombre, campoApellidos, campoTeléfono, campoDirección;
    private JButton añadir, eliminar, borrarLista, editar;
    private JList<Persona> listaNombres;
    private DefaultListModel<Persona> modelo;
    private JScrollPane scrollLista;

    public VentanaPrincipal(){
        lista = new ListaPersonas();
        inicio();
        setTitle("Personas");
        setSize(270, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(105, 20, 135, 23);
        
        apellidos = new JLabel();
        apellidos.setText("Apellidos:");
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(105, 50, 135, 23);
        
        teléfono = new JLabel();
        teléfono.setText("Teléfono:");
        teléfono.setBounds(20, 80, 135, 23);
        campoTeléfono = new JTextField();
        campoTeléfono.setBounds(105, 80, 135, 23);
        
        dirección = new JLabel();
        dirección.setText("Dirección:");
        dirección.setBounds(20, 110, 135, 23);
        campoDirección = new JTextField();
        campoDirección.setBounds(105, 110, 135, 23);
        
        añadir = new JButton("Añadir");
        añadir.setBounds(105, 150, 80, 23);
        añadir.addActionListener(this);
        
        editar = new JButton("Editar");
        editar.setBounds(20, 180, 80, 23);
        editar.addActionListener(this);
        editar.setEnabled(false); // Inicialmente deshabilitado
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(20, 280, 80, 23);
        eliminar.addActionListener(this);
        
        borrarLista = new JButton("Borrar Lista");
        borrarLista.setBounds(120, 280, 120, 23);
        borrarLista.addActionListener(this);
        
        listaNombres = new JList<>();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel<>();
        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 190 ,220, 80);
        scrollLista.setViewportView(listaNombres);
        
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(teléfono);
        contenedor.add(campoTeléfono);
        contenedor.add(dirección);
        contenedor.add(campoDirección);
        contenedor.add(añadir);
        contenedor.add(editar); // Agregar el botón "Editar"
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == añadir) {
            añadirPersona();
            editar.setEnabled(true); // Habilitar el botón "Editar" después de añadir
        } else if (evento.getSource() == eliminar) {
            eliminarPersonaSeleccionada();
        } else if (evento.getSource() == borrarLista) {
            borrarLista();
        } else if (evento.getSource() == editar) {
            editarPersonaSeleccionada();
        }
    }

    private void añadirPersona() {
        String nombre = campoNombre.getText();
    String apellidos = campoApellidos.getText();
    String telefono = campoTeléfono.getText();
    String direccion = campoDirección.getText();

    // Verificar si la persona ya existe en la lista
    for (int i = 0; i < modelo.size(); i++) {
        Persona personaExistente = modelo.getElementAt(i);
        if (personaExistente.getNombre().equalsIgnoreCase(nombre) && personaExistente.getApellidos().equalsIgnoreCase(apellidos)) {
            JOptionPane.showMessageDialog(this, "La persona ya existe en la lista.", "Persona Duplicada", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si ya existe
        }
    }
        Persona p = new Persona(campoNombre.getText(), campoApellidos.getText(), campoTeléfono.getText(), campoDirección.getText());
        lista.añadirPersona(p);
        modelo.addElement(p);
        listaNombres.setModel(modelo);
        campoNombre.setText("");
        campoApellidos.setText("");
        campoTeléfono.setText("");
        campoDirección.setText("");
    }

    private void eliminarPersonaSeleccionada() {
        int indice = listaNombres.getSelectedIndex();
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            lista.eliminarPersona(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una persona para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarLista() {
        lista.borrarLista();
        modelo.clear();
    }
    
    private void editarPersonaSeleccionada() {
    int indice = listaNombres.getSelectedIndex();
    if (indice >= 0) {
        Persona personaSeleccionada = modelo.getElementAt(indice);
        editarPersonaDialog(personaSeleccionada, indice);
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una persona para editar", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void editarPersonaDialog(Persona persona, int indice) {
        JDialog dialog = new JDialog(this, "Editar Persona", true);
        dialog.setLayout(new GridLayout(5, 2));
        
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(persona.getNombre());
        
        JLabel apellidosLabel = new JLabel("Apellidos:");
        JTextField apellidosField = new JTextField(persona.getApellidos());
        
        JLabel telefonoLabel = new JLabel("Teléfono:");
        JTextField telefonoField = new JTextField(persona.getTelefono());
        
        JLabel direccionLabel = new JLabel("Dirección:");
        JTextField direccionField = new JTextField(persona.getDireccion());
        
        JButton guardarButton = new JButton("Guardar");
        
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(nombreField.getText());
                persona.setApellidos(apellidosField.getText());
                persona.setTelefono(telefonoField.getText());
                persona.setDireccion(direccionField.getText());
                modelo.setElementAt(persona, indice);
                dialog.dispose();
            }
        });
        
        dialog.add(nombreLabel);
        dialog.add(nombreField);
        dialog.add(apellidosLabel);
        dialog.add(apellidosField);
        dialog.add(telefonoLabel);
        dialog.add(telefonoField);
        dialog.add(direccionLabel);
        dialog.add(direccionField);
        dialog.add(guardarButton);
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}