/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.Hashtable;

/**
 *
 * @author erick
 */
public class Acceso extends Exp
{
    public Nodo origen, atributo;
    public Acceso(int l, int c, Nodo o, Nodo a)
    {
        this.linea = l;
        this.columna = c;
        this.origen = o;
        this.atributo =a;
    }
    
    public void setValor(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            String nombreVar = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(nombreVar);
            if(variable!=null)
            {
                if(variable.tipo.equals("objeto"))
                {
                    String nombreAtributo = ((idExp)atributo).id;
                    if(variable.valor instanceof Hashtable)
                    {
                        Object valorAtributo = ((Hashtable)variable.valor).get(nombreAtributo);
                        if(valorAtributo !=null)
                        {
                            valor = valorAtributo;
                        }
                        else
                        {
                            singlenton.addErrores(new error("semantico",linea,columna, nombreAtributo ,"La variable "+nombreVar +" no tiene el atributo solicitado."));
                        }
                    }
                }
                else
                {
                    singlenton.addErrores(new error("semantico",linea,columna, nombreVar ,"No es una variable de tipo objeto."));
                }
            }
        }
        else
        if(origen instanceof Acceso)
        {
            Object variable = origen.ejecutar(entorno).valor;
            if(variable instanceof Simbolo)
            {
                
            }
        }
        else 
        if(origen instanceof AccesoArray)
        {
            Object variable = origen.ejecutar(entorno).valor;
            if(variable instanceof Hashtable)
            {
                if(atributo instanceof idExp)
                {
                    String nombreAtributo = ((idExp)atributo).id;
                    Object valorVarible = ((Hashtable)variable).get(nombreAtributo);
                    if(valorVarible!=null)
                    {
                        valor = valorVarible;
                    }                 
                    else
                    {
                       singlenton.addErrores(new error("semantico",linea,columna, nombreAtributo ,"No se ha encontrado el atributo solicitado.")); 
                    }
                }
            }
            else
            if(variable instanceof Simbolo)
            {
                if(((Simbolo)variable).valor instanceof Hashtable)
                {
                    if(atributo instanceof idExp)
                    {
                        String nombreAtributo = ((idExp)atributo).id;
                        Object valorVarible = ((Hashtable)((Simbolo)variable).valor).get(nombreAtributo);
                        if(valorVarible!=null)
                        {
                            valor = valorVarible;
                        }                 
                        else
                        {
                           singlenton.addErrores(new error("semantico",linea,columna, nombreAtributo ,"No se ha encontrado el atributo solicitado.")); 
                        }
                    }
                }               
            }
        }
    }
    
    
    @Override
    public Nodo generar3D(Entorno entorno) {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) {
        valor = "";
        setValor(entorno);
        return this;
    }
    
}
