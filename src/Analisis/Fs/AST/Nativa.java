/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erick
 */
public class Nativa extends Exp
{   
    public String id;
    public String funcion;
    
    public Nativa (int l, int c, String i, String f)
    {
        this.linea = l;
        this.columna = c;
        this.id = i;
        this.funcion =f;
    }
    
    public void setValor(Entorno entorno)
    {
        switch(funcion)
        {
            case "descendente":
                OrdenarDescendente(entorno);
                break;
            case "ascendente":
                ordenarAscendente(entorno);
                break;    
            case "invertir":
                invertir(entorno);
                break;
            case "maximo":
                maximo(entorno);
                break;
            case "minimo":
                minimo(entorno);
                break;                
        }
    }
    
    public void minimo(Entorno entorno)
    {
        Simbolo variable = entorno.getSimbolo(id);
        if(variable!=null)
        {
            try 
            {
                if(variable.valor instanceof ArrayList)
                {
                   //Collections.reverse((ArrayList)variable.valor);
                   Object i = Collections.min((ArrayList)variable.valor);
                   valor =i;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }

        }
    }
    public void maximo(Entorno entorno)
    {
        Simbolo variable = entorno.getSimbolo(id);
        if(variable!=null)
        {
            try 
            {
                if(variable.valor instanceof ArrayList)
                {
                   //Collections.reverse((ArrayList)variable.valor);
                   Object i = Collections.max((ArrayList)variable.valor);
                   valor =i;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }

        }
    }
    
    public void invertir(Entorno entorno)
    {
        Simbolo variable = entorno.getSimbolo(id);
        if(variable!=null)
        {
            try 
            {
                if(variable.valor instanceof ArrayList)
                {
                   Collections.reverse((ArrayList)variable.valor);
                   valor = variable.valor;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }

        }
    }      
    public void ordenarAscendente(Entorno entorno)
    {
        Simbolo variable = entorno.getSimbolo(id);
        if(variable!=null)
        {
            try 
            {
                if(variable.valor instanceof ArrayList)
                {
                   Collections.sort((ArrayList)variable.valor);     
                   valor = variable.valor;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }

        }
    }    
    public void OrdenarDescendente(Entorno entorno)
    {
        Simbolo variable = entorno.getSimbolo(id);
        if(variable!=null)
        {
            try 
            {
                if(variable.valor instanceof ArrayList)
                {
                    Collections.sort((ArrayList)variable.valor); 
                    Collections.sort((ArrayList)variable.valor, Collections.reverseOrder()); 
                   valor = variable.valor;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
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
        setValor(entorno);
        return this;
    }
    
}
