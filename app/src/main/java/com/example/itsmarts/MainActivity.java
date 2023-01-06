package com.example.itsmarts;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsmarts.adapter.Cliente;
import com.example.itsmarts.api.ClientApi;
import com.example.itsmarts.api.service;
import com.example.itsmarts.prueba.ClienteAdapter;
import com.example.itsmarts.databinding.ActivityMainBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    //definimos los datos globales que se ocuparan

    List<Cliente> clientes;
    int id;
    JsonObject object;
    ClienteAdapter clienteAdapter;
    SearchView searchView;
    Button buttoeliminar;
    Button buttoneditar;
    Button button;
    TextView nombre,apellidoP;
    RecyclerView recyclerView;
    Retrofit retrofit;
    com.example.itsmarts.api.service service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //inicializa metodos
        init();
        initViews();
        initListener();
        service = new service();
        retrofit= service.createService();
        getAll();



        //id de los campos que se requieren
        SearchView searchView = findViewById(R.id.searchView);
        buttoneditar = findViewById(R.id.buttoneditar);
         button = findViewById(R.id.nuevo);
         buttoeliminar = findViewById(R.id.buttoneliminar);
         nombre = findViewById(R.id.nombretxt);
         apellidoP = findViewById(R.id.apellidoPatxt);


        //elimina los registros de los clientes






        //abre registro de clientes para crear un nuevo cliente
        button.setOnClickListener(view -> {
            Intent guardar = new Intent(this,RegistroCliente.class);
            startActivity(guardar);
        });





    }

    public void setButtoneditar(View view){
        Intent editar = new Intent(MainActivity.this,RegistroCliente.class);
        startActivity(editar);
    }


    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("desea eliminar este cliente?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        ClientApi clientApi = retrofit.create(ClientApi.class);
                        Call<JsonObject> call = clientApi.getDelete(id);
                        Toast.makeText(getApplicationContext(),"id"+view.getId(),Toast.LENGTH_SHORT).show();
                        call.enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Cliente eliminado",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),"Error al eliminar el clientes",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cliente No eliminado",Toast.LENGTH_SHORT).show();

                    }
                }).show();
    }


    //registros de prueba en la lista
    public void init(){
        /*clientes = new ArrayList<>();
        clientes.add(new Cliente("Jorge","Hernandez"));
        clientes.add(new Cliente("Brenda","Hernandez"));
        clientes.add(new Cliente("Alex","Hernandez"));
        clientes.add(new Cliente("Alex","Hernandez"));
        clientes.add(new Cliente("Alex","Hernandez"));
        clientes.add(new Cliente("Alex","Hernandez"));
        clientes.add(new Cliente("Alex","Hernandez"));*/


        // clienteAdapter = new ClienteAdapter(clientes,this);
        recyclerView = findViewById(R.id.recycler_view);
       /* recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(clienteAdapter);*/

    }

    //muestra la lista clientes desde los servicios
    private void getAll(){
        ClientApi clientApi = retrofit.create(ClientApi.class);
        Call <JsonObject> call = clientApi.getAll();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.code() == 200 && response.body().size() > 0){
                        Toast.makeText(MainActivity.this, "Cargando lista", Toast.LENGTH_SHORT).show();
                        clientes = new ArrayList<>();
                        object = response.body();
                        JsonArray jsonArray = object.get("clientes").getAsJsonArray();
                        for (int i = 0; i<jsonArray.size(); i++){
                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                            clientes.add(new Cliente(jsonObject.get("nombre").getAsString(),jsonObject.get("apellidoP").getAsString()));
                        }

                        ClienteAdapter clienteAdapter = new ClienteAdapter(clientes, MainActivity.this);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(clienteAdapter);
                        clienteAdapter.setOnclick(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int position = recyclerView.getChildAdapterPosition(v);
                            }
                        });

                    }else {
                        Toast.makeText(MainActivity.this, "No hay registros", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Error en la app", Toast.LENGTH_SHORT).show();
                    System.out.println("Error: "+ex.toString());
                    Log.d(TAG, "onFailure: "+ex.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error de conexion",Toast.LENGTH_SHORT).show();
                System.out.println(t.toString());


            }
        });
    }

    //inicia el search view
    public void initViews(){
        searchView = findViewById(R.id.searchView);

    }
    //especificamos donde se encontrara
    public void initListener(){
        searchView.setOnQueryTextListener(this);

    }


    //busca el nuevo texto que escribamos en el searchview
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        clienteAdapter.filtrado(newText);
        return false;
    }


    }




