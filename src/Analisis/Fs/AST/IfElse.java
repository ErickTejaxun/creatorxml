/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.Display;
import Recursos.singlenton;

/**
 *
 * @author erick
 */
public class IfElse extends Sentencia{
    public Exp cond;    
    public Bloque bloque;
    public Nodo ifelse;
    
    public IfElse(Exp c, Bloque b, Nodo el)
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
        valor = "";
        /*Ejecucion del if*/
        Object condicion = cond.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {            
            if((Boolean)condicion)
            {                
                Entorno ent = new Entorno(entorno, entorno.ventana);
                for(Nodo s: bloque.sentencias)
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
                       valor =  s.ejecutar(ent);                       
                    }                    
                    if(valor instanceof Retorno)
                    {                                                
                        return this;
                    }  
                }
            }
            else
            {
                valor = ifelse.ejecutar(entorno).valor;                
                if(valor instanceof Retorno)
                {   
                    System.out.println("------------------------------PUTA MADRE1------------------------" + ((Retorno)valor).ejecutar(entorno));
                    //Object resultado = ((Nodo)valor).ejecutar(entorno).valor;
                    //Display.agregarRetorno((Nodo)resultado);                    
                    return this;
                } 
                if(valor instanceof IfElse)
                {
                    System.out.println("------------------------------PUTA MADRE------------------------");
                }
            }
        }
        else
        {
            entorno.ventana.setSalida("Error de tipo, se esperaba un tipo booleano\tLinea"+linea+"\t:Columna"+columna);
        }        
        return this;
    }
    
}
