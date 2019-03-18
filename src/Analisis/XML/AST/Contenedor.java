/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.XML.AST;

import Recursos.singlenton;
import CreatorXml201213050.InterfazIDE;
import Recursos.error;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Contenedor extends NodoXML
{
    public String id; // Obligatoria
    public String x; // Obligatoria
    public String y ;//Obligatoria
    //  Opcional
    public String alto ; 
    public String ancho;
    public String color;
    public String borde; 
    public ArrayList<NodoXML> listaComponentes;
    public Contenedor(int l, int c)
    {
        id = "";
        x = "";
        y = "";
        alto = "500";
        ancho = "500";
        color = "";
        borde ="falso";
        linea = l;
        columna = c;
        listaComponentes = new ArrayList<NodoXML>();
    }
    
    public Contenedor()
    {
        id = "";
        x = "";
        y = "";
        alto = "500";
        ancho = "500";
        color = "";
        borde ="falso";
        linea = 0;
        columna = 0;
        listaComponentes = new ArrayList<NodoXML>();
    }
    

    public void generarCodigo(InterfazIDE ventana)
    {
        //    public String id; // Obligatoria
        //    public String x; // Obligatoria
        //    public String y ;//Obligatoria
        //    //  Opcional
        //    public String alto ; 
        //    public String ancho;
        //    public String color;
        //    public String borde;         
        boolean flag = true;
        if(id.equals(""))// || id.equals(""))
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
        if(color.equals(""))
        {
            color = ventana.colorActual;
        }
        if(flag) // Están todos los obligatorios.
        {
            //var Cont1_Inicio = Ven_Inicio.CrearContenedor(200, 200, "#ffffff", falso, 10, 10);
            String idContenedor = "contenedor" + ventana.contadorContenedor+"_"+id;
            ventana.contadorContenedor++;
            valor = "var " + idContenedor +"=" + ventana.ventanaActual+".crearcontenedor(";            
            valor+= alto +","+ ancho +",\""+ color +"\","+ borde +","+ x +","+ y +");";            
            ventana.addCuerpoFinal((String) valor);
            
            /*Todos los componenetes*/
            ventana.setContenedorActual(idContenedor);
            for(NodoXML n : listaComponentes)
            {
                n.ejecutar(ventana);
            }
            
        }
        //var Cont1_Inicio = Ven_Inicio.CrearContenedor(200, 200, "#ffffff", falso, 10, 10);
        
    }    

    public ArrayList<NodoXML> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(ArrayList<NodoXML> listaComponentes) {
        this.listaComponentes = listaComponentes;
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

    public String getAlto() {
        return alto;
    }

    public String getAncho() {
        return ancho;
    }

    public String getColor() {
        return color;
    }

    public String getBorde() {
        return borde;
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

    public void setColor(String color) {
        this.color = color;
    }

    public void setBorde(String borde) {
        this.borde = borde;
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
