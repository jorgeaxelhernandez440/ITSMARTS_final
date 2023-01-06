package com.example.itsmarts.api;

import com.example.itsmarts.adapter.Cliente;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

//mandamos a llamar los tipos de servicios
public interface ClientApi {
    //Listar clientes
    @GET("api/clientes")
    Call <JsonObject> getAll();

    //crear clientes
    @POST("api/clientes")
    Call<JsonObject> getInser(@Body Cliente cliente);

    //eliminar
    @DELETE("api/clientes/{cliente}")
    Call <JsonObject> getDelete(@Path("cliente")int id);

}
