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
public class IntExp  extends Exp{
    public int num;
    public IntExp(int n)
    {
        num = n;
    }

    public void setValor()
    {
        valor = num;
    }
    

    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor();
        return this;
    }

    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        setValor();
        valor2 =  valor +"";        
        return this;
    }
}
