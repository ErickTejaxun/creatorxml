/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import Recursos.singlenton;
import Analisis.XML.parserxml;
import Analisis.XML.scannerxml;
import CreatorXml201213050.InterfazIDE;
import Recursos.error;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class Importar extends NodoXML
{
    public String path;
    
    public Importar(String p , int l, int c)
    {
        path = p.replaceAll("\n", "").replace("\n", "").trim();
        linea = l;
        columna = c;
    }

    @Override
    public NodoXML ejecutar(InterfazIDE ventana) 
    {                       
        String pathRaiz = ventana.direcciones.get(ventana.archivoActual);
        pathRaiz = pathRaiz.substring(0, pathRaiz.length()-ventana.archivoActual.length()-1);
        parserxml parserxml_;
        scannerxml scannerxml_;
        String pathReal = pathRaiz+path.replace("/", "\\");
        try 
        {
            if(path.contains(".fs"))
            {
                valor = "importar (\""+path+"\");";
            }
            else
            {
                scannerxml_ = new scannerxml(new java.io.FileReader(pathRaiz+this.path));
                parserxml_ = new parserxml(scannerxml_);
                parserxml_.parse();
                if(!parserxml_.lista.isEmpty())
                {
                    singlenton.addAST(parserxml_.lista);
                }
            }
        } 
        catch (FileNotFoundException ex) // Error de que no exista el archivo.
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,"No se ha encontrado el archivo"));
        } 
        catch (Exception ex) // Errores internos de cup o flex
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,ex.getLocalizedMessage()));
        }
        ventana.addImportacion((String) valor);
        return this;
    }

        

    
}
