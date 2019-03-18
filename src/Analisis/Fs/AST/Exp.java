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
public abstract class Exp extends Nodo{
    public String lv, lf;
    
    public void setLf(String c)
    {
        lf = c;
    }
}
