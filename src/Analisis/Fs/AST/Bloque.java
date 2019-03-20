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

    public ArrayList<Nodo> sentencias ;
    public String id;
    public Metodo actual;
    public Bloque(String i)
    {
        id = i;
        sentencias = new ArrayList<Nodo>();
    }
    public Bloque()
    {
        id = "";
        sentencias = new ArrayList<Nodo>();
    }  
    
    public Bloque(ArrayList<Nodo> s)
    {
        id = "";
        sentencias = s;
    }

    public void setSentencias(ArrayList<Nodo> sentencias) {
        this.sentencias = sentencias;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    
    public void add(Nodo s)
    {
        sentencias.add(s);
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        for(Nodo s: sentencias)
        {
            s.generar3D(entorno);
        }
        return this;
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        valor = "";
        primeraPasada(entorno.ventana.entornoGlobal);
        ejecutarInstrucciones(entorno);        
        return this;
    }
    
    public void primeraPasada(Entorno entorno)
    {
        for (Nodo sentencia : sentencias) 
        {
            if(sentencia instanceof Metodo)
            {
                sentencia.ejecutar(entorno);
            }
        }        
    }
        
    public void ejecutarInstrucciones(Entorno entorno)
    {
        for (Nodo sentencia : sentencias) 
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
                    return;
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
            else if(sentencia instanceof Retorno)
            {
                valor = sentencia.ejecutar(entorno).valor;              
                return;
            }   
            else 
            if(sentencia instanceof Llamada)
            {
                valor = sentencia.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
            }
            else
            {     
                valor = sentencia.ejecutar(entorno);
                if(((Nodo)valor).valor3!=null)
                {
                    valor = sentencia.ejecutar(entorno).valor;
                    return;
                }
            }
        }        
    }
    
}
