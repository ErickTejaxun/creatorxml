/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import CreatorXml201213050.Interfaz;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class LDato extends NodoXML
{
    public String accion;
    public ArrayList<Dato> lista ;
    public LDato(ArrayList<Dato> l)
    {
        lista = l;
        accion = "";
    }
    
    public LDato(ArrayList<Dato> list,String a, int l, int c)
    {        
        accion = a;
        lista = list;
        linea = l;
        columna = c;
    }
    public LDato(ArrayList<Dato> list, int l, int c)
    {        
        accion = "";
        lista = list;
        linea = l;
        columna = c;
    }    
    
    public void generarCodigo(Interfaz ventana)
    {
        valor = "var lista"+singlenton.getContadorLista() +" = [";
        String valores = "";
        int contador = 0;
        for(Dato d: lista)
        {
            valor += d.ejecutar(ventana).valor.toString();
            if(contador < lista.size()-1)
            {
                valor+=",";
            }
            contador++;
        }
        valor +=valores +"];";
        ventana.addCuerpoFinal((String) valor);
    }
    
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {      
        generarCodigo(ventana);
        return this;
    }
    
}
