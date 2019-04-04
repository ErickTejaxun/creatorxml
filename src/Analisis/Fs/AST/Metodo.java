/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Metodo extends Sentencia{

    
    public ArrayList<Nodo> declaracionParametros;
    public ArrayList<Exp> listaParametros = new ArrayList<Exp>();
    public Bloque bloque;
    public String id;    
    public String tipo;
    
    public Metodo(int l, int c, String id,ArrayList<Nodo> ls, Bloque b)
    {
        this.linea = l;
        this.columna = c;
        this.id = id;
        this.declaracionParametros = ls;
        this.bloque =b;
    }
    
    public Metodo(int l, int c, String id,Bloque b)
    {
        this.linea = l;
        this.columna = c;
        this.id = id;
        this.declaracionParametros = new ArrayList<Nodo>();
        this.bloque =b;
    }    


    public void setId(String id) {
        this.id = id;
    }
        
    public void setValor(Entorno entorno)
    {
        Simbolo metodoSimbolo = new Simbolo();
        String idMetodo = this.id;
        for(Nodo n : declaracionParametros)
        {
            idMetodo+= "$var";
        }
        metodoSimbolo.setId(idMetodo);
        metodoSimbolo.setTipo("metodo");
        metodoSimbolo.setValor(this);
        entorno.insertarSimbolo(metodoSimbolo);
    }

    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {        
        valor = "";
        setValor(entorno);
        return this;
    }
    
}
