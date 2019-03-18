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
public class While extends Sentencia{
    public Exp cond;
    public Bloque bloque;
    public ArrayList<Sentencia> instrucciones;
    public While(Exp c, Bloque b)
    {
        cond = c;
        bloque = b;
        instrucciones = b.sentencias;
    }
    
    
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        /*Ejecucion del if*/
        Display.add(this);
        Object condicion = cond.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {
            while((Boolean)condicion)
            {                           
                for(Sentencia sentencia:instrucciones)
                {  
                    /*Verificamos is hay un break;*/
                    if((While)Display.instruccionActual() != this)
                    {
                        return this;
                    }                    
                    if((sentencia instanceof While) || (sentencia instanceof For))
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
                            Display.quitar();
                            break;                            
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
                condicion = cond.ejecutar(entorno).valor;
            }            
        }
        else
        {
            entorno.ventana.setSalida("Error de tipo, se esperaba un tipo booleano\tLinea"+linea+"\t:Columna"+columna);
        }
        return this;
    }
    
        @Override
    public Nodo generar3D(Entorno entorno) 
    {
        valor2 = (String) valor;
        return this;
    }
    
}
