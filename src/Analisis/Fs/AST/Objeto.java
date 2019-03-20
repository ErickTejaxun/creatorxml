/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author erick
 */
public class Objeto extends Nodo
{
    public String id;
    public ArrayList<Atributo> lista;
    
    public Objeto(int l, int c, String i, ArrayList<Atributo> lista)
    {
        this.linea = l;
        this.columna = c;
        this.id = i;
        this.lista = lista;
    }
    
    public void setValor(Entorno entorno)
    {
        Hashtable<String, Object> t = new Hashtable();
        for(Atributo a: lista)
        {
            Object atr = a.exp.ejecutar(entorno).valor;
            t.put(a.id, valor);
        }
        valor = entorno.insertarSimbolo(new Simbolo(id, "objeto", "var",t)); 
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
