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
public class BoolExp extends Exp{
    public boolean bool ;
    public BoolExp(boolean b)
    {
        bool = b;
    }

    public void setValor()
    {
        valor = bool;
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        setValor();
        valor2 = valor+"";
        return this;
    }
    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor();
        return this;
    }
}
