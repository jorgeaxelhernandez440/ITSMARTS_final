package com.example.itsmarts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itsmarts.adapter.Cliente;
import com.example.itsmarts.api.ClientApi;
import com.example.itsmarts.api.service;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistroCliente extends AppCompatActivity {

    //definimos los datos globales que se ocuparan
    private EditText Nombre,ApellidoPaterno,ApellidoMaterno,Telefono,Puesto,Sucursal,RFC,NombreFiscal
    ,Municipio,CodigoPostal,Colonia,Referencia,Latitud,Longitud;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_cliente);

        //id de los campos que se requieren
        button = findViewById(R.id.BtnAgregar);
        Nombre = findViewById(R.id.nombreEdit);
        ApellidoPaterno = findViewById(R.id.apellidoPaEdit);
        ApellidoMaterno = findViewById(R.id.apellidoMaEdit);
        Telefono =  findViewById(R.id.telefonoEdit);
        Puesto =  findViewById(R.id.puestoEdit);
        Sucursal =  findViewById(R.id.sucursalEdit);
        RFC = findViewById(R.id.rfcEdit);
        NombreFiscal = findViewById(R.id.fiscalEdit);
        Municipio = findViewById(R.id.municipioEdit);
        CodigoPostal =  findViewById(R.id.codigopostalEdit);
        Colonia =  findViewById(R.id.coloniaEdit);
        Referencia =  findViewById(R.id.referenciaEdit);
        Latitud = findViewById(R.id.latitudEdit);
        Longitud = findViewById(R.id.longitudEdit);
    }

    //creacion de nuevos clientes
    public void guardarCliente(Cliente cliente){

        button.setEnabled(false);
        Call<JsonObject> call = service.createService().create(ClientApi.class).getInser(cliente);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(RegistroCliente.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegistroCliente.this, "Cliente Guardado", Toast.LENGTH_SHORT).show();
                    button.setEnabled(true);
                }else{
                    Toast.makeText(RegistroCliente.this, "Error al guardar, intente de nuevo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(RegistroCliente.this, "Error al guardar, intente de nuevo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Definimos un metodo para ejecutarlo al presionar el boton para poder hacer las validaciones respectivas de cada uno de los campos
    public void Enviar(View v){
        String nombre = Nombre.getText().toString();
        String ApellidoP = ApellidoPaterno.getText().toString();
        String ApellidoM = ApellidoMaterno.getText().toString();
        String telefono = Telefono.getText().toString();
        String puesto = Puesto.getText().toString();
        String sucursal = Sucursal.getText().toString();
        String rfc = RFC.getText().toString();
        String Nombrefiscal = NombreFiscal.getText().toString();
        String latitud = Latitud.getText().toString();
        String longitud = Longitud.getText().toString();
        String Codigopostal = CodigoPostal.getText().toString();
        String colonia = Colonia.getText().toString();
        String referencia = Referencia.getText().toString();

        if (Nombre.getText().toString().isEmpty()){
            Toast.makeText(this,"Falta Nombre",Toast.LENGTH_LONG).show();
        }else {
            if(ApellidoPaterno.getText().toString().isEmpty()){
                Toast.makeText(this,"Falta Apellido Paterno",Toast.LENGTH_LONG).show();
            }else {
                if(ApellidoMaterno.getText().toString().isEmpty()){
                    Toast.makeText(this,"Falta Apellido Materno",Toast.LENGTH_LONG).show();
                }else {
                    if (Telefono.getText().toString().isEmpty()){
                        Toast.makeText(this,"Falta Telefono",Toast.LENGTH_LONG).show();
                    }else {
                        if (Puesto.getText().toString().isEmpty()){
                            Toast.makeText(this,"Falta Puesto",Toast.LENGTH_LONG).show();
                        }else {
                            if (Sucursal.getText().toString().isEmpty()){
                                Toast.makeText(this,"Falta Sucursal",Toast.LENGTH_LONG).show();
                            }else {
                                if (RFC.getText().toString().isEmpty()){
                                    Toast.makeText(this,"Falta RFC",Toast.LENGTH_LONG).show();
                                }else{
                                    if (NombreFiscal.getText().toString().isEmpty()){
                                        Toast.makeText(this,"Falta Nombre Fiscal",Toast.LENGTH_LONG).show();
                                    }else {
                                        if (Municipio.getText().toString().isEmpty()){
                                            Toast.makeText(this,"Falta Municipio",Toast.LENGTH_LONG).show();
                                        }else {
                                            if (CodigoPostal.getText().toString().isEmpty()){
                                                Toast.makeText(this,"Falta Codigo Postal",Toast.LENGTH_LONG).show();
                                            }else {
                                                if (Colonia.getText().toString().isEmpty()){
                                                    Toast.makeText(this,"Falta Colonia",Toast.LENGTH_LONG).show();
                                                }else {
                                                    if (Referencia.getText().toString().isEmpty()){
                                                        Toast.makeText(this,"Falta Referencia",Toast.LENGTH_LONG).show();
                                                    }else {
                                                        if (Latitud.getText().toString().isEmpty()){
                                                            Toast.makeText(this,"Falta Latitud",Toast.LENGTH_LONG).show();
                                                        }else {
                                                            if (Longitud.getText().toString().isEmpty()){
                                                                Toast.makeText(this,"Falta Longitud",Toast.LENGTH_LONG).show();
                                                            }else {
                                                                Cliente cliente = new Cliente(nombre,ApellidoP,ApellidoM,telefono,puesto,sucursal,rfc,Nombrefiscal,latitud,longitud,Codigopostal,colonia,referencia);
                                                                guardarCliente(cliente);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
