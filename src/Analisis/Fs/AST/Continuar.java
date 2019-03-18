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
public class Continuar extends Sentencia{    


    public Continuar() 
    {
        
    }
       
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        
        return this;
    }
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {        
        return this;
    }
}
