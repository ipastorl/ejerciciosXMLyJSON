package teoria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class principal_retrofit {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/chemaduran/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



    }
}
