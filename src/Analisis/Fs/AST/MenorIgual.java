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
public class MenorIgual extends Exp{
    public Exp left, right;    
    public MenorIgual(Exp l, Exp r)
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
                        valor = Integer.parseInt(v1.toString()) <= Integer.parseInt(v2.toString()); 
                        break;
                    case "double":
                        valor = Double.parseDouble(v1.toString()) <= Double.parseDouble(v2.toString());  
                        break;
                    default:
                        valor = false;
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" <= " +tipo2,"Error de tipos en la operación <="));
                        break;
                }
                break;
            case "double":
                switch(tipo2)
                {
                    case "int":
                    case "double":
                        valor = Double.parseDouble(v1.toString()) <= Double.parseDouble(v2.toString());  
                        break;
                    default:
                        valor = false;
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" <= " +tipo2,"Error de tipos en la operación <="));
                        break;
                }
                break;  
            case "string":
                switch(tipo2)
                {
                    case "string":
                        char array1[] = v1.toString().toCharArray();
                        char array2[] = v2.toString().toCharArray();
                        int suma1 = 0, suma2=0;
                        for(char c : array1)
                        {
                            suma1 += c;
                        }
                        for(char c : array2)
                        {
                            suma2 += c;
                        }                        
                        valor = suma1 <= suma2;
                        break;
                    default:
                        valor = false;
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" <= " +tipo2,"Error de tipos en la operación <="));
                        break;
                }
                break;  
            case "bool":
                switch(tipo2)
                {
                    case "bool":
                        int valor1 = 0, valor2 = 0;
                        if((Boolean)v1){valor1=1;}
                        if((Boolean)v2){valor2=1;}
                        valor = valor1 <= valor2;                        
                        break;
                    default:
                        valor = false;
                        singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" <= " +tipo2,"Error de tipos en la operación <="));
                        break;
                }
                break; 
            default:                                
                singlenton.addErrores(new error("semantico",linea,columna,tipo1 +" <= " +tipo2,"Error de tipos en la operación <="));
                break;            
        }                   
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        int tipo = 0;
        if(left instanceof Suma)
        {
            tipo = 1;
        }
        if(left instanceof Menos)
        {
            tipo = 1;
        }  
        if(left instanceof Multi)
        {
            tipo = 1;
        }
        if(left instanceof Div)
        {
            tipo = 1;
        }        
        
            String t1 = left.generar3D(entorno).valor2;
            String t2 = right.generar3D(entorno).valor2;
            lv = entorno.ventana.generarEtiqueta();
            lf = entorno.ventana.generarEtiqueta();
            valor2= "if " + t1 + " <= " + t2 +" goto "+lv + ";\ngoto "+lf+";";                

        entorno.ventana.add3d(valor2);
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
