/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;


import CreatorXml201213050.InterfazIDE;
import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author erick
 */
public class Entorno 
{
    public Entorno anterior;
    public Hashtable<String, Simbolo> tablaSimbolos;
    public InterfazIDE ventana;
    public int linea = 0, columna = 0;
    public Entorno(Entorno anterior)
    {        
        this.anterior = anterior;
        tablaSimbolos = new Hashtable<String, Simbolo>();                
    }
    
    public void setLocalizacion(int l, int c)
    {
        this.linea = l;
        this.columna = c;
    }
    
    public Entorno(Entorno anterior, InterfazIDE v)
    {
        this.anterior = anterior;
        tablaSimbolos = new Hashtable<String, Simbolo>(); 
        this.ventana = v;
    }
    
    public boolean insertarSimbolo(Simbolo simbolo)
    {
        if(existeSimbolo2(simbolo.id))
        {
            singlenton.addErrores(new error("semantico",linea,columna,simbolo.id,"La variable buscada ya existe en el ámbito."));
            //System.out.println(simbolo +"-----Valor----" + simbolo.valor.toString());
            return false;
        }
        else
        {
            String tipo = "";
            if(simbolo.valor instanceof String)
            {                       
                tipo = "string";
            }else            
            if(simbolo.valor instanceof Double)
            {                       
                tipo = "double";
            }else            
            if(simbolo.valor instanceof Integer)
            {                       
                tipo = "int";
            }else            
            if(simbolo.valor instanceof Boolean)
            {                       
                tipo = "bool";
            }else
            if(simbolo.valor instanceof Simbolo)
            {
                tipo = ((Simbolo)simbolo.valor).tipo;
            }
            else 
            if(simbolo.valor instanceof Hashtable)
            {
                tipo = "objeto";
            }
            simbolo.tipo = tipo;
            tablaSimbolos.put(simbolo.id, simbolo);
            
            
           //Comprobación de tipos perros
           /* boolean flag = false;
            String tipo1 = simbolo.tipo;
            String tipo2 = "";
            if(simbolo.valor instanceof String)
            {
                tipo2 = "string";
            }                
            if(simbolo.valor instanceof Integer)
            {
                tipo2 = "int";
            }  
            if(simbolo.valor instanceof Boolean)
            {
                tipo2 = "bool";
            } 
           switch(tipo1)
           {
               case "string":
                   if(simbolo.valor instanceof String)
                   {                       
                       flag = true;
                   }                   
                   break;
               case "int":
                   if(simbolo.valor instanceof Integer)
                   {                       
                       flag = true;
                   }                   
                   if(simbolo.valor instanceof Double)
                   {
                       simbolo.valor = ((Double)simbolo.valor).intValue();
                       flag = true;
                   }                          
                   break;
               case "double":
                   if(simbolo.valor instanceof Integer)
                   {
                       simbolo.valor = (Double)simbolo.valor;
                       flag = true;
                   }                   
                   if(simbolo.valor instanceof Double)
                   {                       
                       flag = true;
                   }                    
                   break;                   
               case "bool":
                   if(simbolo.valor instanceof Boolean)
                   {
                       flag = true;
                   }                   
                   break;               
               
           }
           if(flag)
           {
               tablaSimbolos.put(simbolo.id, simbolo);
           }
           else
           {
               ventana.setSalida("Error Semantico: Se esperaba un valor :" +simbolo.tipo + " Enviando:" + tipo2);
           }*/
        }
        return false;
    }
    
    
    public boolean existeSimbolo2(String id)
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                return true;
            } 
            break;
        }
        return false;
    }

    
    public boolean existeSimbolo(String id)
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                return true;
            } 
            ent = ent.anterior;
        }
        return false;
    }
    
    public Simbolo getSimbolo(String id)
    {
        id = id.toLowerCase();
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                return sim;
            } 
            ent = ent.anterior;
        }
        return null;
    }
    
    public Object getValor(String id)
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {                
                return sim.valor;
            }    
            ent = ent.anterior;
        }        
        ventana.setSalida("Error, no existe la variable buscada:\t"+id);
        singlenton.addErrores(new error("semantico",linea,columna,id,"La variable buscada no existe"));
        return "";
    }    
        
    
    public boolean actualizarSimbolo(String id, Object valor)                
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                String tipo ="";
                if(valor instanceof String)
                {
                    tipo = "string";
                }
                if(valor instanceof Integer)
                {
                    tipo = "int";
                }                
                if(valor instanceof Double)
                {
                    tipo = "double";
                }
                if(valor instanceof Boolean)
                {
                    tipo = "bool";
                }
                if(valor instanceof Simbolo)
                {
                    tipo = ((Simbolo) valor).tipo;
                }                                                                                
                sim.valor = valor;
                return true;                 
            }
            ent = ent.anterior;
        }
        return false;
    }   
    
    
    public String imprimir()
    {
        String cadena = "";
        Set<String> keys = this.tablaSimbolos.keySet();
        String str;
        //Obtaining iterator over set entries
        Iterator<String> itr = keys.iterator();

        //Displaying Key and value pairs
        while (itr.hasNext()) { 
           // Getting Key
           str = itr.next();

           /* public V get(Object key): Returns the value to which 
            * the specified key is mapped, or null if this map 
            * contains no mapping for the key.
            */           
           cadena += "\nvariable: " +this.tablaSimbolos.get(str).tipo + "\t tipo:"+this.tablaSimbolos.get(str).id;
        }         
        return cadena;
    }
    
    
    
}
