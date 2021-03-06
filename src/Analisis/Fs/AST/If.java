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
public class If extends Sentencia{
    public Exp cond;
    public Bloque bloque;
    
    public If(Exp c, Bloque b)
    {
        cond = c;
        bloque = b;
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        cond.lf = entorno.ventana.generarEtiqueta(); // Etiqueta falso.
        cond.lv = entorno.ventana.generarEtiqueta(); // Etiqueta falso.
        cond.generar3D(entorno);
        entorno.ventana.add3d(cond.lv+ ": <verdadero>");
        entorno.ventana.add3d(cond.lf+ ": <falso>");
        return this;
    }    
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        
        valor = "";
        Object condicion = cond.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {
//            if((Boolean)condicion)
//            {                
//                valor = bloque.ejecutar(entorno).valor;
//            } 
            if((Boolean)condicion)
            {
                for (Nodo sentencia : bloque.sentencias) 
                {                         
                    valor = sentencia.ejecutar(entorno).valor;            
                    if(valor instanceof Retorno)
                    {
                        //valor = Display.getRetornoActual().ejecutar(entorno).valor;
                        //return;
                        break;
                    } 
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
