package leonamlima.com.restapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import leonamlima.com.restapp.R;
import leonamlima.com.restapp.entidades.User;
import leonamlima.com.restapp.services.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo = findViewById(R.id.viewJSON);
        buscaDados();
    }

    private void buscaDados() {
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> lista = response.body();
                for (User user : lista) {
                    campo.append("\n\nid: " + user.getId() +
                            "\nNome: " + user.getName() +
                            "\nUsername: " + user.getUsername() +
                            "\nEmail: " + user.getEmail() +
                            "\nEndereço: " + user.getAddress().getStreet() + ", " + user.getAddress().getCity() +
                            "\nTelefone: " + user.getPhone() +
                            "\nWebsite: " + user.getWebsite()+"\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("RestApp", t.getStackTrace().toString());
            }
        });
    }

    //public void navegar(View view) {
    //    startActivity(new Intent(this, PostActivity.class));
    //}
}
