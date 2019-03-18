package Analisis.Fs;
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
%class scannerfs /*Nombre de la clase a generar.%cupsym simbolos*/
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

espacio = \t|\f|" "|\r    // ER para capturar espacios, salto de línea, tabulaciones.
numero = ([0-9][0-9]*)       // ER para capturar números.
decimal= {numero}"."{numero} // Expresión 
letra = ([a-zA-Z]|"ñ"|"á"|"é"|"í"|"ó"|"ú")
InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n
id = (({letra}|"_")({letra}|{numero}|"_")*)
cadenaComillas = (("\"" [^] ~"\"") | ("\“" [^] ~"\”"))
cadComillaSimple = ("'" [^] ~"'")
comentario = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"
si = "si"
sino = "sino"
sinosi = (sino){comentario}{si}
%state comentarioSimple, comentarioMulti

%%
<YYINITIAL>
{
    [\n] { yychar=0;}
    {espacio}
    {
        //Imprimir("Salto de linea");
    }
    {comentario} 
    {
        Imprimir(yytext());
    }
    "++"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.aumento, yychar, yyline, yytext());
            } 
    "--"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.decremento, yychar, yyline, yytext());
            }

    "+"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.suma, yychar, yyline, yytext());
            }
    "-"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.resta, yychar, yyline, yytext());
            }

    "*"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.multi, yychar, yyline, yytext());
            }      
    "^"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.potencia, yychar, yyline, yytext());
            }                  
    "/"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.div, yychar, yyline, yytext());
            }
    "||"   {
                addLexema("|reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.or, yychar, yyline, yytext());
            }           
    "&&"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.and, yychar, yyline, yytext());
            }
    "!="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.desigual, yychar, yyline, yytext());
            }           
    "=="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.igualigual, yychar, yyline, yytext());
            }           
    "="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.igual, yychar, yyline, yytext());
            }           
    ">"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.mayor, yychar, yyline, yytext());
            }           
    "<"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.menor, yychar, yyline, yytext());
            } 
    ">="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.mayorigual, yychar, yyline, yytext());
            }   
    "<="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.menorigual, yychar, yyline, yytext());
            }  
    "+="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.masigual, yychar, yyline, yytext());
            } 
    "-="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.menosigual, yychar, yyline, yytext());
            }   
    "*="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.multiigual, yychar, yyline, yytext());
            }       
    "/="   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.divigual, yychar, yyline, yytext());
            }                                                                                            
    "("   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.pari, yychar, yyline, yytext());
            }            
    ")"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.pard, yychar, yyline, yytext());
            } 
    "["   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.corchetei, yychar, yyline, yytext());
            }                
    "]"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.corcheted, yychar, yyline, yytext());
            }                            
    "!"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.exclam, yychar, yyline, yytext());
            } 
    ","   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.coma, yychar, yyline, yytext());
            }             
    "var"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.var, yychar, yyline, yytext());
            } 
    "nulo"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.nulo, yychar, yyline, yytext());
            }                                           

    "break"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.tbreak, yychar, yyline, yytext());
            }
    "continue"   {
                addLexema("reservada", yytext(), yyline, yychar);            
                return  new Symbol(sym.tcontinuar, yychar, yyline, yytext());
            }                             
    {si}  {
                addLexema("reservada", yytext(), yyline, yychar);
                return  new Symbol(sym.si, yychar, yyline, yytext());
                }  
    /*{sinosi}  {
                addLexema("reservada", yytext(), yyline, yychar);
                return  new Symbol(sym.sinosi, yychar, yyline, yytext());
                }*/ 
    {sino}  {
                addLexema("reservada", yytext(), yyline, yychar);
                return  new Symbol(sym.sino, yychar, yyline, yytext());
                } 
    ";"     {  
                addLexema("simbolo", yytext(), yyline, yychar);  	        
                return new Symbol(sym.puntocoma, yychar, yyline, yytext());             
            } 

    "falso"  {  
                addLexema("false", yytext(), yyline, yychar);  	        
                return new Symbol(sym.falso, yychar, yyline, false);             
            } 

    "verdadero"  {  
                addLexema("true", yytext(), yyline, yychar);  	        
                return new Symbol(sym.verdadero, yychar, yyline, true);             
            }         
    "imprimir"  {  
                addLexema("reservada", yytext(), yyline, yychar);  	        
                return new Symbol(sym.imprimir, yychar, yyline, yytext());             
            } 
    "while"  {  
                addLexema("reservada", yytext(), yyline, yychar);  	        
                return new Symbol(sym.mientras, yychar, yyline, yytext());             
            }                    
    "for"  {  
                addLexema("reservada", yytext(), yyline, yychar);  	        
                return new Symbol(sym.para, yychar, yyline, yytext());             
            }              
    "switch"  {  
                addLexema("reservada", yytext(), yyline, yychar);  	        
                return new Symbol(sym.seleccion, yychar, yyline, yytext());             
            }            
    "case"  {  
                addLexema("reservada", yytext(), yyline, yychar);  	        
                return new Symbol(sym.caso, yychar, yyline, yytext());             
            }            
    "{"  {  
                addLexema("simbolo", yytext(), yyline, yychar);  	        
                return new Symbol(sym.llaveI, yychar, yyline, yytext());             
            }           
    "}"  {  
                addLexema("simbolo", yytext(), yyline, yychar);  	        
                return new Symbol(sym.llaveD, yychar, yyline, yytext());             
            }   
    ":"  {  
                addLexema("simbolo", yytext(), yyline, yychar);  	        
                return new Symbol(sym.dospuntos, yychar, yyline, yytext());             
            }   

    {id}  {  
                
                addLexema("Identificador", yytext(), yyline, yychar);  	        
                return new Symbol(sym.identificador, yychar, yyline, yytext().toLowerCase());             
            }   
    {decimal}  {  
                
                addLexema("Decimal", yytext(), yyline, yychar);  	        
                return new Symbol(sym.decimal, yychar, yyline, Double.parseDouble(yytext()));             
            }  
    {numero}  {  
                
                addLexema("Entero", yytext(), yyline, yychar);  	        
                return new Symbol(sym.entero, yychar, yyline, Integer.parseInt(yytext()));             
            }   
    {cadenaComillas}  
            {  
                
                addLexema("Cadena", yytext(), yyline, yychar);  	        
                return new Symbol(sym.cadena, yychar, yyline, yytext().substring(1, yytext().length()-1));             
            }   
    {cadComillaSimple}  
            {  
                
                addLexema("caracter", yytext(), yyline, yychar);  	        
                return new Symbol(sym.cadena, yychar, yyline, yytext().substring(1, yytext().length()-1));             
            }                    
    .			
                {
                    System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
                    adderror(yyline, yychar, yytext());
                }
}

		
