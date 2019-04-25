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
import Recursos.Display;
import Recursos.error;
import Recursos.singlenton;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
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
        path = path.replace("/", "\\");
        String pathReal = pathRaiz+"\\"+path.replace("/", "\\");
        StringTokenizer tokenPartesPath = new StringTokenizer(pathRaiz,"\\");
        StringTokenizer tokenPartesArchivo = new StringTokenizer(path,"\\");
        
        
        String[] partesPathActual = new String[tokenPartesPath.countTokens()];
        String[] partesPathArchivo = new String[tokenPartesArchivo.countTokens()];
        
        int i=0;
        while(tokenPartesPath.hasMoreTokens()){
            String str=tokenPartesPath.nextToken();
            partesPathActual[i]=str;            
            i++;
        } 
        i=0;
        while(tokenPartesArchivo.hasMoreTokens()){
            String str=tokenPartesArchivo.nextToken();
            partesPathArchivo[i]=str;            
            i++;
        }         
        
        
        int retroceso = 0;
        for(String parte : partesPathArchivo)
        {
            if(parte.equals(".."))
            {
                retroceso++;
            }
        }
        String pathFinal100RealNofake ="";
        for(int c = 0; c < partesPathActual.length - retroceso; c++)
        {
            if(c == 0)
            {
                pathFinal100RealNofake = partesPathActual[c];
            }
            else
            {
                pathFinal100RealNofake += "\\"+partesPathActual[c];
            }
        }
        if(partesPathArchivo[0].equals("."))
        {
            for(int c = 1+retroceso; c < partesPathArchivo.length; c++)
            {
                pathFinal100RealNofake += "\\" + partesPathArchivo[c];
            }
        }
        else
        {
            for(int c = 0+retroceso; c < partesPathArchivo.length; c++)
            {
                pathFinal100RealNofake += "\\" + partesPathArchivo[c];
            }            
        }
        
        
        try 
        {
            scannerfs_ = new scannerfs(new java.io.FileReader(pathFinal100RealNofake));
            Display.addArhcivo(pathFinal100RealNofake);
            parserfs_ = new parserfs(scannerfs_);
            parserfs_.parse();
            parserfs_.metodo.ejecutar(entorno);
            //valor = parserfs_.metodo.ejecutar(entorno);            
            Display.quitarArchivo();
//            if(!parserfs_.lista.isEmpty())
//            {
//                singlenton.addAST(parserfs_.lista);
//            }            
        } 
        catch (FileNotFoundException ex) // Error de que no exista el archivo.
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,"No se ha encontrado el archivo"));
            Display.quitarArchivo();
        } 
        catch (Exception ex) // Errores internos de cup o flex
        {
            singlenton.addErrores(new error("Semantico", linea, columna, pathReal,ex.getLocalizedMessage()));
            Display.quitarArchivo();
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
