package teoria;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CentralDeVentas {

    // "https://my-json-server.typicode.com/chemaduran/json_api_dem/ventas"
    @GET("json_api_dem/ventas")
    Call<List<Venta>> listVentas();
}
