/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Analisis.XML.AST.NodoXML;
import Recursos.error;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class singlenton 
{
    public static ArrayList<error> listaErrores= new ArrayList(); 
    public static ArrayList<ArrayList<NodoXML>> listaAST = new ArrayList();
    public static int contadorListas = 0;
    
    public static int getContadorLista()
    {
        return contadorListas++;
    }
    
    public static void addErrores(error e)
    {
        listaErrores.add(e);
    }
    
    public static void addAST(ArrayList<NodoXML> n)
    {
        listaAST.add(n);
    }
    
}
