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
public class IfElse extends Sentencia{
    public Exp cond;    
    public Bloque bloque;
    public Sentencia ifelse;
    
    public IfElse(Exp c, Bloque b, Sentencia el)
    {
        cond = c;
        bloque = b;
        ifelse = el;
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        /*Ejecucion del if*/
        Object condicion = cond.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {            
            if((Boolean)condicion)
            {
                Entorno ent = new Entorno(entorno, entorno.ventana);
                for(Sentencia s: bloque.sentencias)
                {                    
                    if(s instanceof Romper)
                    {
                        if((boolean)Display.esValido())
                        {
                            Display.quitar();
                            return this;
                        }
                        else
                        {
                            entorno.ventana.setSalida("Error, break no válido.\tLinea"+linea+"\t:Columna"+columna);
                        }
                    }
                    else
                    {
                        s.ejecutar(ent);
                    }                    
                }                            
            }
            else
            {
                ifelse.ejecutar(entorno);
            }
        }
        else
        {
            entorno.ventana.setSalida("Error de tipo, se esperaba un tipo booleano\tLinea"+linea+"\t:Columna"+columna);
        }        
        return this;
    }
    
}
