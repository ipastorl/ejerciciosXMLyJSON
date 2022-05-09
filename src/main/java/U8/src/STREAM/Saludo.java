package U8.src.STREAM;

public class Saludo {
    private String nombre;

    public Saludo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Hola, " + nombre ;
    }
}
