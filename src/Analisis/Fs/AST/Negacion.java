/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

/**
 *
 * @author erick
 */
public class Negacion extends Exp
{
    public Exp valor1;
        
    public Negacion(Exp val1)
    {
        this.valor1 = val1;
        
    }

    public void setValor(Entorno entorno)
    {
        Object val1 = this.valor1.ejecutar(entorno).valor;               
        if(val1 instanceof Boolean)
        {
            Boolean v1 = (Boolean)val1;          
            this.valor = !v1;
        }        
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        valor2 = (String) valor;
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
