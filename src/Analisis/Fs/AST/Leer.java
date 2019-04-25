/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Analisis.Fs.parserfs;
import Analisis.Fs.scannerfs;
import Analisis.XML.AST.NodoXML;
import Analisis.XML.parserxml;
import Analisis.XML.scannerxml;
import Recursos.Display;
import Recursos.error;
import Recursos.singlenton;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author erick
 */
public class Leer extends Exp
{
    public Exp direccion;
    public ArrayList<ArrayList<NodoXML>> listaxml = new ArrayList<ArrayList<NodoXML>>();
    public Leer(int l, int c, Exp d)
    {
        this.linea = l;
        this.columna = c;
        this.direccion = d;
    }
    public void setValor(Entorno entorno)
    {
        analizar(entorno);
        String traduccion = entorno.ventana.getTraduccion();
        valor = traduccion;        
//        Object path = direccion.ejecutar(entorno).valor;
//        if(path instanceof String)
//        {
//            String direccionArchivo = (String)path;
//            
//        }
//        else
//        {
//            singlenton.addErrores(new error("semantico",linea,columna, "leergxml","Se esperaba una cadena con el path."));
//        }
    }
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
    
    public void analizar(Entorno entorno)
    {
        String path = direccion.ejecutar(entorno).valor.toString();
        String pathRaiz = entorno.ventana.direcciones.get(entorno.ventana.archivoActual);
        pathRaiz = pathRaiz.substring(0, pathRaiz.length()-entorno.ventana.archivoActual.length()-1);
        parserxml parserxml_;
        scannerxml scannerxml_;
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
            scannerxml_ = new scannerxml(new java.io.FileReader(pathFinal100RealNofake));
            Display.addArhcivo(pathFinal100RealNofake);
            parserxml_ = new parserxml(scannerxml_);
            parserxml_.parse();
            if(!parserxml_.lista.isEmpty())
            {
              listaxml.add(parserxml_.lista);
            }      
            EjecutarXML(entorno);            
            Display.quitarArchivo();                                           
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
    
    public void EjecutarXML(Entorno entorno)
    {
        /*Primero el primer ast*/
        for(ArrayList<NodoXML> l : listaxml)
        {
            for(NodoXML n : l)
            {
                n.ejecutar(entorno.ventana);
            }
        }
        
        /*Ahora las importaciones*/
//        for(ArrayList<NodoXML> l : singlenton.listaAST)
        for(int cont = 0; cont<singlenton.listaAST.size(); cont++)
        {
            ArrayList<NodoXML> l = singlenton.listaAST.get(cont);
            for(NodoXML n : l)
            {
                n.ejecutar(entorno.ventana);
            }
        }       
        //entorno.ventana.mostrarTraduccion();
    }    
    
    
}
