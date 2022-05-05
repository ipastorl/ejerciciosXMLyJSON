/**
 * Clase para crear objetos Futbolista
 */
package ejerciciosJSON;

import java.util.ArrayList;

public class Futbolista {
    // atributos de la clase
    Integer dorsal;
    String nombre, equipo;
    ArrayList<Demarcacion> demarcaciones;

    // constructor
    public Futbolista(Integer dorsal, String nombre, String equipo) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.equipo = equipo;
    }

    // getters and setters

    public ArrayList<Demarcacion> getDemarcaciones() {
        return demarcaciones;
    }

    public void setDemarcaciones(ArrayList<Demarcacion> demarcaciones) {
        this.demarcaciones = demarcaciones;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    // imprime el objeto
    @Override
    public String toString() {
        return "Futbolista{" +
                "dorsal=" + dorsal +
                ", nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                '}';
    }
}
