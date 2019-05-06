/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author erick
 */
public class Boton extends JButton
{
    public Llamada alclic=null;
    public String referencia = "";
    public String id = "", ventana = "", contenedor = "";
    public void setReferencia(String nombre)
    {
        alclic = new Llamada(nombre, new ArrayList<Exp>());
    }
}
