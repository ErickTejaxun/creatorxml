/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import Recursos.singlenton;
import CreatorXml201213050.InterfazIDE;
import Recursos.error;

/**
 *
 * @author erick
 */
public class Multimedia extends NodoXML
{
    // tipo == musica, video, imagen
    public String tipo, path, nombre, x, y ; // Obligatorios
    public String alto, ancho, autoreproduccion; // Opcionales
    
    public Multimedia(int l , int c)
    {
        linea = l;
        columna = c;
        alto = "200";
        ancho = "200";
        autoreproduccion = "falso";
    }
    
    public Multimedia()
    {
        linea = 0;
        columna = 0;
        alto = "200";
        ancho = "200";
        autoreproduccion = "falso";        
        y= x = "";
        path = "";
        tipo = "";
    }
    
    public void generarCodigo(InterfazIDE ventana)
    {
        boolean flag = true ; // Pasa saber si trae todos los obligatorios
        if(tipo.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Tipo", "El objeto multimedia tiene que tener un tipo"));           
        }
        if(path.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Path", "El objeto multimedia tiene que tener un Path hacia el recurso"));           
        }        
        if(nombre.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Nombre", "El objeto multimedia tiene que tener nombre"));           
        }                
        if(x.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "X", "El objeto multimedia debe tener una posición x asignada"));           
        }                        
        if(y.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Y", "El objeto multimedia debe tener una posición y asignada"));           
        }
        
        if(flag)
        {
            String tObjeto = "";
            switch(tipo.toLowerCase())
            {
                case "imagen":
                    //CrearImagen(Ruta, X, Y, Alto, Ancho)
                    valor = ventana.contenedorActual +".CrearImagen(\"" +path +"\","+ x+","+ y+","+ alto+","+ ancho+");";
                    break;
                case "video":
                    valor = ventana.contenedorActual +".CrearVideo(\"" +path +"\","+ x+"," + y+","+autoreproduccion+","+ alto+","+ ancho+");";
                    //CrearVideo (Ruta, X, Y, Auto-repr oductor, Alto, Ancho)
                    break;
                case "musica":
                    valor = ventana.contenedorActual +".CrearReproductor(\"" +path +"\","+ x+"," + y+","+autoreproduccion+","+ alto+","+ ancho+");";
                    //CrearReproductor (Ruta, X, Y, Auto-reproductor, Alto, Ancho)
                    break;
            }                        
        }/*Fin de la creación*/
        
        ventana.addCuerpoFinal(valor.toString());
    }     

    public String getTipo() {
        return tipo;
    }

    public String getPath() {
        return path;
    }

    public String getNombre() {
        return nombre;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getAlto() {
        return alto;
    }

    public String getAncho() {
        return ancho;
    }

    public String getAutoreproduccion() {
        return autoreproduccion;
    }

    public Object getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }       
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public void setAutoreproduccion(String autoreproduccion) {
        this.autoreproduccion = autoreproduccion;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
                   
    @Override
    public NodoXML ejecutar(InterfazIDE ventana) 
    {
       generarCodigo(ventana);
       return this;
    }
    
}
