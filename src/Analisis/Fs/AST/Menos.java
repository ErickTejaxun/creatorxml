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
public class Menos extends Exp{
    public Exp exp;
    public Menos(Exp e)
    {
        exp = e;                       
    }
    
    public void setValor(Entorno entorno)
    {
        Object v1 = exp.ejecutar(entorno).valor;               
        String tipo1 = "";
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
            
        
        switch(tipo1)
        {
            case "int": // int + int
                valor = Integer.parseInt(v1.toString()) * -1;
                break;
            case "double":
                valor = Double.parseDouble(v1.toString()) * -1;
                break;                
            default:
                singlenton.addErrores(new error("semantico",linea,columna,tipo1 ,"Error de tipos en la operación menos"));
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
