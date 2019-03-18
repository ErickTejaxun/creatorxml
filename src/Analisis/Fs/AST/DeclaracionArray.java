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
public class DeclaracionArray  extends Sentencia{
    public ArrayList<String> lista;
    public String tipo;
    public ArrayList<Exp> lvalores;
    
    public DeclaracionArray(ArrayList<String> i, String t, ArrayList<Exp> e)
    {
        lista = i;
        tipo = t;
        lvalores = e;
    }
    
    public DeclaracionArray(ArrayList<String> i, String t)
    {
        lista = i;
        tipo = t;        
    }    
    
    public DeclaracionArray(int l, int c, ArrayList<String> i)
    {
        this.linea = l;
        this.columna = c;
        this.lista = i;
        this.tipo = "undefined";
    }
    
    public DeclaracionArray(int l, int c, ArrayList<String> i, ArrayList<Exp> e)
    {
        this.linea = l;
        this.columna = c;
        this.lista = i;
        this.lvalores = e;
        this.tipo = "undefined";        
    }
    
    public void setValor(Entorno entorno)
    {
        entorno.setLocalizacion(columna, linea);
        if(lvalores!=null)
        {       
            String name = "";
            for(int x = 0; x < lista.size()-1; x++)
            {                
                name = lista.get(x);                
                valor = entorno.insertarSimbolo(new Simbolo(name, tipo, "var","nada"));                         
            }
            ArrayList<Object> valores = new ArrayList<Object>();
            for(Exp v: lvalores)
            {
                valores.add(v.ejecutar(entorno).valor);
            }            
            determinarTipo(valores);            
            valor = entorno.insertarSimbolo(new Simbolo(lista.get(lista.size()-1),tipo , "var",valores));                        
        }   
        else
        {
            Object v = null;
            switch(tipo)
            {
                case "string":
                    v = "";
                    break;
                case "int":
                    v = 0;
                    break;
                case "double":
                    v = 0.00;
                    break;
                case "bool":
                    v = false;
                    break;                
            }
            for(String name:lista)
            {                                
                valor = entorno.insertarSimbolo(new Simbolo(name, tipo, "var","nada"));                         
            }
        }
    }
    
    public void determinarTipo(Object valor)
    {        
        if(valor instanceof Boolean)
        {
            this.tipo="bool";                
        }else  
        if(valor instanceof Integer)
        {
            this.tipo="int";                
        }else 
        if(valor instanceof Double)
        {
            this.tipo="double";                
        }else 
        if(valor instanceof String)
        {
            this.tipo="string";                
        }else
        if(valor instanceof ArrayList)
        {
            this.tipo = "array";
        }
        {
            if(valor instanceof Simbolo)
            {
                this.tipo = ((Simbolo) valor).tipo;
            }
        }       
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return null;
    }
    
}
