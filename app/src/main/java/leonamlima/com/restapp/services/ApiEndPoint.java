package leonamlima.com.restapp.services;

import java.util.List;

import leonamlima.com.restapp.entidades.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();
}
