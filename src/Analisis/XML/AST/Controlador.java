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
public class Controlador extends NodoXML
{
    public String tipo = ""; // Obligatorio
    public String nombre = "", id = ""; //Obligatorio
    public String x = ""; // Obligatorio
    public String y = ""; // Obligatorio
    public String defecto = "\"\"";
    /*Opcionales*/
    public String alto, ancho, fuente ="\"Arial\"", tamanio="14", 
            color, negrita="falso", cursiva="falso",maximo, minimo, accion;
    
    public NodoXML tag;
    
    public Controlador()
    {
        alto = "0";
        ancho = "0";
        fuente = "\"Arial\"";
        tamanio = "14";
        color = "#000000";
        negrita = "falso";
        cursiva = "falso";
        maximo = "0";
        minimo = "0";
        accion ="";
    }

    public String getDefecto() {
        return defecto;
    }

    public void setDefecto(String defecto) {
        this.defecto = defecto;
    }

    public void setTag(NodoXML t)
    {
        tag = t;
    }
    
    public NodoXML getTag()
    {
        return tag;
    }
    
    public String getTipo() {
        return tipo;
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

    public String getAlto() {
        return alto;
    }

    public String getAncho() {
        return ancho;
    }

    public String getFuente() {
        return fuente;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getColor() {
        return color;
    }

    public String getNegrita() {
        return negrita;
    }

    public String getCursiva() {
        return cursiva;
    }

    public String getMaximo() {
        return maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public String getAccion() {
        return accion;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNegrita(String negrita) {
        this.negrita = negrita;
    }

    public void setCursiva(String cursiva) {
        this.cursiva = cursiva;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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
            
    public void generarCodigo(Interfaz ventana)
    {

        switch(tipo.toLowerCase())
        {
            case "texto":                
                /*Vemos lo de defecto*/
                if(tag instanceof Defecto)
                {
                    defecto = tag.ejecutar(ventana).valor.toString();
                }
                valor = ventana.contenedorActual +".CrearCajaTexto(" +alto +","+ ancho +","+ fuente +","+ tamanio +","+ color +","+ x+","+ y+","+ negrita +","+ cursiva+",\""+ defecto.trim() +"\",\""+ nombre+"\");";
                break;
            case "numerico":                
                /*Vemos lo de defecto*/
                if(tag instanceof Defecto)
                {
                    defecto = tag.ejecutar(ventana).valor.toString();
                    if(isNumero(defecto))
                    {
                        valor = ventana.contenedorActual +".CrearControlNumerico(" +alto +","+ ancho +","+ maximo +","+ minimo +","+ x +","+ y+","+ defecto+",\""+ nombre+"\");";
                    }
                    else
                    {
                        singlenton.addErrores(new error("Semantico",columna,linea,"Defecto, control numerico", "Se requiere un valor númerico."));            
                    }
                }
                //CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)                
                break; 
            case "desplegable":                
                /*Vemos lo de defecto*/
                if(tag instanceof LDato)
                {
                   tag.ejecutar(ventana);
                }
                //CrearDesplegable(Alto, Ancho, lista, X, Y, Defecto, nombre)
                valor = ventana.contenedorActual +".CrearDesplegable(" +alto +","+ ancho +",lista"+ (singlenton.contadorListas-1)  +","+ x +","+ y +","+defecto+",\""+ nombre+"\");";
                //CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)                
                break;                
        }
        ventana.addCuerpoFinal(valor.toString());
    }
    
    public boolean isNumero(String c)
    {
        boolean flag = true;
        try 
        {
            double  n = Double.parseDouble(c);            
        } catch (Exception e) 
        {
            return false;
        }
        
        
        return flag;
    }

    @Override
    public NodoXML ejecutar(Interfaz ventana) 
    {
        generarCodigo(ventana);
        return this;
    }
    
}
