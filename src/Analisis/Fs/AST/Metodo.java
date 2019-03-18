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

    public ArrayList<Sentencia> sentencias ;
    public ArrayList<Sentencia> declaracionParametros;
    public ArrayList<Exp> listaParametros;
    public String id;    
    public String tipo;
    
    
    public Metodo(String i, String t, ArrayList<Sentencia> s)
    {
        id = i;
        sentencias = s;
        tipo = t;
        
    }
    
    public void setListaParametros(ArrayList<Exp> l)
    {
        listaParametros = l;
    }
    
    public Metodo(ArrayList<Sentencia> s)
    {
        id = "";
        sentencias = s;
    }

    public void setSentencias(ArrayList<Sentencia> sentencias) {
        this.sentencias = sentencias;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    
    public void add(Sentencia s)
    {
        sentencias.add(s);
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        for (Sentencia sentencia : sentencias) 
        {
            if(sentencia instanceof Metodo)
            {
                sentencia.ejecutar(new Entorno(entorno,entorno.ventana));
            }
            else
            {
                sentencia.ejecutar(entorno);
            }
        }
        return this;
    }
    
}
