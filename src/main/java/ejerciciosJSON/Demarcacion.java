package ejerciciosJSON;

public class Demarcacion {
    private String posicion;

    public Demarcacion(String posicion) {
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Demarcacion{" +
                "posicion='" + posicion + '\'' +
                '}';
    }
}
