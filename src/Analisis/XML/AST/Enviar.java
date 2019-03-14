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
public class Enviar extends NodoXML
{
    public String nombre ="",x="",y=""; // Obligatorios
    public String alto = "100", ancho = "100", referencia = "nulo",accion ="Enviar()";//Opcionales
    public String fuente = "Arial", texto = "";
    public Texto txt;
    
    public Enviar(int l, int c)
    {
        linea = l;
        columna = c;
    }
    public Enviar()
    {
        linea = 0;
        columna = 0;
    }    
    
    public void generarCodigo(Interfaz ventana)
    {
        boolean flag = true;
        if(nombre.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Tipo", "El botón debe tener un nombre."));                                   
        }
        if(x.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "X", "El botón debe tener un una posición en x."));                                   
        }        
        if(y.equals(""))
        {
            flag = false;
            singlenton.addErrores(new error("Semantico",linea,columna, "Y", "El botón debe tener un una posición en y."));                                   
        }  
        if(flag)
        {
            valor = "var bot"+nombre+"_"+ventana.contenedorActual+"="+ventana.contenedorActual+".crearBoton("
                    +"\""+fuente+"\","+"14,"+"\"#000000\","+x+","+y+","+referencia+",\""+texto+"\","+alto+","+ancho+");";
            //Var btnIngresar_Inicio = ContBtn_Inicio.CrearBoton("Arial", 14, "#000000", 25, 30, nulo, "Ingresar", 70, 50);   
            //                             Contenedor.CrearBoton(Fuente, Tamaño, Color, X, Y,Referencia, valor, Alto, Ancho)
        }
        if(!accion.equals(""))
        {
            valor+= "\nbot"+nombre+"_"+ventana.contenedorActual+".alclic("+accion+");";
        }
        ventana.addCuerpoFinal(valor.toString());
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

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
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

    public String getReferencia() {
        return referencia;
    }

    public String getAccion() {
        return accion;
    }

    public String getFuente() {
        return fuente;
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
    
    public void setTxt(Texto txt)
    {
        this.txt = txt;
    }
    
    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {
        generarCodigo(ventana);
        return this;
    }
    
}
