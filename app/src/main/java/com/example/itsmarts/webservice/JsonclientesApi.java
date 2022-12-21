package com.example.itsmarts.webservice;

import com.example.itsmarts.adapter.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonclientesApi {

    //Consultar lista de clientes
    @GET("clientes")
    Call<List<Cliente>> getPost();
}