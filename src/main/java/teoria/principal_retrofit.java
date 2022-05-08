package teoria;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class principal_retrofit {
    public static void main(String[] args) {
        // Si no se configura el OkHttpClient, se genera uno por defecto, aquí podemos configurarlo nosotros
        OkHttpClient okHttpClient =
                new OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/chemaduran/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        CentralDeVentas service = retrofit.create(CentralDeVentas.class);
        Venta venta = null;
        final Integer ventaId = 2;

        // Obtener el listado completo de ventas
        System.out.println("Obtener el listado completo de ventas");
        try {
            Response<List<Venta>> response = service.listVentas().execute();
            if(response.isSuccessful()){
                List<Venta> ventas = response.body();
                System.out.println(ventas);
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());;
        }

        // Obtener una venta por su id
        System.out.println("Obtener una venta por su id: ID " + ventaId);
        try {
            Response<Venta> response = service.getVentaId(ventaId).execute();
            if(response.isSuccessful()){
                venta = response.body();
                System.out.println(venta);
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());;
        }

        // Obtener una venta por su id
        System.out.println("Obtener el detalle (listado) de una venta por su id: ID " + ventaId);
        try {
            Response<List<DetalleVenta>> response = service.listVentaIdDetalles(ventaId).execute();
            if(response.isSuccessful()){
                List<DetalleVenta> detalleVentas = response.body();
                System.out.println(detalleVentas);
                if (venta != null){
                    assert detalleVentas != null;
                    venta.setDetalle(new ArrayList<>(detalleVentas));
                }
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());;
        }
        System.out.println("Imprimir la venta, con el detalle");
        System.out.println(venta);
    }
}
