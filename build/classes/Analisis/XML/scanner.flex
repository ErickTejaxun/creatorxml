package Analisis.XML;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
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
        listaErrores.add(new error("Lexico",valor, linea, columna));
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
numero = ([0-9][0-9]*)       // ER para capturar números.
/*decimal= {numero}"."{numero}*/ // Expresión 
/*rgb  = ("#"{id}| "#"{digito} | "#"{digito}{id})*/
letra = ([a-zA-Z]|"ñ"|"á"|"é"|"í"|"ó"|"ú")
InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n
id = (({letra}|"_")({letra}|{numero}|"_")*)
cadenaComillas = (("\"" [^*] ~"\"") | ("\“" [^*] ~"\”"))
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
        /*Imprimir(yytext());*/
    }

    "<" {
            addLexema("simbolo", yytext(), yyline, yychar);
            finalizarCadena();            
            return  new Symbol(sym.menorque, yychar, yyline, yytext());
        }
    ">" {
            addLexema("simbolo", yytext(), yyline, yychar);      
            if(flag)
            {
                yybegin(CADENA);
            }      
            return  new Symbol(sym.mayorque, yychar, yyline, yytext());
        }
    "/" {
            addLexema("simbolo", yytext(), yyline, yychar);  
            yybegin(YYINITIAL2);
            Imprimir("Saltando a YYINITIAL2");
            return  new Symbol(sym.slash, yychar, yyline, yytext());
        } 
    "=" {
            addLexema("simbolo", yytext(), yyline, yychar);            
            return  new Symbol(sym.igual, yychar, yyline, yytext());
        }
    "{" {
            addLexema("simbolo", yytext(), yyline, yychar);            
            return  new Symbol(sym.llaved, yychar, yyline, yytext());
        }                       
    "}" {
            addLexema("simbolo", yytext(), yyline, yychar);            
            return  new Symbol(sym.llavei, yychar, yyline, yytext());
        }                                    
    "id" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tid, yychar, yyline, yytext());
        }         
    "tipo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ttipo, yychar, yyline, yytext());
        }    
    /*Inicio etiquetas donde se activa la recolección de cadenas*/
    "importar" 
        {
            addLexema("reservada", yytext(), yyline, yychar); 
            iniciarCadena();       
            return  new Symbol(sym.timportar, yychar, yyline, yytext());
        }  
    "contenedor" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.contenedor, yychar, yyline, yytext());
        }  
    "ventana" 
        {
            addLexema("reservada", yytext(), yyline, yychar);
            finalizarCadena();                        
            return  new Symbol(sym.tventana, yychar, yyline, yytext());
        }       
    "texto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            yybegin(CADENA);
            iniciarCadena();
            return  new Symbol(sym.ttexto, yychar, yyline, yytext());
        }   
    "dato" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.dato, yychar, yyline, yytext());
        }  
    "defecto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            yybegin(CADENA);
            iniciarCadena();            
            return  new Symbol(sym.defecto, yychar, yyline, yytext());
        }                                                                                        
    /*Fin etiquetas donde se activa la recolección de cadenas*/                
    "color" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcolor, yychar, yyline, yytext());
        }                 
    "accioninicial" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tinicial, yychar, yyline, yytext());
        }                 
    "accionfinal" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tfinal, yychar, yyline, yytext());
        }     
    "x" {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tx, yychar, yyline, yytext());
        }                                                         
    "y" {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ty, yychar, yyline, yytext());
        }                            
    "alto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.talto, yychar, yyline, yytext());
        }                               
    "ancho" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tancho, yychar, yyline, yytext());
        }                                
    "borde" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tborde, yychar, yyline, yytext());
        }                                
    "falso" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.falso, yychar, yyline, yytext());
        }                               
    "verdadero" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.verdadero, yychar, yyline, yytext());
        }                                   
                                    
    "nombre" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tnombre, yychar, yyline, yytext());
        }                                
    "fuente" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tfuente, yychar, yyline, yytext());
        }                                
    "tam" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.ttamanio, yychar, yyline, yytext());
        }                             
    "negrita" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tnegrita, yychar, yyline, yytext());
        }                                 
    "cursiva" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcursiva, yychar, yyline, yytext());
        }                                 
    "control" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tcontrol, yychar, yyline, yytext());
        }  
    "maximo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tmaximo, yychar, yyline, yytext());
        }    
    "multimedia" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tmultimedia, yychar, yyline, yytext());
        } 
    "enviar" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tenviar, yychar, yyline, yytext());
        }                                    
    "boton" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tboton, yychar, yyline, yytext());
        }            
    "minimo" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tminimo, yychar, yyline, yytext());
        }                            
    "accion" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.taccion, yychar, yyline, yytext());
        }                            
    "referencia" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.treferencia, yychar, yyline, yytext());
        }                            
    "listadatos" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.listadatos, yychar, yyline, yytext());
        }                                    
    "path" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.path, yychar, yyline, yytext());
        }                              
    "auto-reproduccion" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.autoreproduccion, yychar, yyline, yytext());
        } 
    {id}
        {
                addLexema("identificador",yytext(), yyline, yychar);
                return new Symbol(sym.id,yychar, yyline, yytext().substring(1,yytext().length()-1));
        }   
    {numero}
        {
                addLexema("numerico",yytext(), yyline, yychar);
                return new Symbol(sym.numero,yychar, yyline, yytext());
        }                 
    {cadenaComillas}
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.cadena,yychar, yyline, yytext().substring(1,yytext().length()-1));
        }                                         
    .		
    {
            System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
            adderror(yyline, yychar, yytext());
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
                return new Symbol(sym.cadena, yychar, yyline+1, cadena);            
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
        /*Imprimir(yytext());*/
    }     
    "importar" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            return  new Symbol(sym.timportar, yychar, yyline, yytext());
        }  
    "contenedor" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.contenedor, yychar, yyline, yytext());
        }  
    "ventana" 
        {
            addLexema("reservada", yytext(), yyline, yychar);            
            return  new Symbol(sym.tventana, yychar, yyline, yytext());
        }       
    "texto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);  
            return  new Symbol(sym.ttexto, yychar, yyline, yytext());
        }   
    "dato" 
        {
            addLexema("reservada", yytext(), yyline, yychar);      
            return  new Symbol(sym.dato, yychar, yyline, yytext());
        }  
    "defecto" 
        {
            addLexema("reservada", yytext(), yyline, yychar);                         
            return  new Symbol(sym.defecto, yychar, yyline, yytext());
        } 
    "<" {
            addLexema("simbolo", yytext(), yyline, yychar);
            finalizarCadena();            
            return  new Symbol(sym.menorque, yychar, yyline, yytext());
        }        
    ">" {
            addLexema("simbolo", yytext(), yyline, yychar);      
            yybegin(YYINITIAL);
            return  new Symbol(sym.mayorque, yychar, yyline, yytext());
        } 
    "/" {
            addLexema("simbolo", yytext(), yyline, yychar);  
            return  new Symbol(sym.slash, yychar, yyline, yytext());
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
    [^#$]
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
    [^#$]    
    {
        //Imprimir(yytext());
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

