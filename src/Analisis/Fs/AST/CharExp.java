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
public class CharExp extends Exp{
    public char cad ;
    public CharExp(char c)
    {
        cad = c;
    }

    public void setValor()
    {
        valor = cad;
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
        setValor();
        return this;
    }
}
