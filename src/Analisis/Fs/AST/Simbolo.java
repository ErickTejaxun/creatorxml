/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author erick
 */
public class Simbolo  implements Cloneable
{
    public String id;
    public String tipo;
    public String rol;
    public Object valor;
    public boolean isArray;
    public int dimensiones;
    public ArrayList<Integer> tamanioDimensiones;
    public Hashtable<Integer, Simbolo> valores; // Si es vector
        
    public Simbolo(String id, String tipo)
    {
        this.id = id;
        this.tipo = tipo;
    }
    
    public Simbolo(String id, String tipo, String rol, Object valor)
    {        
        this.id =id;
        this.tipo = tipo;
        this.rol = rol;
        this.valor = valor;
        this.tamanioDimensiones = null;
        this.valores = null;
        
    }

    public void convertoVector()
    {
        this.valores = new Hashtable<Integer, Simbolo>();
        this.tamanioDimensiones = new ArrayList<Integer>();
        isArray  = true;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setIsArray(boolean isArray) {
        this.isArray = isArray;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRol() {
        return rol;
    }

    public Object getValor() {
        return valor;
    }

    public boolean isIsArray() {
        return isArray;
    }

    public int getDimensiones() 
    {
        return dimensiones;
    }
    
    public Simbolo clone() throws CloneNotSupportedException
    {
        return (Simbolo) super.clone();
    }
}
