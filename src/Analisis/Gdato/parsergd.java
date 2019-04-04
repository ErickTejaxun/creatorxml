
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analisis.Gdato;

import Analisis.Fs.AST.Simbolo;
import java_cup.runtime.*;
import Recursos.*;
import java.util.ArrayList;
import java.util.LinkedList;
import Analisis.XML.AST.*;
import java.util.Hashtable;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parsergd extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parsergd() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parsergd(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parsergd(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\004\000\002\002\012\000\002\005" +
    "\004\000\002\005\003\000\002\003\012\000\002\004\013" +
    "\000\002\004\012\000\002\006\003\000\002\006\003\000" +
    "\002\006\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\004\004\004\001\002\000\004\010\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\005\010\001\002\000\004\004\012\001\002\000" +
    "\004\004\045\001\002\000\004\007\014\001\002\000\004" +
    "\004\ufffe\001\002\000\004\005\015\001\002\000\004\004" +
    "\017\001\002\000\004\004\032\001\002\000\004\011\020" +
    "\001\002\000\004\005\021\001\002\000\010\012\024\013" +
    "\022\014\023\001\002\000\004\004\ufff8\001\002\000\004" +
    "\004\ufff9\001\002\000\004\004\ufffa\001\002\000\004\004" +
    "\026\001\002\000\004\006\027\001\002\000\004\011\030" +
    "\001\002\000\004\005\031\001\002\000\004\004\ufffb\001" +
    "\002\000\006\006\033\011\034\001\002\000\004\007\043" +
    "\001\002\000\004\005\035\001\002\000\010\012\024\013" +
    "\022\014\023\001\002\000\004\004\037\001\002\000\004" +
    "\006\040\001\002\000\004\011\041\001\002\000\004\005" +
    "\042\001\002\000\004\004\ufffc\001\002\000\004\005\044" +
    "\001\002\000\004\004\ufffd\001\002\000\006\006\047\007" +
    "\014\001\002\000\004\004\uffff\001\002\000\004\010\050" +
    "\001\002\000\004\005\051\001\002\000\004\002\000\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\003\012\005\010\001\001\000\004\003\045\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\004\015\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\024\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\035\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parsergd$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parsergd$actions(this);
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
    return action_obj.CUP$parsergd$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


      
    //public ArrayList<NodoXML> lista = new ArrayList<NodoXML>();
    public ArrayList<error> listaErrores = new ArrayList<error>();
    public ArrayList<Simbolo> listaDatos = new ArrayList<Simbolo>();

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
        singlenton.addErrores(a);    

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
class CUP$parsergd$actions {
  private final parsergd parser;

  /** Constructor */
  CUP$parsergd$actions(parsergd parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parsergd$do_action_part00000000(
    int                        CUP$parsergd$act_num,
    java_cup.runtime.lr_parser CUP$parsergd$parser,
    java.util.Stack            CUP$parsergd$stack,
    int                        CUP$parsergd$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parsergd$result;

      /* select the action based on the action number */
      switch (CUP$parsergd$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).value;
		RESULT = start_val;
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parsergd$parser.done_parsing();
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= menorque lista mayorque LREGISTRO menorque slash lista mayorque 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).right;
		ArrayList<Simbolo> l = (ArrayList<Simbolo>)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).value;
		            
            listaDatos = l;
        
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-7)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LREGISTRO ::= LREGISTRO REGISTRO 
            {
              ArrayList<Simbolo> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).right;
		ArrayList<Simbolo> l = (ArrayList<Simbolo>)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).right;
		Simbolo r = (Simbolo)((java_cup.runtime.Symbol) CUP$parsergd$stack.peek()).value;
		 
            l.add(r); 
            RESULT = l;
        
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("LREGISTRO",3, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LREGISTRO ::= REGISTRO 
            {
              ArrayList<Simbolo> RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).right;
		Simbolo r = (Simbolo)((java_cup.runtime.Symbol) CUP$parsergd$stack.peek()).value;
		 
            ArrayList<Simbolo> l = new ArrayList<Simbolo>(); 
            l.add(r); 
            RESULT = l;
        
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("LREGISTRO",3, ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // REGISTRO ::= menorque principal mayorque LATRIBUTO menorque slash principal mayorque 
            {
              Simbolo RESULT =null;
		int atributosleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).left;
		int atributosright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).right;
		Hashtable<String,Object> atributos = (Hashtable<String,Object>)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).value;
		
            Simbolo sim = new Simbolo();
            sim.id = atributos.toString();
            sim.valor = atributos;
            sim.tipo = "objeto";
            RESULT = sim;
        
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("REGISTRO",1, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-7)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // LATRIBUTO ::= LATRIBUTO menorque id mayorque VALOR menorque slash id mayorque 
            {
              Hashtable<String,Object> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-8)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-8)).right;
		Hashtable<String,Object> l = (Hashtable<String,Object>)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-8)).value;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).right;
		Object valor = (Object)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).value;
		int nombre2left = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).left;
		int nombre2right = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).right;
		String nombre2 = (String)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).value;
		
                l.put(nombre,valor);
                RESULT = l;
            
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("LATRIBUTO",2, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-8)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // LATRIBUTO ::= menorque id mayorque VALOR menorque slash id mayorque 
            {
              Hashtable<String,Object> RESULT =null;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-6)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).right;
		Object valor = (Object)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-4)).value;
		int nombre2left = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).left;
		int nombre2right = ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).right;
		String nombre2 = (String)((java_cup.runtime.Symbol) CUP$parsergd$stack.elementAt(CUP$parsergd$top-1)).value;
		
                Hashtable<String, Object> l = new Hashtable<String, Object>();
                l.put(nombre, valor);
                RESULT = l;
            
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("LATRIBUTO",2, ((java_cup.runtime.Symbol)CUP$parsergd$stack.elementAt(CUP$parsergd$top-7)), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // VALOR ::= cadena 
            {
              Object RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parsergd$stack.peek()).value;
		RESULT = valor;
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("VALOR",4, ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // VALOR ::= numero 
            {
              Object RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).right;
		Integer valor = (Integer)((java_cup.runtime.Symbol) CUP$parsergd$stack.peek()).value;
		RESULT = valor;
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("VALOR",4, ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // VALOR ::= decimal 
            {
              Object RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()).right;
		Double valor = (Double)((java_cup.runtime.Symbol) CUP$parsergd$stack.peek()).value;
		RESULT = valor;
              CUP$parsergd$result = parser.getSymbolFactory().newSymbol("VALOR",4, ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), ((java_cup.runtime.Symbol)CUP$parsergd$stack.peek()), RESULT);
            }
          return CUP$parsergd$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parsergd$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parsergd$do_action(
    int                        CUP$parsergd$act_num,
    java_cup.runtime.lr_parser CUP$parsergd$parser,
    java.util.Stack            CUP$parsergd$stack,
    int                        CUP$parsergd$top)
    throws java.lang.Exception
    {
              return CUP$parsergd$do_action_part00000000(
                               CUP$parsergd$act_num,
                               CUP$parsergd$parser,
                               CUP$parsergd$stack,
                               CUP$parsergd$top);
    }
}

}
