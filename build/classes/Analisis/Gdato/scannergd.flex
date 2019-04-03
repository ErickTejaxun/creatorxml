package Analisis.Gdato;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import Recursos.singlenton;
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
        Imprimir(valor +"\t"+ tipo);
        listaLexemas.add(new lexema(tipo, valor, linea, columna));	            
    } 

    public void Imprimir(String cadena)
    {
        System.out.println(cadena);
    }   

    

%}
%class scannergd /*Nombre de la clase a generar.%cupsym simbolos*/
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
    "<"
        {
                
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.menorque,yychar, yyline, yytext());
        }                                         
    "/"
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.slash,yychar, yyline, yytext());
        } 
    ">"
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.mayorque,yychar, yyline, yytext());
        } 
    "principal"
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.principal,yychar, yyline, yytext());
        }  
    "lista"
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.lista,yychar, yyline, yytext());
        }  
    {cadenaComillas}                                                                                   
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.cadena,yychar, yyline, yytext().substring(1,yytext().length()-1));
        }     
    {id}                                                                                   
        {
                addLexema("cadena",yytext(), yyline, yychar);
                return new Symbol(sym.id,yychar, yyline, yytext().toLowerCase());
        }                                     
    .		
    {
            System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
            adderror(yyline, yychar, yytext().toLowerCase());
    }

}
