/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.Display;
import Recursos.error;
import Recursos.singlenton;

/**
 *
 * @author erick
 */
public class Romper extends Sentencia{    


    public Romper(int l, int c) 
    {
        this.linea = l;
        this.columna = c;
    }
       

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {      
        Object r = Display.esValido();
        if(r instanceof Boolean)
        {
            if((Boolean)r)
            {
                Display.quitar();
            }
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna, "Romper","Romper inválido."));
            }                
        }
    
        return this;
    }
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        valor = "";
        valor2 = (String) valor;
        return this;
    }    
}
