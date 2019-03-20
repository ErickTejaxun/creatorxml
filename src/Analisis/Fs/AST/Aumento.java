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
public class Aumento extends Exp{    
    public Nodo id;
    public Aumento(idExp i)
    {
        id = i;        
    }
    public Aumento(int l, int c ,Nodo i)
    {
        id = i;        
        linea = l;
        columna = c;
    }    
    
    public void setValor(Entorno entorno)
    {
        String nombre = "";
        if(id instanceof idExp)
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
            nombre = ((idExp)id).id;
            switch(operacion)
            {

                case 1: // int                                   
                    valor = entorno.actualizarSimbolo(nombre, Integer.parseInt(v1.toString())+1);
                    valor = Integer.parseInt(v1.toString())+1;
                    break;
                case 2: // double                                                          
                    valor = entorno.actualizarSimbolo(nombre, Double.parseDouble(v1.toString()) + 1);
                    valor = Double.parseDouble(v1.toString()) + 1;                
                    break;                
                default:
                    //entorno.ventana.setSalida("Error de tipos en aumento linea:"+linea + "\tColumna:"+columna);
                    singlenton.addErrores(new error("semantico",linea,columna, nombre +" ++","Error de tipos en la operación aumento."));
                    break;
            }              
        }
        if(id instanceof AccesoArray)
        {            
            Object v1 = id.ejecutar(entorno).valor;        
            if((v1 instanceof Integer) || (v1 instanceof Double))
            {                
                Asignacion tmp = new Asignacion(id, new Suma(id, new IntExp(1)), "=");
                tmp.ejecutar(entorno);
                valor = id.ejecutar(entorno).valor;
            }   
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna, nombre +" ++","Error de tipos en la operación aumento."));
            }              
        } 
        if(id instanceof Acceso)
        {            
            Object v1 = id.ejecutar(entorno).valor;
            if((v1 instanceof Integer))
            {                
                Asignacion tmp = new Asignacion(id, new Suma(new IntExp((Integer)v1), new IntExp(1)), "=");
                tmp.ejecutar(entorno);
                valor = id.ejecutar(entorno).valor;
            }   
            else
            if((v1 instanceof Double))
            {                
                Asignacion tmp = new Asignacion(id, new Suma(new DoubleExp((Double)v1), new IntExp(1)), "=");
                tmp.ejecutar(entorno);
                valor = id.ejecutar(entorno).valor;
            }               
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna, nombre +" ++","Error de tipos en la operación aumento."));
            }
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
        valor = "";
        setValor(entorno);
        return this;
    }
}
