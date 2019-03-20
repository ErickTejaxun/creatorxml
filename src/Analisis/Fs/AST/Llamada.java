/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Llamada extends Exp {
    public ArrayList<Exp> parametros;    
    public String id;
    public Llamada(String i, ArrayList<Exp> p)
    {
        id = i;
        parametros = p;
    }
    
    public Llamada(int l, int c, String i, ArrayList<Exp> p)
    {
        this.linea  = l;
        this.columna = c;
        id = i;
        parametros = p;
        
    }
        
    public void setValor(Entorno entorno)
    {
        
        valor = "";
        /*Obtener el id de la funcion a llamar*/
        Entorno entornoLocal = new Entorno(entorno, entorno.ventana);
        String idMetodo = id;
        for(Exp e : parametros)
        {
            idMetodo+="$var";
        }
        Simbolo s = entorno.ventana.entornoGlobal.getSimbolo(idMetodo);
        if(s==null)
        {
            singlenton.addErrores(new error("semantico",linea,columna, id,"El metodo no existe."));
            return;
        }
        if(s.valor instanceof Metodo)
        {            
            int indice = 0;
            for(Exp parametro :parametros)
            {
                ((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).exp = parametro;
                ((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).ejecutar(entornoLocal);
                indice++;
            }
            /*Primero declaramos los valores*/
            
            valor = ((Metodo)s.valor).bloque.ejecutar(entornoLocal).valor;
            if(valor == null)
            {
                valor ="";
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
        valor = "";
        setValor(entorno);                
//        entorno.ventana.setSalida(valor.toString());
//        System.out.println(valor.toString());
        return this;
    }
}
