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
        //System.out.println("----------------LLAMADA---------------------");
        if(s.valor instanceof Metodo)
        {            
            int indice = 0;
            ArrayList<Nodo> valores = new ArrayList<Nodo>();
            String llamada = id+"(";
            for(Exp parametro :parametros)
            {
                Object resultado = parametro.ejecutar(entorno).valor;
                if(resultado instanceof Integer)
                {
                    valores.add(new IntExp((Integer)resultado));
                }
                else
                if(resultado instanceof String)
                {
                    valores.add(new StringExp((String)resultado));
                }                
                else
                if(resultado instanceof Double)
                {
                    valores.add(new DoubleExp((Double)resultado));
                }   
                else
                if(resultado instanceof Boolean)
                {
                    valores.add(new BoolExp((Boolean)resultado));
                }   
                else
                {
                    if(resultado instanceof Simbolo)
                    {
                        valores.add( new idExp(((Simbolo)resultado).id));
                    }                    
                }
                
            }
            for(Nodo parametro :valores)
            {
                llamada+= ((IntExp)parametro).num+",";
                Declaracion dec = ((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice));
                dec.exp = (Exp)parametro;
                dec.ejecutar(entornoLocal);
                //((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).exp = parametro;
                //((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).ejecutar(entornoLocal);
                indice++;
            }            
            System.out.println(llamada+")");
//            for(Exp parametro :parametros)
//            {
//                Declaracion dec = ((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice));
//                dec.exp = parametro;
//                dec.ejecutar(entornoLocal);
//                //((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).exp = parametro;
//                //((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice)).ejecutar(entornoLocal);
//                indice++;
//            }
            /*Primero declaramos los valores*/            
            valor = ((Metodo)s.valor).bloque.ejecutar(entornoLocal).valor;
            if(valor == null)
            {
                valor ="";
            }
            //hanoi(3,1,2,3)
            //funcion Hanoi(var discos, var origen, var auxiliar, var destino)
            //Hanoi(discos - 1, origen, destino, auxiliar);
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
        return this;
    }
}
