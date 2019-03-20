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
    public Exp acceso;
    public Exp exp;
    
    public AccesoArray(int l, int c, Exp i, Exp e)
    {
        this.linea = l;
        this.columna = c;
        this.acceso = i;
        this.exp = e;
    }

    public void setValor(Entorno entorno)
    {
        Object pos = exp.ejecutar(entorno).valor;
        Object variable = acceso.ejecutar(entorno);
        if((pos instanceof Integer)||(pos instanceof Double))
        {            
            if(variable instanceof idExp)
            {
                variable = ((idExp)variable).id;
                int p = (Integer)pos;
                Simbolo sim = entorno.getSimbolo(variable.toString());
                if(sim!=null)
                {
                    if(sim.valor!=null)
                    {
                        if(sim.valor instanceof ArrayList)
                        {
                            ArrayList<Object> l = (ArrayList<Object>) sim.valor;
                            if( p > l.size()-1)
                            {
                                singlenton.addErrores(new error("semantico",linea,columna,variable.toString(),"Error de índice, sobrepasado."));
                            }
                            else
                            {
                                valor = l.get(p);
                            }
                        }
                        else
                        {
                            singlenton.addErrores(new error("semantico",linea,columna,variable.toString(),"La variable no es de tipo arreglo."));
                        }
                    }
                }                 
            }
            else
            if(variable instanceof AccesoArray)
            {
                System.out.println("Segundo acceso");
            }
        }
        else
        {
            singlenton.addErrores(new error("semantico",linea,columna,variable.toString(),"Se requiere de un valor númerico para poder acceder a dicha posición."));
        }
    }
    
    
    
    @Override
    public Nodo generar3D(Entorno entorno) {
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
