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
public class Asignacion extends Sentencia{
    public String id;
    public Exp exp;
    public String tipo="";
    public Asignacion(String i, Exp e)
    {
        id = i;
        exp = e;
    }

    public Asignacion(String i, Exp e, String t)
    {
        id = i;
        exp = e;
        tipo = t;
    }    
    
    public void setValor(Entorno entorno)
    {
        switch(tipo)
        {
            case "=":
                valor = entorno.actualizarSimbolo(id, exp.ejecutar(entorno).valor);
                break;                
            case "+=":
                Suma plus = new Suma(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, plus.ejecutar(entorno).valor);
                break;
            case "-=":
                Resta minus = new Resta(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, minus.ejecutar(entorno).valor);
                break;
            case "*=":
                Multi mul = new Multi(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, mul.ejecutar(entorno).valor);
                break;
            case "/=":
                Div division = new Div(new idExp(id), exp );
                valor = entorno.actualizarSimbolo(id, division.ejecutar(entorno).valor);
                break;                            
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
        setValor(entorno);
        return this;
    }
}
