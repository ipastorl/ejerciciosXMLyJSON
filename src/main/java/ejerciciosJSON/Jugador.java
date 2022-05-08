package ejerciciosJSON;

public class Jugador {
    private Integer id;
    private String nombre, equipo;
    private Estadisticas estadisticas;

    public Jugador(Integer id, String nombre, String equipo, Estadisticas estadisticas) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", estadisticas=" + estadisticas +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }
}
