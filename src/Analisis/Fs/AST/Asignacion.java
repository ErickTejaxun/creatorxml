/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author erick
 */
public class Asignacion extends Sentencia{
    public Nodo id;
    public Exp exp;
    public String tipo="";
    public Asignacion(Nodo i, Exp e)
    {
        id = i;
        exp = e;
    }

    public Asignacion(Nodo i, Exp e, String t)
    {
        id = i;
        exp = e;
        tipo = t;
    }    
    
    public void setValor(Entorno entorno)
    {
        String id ="";
        if(this.id instanceof idExp)
        {
            id = ((idExp)this.id).id;
        }
        if(this.id instanceof AccesoArray)
        {
            AccesoArray acceso = (AccesoArray)this.id;
            Object val = acceso.acceso.ejecutar(entorno).valor;            
            if(val instanceof ArrayList)
            {
                Object posicion = acceso.exp.ejecutar(entorno).valor;
                if((posicion instanceof Integer) ||(posicion instanceof Double))
                {
                    int pos =(Integer)posicion;
                    if(pos < ((ArrayList)val).size())
                    {
                        ((ArrayList)val).add(pos, exp.ejecutar(entorno).valor);
                        valor = entorno.actualizarSimbolo(id, val);
                    }
                    else
                    {
                        singlenton.addErrores(new error("semantico",linea,columna,id,"La variable no es un arreglo."));
                    }
                }
                else
                {
                    singlenton.addErrores(new error("semantico",linea,columna,id,"Se esperaba un valor número como indice."));
                }
            }
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna,id,"La variable no es un arreglo."));
            }
        }
        switch(tipo)
        {
            case "=":
                valor = entorno.actualizarSimbolo(id, exp.ejecutar(entorno).valor);
                break;                
            case "+=":
                Suma plus = new Suma(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, plus.ejecutar(entorno).valor);
                break;
            case "-=":
                Resta minus = new Resta(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, minus.ejecutar(entorno).valor);
                break;
            case "*=":
                Multi mul = new Multi(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, mul.ejecutar(entorno).valor);
                break;
            case "/=":
                Div division = new Div(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, division.ejecutar(entorno).valor);
                break;                            
        }


        if(this.id instanceof Acceso)
        {
            Acceso acceso = (Acceso)this.id;      
            String nombreVariable =((idExp) acceso.origen).id;
            Simbolo variable = entorno.getSimbolo(nombreVariable);
            String nombreAtributo ="";
            if(variable == null)
            {
                return;
            }
            if(variable.valor instanceof Hashtable)
            {
                nombreAtributo =((idExp) acceso.atributo).id;
                if(((Hashtable)variable.valor).get(nombreAtributo)==null)
                {
                    singlenton.addErrores(new error("semantico",linea,columna,nombreAtributo,"No existe el atributo en el objeto variable "+nombreAtributo));
                }
                
            }
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna,nombreVariable,"La variable no es un objeto."));
                return;
            }
            
            Object valorActual = ((Hashtable)variable.valor).get(nombreAtributo);
            Nodo operando = null;
            if(valorActual instanceof Integer)
            {
                operando = new IntExp((Integer)valorActual);
            }
            if(valorActual instanceof Double)
            {
                operando = new DoubleExp((Double)valorActual);
            }
            if(valorActual instanceof String)
            {
                operando = new StringExp((String)valorActual);
            }
            if(valorActual instanceof Boolean)
            {
                operando = new BoolExp((Boolean)valorActual);
            }            
            switch(tipo)
            {
                case "=":
                    ((Hashtable)variable.valor).put(nombreAtributo, exp.ejecutar(entorno).valor);                    
                    break;                
                case "+=":
                    Suma plus = new Suma(operando, exp );
                    ((Hashtable)variable.valor).put(nombreAtributo, plus.ejecutar(entorno).valor);                    
                    break;
                case "-=":
                    Resta minus = new Resta(operando, exp );
                    ((Hashtable)variable.valor).put(nombreAtributo, minus.ejecutar(entorno).valor);
                    break;
                case "*=":
                    Multi mul = new Multi(operando, exp );
                    ((Hashtable)variable.valor).put(nombreAtributo, mul.ejecutar(entorno).valor);
                    break;
                case "/=":
                    Div division = new Div(operando, exp );
                    ((Hashtable)variable.valor).put(nombreAtributo, division.ejecutar(entorno).valor);
                    break;                            
            } 
            valor = entorno.actualizarSimbolo(id, variable.valor);
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
