package teoria;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;

public class principal {
    public static void main(String[] args) {
        // Obtener una fecha
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
    // Transformar un objeto Venta a una cadena JSON
        Venta venta = new Venta(fecha, "Galería Picasso");
        // Crear el objeto GSON para la conversión
        Gson gson = new Gson();
        // convertir
        System.out.println(gson.toJson(venta));
    }
}
