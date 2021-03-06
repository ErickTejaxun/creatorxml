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
public class Resta extends Exp{
    public Nodo left, right;       
    public Resta(Nodo l, Nodo r)
    {
        left = l;        
        right = r;
    }
    
    public void setValor(Entorno entorno)
    {
        Object v1 = left.ejecutar(entorno).valor;
        Object v2 = right.ejecutar(entorno).valor;       
        String tipo1 = "";
        String tipo2 = "";    
        /*Tipo del objeto 1 --------------------------*/
        if(v1 instanceof Integer)
        {
            tipo1 = "int";
        }else
        if(v1 instanceof Double)
        {
            tipo1 = "double";
        }else
        if(v1 instanceof String)
        {
            tipo1 = "string";
        }else
        if(v1 instanceof Boolean)
        {
            tipo1 = "bool";
        }else
        if(v1 instanceof Simbolo)
        {
            tipo1 = ((Simbolo)v1).tipo;
        }
        
        /*Tipo del objeto 2 --------------------------*/
        if(v2 instanceof Integer)
        {
            tipo2 = "int";
        }else
        if(v2 instanceof Double)
        {
            tipo2 = "double";
        }else
        if(v2 instanceof String)
        {
            tipo2 = "string";
        }else
        if(v2 instanceof Boolean)
        {
            tipo2 = "bool";
        }else
        if(v2 instanceof Simbolo)
        {
            tipo2 = ((Simbolo)v1).tipo;
        }        

        switch(tipo1)
        {
            case "int":
                switch(tipo2)
                {
                    case "int":
                        valor = Integer.parseInt(v1.toString()) -Integer.parseInt(v2.toString()); 
                        break;
                    case "double":
                        valor = Double.parseDouble(v1.toString()) - Double.parseDouble(v2.toString());  
                        break;
                    default:
                        //entorno.ventana.setSalida("Error de tipos operación suma, linea:"+linea + "\tColumna:"+columna);
                        //(String tipo, int linea, int columna, String valor,String descripcion)
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" - " +tipo2,"Error de tipos en la operación resta"));
                        break;
                }
                break;
            case "double":
                switch(tipo2)
                {
                    case "int":
                    case "double":
                        valor = Double.parseDouble(v1.toString()) - Double.parseDouble(v2.toString());  
                        break;
                    default:
                        //entorno.ventana.setSalida("Error de tipos operación suma, linea:"+linea + "\tColumna:"+columna);
                        //(String tipo, int linea, int columna, String valor,String descripcion)
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" - " +tipo2,"Error de tipos en la operación resta"));
                        break;
                }
                break;  
            case "string":
                switch(tipo2)
                {
                    default:
                        //entorno.ventana.setSalida("Error de tipos operación suma, linea:"+linea + "\tColumna:"+columna);
                        //(String tipo, int linea, int columna, String valor,String descripcion)
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" - " +tipo2,"Error de tipos en la operación resta"));
                        break;
                }
                break;  
            case "bool":
                switch(tipo2)
                {
                    default:
                        //entorno.ventana.setSalida("Error de tipos operación suma, linea:"+linea + "\tColumna:"+columna);
                        //(String tipo, int linea, int columna, String valor,String descripcion)
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" - " +tipo2,"Error de tipos en la operación resta"));
                        break;
                }
                break; 
            default:                                
                singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" - " +tipo2,"Error de tipos en la operación resta"));
                break;            
        }   
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        String v1 = left.generar3D(entorno).valor2;
        String v2 = right.generar3D(entorno).valor2;                  
        valor2 = entorno.ventana.generarTemporal();
        entorno.ventana.add3d(valor2 + "=" + v1 +"-" +v2 +";");       
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
