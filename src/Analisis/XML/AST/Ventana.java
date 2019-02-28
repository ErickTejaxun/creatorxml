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
public class Ventana extends NodoXML
{   
    public String id;
    public String tipo;
    public String color;
    public String accioninicial;
    public String accionfinal;

    public Ventana()
    {
        id = "";
        tipo = "";
        color = "";
        accionfinal = "";
        accioninicial = "";
    }
   
    public Ventana(int l, int c)
    {
        linea = l;
        columna = c;
        id = "";
        tipo = "";
        color = "";
        accionfinal = "";
        accioninicial = "";
    }    
    
    
    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getAccioninicial() {
        return accioninicial;
    }

    public String getAccionfinal() {
        return accionfinal;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAccioninicial(String accioninicial) {
        this.accioninicial = accioninicial;
    }

    public void setAccionfinal(String accionfinal) {
        this.accionfinal = accionfinal;
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
    
    public void generar(Interfaz ventana)
    {
        boolean flag = true;
        if(tipo.equals(""))// || id.equals(""))
        {
            flag = false;
            ventana.todosErrores.add(new error("Semantico",columna,linea,"ventana", "No se ha definido el tipo para la ventana."));            
        }
        if(id.equals(""))
        {
            flag = false;
            ventana.todosErrores.add(new error("Semantico",columna,linea,"ventana", "No se ha definido el id para la ventana."));            
        }        
        if(flag)
        {
            if(tipo.equals("principal"))
            {
                valor = "var " + id + "= crearventana(";
                if(color.equals(""))
                {
                    valor+= "\"#ffffff\"";
                }
                else
                {
                    valor+= "\""+color+"\"";
                }        
                valor+= ");";
            }
            else 
            if(tipo.equals("secundaria"))
            {
                
            }
            else
            {
                ventana.todosErrores.add(new error("Semantico",columna,linea,tipo, "Tipo de ventana no válido."));
            }
        }
    }
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {
        generar(ventana);
        ventana.escribirConsola((String) valor);
        return this;
    }              
}
