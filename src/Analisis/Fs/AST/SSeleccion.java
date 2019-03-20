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
public class SSeleccion extends Exp
{
    public Nodo condicion, valorv, valorf;
    
    public SSeleccion(int l, int c, Nodo cond, Nodo v, Nodo f)
    {
        this.linea = l;
        this.columna = c;
        this.condicion = cond;
        this.valorv = v;
        this.valorf = f;
    }
    
    public void setValor(Entorno entorno)
    {
        Object condicion = this.condicion.ejecutar(entorno).valor;
        if(condicion instanceof Boolean)
        {
            if((Boolean)condicion)
            {
                valor = valorv.ejecutar(entorno).valor;
            }
            else
            {
                valor = valorf.ejecutar(entorno).valor;   
            }
        }
        else
        {
            singlenton.addErrores(new error("semantico",linea,columna, "seleccion","Se esperaba una condicion de tipo booleano"));
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
