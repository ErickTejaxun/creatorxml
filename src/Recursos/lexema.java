/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

/**
 *
 * @author Erick
 */
public class lexema 
{
    
    String texto;
    int linea;
    int columna;
    String descripcion;
    String tipo;
    String Valor;
    int index;

    //lexema(tipo, valor, linea, columna)
    public lexema(String t, String v, int l, int c)
    {
        this.tipo = t;
        this.descripcion = v;
        this.linea = l;
        this.columna = c;
    }
    
    public  lexema(String valor, int linea, int columna, String descripcion, String tipo)
    {
        this.Valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public lexema(){
    texto="";
    linea=0;
    columna=0;
    descripcion="";
    tipo="";
    }
    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getLinea() {
        return linea;
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
    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
