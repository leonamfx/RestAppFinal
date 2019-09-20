package leonamlima.com.restapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import leonamlima.com.restapp.R;
import leonamlima.com.restapp.entidades.Post;
import leonamlima.com.restapp.services.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        enviarCosnultaRest();
    }

    private void enviarCosnultaRest() {
        Post post = new Post(1,"Teste","Loren Ipsum");
        RetrofitService.getServico().criarPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int cod = response.code();
                int id = response.body().getId();
                TextView textViewid = findViewById(R.id.textViewNovoIdCriado);
                TextView textViewcod = findViewById(R.id.textViewCodigoDeRetorno);

            textViewcod.setText(""+cod);
            textViewid.setText(""+id);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
