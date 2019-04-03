/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Analisis.Fs.parserfs;
import Analisis.Fs.scannerfs;
import Analisis.XML.parserxml;
import Analisis.XML.scannerxml;
import Recursos.error;
import Recursos.singlenton;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class Importar extends Nodo
{
    public Nodo direccion;
    
    public Importar(int l, int c, Nodo dir)
    {
        this.linea = l;
        this.columna = c;
        this.direccion = dir;
    }
    
    
    public void setValor(Entorno entorno) 
    {
        String path = direccion.ejecutar(entorno).valor.toString();
        String pathRaiz = entorno.ventana.direcciones.get(entorno.ventana.archivoActual);
        pathRaiz = pathRaiz.substring(0, pathRaiz.length()-entorno.ventana.archivoActual.length()-1);
        parserfs parserfs_;
        scannerfs scannerfs_;
        String pathReal = pathRaiz+"\\"+path.replace("/", "\\");
        try 
        {
            scannerfs_ = new scannerfs(new java.io.FileReader(pathRaiz+path));
            parserfs_ = new parserfs(scannerfs_);
            parserfs_.parse();
            valor = parserfs_.metodo;
//            if(!parserfs_.lista.isEmpty())
//            {
//                singlenton.addAST(parserfs_.lista);
//            }            
        } 
        catch (FileNotFoundException ex) // Error de que no exista el archivo.
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,"No se ha encontrado el archivo"));
        } 
        catch (Exception ex) // Errores internos de cup o flex
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,ex.getLocalizedMessage()));
        }
                
    }

    @Override
    public Nodo generar3D(Entorno entorno) {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
    
}
