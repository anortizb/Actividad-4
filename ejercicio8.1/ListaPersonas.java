/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    private List<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<>();
    }

    public void añadirPersona(Persona persona) {
        personas.add(persona);
    }

    public void eliminarPersona(int indice) {
        if (indice >= 0 && indice < personas.size()) {
            personas.remove(indice);
        }
    }

    public void borrarLista() {
        personas.clear();
    }

    // Otros métodos de la clase si son necesarios
}
