package com.example.itsmarts.adapter;

import java.util.Objects;
//en este apartado tenemos el modelo de cliente con cada uno de sus campos con su tipo de dato
public class Cliente {
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String puesto;
    private String sucursal;
    private String rfc;
    private String nombrefiscal;
    private float latitud;
    private float longitud;
    private String referencia;
    private String estado;
    private String municipio;
    private String colonia;
    private int codigoPostal;
    private int estatus;

    public Cliente(String nombre, String apellidoP) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.puesto = puesto;
        this.sucursal = sucursal;
        this.rfc = rfc;
        this.nombrefiscal = nombrefiscal;
        this.latitud = latitud;
        this.longitud = longitud;
        this.referencia = referencia;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.estatus = estatus;
    }

    public Cliente(String nombre, String apellidoP, String apellidoM, String telefono, String puesto, String sucursal, String rfc, String nombrefiscal, String latitud, String longitud, String codigopostal, String colonia, String referencia) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombrefiscal() {
        return nombrefiscal;
    }

    public void setNombrefiscal(String nombrefiscal) {
        this.nombrefiscal = nombrefiscal;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return telefono == cliente.telefono && Float.compare(cliente.latitud, latitud) == 0 && Float.compare(cliente.longitud, longitud) == 0 && codigoPostal == cliente.codigoPostal && nombre.equals(cliente.nombre) && apellidoP.equals(cliente.apellidoP) && apellidoM.equals(cliente.apellidoM) && puesto.equals(cliente.puesto) && sucursal.equals(cliente.sucursal) && rfc.equals(cliente.rfc) && nombrefiscal.equals(cliente.nombrefiscal) && referencia.equals(cliente.referencia) && estado.equals(cliente.estado) && municipio.equals(cliente.municipio) && colonia.equals(cliente.colonia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidoP, apellidoM, telefono, puesto, sucursal, rfc, nombrefiscal, latitud, longitud, referencia, estado, municipio, colonia, codigoPostal);
    }
}
