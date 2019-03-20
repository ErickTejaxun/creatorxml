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
public class Retorno extends Nodo
{
    public Nodo expresion;
    public Retorno(int l, int c, Nodo e)
    {
        this.linea = l;
        this.columna = c;
        this.expresion = e;
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
        valor = expresion.ejecutar(entorno).valor;          
        return this;
    }
    
}
