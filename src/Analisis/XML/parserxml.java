
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analisis.XML;

import java_cup.runtime.*;
import Recursos.*;
import java.util.ArrayList;
import java.util.LinkedList;
import Analisis.XML.AST.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parserxml extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parserxml() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parserxml(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parserxml(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\004\000\002\002\003\000\002\002" +
    "\004\000\002\002\004\000\002\002\004\000\002\007\004" +
    "\000\002\007\003\000\002\010\012\000\002\011\013\000" +
    "\002\011\012\000\002\012\006\000\002\012\006\000\002" +
    "\012\006\000\002\012\006\000\002\012\006\000\002\012" +
    "\006\000\002\012\006\000\002\012\005\000\002\012\005" +
    "\000\002\012\005\000\002\012\005\000\002\012\005\000" +
    "\002\012\005\000\002\012\005\000\002\006\004\000\002" +
    "\006\003\000\002\006\003\000\002\005\011" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\126\000\006\003\005\004\007\001\002\000\004\002" +
    "\000\001\002\000\004\004\130\001\002\000\006\003\ufffb" +
    "\004\ufffb\001\002\000\006\014\017\017\016\001\002\000" +
    "\004\002\015\001\002\000\006\003\013\004\007\001\002" +
    "\000\004\002\uffff\001\002\000\004\002\ufffd\001\002\000" +
    "\006\003\ufffc\004\ufffc\001\002\000\004\002\001\001\002" +
    "\000\022\005\026\012\027\013\031\015\034\016\030\022" +
    "\036\050\035\052\032\001\002\000\004\005\020\001\002" +
    "\000\004\055\021\001\002\000\004\004\022\001\002\000" +
    "\004\006\023\001\002\000\004\014\024\001\002\000\004" +
    "\005\025\001\002\000\006\003\ufffa\004\ufffa\001\002\000" +
    "\006\003\057\004\062\001\002\000\004\007\120\001\002" +
    "\000\004\007\116\001\002\000\004\007\114\001\002\000" +
    "\004\007\112\001\002\000\022\005\053\012\052\013\051" +
    "\015\054\016\045\022\046\050\050\052\047\001\002\000" +
    "\004\007\043\001\002\000\004\007\041\001\002\000\004" +
    "\007\037\001\002\000\004\057\040\001\002\000\022\005" +
    "\uffea\012\uffea\013\uffea\015\uffea\016\uffea\022\uffea\050\uffea" +
    "\052\uffea\001\002\000\004\057\042\001\002\000\022\005" +
    "\uffeb\012\uffeb\013\uffeb\015\uffeb\016\uffeb\022\uffeb\050\uffeb" +
    "\052\uffeb\001\002\000\004\055\044\001\002\000\022\005" +
    "\uffee\012\uffee\013\uffee\015\uffee\016\uffee\022\uffee\050\uffee" +
    "\052\uffee\001\002\000\004\007\110\001\002\000\004\007" +
    "\106\001\002\000\004\007\104\001\002\000\004\007\102" +
    "\001\002\000\004\007\100\001\002\000\004\007\076\001" +
    "\002\000\006\003\057\004\062\001\002\000\004\007\055" +
    "\001\002\000\004\055\056\001\002\000\022\005\ufff5\012" +
    "\ufff5\013\ufff5\015\ufff5\016\ufff5\022\ufff5\050\ufff5\052\ufff5" +
    "\001\002\000\004\004\uffe7\001\002\000\004\004\uffe8\001" +
    "\002\000\004\004\072\001\002\000\004\026\063\001\002" +
    "\000\004\005\064\001\002\000\004\004\065\001\002\000" +
    "\004\006\066\001\002\000\004\026\067\001\002\000\004" +
    "\005\070\001\002\000\004\004\uffe6\001\002\000\004\004" +
    "\uffe9\001\002\000\006\006\073\026\063\001\002\000\004" +
    "\017\074\001\002\000\004\005\075\001\002\000\004\002" +
    "\ufff9\001\002\000\004\055\077\001\002\000\022\005\ufff7" +
    "\012\ufff7\013\ufff7\015\ufff7\016\ufff7\022\ufff7\050\ufff7\052" +
    "\ufff7\001\002\000\004\055\101\001\002\000\022\005\ufff6" +
    "\012\ufff6\013\ufff6\015\ufff6\016\ufff6\022\ufff6\050\ufff6\052" +
    "\ufff6\001\002\000\004\057\103\001\002\000\022\005\ufff2" +
    "\012\ufff2\013\ufff2\015\ufff2\016\ufff2\022\ufff2\050\ufff2\052" +
    "\ufff2\001\002\000\004\055\105\001\002\000\022\005\ufff3" +
    "\012\ufff3\013\ufff3\015\ufff3\016\ufff3\022\ufff3\050\ufff3\052" +
    "\ufff3\001\002\000\004\057\107\001\002\000\022\005\ufff1" +
    "\012\ufff1\013\ufff1\015\ufff1\016\ufff1\022\ufff1\050\ufff1\052" +
    "\ufff1\001\002\000\004\055\111\001\002\000\022\005\ufff4" +
    "\012\ufff4\013\ufff4\015\ufff4\016\ufff4\022\ufff4\050\ufff4\052" +
    "\ufff4\001\002\000\004\055\113\001\002\000\022\005\uffec" +
    "\012\uffec\013\uffec\015\uffec\016\uffec\022\uffec\050\uffec\052" +
    "\uffec\001\002\000\004\055\115\001\002\000\022\005\uffef" +
    "\012\uffef\013\uffef\015\uffef\016\uffef\022\uffef\050\uffef\052" +
    "\uffef\001\002\000\004\055\117\001\002\000\022\005\uffed" +
    "\012\uffed\013\uffed\015\uffed\016\uffed\022\uffed\050\uffed\052" +
    "\uffed\001\002\000\004\055\121\001\002\000\022\005\ufff0" +
    "\012\ufff0\013\ufff0\015\ufff0\016\ufff0\022\ufff0\050\ufff0\052" +
    "\ufff0\001\002\000\004\004\123\001\002\000\006\006\124" +
    "\026\063\001\002\000\004\017\125\001\002\000\004\005" +
    "\126\001\002\000\004\002\ufff8\001\002\000\004\002\ufffe" +
    "\001\002\000\004\017\016\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\126\000\012\002\007\007\010\010\005\011\003\001" +
    "\001\000\002\001\001\000\004\011\126\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\013\011\011\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\012\032\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\005\057\006\121\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\005\057\006\060\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\070\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\005\070\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parserxml$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parserxml$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parserxml$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


      
    public ArrayList<NodoXML> lista = new ArrayList<NodoXML>();
    public ArrayList<error> listaErrores = new ArrayList<error>();
    /*
    public void syntax_error(Symbol s)
    {
        System.err.println("El analizador se recupero tras el error\nError en la Línea " + (s.right+1) +" Columna "+(s.left+1)+ ". Identificador "
        +s.value + " no reconocido." );        
        listaErrores.add(new error("Sintactico",s.value.toString(), s.right+1, s.left+1));
    }*/

    /**Metodo al que se llama en el momento en que ya no es posible una recuperación de errores.
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.err.println("El analizador No se recupero tras el error\nError en la Línea " + (s.right+1)+ "Columna "+(s.left+1)+". Identificador " +
        s.value + " no reconocido.");            
    }*/

    public LinkedList<Integer> posibles=new LinkedList();

       /* Reporte de error encontrado. */
    public void report_error(String message, Object info) 
    {
        int linea = 0;
        int columna = 0;
        java_cup.runtime.Symbol s = null;
        StringBuilder m = new StringBuilder("Error Sintactico");

        if (info instanceof java_cup.runtime.Symbol) 
        {
            s = ((java_cup.runtime.Symbol) info);
            if (s.left >= 0) 
            {                
                columna = s.left+1;
                if (s.right >= 0)
                {
                    linea = s.right + 1;
                }                    
            }
        }

        m.append(" Se esperaba: "+message);
        //System.err.println(m.toString());
        //System.out.println("Error");
        //System.out.println("Error linea:"+linea+", col:"+columna);
        LinkedList<String> toks = new LinkedList();

        if(!expected_token_ids().isEmpty())
        {
            Imprimir("No esta vacia "+ expected_token_ids().size());
            error a = new error();
            a.setLinea(linea);
            a.setColumna(columna);
            a.setValor(s.value.toString());
            a.setDescripcion("Sintactico");
            a.setPath("-------");
            for(int w=0; w<expected_token_ids().size(); w++)
            { 
                if(expected_token_ids().get(w) !=sym.error)
                {
                    int tok = (int)expected_token_ids().get(w);                        
                    toks.add( symbol_name_from_id(tok) );
                }
            }
        }

        Imprimir(expected_token_ids().size());

        error a = new error();
        a.setLinea(linea);
        a.setColumna(columna);
        a.setValor(s.value.toString());
        a.setDescripcion("Sintactico");
        a.setPath("----");       
        for(int w=0; w<expected_token_ids().size(); w++)
        { 
            if(expected_token_ids().get(w)!=sym.error)
            {
                int tok = (int)expected_token_ids().get(w);
                toks.add( symbol_name_from_id(tok) );
            }
        }
        String esperados = "";
        for(String id : toks)
        {
            if(!esperados.equals(""))
            {
                esperados += ", ";
            }
            esperados += id;
            
        }
        a.setDescripcion("Se esperaba: " +esperados); 
        a.setTipo("Sintactico");
        Imprimir("Linea: "+linea + "\tColumna: " + columna);
        listaErrores.add(a);    

    }
    
    public String symbol_name_from_id(int id){
        return sym.terminalNames[id];
    }

    public void report_fatal_error(String message, Object info) 
    {        
        report_error(message, info);
        //System.exit(0);
    }  

    public void Imprimir(Object str)  
    {
        System.out.println(str);
    }
    


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parserxml$actions {
  private final parserxml parser;

  /** Constructor */
  CUP$parserxml$actions(parserxml parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parserxml$do_action_part00000000(
    int                        CUP$parserxml$act_num,
    java_cup.runtime.lr_parser CUP$parserxml$parser,
    java.util.Stack            CUP$parserxml$stack,
    int                        CUP$parserxml$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parserxml$result;

      /* select the action based on the action number */
      switch (CUP$parserxml$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).value;
		RESULT = start_val;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parserxml$parser.done_parsing();
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= VENTANA 
            {
              Object RESULT =null;
		int ventleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int ventright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Ventana vent = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		lista.add(vent);
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= LIMPORTAR VENTANA 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).right;
		ArrayList<NodoXML> l = (ArrayList<NodoXML>)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).value;
		int ventleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int ventright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Ventana vent = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		 lista = l; lista.add(vent); 
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INICIO ::= error VENTANA 
            {
              Object RESULT =null;
		int ventleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int ventright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Ventana vent = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		 ArrayList<NodoXML> lista = new ArrayList<NodoXML>();  lista.add(vent); 
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INICIO ::= LIMPORTAR error 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).right;
		ArrayList<NodoXML> l = (ArrayList<NodoXML>)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).value;
		 lista = l; 
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // LIMPORTAR ::= LIMPORTAR IMPORTAR 
            {
              ArrayList<NodoXML> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).right;
		ArrayList<NodoXML> l = (ArrayList<NodoXML>)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Importar i = (Importar)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		 l.add(i); RESULT = l;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("LIMPORTAR",5, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // LIMPORTAR ::= IMPORTAR 
            {
              ArrayList<NodoXML> RESULT =null;
		int impleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int impright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Importar imp = (Importar)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		ArrayList<NodoXML> l = new ArrayList<NodoXML>(); l.add(imp); RESULT = l;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("LIMPORTAR",5, ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // IMPORTAR ::= menorque timportar mayorque cadena menorque slash timportar mayorque 
            {
              Importar RESULT =null;
		int cadleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-4)).left;
		int cadright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-4)).right;
		String cad = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-4)).value;
		RESULT = new Importar(cad, cadleft, cadright);
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("IMPORTAR",6, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-7)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // VENTANA ::= menorque tventana EVENTANA mayorque CONTENIDO menorque slash tventana mayorque 
            {
              Ventana RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-8)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-8)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-8)).value;
		int ventleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).left;
		int ventright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).right;
		Ventana vent = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).value;
		 vent.setLinea(ileft); vent.setColumna(iright); RESULT= vent;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("VENTANA",7, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-8)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // VENTANA ::= menorque tventana mayorque CONTENIDO menorque slash tventana mayorque 
            {
              Ventana RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-7)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-7)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-7)).value;
		 RESULT= new Ventana(ileft, iright);
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("VENTANA",7, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-7)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EVENTANA ::= EVENTANA tid igual cadena 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setId(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EVENTANA ::= EVENTANA ttipo igual cadena 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setTipo(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EVENTANA ::= EVENTANA tcolor igual cadena 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setColor(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EVENTANA ::= EVENTANA tinicial igual cadena 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setAccioninicial(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EVENTANA ::= EVENTANA tfinal igual cadena 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setAccionfinal(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EVENTANA ::= EVENTANA talto igual numero 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setAlto(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EVENTANA ::= EVENTANA tancho igual numero 
            {
              Ventana RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).right;
		Ventana v = (Ventana)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		v.setAncho(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-3)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EVENTANA ::= tid igual cadena 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setId(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EVENTANA ::= ttipo igual cadena 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setTipo(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EVENTANA ::= tcolor igual cadena 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setColor(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EVENTANA ::= tinicial igual cadena 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setAccioninicial(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EVENTANA ::= tfinal igual cadena 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setAccionfinal(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EVENTANA ::= talto igual numero 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setAlto(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EVENTANA ::= tancho igual numero 
            {
              Ventana RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		Ventana v = new Ventana(); v.setAncho(valor); RESULT= v;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("EVENTANA",8, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-2)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // CONTENIDO ::= CONTENIDO CONTENEDOR 
            {
              ArrayList<NodoXML> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).right;
		ArrayList<NodoXML> l = (ArrayList<NodoXML>)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)).value;
		RESULT = l;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("CONTENIDO",4, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-1)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // CONTENIDO ::= CONTENEDOR 
            {
              ArrayList<NodoXML> RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()).right;
		Contenedor c = (Contenedor)((java_cup.runtime.Symbol) CUP$parserxml$stack.peek()).value;
		 ArrayList<NodoXML> l = new ArrayList<NodoXML>(); l.add(c); RESULT = l;
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("CONTENIDO",4, ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // CONTENIDO ::= error 
            {
              ArrayList<NodoXML> RESULT =null;

              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("CONTENIDO",4, ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // CONTENEDOR ::= menorque contenedor mayorque menorque slash contenedor mayorque 
            {
              Contenedor RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)).value;
		 RESULT = new Contenedor(ileft,iright);
              CUP$parserxml$result = parser.getSymbolFactory().newSymbol("CONTENEDOR",3, ((java_cup.runtime.Symbol)CUP$parserxml$stack.elementAt(CUP$parserxml$top-6)), ((java_cup.runtime.Symbol)CUP$parserxml$stack.peek()), RESULT);
            }
          return CUP$parserxml$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parserxml$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parserxml$do_action(
    int                        CUP$parserxml$act_num,
    java_cup.runtime.lr_parser CUP$parserxml$parser,
    java.util.Stack            CUP$parserxml$stack,
    int                        CUP$parserxml$top)
    throws java.lang.Exception
    {
              return CUP$parserxml$do_action_part00000000(
                               CUP$parserxml$act_num,
                               CUP$parserxml$parser,
                               CUP$parserxml$stack,
                               CUP$parserxml$top);
    }
}

}
