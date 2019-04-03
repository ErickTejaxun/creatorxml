/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author erick
 */
public class Atributo extends  Exp
{
    public String id;
    public Nodo exp;
    
    public Hashtable<String, Object> t  = new Hashtable();
    
    
    public Atributo(int l, int c, String i, Nodo e)
    {
        this.linea = l;
        this.columna = c;
        t.put(i, e);        
    }   
    public Atributo(String i)
    {
        linea = 0;
        columna = 0;
        id = i;        
    }
    
    public void addAtributo(String id, Nodo e)
    {
        t.put(id, e);
    }
    
    public void setValor(Entorno entorno)
    {
        Hashtable<String, Object> valores = new Hashtable();
        
        String cadena = "";
        Set<String> keys = this.t.keySet();
        String str;
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) 
        { 
           str = itr.next();
           Object val = this.t.get(str);
           valores.put(str, ((Nodo)val).ejecutar(entorno).valor);
        } 
        valor = valores;
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) {
        valor = "";
        setValor(entorno);
        return this;
    }
    
}
