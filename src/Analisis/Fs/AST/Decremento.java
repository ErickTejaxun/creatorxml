/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;

/**
 *
 * @author erick
 */
public class Decremento extends Exp{    
    public idExp id;
    public Decremento(idExp i)
    {
        id = i;        
    }
    public Decremento(int l, int c, idExp i)
    {
        id = i;        
        linea = l;
        columna = c;
    }
        
    public void setValor(Entorno entorno)
    {
        Object v1 = id.ejecutar(entorno).valor;        
        int operacion = 0;
        if(v1 instanceof Integer)
        {
            operacion += 1;
        }
        if(v1 instanceof Double)
        {
            operacion += 2;
        }

        
        
        switch(operacion)
        {
            
            case 1: // int                                   
                valor = entorno.actualizarSimbolo(id.id, Integer.parseInt(v1.toString())-1);
                valor = Integer.parseInt(v1.toString())-1;
                break;
            case 2: // double                                                          
                valor = entorno.actualizarSimbolo(id.id, Double.parseDouble(v1.toString()) - 1);
                valor = Double.parseDouble(v1.toString()) - 1;                
                break;                
            default:
                //entorno.ventana.setSalida("Error de tipos en aumento linea:"+linea + "\tColumna:"+columna);
                singlenton.addErrores(new error("semantico",linea,columna,id.id +" --","Error de tipos en la operación decremento."));
                break;
        }      
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
}
