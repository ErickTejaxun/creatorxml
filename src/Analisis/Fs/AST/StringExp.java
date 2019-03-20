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
public class StringExp extends Exp{
    public String cad ;
    public StringExp(String c)
    {
        cad = c;
    }

    public void setValor()
    {
        valor = cad;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor();
        return this;
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        valor = "";
        setValor();
        valor2 = valor+"";
        return this;
    }   
}
