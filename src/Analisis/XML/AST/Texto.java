/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import CreatorXml201213050.Interfaz;
import Recursos.error;

/**
 *
 * @author erick
 */
public class Texto extends NodoXML
{
    public String nombre=""; // Obligatoria           
    public String id=""; // Obligatoria
    public String x=""; // Obligatoria
    public String y="" ;//Obligatoria
    public String fuente = "Arial";
    public String tam = "14";
    public String negrita = "falso";
    public String color = "#000000";
    public String cursiva = "falso";
    public String texto ="";

    public Texto()
    {
        
    }
    
    
    public Texto(int l, int c)
    {
        linea = l;
        columna = c;
    }        
    
    public void generarCodigo(Interfaz ventana)
    {        
        boolean flag = true;
        if(nombre.equals(""))// || id.equals(""))
        {
            flag = false;
           singlenton.addErrores(new error("Semantico",columna,linea,"Contenedor", "No se ha definido el id para la contenedor."));            
        }
        if(x.equals(""))
        {
            flag = false;
           singlenton.addErrores(new error("Semantico",columna,linea,"Contenedor", "No se ha definido la posición en x del contenedor."));            
        }        
        if(y.equals(""))
        {
            flag = false;
           singlenton.addErrores(new error("Semantico",columna,linea,"Contenedor", "No se ha definido la posición en y del contenedor."));            
        }  
        // Si no se define un color se agrega el color de la ventana a la cual pertenece.
        if(color.equals("")) 
        {
            color = ventana.colorActual;
        }
        if(flag) // Están todos los obligatorios.
        {
            String idContenedor = "contenedor" + ventana.contadorContenedor+"_"+id;
            valor = ventana.contenedorActual+".creartexto(\""+fuente +"\","+tam+",\""+color+"\","+x+","+y+","+negrita+","+cursiva+",\""+texto+"\");";
            ventana.addCuerpoFinal((String) valor);            
        }       
                       
    }    

    public void setTexto(String t)
    {
        this.texto = t.trim();
    }
    
    public String getTexto()
    {
        return this.texto;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.id = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public void setNegrita(String negrita) {
        this.negrita = negrita;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCursiva(String cursiva) {
        this.cursiva = cursiva;
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

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getFuente() {
        return fuente;
    }

    public String getTam() {
        return tam;
    }

    public String getNegrita() {
        return negrita;
    }

    public String getColor() {
        return color;
    }

    public String getCursiva() {
        return cursiva;
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


    
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {
        generarCodigo(ventana);        
        return this;
    }
    
}
