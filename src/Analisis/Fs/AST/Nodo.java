/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

/**
 *
 * @author erick
 */
public abstract class Nodo 
{
    public Object valor;
    public String valor2;
    public int linea, columna;    
    public abstract Nodo generar3D(Entorno entorno);
    public abstract Nodo ejecutar(Entorno entorno);
}
