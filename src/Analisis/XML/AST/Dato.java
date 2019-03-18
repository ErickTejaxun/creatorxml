/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import CreatorXml201213050.InterfazIDE;

/**
 *
 * @author erick
 */
public class Dato extends NodoXML
{
    public String defecto = "";
    public Dato(String c)
    {
        defecto = c;
    }
    
    public Dato(String v, int l, int c)
    {
        defecto = v;
        linea = l;
        columna = c;
    }
    
    @Override
    public NodoXML ejecutar(InterfazIDE ventana) 
    {
        valor = defecto;
        return this;
    }
    
}
