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
public class Declaracion  extends Sentencia{
    public ArrayList<String> lista;
    public ArrayList<Atributo> listaAtributos;
    public String tipo;
    public Exp exp;
    
   
    public Declaracion(ArrayList<String> i, String t, Exp e)
    {
        lista = i;
        tipo = t;
        exp = e;
    }
    
    public Declaracion(ArrayList<String> i, String t)
    {
        lista = i;
        tipo = t;        
    }    
    
    public Declaracion(int l, int c, ArrayList<String> i)
    {
        this.linea = l;
        this.columna = c;
        this.lista = i;
        this.tipo = "undefined";
    }
    
    
    public Declaracion(int l, int c, ArrayList<String> i, Exp e)
    {
        this.linea = l;
        this.columna = c;
        this.lista = i;
        this.exp = e;
        this.tipo = "undefined";
        if(e instanceof Atributo)
        {
            this.tipo = "objeto";
        }
    }
    
    public Declaracion(int l, int c, ArrayList<String> nombres, String t, Exp atributos)
    {
        this.linea = l;
        this.columna = c;
        this.lista = nombres;
        this.tipo = t;
        this.exp = atributos;                
    }
    
    
    
    public void setValor(Entorno entorno)
    {
        entorno.setLocalizacion(columna, linea);
        if(exp!=null)
        {       
            String name = "";
            for(int x = 0; x < lista.size()-1; x++)
            {                
                name = lista.get(x);                
                valor = entorno.insertarSimbolo(new Simbolo(name, tipo, "var","nada"));                         
            }
            valor = exp.ejecutar(entorno).valor;
            if(valor instanceof Hashtable)
            {
                Object ventana = ((Hashtable)valor).get("ventana");
                if(ventana!=null)                
                {
                    Simbolo sventana = entorno.getSimbolo(ventana.toString());
                    if(sventana!=null)
                    {
                        ((Hashtable)((Hashtable)sventana.valor).get("contenido")).remove(((Hashtable)((Hashtable)sventana.valor).get("contenido")).size());
                        ((Hashtable)((Hashtable)sventana.valor).get("contenido")).put(lista.get(0), valor);
                    }
                }else
                {
                    Object contenedor = ((Hashtable)valor).get("contenedor");
                    if(contenedor!=null)
                    {
                        if(contenedor instanceof Hashtable)
                        {
                            Object nombreVentana = ((Hashtable)contenedor).get("ventana");
                            if(nombreVentana !=null)
                            {
                                Simbolo s2ventana = entorno.getSimbolo(nombreVentana.toString());
                                if(s2ventana !=null)
                                {
                                    Object contenido = ((Simbolo)s2ventana).valor;
                                    if(contenido instanceof Hashtable)
                                    {
                                        //Object contenedor = ((Hashtable)contenido).get()
                                    }
                                }
                            }
                        }
                    }
                }
            }
            determinarTipo(valor);             
            valor = entorno.insertarSimbolo(new Simbolo(lista.get(lista.size()-1),tipo , "var",exp.ejecutar(entorno).valor));                        
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
        if(valor instanceof Hashtable)
        {
            this.tipo = "objeto";
        }
        else
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
        valor = "";
        setValor(entorno);
        return this;
    }
    
}
