/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Fs.AST;

/**
 *
 * @author erick
 */
public class Or extends Exp
{
    public Exp left;
    public Exp right;
    
    public Or(Exp val1, Exp val2)
    {
        this.left = val1;
        this.right = val2;
    }

    public void setValor(Entorno entorno)
    {
        Object val1 = this.left.ejecutar(entorno).valor;
        Object val2 = this.right.ejecutar(entorno).valor;

        
        if((val1 instanceof Boolean) && (val2 instanceof Boolean))
        {
            Boolean v1 = (Boolean)val1;
            Boolean v2 = (Boolean)val2;            
            this.valor = v1 || v2;
        }        
    }
    
    
    @Override
    public Nodo generar3D(Entorno entorno) 
    {
        int tipo = 0;
        if(left instanceof Suma)
        {
            tipo = 1;
        }
        if(left instanceof Menos)
        {
            tipo = 1;
        }  
        if(left instanceof Multi)
        {
            tipo = 1;
        }
        if(left instanceof Div)
        {
            tipo = 1;
        }  
                
        left.lv = this.lv;
        left.lf = entorno.ventana.generarEtiqueta();        
        Exp l = (Exp) left.generar3D(entorno);
        entorno.ventana.add3d(l.lf+":");        
        right.lv = this.lv;
        right.lf = this.lf;
        Exp r = (Exp)right.generar3D(entorno);        
        entorno.ventana.add3d(r.lv+":");  
        return this;
    }    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        valor = "";
        setValor(entorno);
        return this;
    }


    
}
