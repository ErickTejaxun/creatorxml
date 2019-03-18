/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class AccesoArray  extends Exp
{
    public String id;
    public Exp exp;
    
    public AccesoArray(int l, int c, String i, Exp e)
    {
        this.linea = l;
        this.columna = c;
        this.id = i.toLowerCase();
        this.exp = e;
    }

    public void setValor(Entorno entorno)
    {
        Object pos = exp.ejecutar(entorno).valor;
        if((pos instanceof Integer)||(pos instanceof Double))
        {
            int p = (Integer)pos;
            Simbolo sim = entorno.getSimbolo(id);
            if(sim!=null)
            {
                if(sim.valor!=null)
                {
                    if(sim.valor instanceof ArrayList)
                    {
                        ArrayList<Object> l = (ArrayList<Object>) sim.valor;
                        if( p > l.size()-1)
                        {
                            singlenton.addErrores(new error("semantico",linea,columna,id,"Error de índice, sobrepasado."));
                        }
                        else
                        {
                            valor = l.get(p);
                        }
                    }
                    else
                    {
                        singlenton.addErrores(new error("semantico",linea,columna,id,"La variable no es de tipo arreglo."));
                    }
                }
            }            
        }
        else
        {
            singlenton.addErrores(new error("semantico",linea,columna,id,"Se requiere de un valor númerico para poder acceder a dicha posición."));
        }
    }
    
    
    
    @Override
    public Nodo generar3D(Entorno entorno) {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }

}
