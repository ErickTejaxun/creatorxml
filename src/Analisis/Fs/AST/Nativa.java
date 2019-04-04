/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author erick
 */
public class Nativa extends Exp
{   
    public String id;
    public String funcion;
    public String iterador;
    public Nodo origen;
    public Nodo expresion;
    public Nativa (int l, int c, String i, String f)
    {
        this.linea = l;
        this.columna = c;
        this.id = i;
        this.funcion =f;
    }
    //Nativa(origenright, origenleft, origen, funcion)    
    public Nativa (int l, int c, Nodo or, String f)
    {
        this.linea = l;
        this.columna = c;
        this.origen = or;
        this.funcion =f;
    }    
    
    public Nativa (int l, int c, String i, String f, String it)
    {
        this.linea = l;
        this.columna = c;
        this.id = i;
        this.funcion =f;
        this.iterador = it;
    }    
    public Nativa(int l, int c, Nodo or, Exp exp )
    {
        this.linea = l;
        this.columna = c;
        this.origen = or;
        this.expresion = exp;
    }
    //Nativa(origenright, origenleft, origen, metodo, metodo);    
    public Nativa(int l, int c, Nodo or, String f, String it)
    {
        this.linea = l;
        this.columna = c;
        this.origen = or;
        this.funcion =f;
        this.iterador = it;        
    }
    
    public Nativa (int l, int c, Exp origen, String id, Nodo metodo)
    {
        this.linea = l;
        this.columna = c;
        this.origen = origen;
        this.funcion = id;
        this.expresion = metodo;
    }
    
    
    public void setValor(Entorno entorno)
    {       
        switch(funcion)
        {
            case "descendente":
                OrdenarDescendente(entorno);
                break;
            case "ascendente":
                ordenarAscendente(entorno);
                break;    
            case "invertir":
                invertir(entorno);
                break;
            case "maximo":
                maximo(entorno);
                break;
            case "minimo":
                minimo(entorno);
                break;    
            case "filtrar":
                filtrar(entorno);
                break;
            case "buscar":
                buscar(entorno);
                break;
            case "map":
                map(entorno);
                break;    
            case "reduce":
                reduce(entorno);
                break;                
        }
    }
    
//    public void map(Entorno entorno)
//    {
//        if(origen instanceof idExp)
//        {
//            id = ((idExp)origen).id;
//            Simbolo variable = entorno.getSimbolo(id);
//            if(variable!=null)
//            {
//                try 
//                {
//                    if(variable.valor instanceof ArrayList)
//                    {
//                      
//                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
//                      if(funcionIteradora!=null)
//                      {
//                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
//                        for(Simbolo item : ((ArrayList<Simbolo>)variable.valor))
//                        {
//                            Metodo iteradora = (Metodo)funcionIteradora.valor;                            
//                            Set<String> keys = ((Hashtable)item.valor).keySet();
//                            String str;
//                            Iterator<String> itr = keys.iterator();                            
//                            String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
//                            Atributo atributos = new Atributo(nombreVar);
//                            while (itr.hasNext()) 
//                            { 
//                               str = itr.next();
//                               atributos.addAtributo(str, new StringExp((String) ((Hashtable)item.valor).get(str)));
//                               //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
//                            }     
//                            ArrayList<String> nombres = new ArrayList<String>();
//                            nombres.add(nombreVar);                            
//                            iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
//                            ArrayList<Exp> lista = new ArrayList<Exp>();
//                            lista.add(atributos);
//                            Llamada llamada = new Llamada(iterador,lista);
//                            Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
////                            if(resultado instanceof Boolean)
////                            {
////                                if((Boolean)resultado)
////                                {
////                                    nuevoArray.add((Hashtable)item.valor);
////                                    break;
////                                }
////                                else
////                                {
////                                    System.out.println("No coincide");
////                                }                                
////                            }
//                        }                                                                                             
//                        valor = "";
//                      }
//                      else
//                      {
//                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
//                      }
//                    }                
//                } catch (Exception e) 
//                {
//                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
//                }
//            }               
//        }
//        else
//        if(origen instanceof Nativa)
//        {
//            Object resultado = origen.ejecutar(entorno).valor;
//                try 
//                {
//                    if(resultado instanceof ArrayList)
//                    {                    
//                       //Collections.reverse((ArrayList)variable.valor);
//                       Object i = Collections.min((ArrayList)resultado);
//                       valor =i;
//                    }                
//                } catch (Exception e) 
//                {
//                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
//                }
//        }               
//    }     
    
    public Boolean esHomogeneo(ArrayList l)
    {
        int flag = 0;
        for(Object ob : l)
        {
            if(ob instanceof Integer)
            {
                flag = 0;
            }
            else
            {
               flag ++;
            }
        }
        if(flag == 0){ return true;}
        
        flag = 0;
        for(Object ob : l)
        {
            if(ob instanceof Double)
            {
                flag = 0;
            }
            else
            {
               flag ++;
            }
        }
        if(flag == 0){ return true;}
        flag = 0;
        for(Object ob : l)
        {
            if(ob instanceof String)
            {
                flag = 0;
            }
            else
            {
               flag ++;
            }
        }
        if(flag == 0){ return true;}   
        flag = 0;
        for(Object ob : l)
        {
            if(ob instanceof Boolean)
            {
                flag = 0;
            }
            else
            {
               flag ++;
            }
        }
        if(flag == 0){ return true;}                 
        return false;
    }
    
    public void reduce(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            Object acumulador =null;
            int contador = 0;
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                      if(iterador==null)
                      {
                          if(expresion instanceof idExp)
                          {
                              iterador = ((idExp)expresion).id;
                          }
                      }
                      if(!esHomogeneo((ArrayList)variable.valor))
                      {
                          singlenton.addErrores(new error("semantico",linea,columna, id," No se puede aplicar la función reduce porque no es arreglo homogeneo."));
                          return;
                      }
                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var"+"$var");
                      int caso = 0;
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        ArrayList<Object> vectorPrimitivo = new ArrayList<Object>();
                        for(Object t : ((ArrayList<Simbolo>)variable.valor))
                        {                           
                            if(t instanceof Simbolo)
                            {
                                caso = 0;
                                Simbolo item = (Simbolo)t;
                                Metodo iteradora = (Metodo)funcionIteradora.valor;                            
                                Set<String> keys = ((Hashtable)item.valor).keySet();
                                String str;
                                Iterator<String> itr = keys.iterator();                            
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                Atributo atributos = new Atributo(nombreVar);
                                while (itr.hasNext()) 
                                { 
                                   str = itr.next();
                                   atributos.addAtributo(str, new StringExp((String) ((Hashtable)item.valor).get(str)));
                                   //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
                                }     
                                ArrayList<String> nombres = new ArrayList<String>();
                                nombres.add(nombreVar);                            
                                //iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                
                            }
                            else
                            {  
                                if(contador==0)
                                {
                                    valor = t;
                                }
                                else
                                {
                                    caso = 1;                                
                                    Simbolo item = new Simbolo();
                                    item.valor = t;                                
                                    Exp valorParametro = null;
                                    Exp valorParametroIterador = null;
                                    if(t instanceof Integer)
                                    {
                                        valorParametro = new IntExp((Integer)t);                                    
                                    }
                                    if(t instanceof Double)
                                    {
                                        valorParametro = new DoubleExp((Double)t);
                                    }     
                                    if(t instanceof String)
                                    {
                                        valorParametro = new StringExp((String)t);
                                    } 
                                    if(t instanceof Boolean)
                                    {
                                        valorParametro = new BoolExp((Boolean)t);
                                    }  
                                    if(t instanceof  Hashtable)
                                    {
                                        valorParametro = new Atributo("");
                                        ((Atributo)valorParametro).t = (Hashtable<String, Object>) t;
                                    }

                                    /*---------------------Acumulable----------------------*/
                                    if(valor instanceof Integer)
                                    {
                                        valorParametroIterador = new IntExp((Integer)t);                                    
                                    }
                                    if(valor instanceof Double)
                                    {
                                        valorParametroIterador = new DoubleExp((Double)t);
                                    }     
                                    if(valor instanceof String)
                                    {
                                        valorParametroIterador = new StringExp((String)t);
                                    } 
                                    if(valor instanceof Boolean)
                                    {
                                        valorParametroIterador = new BoolExp((Boolean)t);
                                    }  
                                    if(valor instanceof  Hashtable)
                                    {
                                        valorParametro = new Atributo("");
                                        ((Atributo)valorParametro).t = (Hashtable<String, Object>) t;
                                    }                                    

                                    
                                    Metodo iteradora = (Metodo)funcionIteradora.valor;
                                    String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                    iteradora.listaParametros.add(valorParametro);                                    
                                    ArrayList<Exp> lista = new ArrayList<Exp>();
                                    lista.add(valorParametroIterador);
                                    lista.add(valorParametro);
                                    Llamada llamada = new Llamada(iterador,lista);     
                                    valor  = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                     
                                }
                            }
                            contador ++;
                        }                          
                        
                      }
                      else
                      {
                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
                      }
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }               
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }               
    }        
    
    public void map(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                      if(iterador==null)
                      {
                          if(expresion instanceof idExp)
                          {
                              iterador = ((idExp)expresion).id;
                          }
                      }
                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
                      int caso = 0;
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        ArrayList<Object> vectorPrimitivo = new ArrayList<Object>();
                        for(Object t : ((ArrayList<Simbolo>)variable.valor))
                        {                           
                            if(t instanceof Simbolo)
                            {
                                caso = 0;
                                Simbolo item = (Simbolo)t;
                                Metodo iteradora = (Metodo)funcionIteradora.valor;                            
                                Set<String> keys = ((Hashtable)item.valor).keySet();
                                String str;
                                Iterator<String> itr = keys.iterator();                            
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                Atributo atributos = new Atributo(nombreVar);
                                while (itr.hasNext()) 
                                { 
                                    Exp nuevaExpresion = null;
                                    str = itr.next();
                                    Object tmp = ((Hashtable)item.valor).get(str);
                                    if(tmp instanceof Integer)
                                    {
                                        nuevaExpresion = new IntExp((Integer)tmp);
                                    }
                                    if(tmp instanceof Double)
                                    {
                                        nuevaExpresion = new DoubleExp((Double)tmp);
                                    }     
                                    if(tmp instanceof String)
                                    {
                                        nuevaExpresion = new StringExp((String)tmp);
                                    } 
                                    if(tmp instanceof Boolean)
                                    {
                                        nuevaExpresion = new BoolExp((Boolean)tmp);
                                    }  
                                    if(tmp instanceof  Hashtable)
                                    {
                                        nuevaExpresion = new Atributo("");
                                        ((Atributo)nuevaExpresion).t = (Hashtable<String, Object>) t;

                                    }                                                                                                         
                                   atributos.addAtributo(str, nuevaExpresion);                                   
                                }     
                                ArrayList<String> nombres = new ArrayList<String>();
                                nombres.add(nombreVar);                                                            
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                valor = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                
                                if(valor!=null)
                                {
                                    vectorPrimitivo.add(valor);
                                }
                            }
                            else
                            {  
                                caso = 1;
                                
                                Simbolo item = new Simbolo();
                                item.valor = t;                                
                                Exp valorParametro = null;
                                if(t instanceof Integer)
                                {
                                    valorParametro = new IntExp((Integer)t);
                                }
                                if(t instanceof Double)
                                {
                                    valorParametro = new DoubleExp((Double)t);
                                }     
                                if(t instanceof String)
                                {
                                    valorParametro = new StringExp((String)t);
                                } 
                                if(t instanceof Boolean)
                                {
                                    valorParametro = new BoolExp((Boolean)t);
                                }  
                                if(t instanceof  Hashtable)
                                {
                                    valorParametro = new Atributo("");
                                    ((Atributo)valorParametro).t = (Hashtable<String, Object>) t;
                                    
                                }
                                Metodo iteradora = (Metodo)funcionIteradora.valor;
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                iteradora.listaParametros.add(valorParametro);
                                
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(valorParametro);
                                Llamada llamada = new Llamada(iterador,lista);     
                                
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                               
                                
                            }
                            
                        }                          
                        switch(caso)
                        {
                            case 0: 
                                //valor = nuevoArray;
                                valor = vectorPrimitivo;
                                break;
                            case 1:
                                valor = vectorPrimitivo;
                        }                        
                      }
                      else
                      {
                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
                      }
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }               
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }               
    }     
    
    public void buscar(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                      if(iterador==null)
                      {
                          if(expresion instanceof idExp)
                          {
                              iterador = ((idExp)expresion).id;
                          }
                      }
                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
                      int caso = 0;
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        ArrayList<Object> vectorPrimitivo = new ArrayList<Object>();
                        for(Object t : ((ArrayList<Simbolo>)variable.valor))
                        {                           
                            if(t instanceof Simbolo)
                            {
                                caso = 0;
                                Simbolo item = (Simbolo)t;
                                Metodo iteradora = (Metodo)funcionIteradora.valor;                            
                                Set<String> keys = ((Hashtable)item.valor).keySet();
                                String str;
                                Iterator<String> itr = keys.iterator();                            
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                Atributo atributos = new Atributo(nombreVar);
                                while (itr.hasNext()) 
                                { 
                                   str = itr.next();
                                   atributos.addAtributo(str, new StringExp((String) ((Hashtable)item.valor).get(str)));
                                   //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
                                }     
                                ArrayList<String> nombres = new ArrayList<String>();
                                nombres.add(nombreVar);                            
                                //iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        nuevoArray.add((Hashtable)item.valor);
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("No coincide");
                                    }                                
                                }                                
                            }
                            else
                            {  
                                caso = 1;
                                
                                Simbolo item = new Simbolo();
                                item.valor = t;                                
                                Exp valorParametro = null;
                                if(t instanceof Integer)
                                {
                                    valorParametro = new IntExp((Integer)t);
                                }
                                if(t instanceof Double)
                                {
                                    valorParametro = new DoubleExp((Double)t);
                                }     
                                if(t instanceof String)
                                {
                                    valorParametro = new StringExp((String)t);
                                } 
                                if(t instanceof Boolean)
                                {
                                    valorParametro = new BoolExp((Boolean)t);
                                }  
                                if(t instanceof  Hashtable)
                                {
                                    valorParametro = new Atributo("");
                                    ((Atributo)valorParametro).t = (Hashtable<String, Object>) t;
                                    
                                }
                                Metodo iteradora = (Metodo)funcionIteradora.valor;
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                iteradora.listaParametros.add(valorParametro);
                                
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(valorParametro);
                                Llamada llamada = new Llamada(iterador,lista);     
                                
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        vectorPrimitivo.add(t);
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("No coincide");
                                    }                                
                                }                                
                                
                            }
                            
                        }  
                        
                        switch(caso)
                        {
                            case 0: 
                                valor = nuevoArray.get(0);
                                break;
                            case 1:
                                valor = vectorPrimitivo.get(0);
                        }
                        
                      }
                      else
                      {
                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
                      }
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }               
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }               
    }    
    
    public void filtrar(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                      if(iterador==null)
                      {
                          if(expresion instanceof idExp)
                          {
                              iterador = ((idExp)expresion).id;
                          }
                      }
                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
                      int caso = 0;
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        ArrayList<Object> vectorPrimitivo = new ArrayList<Object>();
                        for(Object t : ((ArrayList<Simbolo>)variable.valor))
                        {                           
                            if(t instanceof Simbolo)
                            {
                                caso = 0;
                                Simbolo item = (Simbolo)t;
                                Metodo iteradora = (Metodo)funcionIteradora.valor;                            
                                Set<String> keys = ((Hashtable)item.valor).keySet();
                                String str;
                                Iterator<String> itr = keys.iterator();                            
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                Atributo atributos = new Atributo(nombreVar);
                                while (itr.hasNext()) 
                                { 
                                   str = itr.next();
                                   Nodo parametro = null;
                                   Object tmp = ((Hashtable)item.valor).get(str);                                   
                                   if(tmp instanceof String)
                                   {
                                       parametro = new StringExp((String)tmp);
                                   }
                                   if(tmp instanceof Integer)
                                   {
                                       parametro = new IntExp((Integer)tmp);
                                   }
                                   if(tmp instanceof Double)
                                   {
                                       parametro = new DoubleExp((Double)tmp);
                                   }
                                   if(tmp instanceof Boolean)
                                   {
                                       parametro = new BoolExp((Boolean)tmp);
                                   }                                                                                                         
                                   atributos.addAtributo(str, parametro );
                                   //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
                                }     
                                ArrayList<String> nombres = new ArrayList<String>();
                                nombres.add(nombreVar);                            
                                //iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        nuevoArray.add((Hashtable)item.valor);
                                        //break;
                                    }
                                    else
                                    {
                                        System.out.println("No coincide");
                                    }                                
                                }                                
                            }
                            else
                            {  
                                caso = 1;
                                
                                Simbolo item = new Simbolo();
                                item.valor = t;                                
                                Exp valorParametro = null;
                                if(t instanceof Integer)
                                {
                                    valorParametro = new IntExp((Integer)t);
                                }
                                if(t instanceof Double)
                                {
                                    valorParametro = new DoubleExp((Double)t);
                                }     
                                if(t instanceof String)
                                {
                                    valorParametro = new StringExp((String)t);
                                } 
                                if(t instanceof Boolean)
                                {
                                    valorParametro = new BoolExp((Boolean)t);
                                }                                 
                                Metodo iteradora = (Metodo)funcionIteradora.valor;
                                String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
                                iteradora.listaParametros.add(valorParametro);
                                
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(valorParametro);
                                Llamada llamada = new Llamada(iterador,lista);     
                                
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        vectorPrimitivo.add(t);
                                        //break;
                                    }
                                    else
                                    {
                                        System.out.println("No coincide");
                                    }                                
                                }                                
                                
                            }
                            
                        }  
                        
                        switch(caso)
                        {
                            case 0: 
                                valor = nuevoArray;
                                break;
                            case 1:
                                valor = vectorPrimitivo;
                        }
                        
                      }
                      else
                      {
                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
                      }
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }               
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }               
    }    
    
//    public void buscar(Entorno entorno)
//    {
//        if(origen instanceof idExp)
//        {
//            id = ((idExp)origen).id;
//            Simbolo variable = entorno.getSimbolo(id);
//            if(variable!=null)
//            {
//                try 
//                {
//                    if(variable.valor instanceof ArrayList)
//                    {
//                      if(iterador==null)
//                      {
//                          if(expresion instanceof idExp)
//                          {
//                              iterador = ((idExp)expresion).id;
//                          }
//                      }                        
//                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
//                      if(funcionIteradora!=null)
//                      {
//                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
//                        if(((ArrayList<Simbolo>)variable.valor) instanceof ArrayList)
//                        {
//
//                            if( true)
//                            {
//                                Metodo iterMetodo = (Metodo)funcionIteradora.valor;
//                                Set<String> keys = ((Hashtable)variable.valor).keySet();
//                                Iterator<String> itr = keys.iterator(); 
//                                String str;
//                                while (itr.hasNext()) 
//                                { 
//                                   str = itr.next();
//                                   //atributos.addAtributo(str, new StringExp((String) ((Hashtable)item.valor).get(str)));
//                                   //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
//                                }                                 
//                            }
//                            else
//                            {
//                                for(Simbolo item : ((ArrayList<Simbolo>)variable.valor))
//                                {
//                                    Metodo iteradora = (Metodo)funcionIteradora.valor;                            
//                                    Set<String> keys = ((Hashtable)item.valor).keySet();
//                                    String str;
//                                    Iterator<String> itr = keys.iterator();                            
//                                    String nombreVar = ((Declaracion)iteradora.declaracionParametros.get(0)).lista.get(0);
//                                    Atributo atributos = new Atributo(nombreVar);
//                                    while (itr.hasNext()) 
//                                    { 
//                                       str = itr.next();
//                                       atributos.addAtributo(str, new StringExp((String) ((Hashtable)item.valor).get(str)));
//                                       //l.add(new Atributo(0, 0, str, new StringExp(((Hashtable)item.valor).get(str).toString()))); 
//                                    }     
//                                    ArrayList<String> nombres = new ArrayList<String>();
//                                    nombres.add(nombreVar);                            
//                                    iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
//                                    ArrayList<Exp> lista = new ArrayList<Exp>();
//                                    lista.add(atributos);
//                                    Llamada llamada = new Llamada(iterador,lista);
//                                    Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
//                                    if(resultado instanceof Boolean)
//                                    {
//                                        if((Boolean)resultado)
//                                        {
//                                            //Agregamos la variable a la tabla de símbolo.
//                                            Simbolo sim = new Simbolo();
//                                            sim.id = this.id;
//                                            sim.valor = atributos;
//                                            entorno.insertarSimbolo(sim);
//                                            return;
//                                        }
//                                        else
//                                        {
//                                            System.out.println("No coincide");
//                                        }                                
//                                    }
//                                }                                  
//                            }
//                        }
//                        else
//                        {
//                            
//                        }
//                        valor = nuevoArray;
//                      }
//                      else
//                      {
//                          singlenton.addErrores(new error("semantico",linea,columna, iterador,"No se ha encontrado la función iteradora."));
//                      }
//                    }                
//                } catch (Exception e) 
//                {
//                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
//                }
//            }               
//        }
//        else
//        if(origen instanceof Nativa)
//        {
//            Object resultado = origen.ejecutar(entorno).valor;
//                try 
//                {
//                    if(resultado instanceof ArrayList)
//                    {                    
//                       //Collections.reverse((ArrayList)variable.valor);
//                       Object i = Collections.min((ArrayList)resultado);
//                       valor =i;
//                    }                
//                } catch (Exception e) 
//                {
//                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
//                }
//        }               
//    }
    
    public void minimo(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)variable.valor);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }               
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.min((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }        
    }
    public void maximo(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.max((ArrayList)variable.valor);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }            
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {                    
                       //Collections.reverse((ArrayList)variable.valor);
                       Object i = Collections.max((ArrayList)resultado);
                       valor =i;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }        
        
    }
    
    public void invertir(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;        
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                       Collections.reverse((ArrayList)variable.valor);
                       valor = variable.valor;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }
        }
        else
        if(origen instanceof Nativa)
        {
            Object resultado = origen.ejecutar(entorno).valor;
                try 
                {
                    if(resultado instanceof ArrayList)
                    {
                       Collections.reverse((ArrayList)resultado);
                       valor = resultado;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
        }
    }      
    public void ordenarAscendente(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id;        
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                       Collections.sort((ArrayList)variable.valor);     
                       valor = variable.valor;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }
            }
        }
        else
        if(origen instanceof Nativa)
        {
            Object val = origen.ejecutar(entorno).valor;
            try 
            {
                if(val instanceof ArrayList)
                {
                   Collections.sort((ArrayList)val);     
                   valor = val;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }            
        }
    }    
    public void OrdenarDescendente(Entorno entorno)
    {
        if(origen instanceof idExp)
        {
            id = ((idExp)origen).id; 
            Simbolo variable = entorno.getSimbolo(id);
            if(variable!=null)
            {
                try 
                {
                    if(variable.valor instanceof ArrayList)
                    {
                        Collections.sort((ArrayList)variable.valor); 
                        Collections.sort((ArrayList)variable.valor, Collections.reverseOrder()); 
                       valor = variable.valor;
                    }                
                } catch (Exception e) 
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
                }

            }
        }
        else
        if(origen instanceof Nativa)
        {
            Object val = origen.ejecutar(entorno).valor;
            try 
            {
                if(val instanceof ArrayList)
                {
                    Collections.sort((ArrayList)val); 
                    Collections.sort((ArrayList)val, Collections.reverseOrder()); 
                    valor = val;
                }                
            } catch (Exception e) 
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No se puede ordenar el arreglo porque no es homogeneo."));
            }            
        }        
    }
    
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        return this;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
    
}
