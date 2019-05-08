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
        ejecutarInstrucciones(new Entorno(entorno, entorno.ventana));        
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
            if(sentencia instanceof Importar)
            {
                
            }            
        }        
    }
        
    public void ejecutarInstrucciones(Entorno entorno)
    {                        
        for (Nodo sentencia : sentencias) 
        {                         
            valor = sentencia.ejecutar(entorno).valor;            
            if(valor instanceof Retorno)
            {
                valor = Display.getRetornoActual().ejecutar(entorno).valor;
                return;
                //break;
            } 
            if(valor instanceof Romper)
            {
                return;
            }
        }        
        //Display.quitarMetodo();
    }
    
}
