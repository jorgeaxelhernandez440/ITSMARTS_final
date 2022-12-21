package com.example.itsmarts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegistroCliente extends AppCompatActivity {
    private EditText Nombre,ApellidoPaterno,ApellidoMaterno,Telefono,Puesto,Sucursal,RFC,NombreFiscal
    ,Municipio,CodigoPostal,Colonia,Referencia,Latitud,Longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_cliente);

        //Asignamos los valores de cada componente de la interfaz a las variables
        Nombre = (EditText) findViewById(R.id.nombreEdit);
        ApellidoPaterno = (EditText) findViewById(R.id.apellidoPaEdit);
        ApellidoMaterno = (EditText) findViewById(R.id.apellidoMaEdit);
        Telefono = (EditText) findViewById(R.id.telefonoEdit);
        Puesto = (EditText) findViewById(R.id.puestoEdit);
        Sucursal = (EditText) findViewById(R.id.sucursalEdit);
        RFC = (EditText) findViewById(R.id.rfcEdit);
        NombreFiscal = (EditText) findViewById(R.id.fiscalEdit);
        Municipio = (EditText) findViewById(R.id.municipioEdit);
        CodigoPostal = (EditText) findViewById(R.id.codigopostalEdit);
        Colonia = (EditText) findViewById(R.id.coloniaEdit);
        Referencia = (EditText) findViewById(R.id.referenciaEdit);
        Latitud = (EditText) findViewById(R.id.latitudEdit);
        Longitud = (EditText) findViewById(R.id.longitudEdit);

    }
    //Definimos un metodo para ejecutarlo al presionar el boton
    public void Enviar(View v){
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
