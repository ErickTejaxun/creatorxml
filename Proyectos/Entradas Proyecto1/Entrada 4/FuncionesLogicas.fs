funcion Hanoi(var discos, var origen, var auxiliar, var destino) {
    si (discos == 1) {
        imprimir("mover disco de " + origen + " a " + destino);
    } sino {
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
    var ta=par(a);
    var b="El numero " + ta + " es: ";
    var c= par(a) == 1 ? "Par" : "Impar";
    var d=b+c;
    imprimir(d);
}

funcion VerImpar(var b){
    var a=impar(b);
    var tb="El numero " + b + " es: ";
    var c=a == 0 ? "Par" : "Impar";
    var d=tb+c;
    imprimir(d);
}