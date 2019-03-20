/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.Display;
import Recursos.singlenton;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Seleccion extends Nodo
{
    public Nodo condicion;
    public ArrayList<Caso> lcasos;
    public Seleccion(int l, int c, Nodo condicion, ArrayList<Caso> lista)
    {
        this.linea = l;
        this.columna = c;
        this.condicion = condicion;
        this.lcasos = lista;
    }
    
    public void setValor(Entorno entorno)
    {
        boolean flag = false;
        Display.add(this);
        for(Caso caso :lcasos)
        {
            Object instruccionActual = Display.instruccionActual();
            if(this==instruccionActual )
            {
                if(!flag)
                {
                    if(caso.condicion !=null)
                    {
                        Igual expresion = new Igual(caso.condicion, condicion);
                        Object resultado = expresion.ejecutar(entorno).valor;
                        if(resultado instanceof Boolean)
                        {
                            if((Boolean)resultado)
                            {
                                caso.ejecutar(entorno);
                                flag = true;
                            }
                        }
                        else
                        {
                            //Error cerote.
                        }                    
                    }
                    else
                    {
                            caso.ejecutar(entorno);
                            flag = true;                    
                    }

                }else
                {
                   caso.ejecutar(entorno); 
                }                
            }
        }
        if(Display.instruccionActual()== this)
        {
            Display.quitar();
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
