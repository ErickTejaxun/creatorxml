funcion fibonaci(var n){
    retornar (n==1 || n==2) ? 1 : fibonaci(n-1) + fibonaci(n-2);
} 
funcion factorial(var n) {
    retornar n == 0 ? 1 : n * factorial(n - 1);
}
var contador = 0;
imprimir(ackermann(3,2));
imprimir("Iteraciones " +contador);
funcion ackermann(var m, var n) {
	//imprimir("ackerman("+m+","+n+")");
	contador++;
    si (m == 0)
    {    	   
        retornar (n + 1);
    } 
    sino si (m > 0 && n == 0) 
    {
        retornar ackermann(m - 1, 1);
    } sino 
    {
        retornar ackermann(m - 1, ackermann(m, n - 1));
    }
}


funcion estado(var a)
{
  si (a == 10)
  {
    retornar 100;
  }
  sino
  {
  	retornar 666;
  }
  
  
}

/**/
imprimir(fibonaci(10));
imprimir(factorial(6));
imprimir(estado(1));