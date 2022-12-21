package com.example.itsmarts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itsmarts.adapter.Cliente;
import com.example.itsmarts.webservice.JsonclientesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.nuevo);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //abre registro de clientes
        button.setOnClickListener(view -> {
            Intent guardar = new Intent(this,RegistroCliente.class);
            startActivity(guardar);
        });



    }

    //llama los web service para mostrarlos en el recyclerview
    private void getPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://practicaits2022-production.up.railway.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonclientesApi jsonclientesApi = retrofit.create(JsonclientesApi.class);

        Call<List<Cliente>> call = jsonclientesApi.getPost();

        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {

            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {

            }
        });
    }



}