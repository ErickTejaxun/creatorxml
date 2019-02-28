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
public class Contenedor extends NodoXML
{
    public Contenedor(int l, int c)
    {
        linea = l;
        columna = c;
    }
    
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) {
        return this;
    }
    
}
