/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.Display;

/**
 *
 * @author erick
 */
public class For extends Sentencia{    
    public Nodo inicio; // Asignacion inicial.
    public Exp cond;// Condicion a verificar
    public Nodo actualizacion; // Aumento o decremento
    public Bloque bloque; // bloque de instrucciones
    
    public For(Nodo  i, Exp c, Nodo a, Bloque b)
    {
        this.inicio = i;
        this.cond = c;
        this.actualizacion = a;
        this.bloque = b;        
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
        /*Ejecucion del if*/
        inicio.ejecutar(entorno);
        Object condicion = cond.ejecutar(entorno).valor;
        /*Ejecucion del if*/
        Display.add(this);        
        if(condicion instanceof Boolean)
        {
            while((Boolean)condicion)
            {                           
                for(Nodo sentencia:bloque.sentencias)
                {                      
                    if((For)Display.instruccionActual() != this)
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
                actualizacion.ejecutar(entorno); // Actualizamos el valor.
            }            
        }
        else
        {
            entorno.ventana.setSalida("Error de tipo, se esperaba un tipo booleano\tLinea"+linea+"\t:Columna"+columna);
        }
        
        return this;
    }
    
}
