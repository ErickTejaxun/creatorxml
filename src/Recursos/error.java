/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Recursos.*;

/**
 *
 * @author Erick
 */
public class error {
    
    String valor;
    int linea;
    int columna;
    String descripcion;
    String tipo;
    String path;
    
    
    //error("Lexico",valor, linea, columna)
    public error(String t , String v, int l, int c)
    {
        this.tipo = t;
        this.descripcion = v;
        this.linea = l;
        this.columna = c;
    }
    
    
    
    public error(String tipo, int linea, int columna, String valor)
    {
        this.tipo=tipo;
        this.linea= linea;
        this.columna = columna;
        this.valor = valor;
        this.descripcion = valor;
    }
    
    public error(String tipo, int linea, int columna, String valor,String descripcion)
    {
        this.tipo=tipo;
        this.linea= linea;
        this.columna = columna;
        this.valor = valor;
        this.descripcion = descripcion;
    }    
    
    public error(){
    valor="";
    linea=0;
    columna=0;
    descripcion="";
    tipo="";
    }

    public int getLinea() {
        return linea;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    

    public String getValor() {
        return valor;
    }

    public void setValor(String texto) {
        this.valor = texto;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }
    
    
    
}
