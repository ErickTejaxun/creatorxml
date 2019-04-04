funcion Hanoi(var discos, var origen, var auxiliar, var destino) {
    //Imprimir("discos :"+discos +" origen:"+origen +" auxiliar:"+auxiliar+" destino:"+destino);
    
    si (discos == 1)     
    {
        imprimir("mover disco de " + origen + " a " + destino);
    } 
    sino 
    {
        Hanoi(discos - 1, origen, destino, auxiliar);
        imprimir("mover disco de " + origen + " a " + destino);
        Hanoi(discos - 1, auxiliar, origen, destino);
    }
}



funcion hofstaderFemenina(var n) {
    si (n < 0) {
        retornar 0;
    } sino {
        retornar (n == 0) ? 1 : n - hofstaderFemenina(n - 1);
    }
}

funcion hofstaderMasculino(var n) {
    si (n < 0) {
        retornar 0;
    } sino {
        retornar n == 0 ? 0 : n - hofstaderMasculino(n - 1);
    }
}

funcion par(var nump) {    
    si (nump == 0) {
        retornar 1;
    }
    retornar impar(nump - 1);
}

funcion impar(var numi) {
    si (numi == 0) {
        retornar 0;
    }
    retornar par(numi - 1);
}

funcion VerFemenina(){
    imprimir(hofstaderFemenina(10));
}

funcion VerMasculino(){
    imprimir(hofstaderMasculino(10));
}

funcion VerPar(var a){
    imprimir("El numero " + a + " es: " + (par(a) == 1 ? "Par" : "Impar"));
}

funcion VerImpar(var b)
{
    imprimir("El numero " + b + " es: " + (impar(b) == 0 ? "Par" : "Impar"));
}

funcion ackermann(var m, var n) {
    si (m == 0) {
    	   //Imprimir("Retornando n+1" + (n+1));
        retornar (n + 1);
    } sino si (m > 0 && n == 0) {
        retornar ackermann(m - 1, 1);
    } sino {
        retornar ackermann(m - 1, ackermann(m, n - 1));
    }
}

funcion entero(var valor)
{
	si(valor >10)
	{
		retornar 1+ entero(valor-1);
	}
	sino
	{
		retornar 1 ;
	}
}

funcion factorial(var n) {
    retornar n == 0 ? 1 : n * factorial(n - 1);
}

funcion factorial1(var n) 
{
	imprimir(n);
	si(n==0)
	{
		retornar 1;
	}
	sino
	{
		retornar  n * factorial1(n - 1);
	}
	   
}

funcion decision(var v)
{
	si(v ==1 )
	{
		retornar 1;		
	}
	sino 
	{
	     si(v ==2)
	     {
	     	retornar v * decision(v-1);
	     }
	     sino 
	     {
	        si (v==3)
	        {
	        	 retornar v * decision(v-1);
	        }
	        sino 
	        {
	           si (v==4)
	           {
	           	retornar v * decision(v-1);
	           }
	           sino
	           {
	              retornar v *decision(v-1);
	           }
	        }
	     }
	}
}

imprimir(decision(12));
imprimir(factorial(5));
imprimir("Erick");
VerImpar(20);
vermasculino();
verfemenina();

hanoi(3,1,2,3);

imprimir(ackermann(3,1));

     