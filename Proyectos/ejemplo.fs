imprimir("Fibonnaci(10) " + fibonaci(10) +"---"+ fibonaci2(10) );
imprimir("factorial(6) " + factorial(6));
var val = {a:3, b:11};
var arr = [1,3, val.a,val.b, val];
imprimir("ackerman("+arr[2]+","+arr[4].b+") = " + ackermann(val.a,arr[4].b));

funcion fibonaci(var n){
    si(n == 1 || n==2 )
    {
    		retornar 1;
    }
    sino
    {
    		retornar fibonaci(n-1) + fibonaci(n-2);
    }
}

funcion factorial(var n) {
    retornar n == 0 ? 1 : n * factorial(n - 1);
}

funcion fibonaci2(var n){
    retornar (n==1 || n==2) ? 1 : fibonaci2(n-1) + fibonaci2(n-2);
} 

funcion ackermann(var m, var n) {
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