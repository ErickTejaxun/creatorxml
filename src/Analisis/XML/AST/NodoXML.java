/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;
import Recursos.*;
import CreatorXml201213050.Interfaz;

/**
 *
 * @author erick
 */
public abstract class NodoXML 
{
    public Object valor = "";
    public int linea, columna;    
    public abstract NodoXML ejecutar(Interfaz ventana);
}
