/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import CreatorXml201213050.*;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Display 
{
    public static ArrayList<Object> display = new ArrayList<Object>();
    public static ArrayList<Object> displayMetodo = new ArrayList<Object>();
    public static int puntero = 0; 
    
 
    public static void quitarMetodo()
    {
        if(!displayMetodo.isEmpty())
        {
            displayMetodo.remove(display.size()-1);
        }
    }
    
    public static Object metodoActual()
    {
        if(!displayMetodo.isEmpty())
        {
            return displayMetodo.get(displayMetodo.size()-1);
        }
        return null;
    }    
    
    
    public static Object esValido()
    {
        if(display.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static Object instruccionActual()
    {
        if(!display.isEmpty())
        {
            return display.get(display.size()-1);
        }
        return null;
    }
    
    
    public static void add(Object o)
    {
        display.add(o);
    }
    
    public static int getPuntero()
    {
        return puntero;
    }
    public static void quitar()
    {
        display.remove(display.size()-1);
    }
}
