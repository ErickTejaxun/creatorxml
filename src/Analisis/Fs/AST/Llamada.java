/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Llamada extends Sentencia {
    public ArrayList<Exp> parametros;    
    public String id;
    public Llamada(String i, ArrayList<Exp> p)
    {
        id = i;
        parametros = p;
    }
    
    public void setValor(Entorno entorno)
    {
        ArrayList<String> listaTipos = new ArrayList<String>();
        ArrayList<Object> listaValores = new ArrayList<Object>();
        Object valor;
        for(Exp e : parametros)
        {
            valor = e.ejecutar(entorno).valor;
            listaValores.add(valor);
            if(valor instanceof String)
            {
                listaTipos.add("string");
            }
            if(valor instanceof Integer)
            {
                listaTipos.add("int");
            }
            if(valor instanceof Boolean)
            {
                listaTipos.add("boolean");               
            }
            if(valor instanceof Double)
            {
                listaTipos.add("double");                
            }
            if(valor instanceof Simbolo)// Es un objeto
            {
                listaTipos.add(((Simbolo) valor).tipo);
            }
        }
        /*
        Ahora ya tenemos el nombre de la funcion a llamar y también la lista de tipos de parametros        
        */
        String idMetodo = id;
        for(String tipo : listaTipos)
        {
            idMetodo += "$" + tipo;
        }
        /*Ahora ya tenemos el id del metodo buscado*/
        Simbolo metodo = entorno.getSimbolo(idMetodo);
        /*Ahora verificamos si existe con el id que generamos, si no existe habría que verificar los tipos y en caso
        sea necesario, realizar casteos a los valores necesarios.*/
        if(metodo!=null)
        {
            if(metodo.valor instanceof Sentencia)
            {
                
            }
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
        entorno.ventana.setSalida(valor.toString());
        System.out.println(valor.toString());
        return this;
    }
}
