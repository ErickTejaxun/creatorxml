/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import Recursos.singlenton;
import Recursos.error;
import java.util.ArrayList;

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
    public String alto, ancho;
    public ArrayList<NodoXML> elementos;

    public Ventana()
    {
        id = "";
        tipo = "";
        color = "#ffffff";
        accionfinal = "";
        accioninicial = "";
        alto = "800";
        ancho = "1000";
        elementos = new ArrayList<NodoXML>();
    }
   
    public Ventana(int l, int c)
    {
        linea = l;
        columna = c;
        id = "";
        tipo = "";
        color = "#ffffff";
        accionfinal = "";
        accioninicial = "";
        alto = "800";
        ancho = "1000";   
        elementos = new ArrayList<NodoXML>();
    }    
    
    public void setElementos(ArrayList<NodoXML> l)
    {
        elementos = l;
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

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }
    
    
    
    
    public void generarCodigo(CreatorXml201213050.InterfazIDE ventana)
    {
        boolean flag = true;
        if(tipo.equals(""))// || id.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",columna,linea,"ventana", "No se ha definido el tipo para la ventana."));            
        }
        if(id.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",columna,linea,"ventana", "No se ha definido el id para la ventana."));            
        }  
        if(flag)
        {
            if(tipo.toLowerCase().equals("principal"))
            {
                String idVentana = "ventana" + ventana.contadorVentanas+ "_" + id ;
                valor = "var "+idVentana+ "= crearventana(";
                ventana.setVentanaActual(idVentana);
                valor+= "\""+color+"\",";
                /*Ancho y alto*/
                valor+= alto + "," +ancho+ ",\""+ id +"\""+ ");";  
                ventana.addCuerpoInicio((String) valor);
            }
            else 
            if(tipo.toLowerCase().equals("secundaria"))
            {
                String idVentana = "ventana" + ventana.contadorVentanas+ "_" + id ;
                valor = "var "+idVentana+ "= crearventana(";
                ventana.setVentanaActual(idVentana);
                valor+= "\""+color+"\",";
                /*Ancho y alto*/
                valor+= alto + "," + ancho+ ",\""+ id +"\""+ ");";  
                ventana.addCuerpoInicio((String) valor);
            }
            else
            {
                String idVentana = "ventana" + ventana.contadorVentanas+ "_" + id ;
                valor = "var "+idVentana+ "= crearventana(";
                ventana.setVentanaActual(idVentana);
                if(color.equals(""))
                {
                    color= "\"#ffffff\"";
                }                
                valor+= "\""+color+"\",";
                        
                /*Ancho y alto*/
                valor+= alto + "," + ancho+ ",\""+ id +"\""+ ");";   
                ventana.addCuerpoInicio((String) valor);                                
                singlenton.addErrores(new error("Semantico",columna,linea,tipo, "Tipo de ventana no válido"));
            }
            
            ventana.setColorActual(color);
            
            for(NodoXML elem : elementos)
            {
                elem.ejecutar(ventana);
            }
            
            
            
            if(!accioninicial.equals(""))
            {
                ventana.addCuerpoFinal("ventana" + ventana.contadorVentanas+ "_" + id +".alcargar("+accioninicial+");");
            }                
            if(!accionfinal.equals(""))
            {
                ventana.addCuerpoFinal("ventana" + ventana.contadorVentanas+ "_" + id +".alcargar("+accionfinal+");");
            }              
            if(tipo.toLowerCase().equals("principal"))
            {
                ventana.addCuerpoFinal("ventana" + ventana.contadorVentanas+ "_" + id +".alcargar();");                
            }
        }
    }
    
    @Override
    public NodoXML ejecutar(CreatorXml201213050.InterfazIDE ventana) 
    {
        generarCodigo(ventana);              
        return this;
    }              
}
