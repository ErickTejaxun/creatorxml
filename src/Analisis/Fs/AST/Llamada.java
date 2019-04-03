/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

import Analisis.Gdato.parsergd;
import Analisis.Gdato.scannergd;
import Recursos.error;
import Recursos.singlenton;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class Llamada extends Exp {
    public ArrayList<Exp> parametros;    
    public String id;
    public Llamada(String i, ArrayList<Exp> p)
    {
        id = i;
        parametros = p;
    }
    
    public Llamada(int l, int c, String i, ArrayList<Exp> p)
    {
        this.linea  = l;
        this.columna = c;
        id = i;
        parametros = p;
        
    }
        
    public void setValor(Entorno entorno) throws Exception
    {
        valor = "";
        if(!id.equalsIgnoreCase("crearArrayDesdeArchivo"))
        {            
            /*Obtener el id de la funcion a llamar*/
            Entorno entornoLocal = new Entorno(entorno, entorno.ventana);
            String idMetodo = id;
            for(Exp e : parametros)
            {
                idMetodo+="$var";
            }
            Simbolo s = entorno.ventana.entornoGlobal.getSimbolo(idMetodo);
            if(s==null)
            {
                singlenton.addErrores(new error("semantico",linea,columna, id,"El metodo no existe."));
                return;
            }
            //System.out.println("----------------LLAMADA---------------------");
            if(s.valor instanceof Metodo)
            {            
                int indice = 0;
                ArrayList<Nodo> valores = new ArrayList<Nodo>();
                String llamada = id+"(";
                for(Exp parametro :parametros)
                {                
                    Object resultado = parametro.ejecutar(entorno).valor;
                    if(resultado instanceof Integer)
                    {
                        valores.add(new IntExp((Integer)resultado));
                    }
                    else
                    if(resultado instanceof String)
                    {
                        valores.add(new StringExp((String)resultado));
                    }                
                    else
                    if(resultado instanceof Double)
                    {
                        valores.add(new DoubleExp((Double)resultado));
                    }   
                    else
                    if(resultado instanceof Boolean)
                    {
                        valores.add(new BoolExp((Boolean)resultado));
                    }   
                    else      
                    if(resultado instanceof Simbolo)
                    {
                        valores.add( new idExp(((Simbolo)resultado).id));
                    }  
                    else 
                    if(resultado instanceof Hashtable)
                    {
                        Simbolo stemp = new Simbolo("item", "object", "var",resultado);
                        entorno.insertarSimbolo(stemp);
                        valores.add( new idExp( stemp.id));
                    }
                                  
                }
                for(Nodo parametro :valores)
                {
                    llamada+= ((Nodo)parametro).ejecutar(entorno).valor+",";
                    Declaracion dec = ((Declaracion)((Metodo)s.valor).declaracionParametros.get(indice));
                    dec.exp = (Exp)parametro;
                    dec.ejecutar(entornoLocal);
                    indice++;
                }                        
                llamada+= ")";
                //System.out.println(llamada);
                valor = ((Metodo)s.valor).bloque.ejecutar(entornoLocal).valor;
                if(valor == null)
                {
                    valor ="";
                }
            }            
        }
        else
        {
                Object ruta = parametros.get(0);                
                parsergd parsergd_;
                scannergd scannerdg_ = new scannergd(new java.io.FileReader((String)ruta));
                parsergd_ = new parsergd(scannerdg_);
                parsergd_.parse();              
                if(parsergd_.listaDatos!=null)
                {
                      valor = parsergd_.listaDatos;
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
        valor = "";
        try {                
            setValor(entorno);
        } catch (Exception ex) {
            Logger.getLogger(Llamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
}
