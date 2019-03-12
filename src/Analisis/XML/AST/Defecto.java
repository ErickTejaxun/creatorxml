/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import CreatorXml201213050.Interfaz;

/**
 *
 * @author erick
 */
public class Defecto extends NodoXML
{
    public String defecto = "";
    public Defecto(String c)
    {
        defecto = c;
    }
    
    public Defecto(String v, int l, int c)
    {
        defecto = v;
        linea = l;
        columna = c;
    }
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {
        valor = defecto;
        return this;
    }
    
}
