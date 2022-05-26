package ExamenU8U92122.ejercicio2;

public class Piloto {
    private String nombre;
    private Integer edad;
    private String escuderia;
    private Integer campeonatos;
    private String pais;

    @Override
    public String toString() {
        return "Piloto{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", escuderia='" + escuderia + '\'' +
                ", campeonatos=" + campeonatos +
                '}';
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public Integer getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Integer campeonatos) {
        this.campeonatos = campeonatos;
    }
}
