package leonamlima.com.restapp.services;

import java.util.List;

import leonamlima.com.restapp.entidades.Post;
import leonamlima.com.restapp.entidades.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();

    @POST("posts")
    Call<Post> criarPost(@Body Post post);
}
