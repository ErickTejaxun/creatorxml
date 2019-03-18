/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.Display;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Bloque extends Sentencia{

    public ArrayList<Sentencia> sentencias ;
    public String id;
    public Bloque(String i)
    {
        id = i;
        sentencias = new ArrayList<Sentencia>();
    }
    public Bloque()
    {
        id = "";
        sentencias = new ArrayList<Sentencia>();
    }  
    
    public Bloque(ArrayList<Sentencia> s)
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
        for(Sentencia s: sentencias)
        {
            s.generar3D(entorno);
        }
        return this;
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        for (Sentencia sentencia : sentencias) 
        {
            if(sentencia instanceof Bloque)
            {
                sentencia.ejecutar(new Entorno(entorno,entorno.ventana));
            }
            else if(sentencia instanceof Romper)
            {
                if(Display.esValido()!=null)
                {
                    Display.quitar();
                    return this;
                }
                else
                {
                    entorno.ventana.setSalida("Error semantico, break no se encuentra dentro de un ciclo");
                }                
            }
            else if(sentencia instanceof Continuar)
            {                
                if(Display.esValido()!=null)
                {
                    if(Display.esValido() instanceof Continuar)
                    {
                        continue;
                    }
                }
                else
                {
                    entorno.ventana.setSalida("Error semantico, continue no se encuentra dentro de un ciclo");
                }                                
            }
            else
            {
                sentencia.ejecutar(entorno);
            }            
        }
        return this;
    }
    
}
