package ejerciciosJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface DBFutbolistas {
    //https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/jugadores
    @GET("futbolistas_api_demo/jugadores")
    Call<List<Jugador>> listFutbolistas();

    //https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/15
    @GET("futbolistas_api_demo/jugadores/{id}")
    Call<Jugador> getJugadorxDorsal(@Path("id") Integer id);

    //https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/15/estadisticas
    @GET("futbolistas_api_demo/jugadores/{id}")
    Call<Estadisticas> getEstadisticasJugador(@Path("id") Integer id);
}
