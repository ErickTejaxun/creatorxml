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
                      
                      Simbolo funcionIteradora = entorno.ventana.entornoGlobal.getSimbolo(iterador+"$var");
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        for(Simbolo item : ((ArrayList<Simbolo>)variable.valor))
                        {
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
                            iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                            ArrayList<Exp> lista = new ArrayList<Exp>();
                            lista.add(atributos);
                            Llamada llamada = new Llamada(iterador,lista);
                            Object resultado = llamada.ejecutar(entorno).valor;
//                            if(resultado instanceof Boolean)
//                            {
//                                if((Boolean)resultado)
//                                {
//                                    nuevoArray.add((Hashtable)item.valor);
//                                    break;
//                                }
//                                else
//                                {
//                                    System.out.println("No coincide");
//                                }                                
//                            }
                        }                                                                                             
                        valor = "";
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
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        for(Object t : ((ArrayList<Simbolo>)variable.valor))
                        {                           
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
                              Object resultado = llamada.ejecutar(entorno).valor;
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
                        valor = nuevoArray;
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
                      if(funcionIteradora!=null)
                      {
                        ArrayList<Hashtable> nuevoArray = new ArrayList<Hashtable>();
                        if(((ArrayList<Simbolo>)variable.valor) instanceof ArrayList)
                        {
                            for(Simbolo item : ((ArrayList<Simbolo>)variable.valor))
                            {
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
                                iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                Object resultado = llamada.ejecutar(entorno).valor;
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        //Agregamos la variable a la tabla de símbolo.
                                        Simbolo sim = new Simbolo();
                                        sim.id = this.id;
                                        sim.valor = atributos;
                                        entorno.insertarSimbolo(sim);
                                        return;
                                    }
                                    else
                                    {
                                        System.out.println("No coincide");
                                    }                                
                                }
                            }                            
                        }
                        else
                        {
                            
                        }
                        valor = nuevoArray;
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
