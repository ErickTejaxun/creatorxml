funcion fibonaci(var n){
    retornar (n==1 || n==2) ? 1 : fibonaci(n-1) + fibonaci(n-2);
} 

funcion factorial(var n) {
    retornar n == 0 ? 1 : n * factorial(n - 1);
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

imprimir(fibonaci(10));
imprimir(factorial(6));
imprimir(ackermann(1,1));