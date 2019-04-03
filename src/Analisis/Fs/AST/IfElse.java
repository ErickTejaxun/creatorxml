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
        Object condicion = cond.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {
            if((Boolean)condicion)
            {                
                valor = bloque.ejecutar(entorno).valor;
            }
            else
            {
                valor = ifelse.ejecutar(entorno).valor;
            }
            
            if(valor instanceof Retorno)
            {
                return this;
            }
        }
        else
        {
            entorno.ventana.setSalida("Error de tipo, se esperaba un tipo booleano\tLinea"+linea+"\t:Columna"+columna);
        }
        return this;
    }
    
}
