/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Analisis.Fs.parserfs;
import Analisis.Fs.scannerfs;
import Analisis.Gdato.parsergd;
import Analisis.Gdato.scannergd;
import Recursos.error;
import Recursos.singlenton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java_cup.runtime.Scanner;

/**
 *
 * @author erick
 */
public class ArrayArchivo extends Exp
{
    public Nodo direccion;
    
    public ArrayArchivo(int l, int c, Nodo e)
    {
        this.linea = l;
        this.columna = c;
        this.direccion =e;
    }

    public void setValor(Entorno entorno)
    {
        String path = direccion.ejecutar(entorno).valor.toString();
        String pathRaiz = entorno.ventana.direcciones.get(entorno.ventana.archivoActual);
        pathRaiz = pathRaiz.substring(0, pathRaiz.length()-entorno.ventana.archivoActual.length()-1);
        parsergd parsergd_;
        scannergd scannergd_;
        String pathReal = pathRaiz+"\\"+path.replace("/", "\\");
        try 
        {           
            File archivo= new File(pathReal); 
            java.util.Scanner sc = new java.util.Scanner(archivo); 
            String data = "";
            while (sc.hasNextLine())
            {
                if(data.equals(""))
                {
                    data = sc.nextLine();
                }
                else
                {
                    data = data + "\n" + sc.nextLine();
                }
            }        
            data = data.replace("\"\"","\" \"");
            //scannergd_ = new scannergd(new java.io.FileReader(pathReal));
            scannergd_ = new scannergd(new BufferedReader(new StringReader(data)));
            parsergd_ = new parsergd(scannergd_);
            parsergd_.parse();
            if(!parsergd_.listaDatos.isEmpty())
            {
                valor = parsergd_.listaDatos;
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
