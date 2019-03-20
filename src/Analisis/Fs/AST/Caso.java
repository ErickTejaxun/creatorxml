/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Caso extends Nodo
{
    public Nodo condicion;
    public Bloque instrucciones;
    
    public Caso(int l, int c, Nodo v, Bloque  i)
    {
        this.linea = l;
        this.columna = c;
        this.condicion = v;
        this.instrucciones = i;
    }

    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        valor = "";
        instrucciones.ejecutar(new Entorno(entorno, entorno.ventana));
        return this;
    }
    
}
