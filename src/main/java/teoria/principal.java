package teoria;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

        // crear los modelos de datos con los objetos (detalles)
        DetalleVenta d1 = new DetalleVenta("Guernica",3.21,3.21,1);
        DetalleVenta d2 = new DetalleVenta("La habitación azul", 3.78,3.78, 1);
        DetalleVenta d3 = new DetalleVenta("Las mujeres de Argel",4.54, 4.54,1);

        // lista detalles para incluirla en una venta
        ArrayList<DetalleVenta> detalles = new ArrayList<>();

        detalles.add(d1);
        detalles.add(d2);
        detalles.add(d3);

        venta.setDetalle(detalles);

        // convertir objeto compuesto con ArrayList a JSON
        System.out.println(gson.toJson(venta));
        String json_completo = gson.toJson(venta);

        // convertir un String JSON a objeto
        Venta nuevaVenta = gson.fromJson(json_completo, Venta.class);
        System.out.println(nuevaVenta);

        // obtener un arraylist de manera independiente
        String jsonArray = gson.toJson(detalles);
        Type listType = new TypeToken<ArrayList<DetalleVenta>>() {}.getType();
        ArrayList<DetalleVenta> arraydejson = gson.fromJson(jsonArray,listType);

        System.out.println(arraydejson);

    }
}
