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
public class DoubleExp extends Exp{
    public double num;
    public DoubleExp(double n)
    {
        num = n;
    }

    public void setValor()
    {
        valor = num;
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        setValor();
        valor2 = valor+"";
        return this;
    }
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        valor = "";
        setValor();
        return this;
    }
}
