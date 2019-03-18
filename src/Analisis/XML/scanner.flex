package Analisis.XML;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Analisis.XML.AST.singlenton;
import Recursos.*;
%%
%{	    
    public ArrayList<error> listaErrores = new ArrayList(); // Lista para almacenar errores.
    public ArrayList<lexema> listaLexemas = new ArrayList(); // Lista para almacenar el flujo de palabras (tokens).
    public String cadena ="";
    public boolean flag = false;
    public boolean flagSalto= false;
    public int contadorEtiquetas = 0 ;  // 0 estado yyinitial, 1 estado 0, 2 estado 1;


    public void iniciarCadena()
    {  
        flag = true;
        cadena = "";
    }

    public void finalizarCadena()
    {   
        flagSalto = !flagSalto;     
        Imprimir("--------------------");
        Imprimir(cadena);
        Imprimir("--------------------");
        cadena = "";        
        flag = false;        
    }
    
    public void adderror(int linea, int columna, String valor)
    {        
        singlenton.addErrores(new error("Lexico",valor, linea, columna));
    }
    public void adderror(int linea, int columna, String valor, String desc)
    {        
        singlenton.addErrores(new error("Lexico",linea, columna, valor, desc));
    }    
    public void addLexema(String tipo, String valor, int linea, int columna)
    {        
        listaLexemas.add(new lexema(tipo, valor, linea, columna));	            
    } 

    public void Imprimir(String cadena)
    {
        System.out.println(cadena);
    }   

    

%}
%class scannerxml /*Nombre de la clase a generar.%cupsym simbolos*/
%unicode /*Caracteres unicode*/
%public /*Se generará una clase pública.*/
%cup  /*Implementación con CUP*/
%full
%line   /*Almacenar el número de linea actual.*/
%char   /* Contador de caracteres.*/
%ignorecase /*Indiferente entre mayusculas y minusculas*/
%eofval{ // Genera el simbolo de cierre.
	return new Symbol(sym.EOF);    
%eofval}



espacio = \t|\f|" "|\r|\n    // ER para capturar espacios, salto de línea, tabulaciones.
numero = ([0-9][0-9]*) ("." [0-9][0-9]*)?       // ER para capturar números.
/*decimal= {numero}"."{numero}*/ // Expresión 
/*rgb  = ("#"{id}| "#"{digito} | "#"{digito}{id})*/
letra = ([a-zA-Z]|"ñ"|"á"|"é"|"í"|"ó"|"ú")
InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n
id = (({letra}|"_")({letra}|{numero}|"_")*)
cadenaComillas = (("\"" [^*] ~"\"") | ("\“" [^*] ~"\”"))
parametros = (("{" [^*] ~"]") | ("[" [^*] ~"]"))
/*cadComillaSimple = ("'" [^*] ~"'")*/
/*direccionWindows= ("\"" ({letra}":"("\\"({id}|{espacio}|"_"|"-"|{numero})+)+"."{id}) "\"")*/
comentario = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "#$" [^*] ~"$#" | "#$" "$"+ "#"
EndOfLineComment = "##" {InputCharacter}* {LineTerminator}?
DocumentationComment = "#$" "*"+ [^/*] ~"$#"
/*si = ("si")*/
/*sino = ("sino")*/
/*sinosi={sino}({comentario}|{espacio})*(si)*/
%state CADENA COMENTARIO COMENTARIO2 COMENTARIO3 COMENTARIO4 YYINITIAL2

%%
<YYINITIAL>
{
    [\n] { yychar=0;}
    {espacio}
    {
        /*Imprimir("Salto de linea");*/
    }
    {comentario} 
    {
        /*Imprimir(yytext().toLowerCase());*/
    }
    "<=" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.menorigual, yychar, yyline, yytext().toLowerCase());
        } 
    ">=" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.mayorigual, yychar, yyline, yytext().toLowerCase());
        } 
    "!=" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.diferente, yychar, yyline, yytext().toLowerCase());
        }  
    "==" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.igualigual, yychar, yyline, yytext().toLowerCase());
        }                           
    "<" {
            addLexema("simbolo", yytext(), yyline, yychar);
            finalizarCadena();            
            return  new Symbol(sym.menorque, yychar, yyline, yytext().toLowerCase());
        }
    ">" {
            addLexema("simbolo", yytext(), yyline, yychar);      
            if(flag)
            {
                yybegin(CADENA);
            }      
            return  new Symbol(sym.mayorque, yychar, yyline, yytext().toLowerCase());
        }
    "/" {
            addLexema("simbolo", yytext(), yyline, yychar);  
            yybegin(YYINITIAL2);
            Imprimir("Saltando a YYINITIAL2");
            return  new Symbol(sym.slash, yychar, yyline, yytext().toLowerCase());
        } 
    "=" {
            addLexema("simbolo", yytext(), yyline, yychar);            
            return  new Symbol(sym.igual, yychar, yyline, yytext().toLowerCase());
        }
    "{" {
            addLexema("simbolo", yytext(), yyline, yychar);        
            return  new Symbol(sym.llavei, yychar, yyline, yytext().toLowerCase());
        } 
    "(" {
            addLexema("simbolo", yytext(), yyline, yychar);        
            return  new Symbol(sym.pari, yychar, yyline, yytext().toLowerCase());
        }   
    ")" {
            addLexema("simbolo", yytext(), yyline, yychar);        
            return  new Symbol(sym.pard, yychar, yyline, yytext().toLowerCase());
        }                                        
    "}" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.llaved, yychar, yyline, yytext().toLowerCase());
        } 
    "," {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.coma, yychar, yyline, yytext().toLowerCase());
        }   
    "+" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.mas, yychar, yyline, yytext().toLowerCase());
        } 
    "-" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.menos, yychar, yyline, yytext().toLowerCase());
        }                
    "*" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.multi, yychar, yyline, yytext().toLowerCase());
        } 
    "^" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.potencia, yychar, yyline, yytext().toLowerCase());
        }    
    "||" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.or, yychar, yyline, yytext().toLowerCase());
        }  
    "&&" {
            addLexema("simbolo", yytext(), yyline, yychar);                        
            return  new Symbol(sym.and, yychar, yyline, yytext().toLowerCase());
        }                                                                                 
    "id" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tid, yychar, yyline, yytext().toLowerCase());
        }         
    "tipo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ttipo, yychar, yyline, yytext().toLowerCase());
        }    
    /*Inicio etiquetas donde se activa la recolección de cadenas*/
    "importar" 
        {
            addLexema("reservada", yytext(), yyline, yychar); 
            iniciarCadena();       
            return  new Symbol(sym.timportar, yychar, yyline, yytext().toLowerCase());
        }  
    "contenedor" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.contenedor, yychar, yyline, yytext().toLowerCase());
        }  
    "ventana" 
        {
            addLexema("reservada", yytext(), yyline, yychar);
            finalizarCadena();                        
            return  new Symbol(sym.tventana, yychar, yyline, yytext().toLowerCase());
        }       
    "texto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);              
            iniciarCadena();
            return  new Symbol(sym.ttexto, yychar, yyline, yytext().toLowerCase());
        }   
    "dato" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            iniciarCadena();          
            return  new Symbol(sym.dato, yychar, yyline, yytext().toLowerCase());
        }  
    "defecto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);                        
            iniciarCadena();            
            return  new Symbol(sym.defecto, yychar, yyline, yytext().toLowerCase());
        }                                                                                        
    /*Fin etiquetas donde se activa la recolección de cadenas*/                
    "color" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcolor, yychar, yyline, yytext().toLowerCase());
        }                 
    "accioninicial" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tinicial, yychar, yyline, yytext().toLowerCase());
        }                 
    "accionfinal" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tfinal, yychar, yyline, yytext().toLowerCase());
        }     
    "x" {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tx, yychar, yyline, yytext().toLowerCase());
        }                                                         
    "y" {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ty, yychar, yyline, yytext().toLowerCase());
        }                            
    "alto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.talto, yychar, yyline, yytext().toLowerCase());
        }                               
    "ancho" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tancho, yychar, yyline, yytext().toLowerCase());
        }                                
    "borde" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tborde, yychar, yyline, yytext().toLowerCase());
        }                                
    "falso" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.falso, yychar, yyline, yytext().toLowerCase());
        }                               
    "verdadero" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.verdadero, yychar, yyline, yytext().toLowerCase());
        }                                   
                                    
    "nombre" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tnombre, yychar, yyline, yytext().toLowerCase());
        }                                
    "fuente" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tfuente, yychar, yyline, yytext().toLowerCase());
        }                                
    "tam" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ttamanio, yychar, yyline, yytext().toLowerCase());
        }                             
    "negrita" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tnegrita, yychar, yyline, yytext().toLowerCase());
        }                                 
    "cursiva" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcursiva, yychar, yyline, yytext().toLowerCase());
        }                                 
    "control" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcontrol, yychar, yyline, yytext().toLowerCase());
        }  
    "maximo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tmaximo, yychar, yyline, yytext().toLowerCase());
        }    
    "multimedia" 
        {
            addLexema("reservada", yytext(), yyline, yychar);
            finalizarCadena();            
            return  new Symbol(sym.tmultimedia, yychar, yyline, yytext().toLowerCase());
        } 
    "enviar" 
        {
            addLexema("reservada", yytext(), yyline, yychar);    
            iniciarCadena();
            return  new Symbol(sym.tenviar, yychar, yyline, yytext().toLowerCase());
        }                                    
    "boton" 
        {
            addLexema("reservada", yytext(), yyline, yychar); 
            iniciarCadena();           
            return  new Symbol(sym.tboton, yychar, yyline, yytext().toLowerCase());
        }            
    "minimo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tminimo, yychar, yyline, yytext().toLowerCase());
        }                            
    "accion" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.taccion, yychar, yyline, yytext().toLowerCase());
        }                            
    "referencia" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.treferencia, yychar, yyline, yytext().toLowerCase());
        }                            
    "listadatos" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.listadatos, yychar, yyline, yytext().toLowerCase());
        }                                    
    "path" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tpath, yychar, yyline, yytext().toLowerCase());
        }                              
    "auto-reproduccion" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tautoreproduccion, yychar, yyline, yytext().toLowerCase());
        } 
    {parametros}
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.cadena,yychar, yyline, yytext().substring(1,yytext().length()-1));
        } 
    {id}
        {
                addLexema("identificador",yytext(), yyline, yychar);
                return new Symbol(sym.id,yychar, yyline, yytext());
        }   
    {numero}
        {
                addLexema("numerico",yytext(), yyline, yychar);
                return new Symbol(sym.numero,yychar, yyline, yytext().toLowerCase());
        }                                
    {cadenaComillas}
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.cadena,yychar, yyline, yytext().substring(1,yytext().length()-1));
        }                                         
    .		
    {
            System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
            adderror(yyline, yychar, yytext().toLowerCase());
    }

}
<CADENA>
{
    [^]
    {  
        switch(yytext())
        {
            case "#":
                yybegin(COMENTARIO);
                break;
            case "<":            
                yybegin(YYINITIAL2);
                yypushback(1);                
                addLexema("cadena",cadena, yyline, yychar);     
                Imprimir("Saliendo de estado cadena.");
                if(!cadena.trim().equals(""))
                {
                    Imprimir("Retornando cadena ------------" + cadena + "*******************");
                    return new Symbol(sym.cadena, yychar, yyline, cadena.trim());
                }   
                yybegin(YYINITIAL);
                Imprimir("No se retornó cadena.");
            default:
                if(yytext().equals("\n"))
                {
                    cadena  = cadena + "\n";  
                    yychar = 1;                  
                }
                else
                {
                    cadena  = cadena + yytext();            
                }  
                //Imprimir(cadena);
                break;
        }                  
    } 
}

<YYINITIAL2>
{      
    {espacio}
    {
        /*Imprimir("Salto de linea");*/
    }
    {comentario} 
    {
        /*Imprimir(yytext().toLowerCase());*/
    }     
    "importar" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            return  new Symbol(sym.timportar, yychar, yyline, yytext().toLowerCase());
        }  
    "contenedor" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.contenedor, yychar, yyline, yytext().toLowerCase());
        }  
    "ventana" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tventana, yychar, yyline, yytext().toLowerCase());
        }       
    "texto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            return  new Symbol(sym.ttexto, yychar, yyline, yytext().toLowerCase());
        }   
    "dato" 
        {
            addLexema("reservada", yytext(), yyline, yychar);      
            return  new Symbol(sym.dato, yychar, yyline, yytext().toLowerCase());
        } 
    "listadatos" 
        {
            addLexema("reservada", yytext(), yyline, yychar);      
            return  new Symbol(sym.listadatos, yychar, yyline, yytext().toLowerCase());
        }          
    "defecto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);                         
            return  new Symbol(sym.defecto, yychar, yyline, yytext().toLowerCase());
        }
    "control" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcontrol, yychar, yyline, yytext().toLowerCase());
        }
    "multimedia" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tmultimedia, yychar, yyline, yytext().toLowerCase());
        }   
    "boton" 
        {
            addLexema("reservada", yytext(), yyline, yychar);                       
            return  new Symbol(sym.tboton, yychar, yyline, yytext().toLowerCase());
        }
    "enviar" 
        {
            addLexema("reservada", yytext(), yyline, yychar);                       
            return  new Symbol(sym.tenviar, yychar, yyline, yytext().toLowerCase());
        }                                         
    "<" {
            addLexema("simbolo", yytext(), yyline, yychar);
            finalizarCadena();            
            return  new Symbol(sym.menorque, yychar, yyline, yytext().toLowerCase());
        }        
    ">" {
            addLexema("simbolo", yytext(), yyline, yychar);      
            yybegin(YYINITIAL);
            return  new Symbol(sym.mayorque, yychar, yyline, yytext().toLowerCase());
        } 
    "/" {
            addLexema("simbolo", yytext(), yyline, yychar);  
            return  new Symbol(sym.slash, yychar, yyline, yytext().toLowerCase());
        }                    
}

<COMENTARIO>
{
    "$"
    {
        yybegin(COMENTARIO3);/*Comentario multilinea*/
        Imprimir("Inicia comentario multi linea.");
    }
    "#"
    {
        yybegin(COMENTARIO2);/*Comentario de una sola linea*/
        Imprimir("Inicia comentario uni linea.");
    }
    "<"
    {
        adderror(yyline, yychar, yytext(),"Falta simbolo para cierre de comentario.");
        yybegin(CADENA);
        yypushback(1);
    }
    [^#$<]
    {
        yybegin(CADENA);        
        cadena = cadena + "#";
    }
   
}

<COMENTARIO2>
{
    "\n"
    {
        yybegin(CADENA);
        //yyline++;
        Imprimir("Regresando a estado cadena");
    }    
    [^\n]
    {
        /*Ignorar que es comentario*/
    }
}

<COMENTARIO3>
{    
    "$#"
    {
        yybegin(CADENA);/*Comentario de una sola linea*/        
        Imprimir("Fin del comentario multi linea.");
    } 
    "$"
    {
        //cadena += "$";
        adderror(yyline, yychar, yytext(),"Falta simbolo para cierre de comentario.");
        yybegin(CADENA);/*Comentario de una sola linea*/        
        Imprimir("Fin del comentario multi linea.");
    }     
    "<"
    {
        yybegin(CADENA);
        yypushback(1);
    }    
    [^#$<]    
    {
        //Imprimir(yytext().toLowerCase());
        /*Ignorar*/
    } 
}		

<COMENTARIO4>
{
    "$"
    {
        yybegin(CADENA);/*Comentario de una sola linea*/
    }     
    [^$]
    {
        yybegin(COMENTARIO3);
        Imprimir("Saltar a comentario 3");
    }   
}		

