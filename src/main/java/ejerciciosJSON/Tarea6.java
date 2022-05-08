package ejerciciosJSON;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Tarea6 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/chemaduran/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DBFutbolistas service = retrofit.create(DBFutbolistas.class);
        Jugador jugador = null;
        final Integer id = 15;

        // Obtener listado de jugadores
        System.out.println("Jugadores:");
        try {
            Response<List<Jugador>> response = service.listFutbolistas().execute();
            if(response.isSuccessful()){
                List<Jugador> futbolistas = response.body();
                System.out.println(futbolistas);
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());
        }

        // Obtener un jugador por su id
        System.out.println("Jugador " + id + " :");
        try {
            Response<Jugador> response = service.getJugadorxDorsal(id).execute();
            if(response.isSuccessful()){
                jugador = response.body();
                System.out.println(jugador);
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());
        }

        // Obtener las estadísticas de un jugador
        System.out.println("Estadísticas del jugador " + id + " :");
        try {
            Response<Estadisticas> response = service.getEstadisticasJugador(id).execute();
            if(response.isSuccessful()){
                Estadisticas estadisticas = response.body();
                System.out.println(estadisticas);
            } else {
                System.out.println("Petición no válida " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());
        }
    }
}
