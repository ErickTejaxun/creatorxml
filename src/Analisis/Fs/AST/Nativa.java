/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Recursos.error;
import Recursos.singlenton;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;

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
    public ArrayList<Exp> parametros;
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
    
//    public Nativa (int l, int c, Exp origen, String id, Nodo metodo)
//    {
//        this.linea = l;
//        this.columna = c;
//        this.origen = origen;
//        this.funcion = id;
//        this.expresion = metodo;
//    }

    public Nativa(int l, int c, Nodo origen, String funcion, Exp metodo) 
    {
        this.linea = l;
        this.columna = c;
        this.origen = origen;
        this.funcion = funcion;
        this.expresion = metodo;
    }
    
    public Nativa(int l, int c, Nodo origen, String funcion, ArrayList<Exp> parametros) 
    {
        this.linea = l;
        this.columna = c;
        this.origen = origen;
        this.funcion = funcion;
        this.parametros = parametros;
        if(parametros.size()>0)
        {
            this.expresion = parametros.get(0);
        }
    }    
    
    
    public void setValor(Entorno entorno)
    {     
//        if(funcion == null)
//        {
//            
//        }
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
            case "alguno":
                alguno(entorno);
                break;
            case "todos":
                todos(entorno);
                break;
            /*Interfaz*/
            case "crearcontenedor":
                crearcontenedor(entorno);
                break;
            case "creartexto":
                creartexto(entorno);
                break;     
            case "alcargar":
                alcargar(entorno);
                break;
//            case "leergxml":
//                leergxml(entorno);
//                break;                    
        }
    }

    
    public void alcargar(Entorno entorno)
    {
        Object nombre = ((idExp)origen).id; //origen.ejecutar(entorno).valor
        
        if(nombre instanceof String)
        {
            Simbolo ventana = entorno.getSimbolo(nombre.toString());            
            if(ventana !=null)
            {
                if(ventana.valor instanceof Hashtable)
                {
                    Object tipo = ((Hashtable)ventana.valor).get("tipo");
                    if(tipo!=null)
                    {
                        if(expresion !=null)
                        {
                            if(expresion instanceof Llamada)
                            {
                                String nombreMetodo = ((Llamada)expresion).id;
                                ((Hashtable)ventana.valor).put("alcargar",expresion);
                                if(tipo.toString().equalsIgnoreCase("ventana"))
                                {
                                    System.out.println(ventana.valor);
                                }                            
                            }                                            
                        }       
                        else
                        {
                            /*Aqui levantamos nuestra ventana*/
                            String titulo = ((Hashtable)ventana.valor).get("id").toString();                            
                            Ventana nuevaVentana = new Ventana(); // Instanciamos la ventana :3 
                            int alto = (int)((Hashtable)ventana.valor).get("alto");
                            int ancho = (int)((Hashtable)ventana.valor).get("ancho");
                            String color = ((Hashtable)ventana.valor).get("color").toString();
                            nuevaVentana.setBounds(0, 0, alto, ancho); // Indicamos el tamaño
                            nuevaVentana.setTitle(titulo); // Agregamos el nombres
                            nuevaVentana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            nuevaVentana.setResizable(false);
                            nuevaVentana.setLayout(null);
                            Color colorPaint = colorFuente(color);
                            Panel panelPrincipalNuevaVentana = new Panel();
                            panelPrincipalNuevaVentana.setBackground(colorPaint); 
                            panelPrincipalNuevaVentana.setBounds(0, 0, alto, ancho);
                            panelPrincipalNuevaVentana.setLayout(null);                                                                              
                            nuevaVentana.repaint();                                                                                    
                            nuevaVentana.id = titulo;
                            /*Creamos todas sus mierdas*/
                                                        
                            Enumeration e = ((Hashtable)ventana.valor).keys();                            
                            Object valor;                            
                            valor = ((Hashtable)ventana.valor).get("contenido");                              
                            if(valor instanceof Hashtable) /*Esta hash es el contenido de elementos.*/
                            {
                                Hashtable elementosVentana = ((Hashtable)valor);
                                Enumeration elementos = elementosVentana.keys();
                                
                                while(elementos.hasMoreElements())
                                {
                                    Object clave = elementos.nextElement();
                                    Object elemento = elementosVentana.get(clave);
                                    Hashtable atributosContenedor = (Hashtable)elemento;
                                    if(elemento !=null)
                                    {
                                        Panel nuevoContenedor = new Panel();
                                        String idContenedor = clave.toString();
                                        int altoContenedor = (int)atributosContenedor.get("alto");
                                        int anchoContenedor = (int)atributosContenedor.get("ancho");
                                        String colorC = atributosContenedor.get("color").toString();
                                        Boolean bordeContenedor = (Boolean)atributosContenedor.get("borde");
                                        int yContenedor = (int)atributosContenedor.get("y");
                                        int xContenedor = (int)atributosContenedor.get("x");
                                        nuevoContenedor.setLayout(null);
                                        nuevoContenedor.setBounds(xContenedor, yContenedor, altoContenedor, anchoContenedor);
                                        nuevoContenedor.setBackground(colorFuente(colorC));
                                        if(bordeContenedor)
                                        {
                                              nuevoContenedor.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
                                              nuevoContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                                        }
                                        /*Agregamos todos los elementos del contenedor*/
                                        Hashtable tablaElementosContenedor = ((Hashtable)atributosContenedor.get("contenido"));
                                        Enumeration elementosContenedor = tablaElementosContenedor.keys();
                                        while(elementosContenedor.hasMoreElements())
                                        {
                                            Object claveElementoContenedor = elementosContenedor.nextElement();
                                            Object valorElementoContenedor = tablaElementosContenedor.get(claveElementoContenedor);
                                            if(valorElementoContenedor instanceof Simbolo)
                                            {
                                                Simbolo tmpElementoContenedor = (Simbolo)valorElementoContenedor;
                                                Hashtable atributosElementoContenedor = (Hashtable)tmpElementoContenedor.valor;
                                                switch(tmpElementoContenedor.tipo)
                                                {
                                                    case "texto":
                                                        Texto txt = new Texto();
                                                        //Fuente, Tamaño, Color, X, Y, Negrilla, Cursiva, valor)                             
                                                        int estiloLetra = getEstilo((boolean)atributosElementoContenedor.get("negrilla"),(boolean)atributosElementoContenedor.get("cursiva"));
                                                        txt.setFont(new java.awt.Font(atributosElementoContenedor.get("fuente").toString(), 0, (int)atributosElementoContenedor.get("tamano")));
                                                        txt.setForeground(colorFuente(atributosElementoContenedor.get("color").toString()));
                                                        txt.setText(atributosElementoContenedor.get("texto").toString());
                                                        int x = (int)atributosElementoContenedor.get("x");
                                                        int y = (int)atributosElementoContenedor.get("y");
                                                        txt.setBounds(x,y, txt.getText().length()*7,20);
                                                        nuevoContenedor.add(txt);
                                                        break;
                                                }
                                            }
                                        }
                                        /*-------------------------Fin elementos Contenedor*/
                                        
                                        
                                        panelPrincipalNuevaVentana.add(nuevoContenedor);                                        
                                    }
                                }
                            }
                                                        
                            
                            /*Agregamos el panel principal*/
                            nuevaVentana.add(panelPrincipalNuevaVentana);  
                            /*Ejecutamos el metodo :V*/
                            Object metodoInicial = ((Hashtable)ventana.valor).get("alcargar");
                            if(metodoInicial!=null)
                            {
                                ((Llamada)metodoInicial).ejecutar(entorno);
                            }                            
                            nuevaVentana.show();
                            //System.out.println("Levantanado la puta interfaz");
                        }
                    }
                }                                
            }
        }
    }
    
    
    public int getEstilo(boolean negrita, boolean cursiva)
    {
        if(negrita && cursiva)
        {
            return 3;
        }
        if(negrita==true && cursiva==false)
        {
            return 1;
        }
        if(negrita==false && cursiva==true)
        {
            return 2;
        }        
        return 0;
    }
    
    public void creartexto(Entorno entorno)
    {
        if(parametros !=null)
        {
            if(id==null)
            {
                id =((idExp)origen).id;
            }
            Simbolo contenedor = entorno.getSimbolo(id);
            if(((Hashtable)contenedor.valor).get("tipo")!=null)
            {
                if(!((Hashtable)contenedor.valor).get("tipo").equals("contenedor"))
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No es un objeto de tipo contenedor"));
                    return;                    
                }                
            }
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No es un objeto de tipo contenedor"));
                return;
            }       
            
            Simbolo ventana = entorno.getSimbolo(((Hashtable)contenedor.valor).get("ventana").toString());
            Hashtable tmpAtributos = ((Hashtable)((Hashtable)ventana.valor).get("contenido"));
            Object tmp = tmpAtributos.get(id);
            if(tmp instanceof Hashtable)
            {
                //Simbolo contenedorVentana = (Simbolo)tmp;
                Hashtable contenedorVentana = (Hashtable)tmp; // contenedor en el que vamos a guardar este elemento
                if(contenedorVentana!=null)
                {
                    Hashtable<String,Object> atributos = new Hashtable<String,Object>();
                    /*Obtenemos todos los atributos*/
                    Simbolo nuevoTexto = new Simbolo("", "texto");
                    nuevoTexto.rol = "variable";
                    if(parametros.size()==8)
                    {
                        //Fuente, Tamaño, Color, X, Y, Negrilla, Cursiva, valor
                        atributos.put("tipo", "texto");
                        atributos.put("fuente", parametros.get(0).ejecutar(entorno).valor);
                        atributos.put("tamano", parametros.get(1).ejecutar(entorno).valor);
                        String color = parametros.get(2).ejecutar(entorno).valor.toString();
                        if(isColor(color))
                        {
                            atributos.put("color", color);
                        }
                        else
                        {
                            atributos.put("color", ((Hashtable)contenedor.valor).get("color"));
                        }

                        atributos.put("x", parametros.get(3).ejecutar(entorno).valor);
                        atributos.put("y", parametros.get(4).ejecutar(entorno).valor);
                        atributos.put("negrilla", parametros.get(5).ejecutar(entorno).valor);
                        atributos.put("cursiva",parametros.get(6).ejecutar(entorno).valor);
                        atributos.put("texto",parametros.get(7).ejecutar(entorno).valor);
                        atributos.put("contenido", new Hashtable<String,Simbolo>());
                        valor = atributos;  
                        nuevoTexto.valor = atributos;
                        ((Hashtable)contenedorVentana.get("contenido")).put("", nuevoTexto);
//                        Object tabla = null;
//                        if(contenedorVentana.valor instanceof Hashtable)
//                        {
//                            tabla = ((Hashtable)contenedorVentana.valor).get("contenido");
//                        }
//                        if(tabla!=null)
//                        {
//                            if(tabla instanceof Hashtable)
//                            {
//                                ((Hashtable) tabla).put(((Hashtable) tabla).size()+1, valor);
//                            }
//                        }
//
//                        nuevoContenedor.valor = atributos;
                        //entorno.insertarSimbolo(nuevoContenedor);
                    }
                    else
                    {
                        singlenton.addErrores(new error("semantico",linea,columna, id," Faltan parametros para la creación de un conetenedor."));
                    }
                    //nuevoContenedor.valores = ;
                }                
            }                        
        }
    }    
    
    /*Terminada*/
    public void crearcontenedor(Entorno entorno)
    {
        if(parametros !=null)
        {
            if(id==null)
            {
                id =((idExp)origen).id;
            }
            Simbolo sim = entorno.getSimbolo(id);
            if(((Hashtable)sim.valor).get("tipo")!=null)
            {
                if(!((Hashtable)sim.valor).get("tipo").equals("ventana"))
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," No es un objeto de tipo ventana"));
                    return;                    
                }                
            }
            else
            {
                singlenton.addErrores(new error("semantico",linea,columna, id," No es un objeto de tipo ventana"));
                return;
            }            
            if(sim!=null)
            {
                Hashtable<String,Object> atributos = new Hashtable<String,Object>();
                /*Obtenemos todos los atributos*/
                Simbolo nuevoContenedor = new Simbolo("", "contenedor");
                nuevoContenedor.rol = "variable";
                if(parametros.size()==6)
                {
                    atributos.put("tipo", "contenedor");
                    atributos.put("alto", parametros.get(0).ejecutar(entorno).valor);
                    atributos.put("ancho", parametros.get(1).ejecutar(entorno).valor);
                    String color = parametros.get(2).ejecutar(entorno).valor.toString();
                    if(isColor(color))
                    {
                        atributos.put("color", color);
                    }
                    else
                    {
                        atributos.put("color", ((Hashtable)sim.valor).get("color"));
                    }
                    
                    atributos.put("borde", parametros.get(3).ejecutar(entorno).valor);
                    atributos.put("x", parametros.get(4).ejecutar(entorno).valor);
                    atributos.put("y", parametros.get(5).ejecutar(entorno).valor);
                    atributos.put("ventana",id);
                    atributos.put("contenido", new Hashtable<String,Simbolo>());
                    valor = atributos;  
                    Object tabla = null;
                    if(sim.valor instanceof Hashtable)
                    {
                        tabla = ((Hashtable)sim.valor).get("contenido");
                    }
                    if(tabla!=null)
                    {
                        if(tabla instanceof Hashtable)
                        {
                            ((Hashtable) tabla).put(((Hashtable) tabla).size()+1, valor);
                        }
                    }
                    
                    nuevoContenedor.valor = atributos;
                    //entorno.insertarSimbolo(nuevoContenedor);
                }
                else
                {
                    singlenton.addErrores(new error("semantico",linea,columna, id," Faltan parametros para la creación de un conetenedor."));
                }
                //nuevoContenedor.valores = ;
            }
        }
    }
    
    public boolean isColor(String color)
    {
       if(color.contains("#"))
       {
            //Mensaje("Buscando color: \t "+color,"");           
            //Color colorFodo = new Color(int r, int g, int b, int a);
            //this.scroll.setBackground(colorFondo);
            int r,g,b,a;
            String hr,hg,hb,ha;
            String entrada= color;
            hr = entrada.substring(1,3);
            hg = entrada.substring(3,5);
            hb = entrada.substring(5,7);

            r = hexToDec(hr);
            g = hexToDec(hg);
            b = hexToDec(hb);
            a=0;
            if(r==300 || g ==300 || b==300)
            {
                //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),"Semantico", hijoD.getValue() + " Valor rgb no valido."});
                String mensaje = color + "Valor rgb no válido.";
                singlenton.addErrores(new error("semantico",linea,columna, color,mensaje));                       
                return false;
            }
            else
            {
                //panel.setBackground(new Color(r,g,b));
                return true;          
            }        
       }    
       return false;
    }
    
   private static int hexToDec(String hex) {  
       Integer outputDecimal = 0;
        try
        { 
            outputDecimal = Integer.parseInt(hex, 16);
            System.out.print(outputDecimal+"\t D:\t" + hex);
            return outputDecimal;
        }
        catch(NumberFormatException ne)
        {
            return 300;
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
                                        valorParametroIterador = new IntExp((Integer)valor);                                    
                                    }
                                    if(valor instanceof Double)
                                    {
                                        valorParametroIterador = new DoubleExp((Double)valor);
                                    }     
                                    if(valor instanceof String)
                                    {
                                        valorParametroIterador = new StringExp((String)valor);
                                    } 
                                    if(valor instanceof Boolean)
                                    {
                                        valorParametroIterador = new BoolExp((Boolean)valor);
                                    }  
                                    if(valor instanceof  Hashtable)
                                    {
                                        valorParametro = new Atributo("");
                                        ((Atributo)valorParametro).valor = (Hashtable<String, Object>) valor;
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
                                contador ++;
                            }
                            
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
                        
            Object acumulador =null;
            int contador = 0;
            if(resultado!=null)
            {
                try 
                {
                    if(resultado instanceof ArrayList)
                    {
                      if(iterador==null)
                      {
                          if(expresion instanceof idExp)
                          {
                              iterador = ((idExp)expresion).id;
                          }
                      }
                      if(!esHomogeneo((ArrayList)resultado))
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
                        for(Object t : ((ArrayList<Simbolo>)resultado))
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
                                resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                
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
                                        valorParametroIterador = new IntExp((Integer)valor);                                    
                                    }
                                    if(valor instanceof Double)
                                    {
                                        valorParametroIterador = new DoubleExp((Double)valor);
                                    }     
                                    if(valor instanceof String)
                                    {
                                        valorParametroIterador = new StringExp((String)valor);
                                    } 
                                    if(valor instanceof Boolean)
                                    {
                                        valorParametroIterador = new BoolExp((Boolean)valor);
                                    }  
                                    if(valor instanceof  Hashtable)
                                    {
                                        valorParametro = new Atributo("");
                                        ((Atributo)valorParametro).valor = (Hashtable<String, Object>) valor;
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
                                contador ++;
                            }
                            
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
        
        if(valor.equals(""))
        {
            //valor = 0;
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
                                
                                //Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;    
                                valor = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                
                                if(valor!=null)
                                {
                                    if(valor instanceof Hashtable)
                                    {
                                        nuevoArray.add((Hashtable)valor);
                                    }
                                    else
                                    {
                                        vectorPrimitivo.add(valor);
                                    }
                                }                                
                                
                            }
                            
                        }                          
                        if(vectorPrimitivo.size()>0)
                        {
                            valor = vectorPrimitivo;
                        }
                        else
                        if(nuevoArray.size()>0)
                        {
                            valor = nuevoArray;
                        }
//                        switch(caso)
//                        {
//                            case 0: 
//                                //valor = nuevoArray;
//                                valor = vectorPrimitivo;
//                                break;
//                            case 1:
//                                valor = vectorPrimitivo;
//                        }                        
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
            if(resultado!=null)
            {
                try 
                {
                    if(resultado instanceof ArrayList)
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
                        for(Object t : ((ArrayList<Simbolo>)resultado))
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
                                
                                //Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;    
                                valor = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;                                
                                if(valor!=null)
                                {
                                    if(valor instanceof Hashtable)
                                    {
                                        nuevoArray.add((Hashtable)valor);
                                    }
                                    else
                                    {
                                        vectorPrimitivo.add(valor);
                                    }
                                }                                
                                
                            }
                            
                        }                          
                        if(vectorPrimitivo.size()>0)
                        {
                            valor = vectorPrimitivo;
                        }
                        else
                        if(nuevoArray.size()>0)
                        {
                            valor = nuevoArray;
                        }
//                        switch(caso)
//                        {
//                            case 0: 
//                                //valor = nuevoArray;
//                                valor = vectorPrimitivo;
//                                break;
//                            case 1:
//                                valor = vectorPrimitivo;
//                        }                        
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
    }   
    
    public void todos(Entorno entorno)
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
                                    if(!(Boolean)resultado)
                                    {
                                        valor = "falso";
                                        return;
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
                                    if(!(Boolean)resultado)
                                    {
                                        valor = "falso";
                                        return;
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
        valor = "verdadero";
    }      
    
    public void alguno(Entorno entorno)
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
                                        valor = "verdadero";
                                        return;
//                                        nuevoArray.add((Hashtable)item.valor);
//                                        break;
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
                                        valor = "verdadero";
                                        return;
//                                        vectorPrimitivo.add(t);
//                                        break;
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
        valor = "falso";
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
            Object resultadoNativa = origen.ejecutar(entorno).valor;
            
            Simbolo variable = new Simbolo();
            variable.setValor(resultadoNativa);
                    //entorno.getSimbolo(id);
            
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
                                System.out.print(nuevoArray.size());
                                ArrayList<String> nombres = new ArrayList<String>();
                                nombres.add(nombreVar);                            
                                //iteradora.declaracionParametros.set(0, new Declaracion(0,0, nombres, atributos));
                                ArrayList<Exp> lista = new ArrayList<Exp>();
                                lista.add(atributos);
                                Llamada llamada = new Llamada(iterador,lista);
                                Object resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
                                System.out.println("-------\t"+nuevoArray.size());
                                if(resultado instanceof Boolean)
                                {
                                    if((Boolean)resultado)
                                    {
                                        boolean add = nuevoArray.add((Hashtable)item.valor);
                                        System.out.println("#Elementos\t"+nuevoArray.size());
                                        if(!add)
                                        {
                                            System.err.println("No se ha podido agregar el item");
                                        }
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

            if(resultado!=null)
            {
                try 
                {
                    if(resultado instanceof ArrayList)
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
                        for(Object t : ((ArrayList<Simbolo>)resultado))
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
                                resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
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
                                
                                resultado = llamada.ejecutar(new Entorno(entorno, entorno.ventana)).valor;
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
    
   public Color colorFuente(String color)
   {
       color = quitarComillas(color).toLowerCase();       
       Color retorno = Color.WHITE ;
       System.out.println("Buscando color: \t "+color);
       
       if(color.contains("#"))
       {
            //Mensaje("Buscando color: \t "+color,"");           
            //Color colorFodo = new Color(int r, int g, int b, int a);
            //this.scroll.setBackground(colorFondo);
            int r,g,b,a;
            String hr,hg,hb,ha;
            String entrada= color;
            hr = entrada.substring(1,3);
            hg = entrada.substring(3,5);
            hb = entrada.substring(5,7);

            r = hexToDec(hr);
            g = hexToDec(hg);
            b = hexToDec(hb);
            a=0;
            if(r==300 || g ==300 || b==300)
            {
                //filasErrores.addRow(new String[]{"CHTML",String.valueOf(hijoD.getLinea()),String.valueOf(hijoD.getColumna()),"Semantico", hijoD.getValue() + " Valor rgb no valido."});
                String mensaje = color + "Valor rgb no válido.";
                singlenton.addErrores(new error("Sematico", linea, columna, color, mensaje ));             
            }
            else
            {
                //panel.setBackground(new Color(r,g,b));
                retorno = new Color(r,g,b);            
            }        
       }
       else
       {              
            switch(color)
            {
                case "blue":
                    retorno = Color.blue;
                    break;
                case "black":
                    retorno = Color.BLACK;
                    break;
                case "gray":
                    retorno = Color.GRAY;
                    break;
                case "cyan":
                    retorno = Color.CYAN;
                    break;
                case "dark_gray":
                    retorno = Color.DARK_GRAY;
                    break;   
                case "green":
                    retorno = Color.GREEN;
                    break;
                case "light_gray":
                    retorno = Color.LIGHT_GRAY;
                    break;
                case "magenta":
                    retorno = Color.MAGENTA;
                    break;
                case "orange":
                    retorno = Color.ORANGE;
                    break;
                case "pink":
                    retorno = Color.PINK;
                    break;
                case "red":
                    retorno = Color.RED;
                    break;
                case "white":
                    retorno = Color.WHITE;
                    break;
                case "yellow":
                    retorno = Color.YELLOW;
                    break;  
                default:
                    //filasErrores.addRow(new String[]{"CHTML",String.valueOf(raiz.getLinea()),String.valueOf(raiz.getColumna()),"Semantico","Nombre de color no válido."});
                    //Errores(String tipo, int linea, int columna, String valor)
                    String mensaje = color + "Nombre de color no válido.";                    
                    singlenton.addErrores(new error("Sematico", linea, columna, color, mensaje ));
                    break;
            }   
       }
        return retorno;
   }     
    
    public String quitarComillas(String cadena)
    {
        if(cadena!=null)
        {
            if(!cadena.equals(""))
            {
                String inicio = cadena.substring(0, 1);
                if(inicio.equals("\""))
                {
                    return cadena.substring(1, cadena.length()-1);
                }
                return cadena.trim();            
            }
            return cadena.trim();
        }
        return cadena.trim();
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
