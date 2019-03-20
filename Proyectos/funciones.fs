suma(10*5,30);
suma(10,30);
imprimir("-------------------");
imprimir(fibonaci(15));
imprimir("-------------------");
var contador = 2 ;
contador++;
contador--;
imprimir(contador);
imprimir(verdadero ^ 1.2 + "=1.0");
imprimir(4.5 ^ verdadero +"= 1.0");

imprimir(4 ^ verdadero +"= 4");
imprimir(4 ^ falso  +" = 1");


var x = 4*9-5+1+(3*7/8)*10-22/5^3; // Esta operacion da por resultado 32
var y = x*2.05;
var z = -5;
imprimir("z = " + z);

var flag = falso || verdadero && falso;
var mensaje = "El valor de la variables es ... ";
imprimir("El valor de x es " + x);
imprimir("El valor de x++ es " + x++);
imprimir("El valor de x es " + x);
imprimir("----------------------------------");
imprimir("El valor de y es " + y);
imprimir("El valor de y-- es " + y--);
imprimir("El valor de y es " + y++);
imprimir("----------------------------------");
imprimir("El valor de z es " + z);
imprimir("sumatoria x+y+z = " + (x+y));
imprimir("El valor de flag es " + flag);
/*
En la siguiente parte de codigo, se imprimirá "veradero" si flag es falso.
*/
si(!!!flag)
{
	imprimir /*hola perros*/("Verdaderos " + x + " resultado " +flag );
}
contador += " Es el resultado";
imprimir(contador);
contador += " puta madre";
imprimir(contador);

var comparacion = "holb" >= "holb" ;
imprimir( comparacion);

var flag2 = verdadero ==  !falso && !comparacion || 5>9;
imprimir( !!(4 > 3) );

var uno, dos, tres = 0; 
Var cad = "hola";


imprimir("uno   x"+dos);
Var ar = [1, verdadero, "cadena", 5]; //arreglo heterogéneo con tres elementos de tipos
ar[3] = 88;
ar[3]++;
imprimir ("ar[0] "+ (ar[0] * 100)  );
while(verdadero){ imprimir("ar[3] ==" + (ar[3]+ar[0]));  imprimir(ar[0]*6.6); detener;}

var nombre1 = "erick";
var nombre2 = "erick";
si(nombre1 == nombre2)
{
	imprimir("nombre iguales " + nombre1);
}
sino 
{
	imprimir("nombre diferentes " + nombre1);
}

Var miobjeto = { curso: "compi2", Oportunidad:"7", Aprobado: "falso", carnet : 201213050, estado : verdadero };


imprimir("Miobjeto "+ ( miobjeto.carnet --  ));
imprimir("Miobjeto "+ ( miobjeto.carnet --  ));
imprimir("Miobjeto "+ ( miobjeto.carnet --  ));
imprimir("Miobjeto "+ ( miobjeto.carnet --  ));

si(miobjeto.estado)
{
    imprimir("El curso " + miobjeto.curso + " ha sido aprobado");
}
sino
{
	imprimir("El curso " + miobjeto.curso + " no ha sido aprobado");
}

var vvv = 0;
var enterito = vvv==1? 12: 69;

imprimir("Enterito " + enterito);


var s=1;
imprimir(s +"-------------------------------");
selecciona (s)
{
    caso 1: 
    {
        imprimir("caso 1");
        //detener;
    }
    caso 2: 
    {
        imprimir("caso 2");
        s = 10;
        
    }    
    caso verdadero: 
    {
    	   imprimir(13);
    	   s += 10;
    	   detener;
    }
    defecto:
    {
    		imprimir("caso defecto");
    }
}
imprimir(s);

funcion suma(var x, var y)
{
	imprimir("funcion suma");
	imprimir(x+y);
	
}

funcion factorial(var n) {
    //imprimir("Factorial ... " + n);
    retornar n == 0 ? 1 : n * factorial(n - 1);
    //retornar n*10;
}


funcion fibonaci(var n){
    retornar(n==1 || n==2) ? 1 : fibonaci(n-1) + fibonaci(n-2);
    imprimir("metodo fibonacci");
    imprimir("putas");
} 


funcion potencia(var base, var exp) {
    retornar exp == 0 ? 1 : (base * potencia(base, exp - 1));
}

funcion factorial(var n) {
    retornar n == 0 ? 1 : n * factorial(n - 1);
}

funcion invertirNumero (var n){
    retornar n < 10 ? n : modulo(n, 10) + invertirNumero (n / 10) * 10;
}

funcion modulo(var n, var p){
    retornar n < p ? n : modulo( n - p, p);
}

funcion sacar_mcd(var a, var b) {
    retornar b == 0 ? a : sacar_mcd(b, modulo(a , b));
}

funcion fibonaci(var n){
    retornar (n==1 || n==2) ? 1 : fibonaci(n-1) + fibonaci(n-2);
} 

funcion VerPotencia(var num, var pot){
    Imprimir("La potencia de " + num + " a la " + pot + " es " + potencia(num, pot));
}

funcion VerFactorial(var num){
    Imprimir("El factorial de " + num + " es " + Factorial(num));
}

funcion VerInvertido(var num){
    Imprimir("El numero invertido de " + num + " es " + invertirNumero(num));
}

funcion VerMCD(var num, var p){
    Imprimir("El numero MCD de " + num + "a la " + p + " es " + sacar_mcd(num, p));
}

funcion VerFibonacci(var num){
    Imprimir("El Fibonacci de " + num + " es " + Fibonaci(num));
}

funcion Paisaje(var clasificacion){
	Selecciona(clasificacion / 10){
		caso 1: {
			Imprimir("Playa al ");
		}
		caso 2: {
			Imprimir("Luna ");
		}
		caso 3: {
			Imprimir("Selva de ");
		}
		caso 4: {
			Imprimir("Desierto de ");
		}
		caso 5: {
			Imprimir("Oceano ");
		}
		caso 1: {
			Imprimir("atardecer");
			detener;
			Imprimir("No debio haber impreso esto");
		}
		caso 2: {
			Imprimir("llena");
			detener;
			Imprimir("No debio haber impreso esto");
		}
		caso 3: {
			Imprimir("noche");
			detener;
			Imprimir("No debio haber impreso esto");
		}
		caso 4: {
			Imprimir("Dia");
			detener;
			Imprimir("No debio haber impreso esto");
		}
		caso 5: {
			Imprimir("Azul");
			detener;
			Imprimir("No debio haber impreso esto");
		}
		caso 1: {
			Imprimir("ERROR!!!!!");
		}
		caso 2: {
			Imprimir("ERROR!!!!!");
		}
		caso 3: {
			Imprimir("ERROR!!!!!");
		}
		caso 4: {
			Imprimir("ERROR!!!!!");
		}
		caso 5: {
			Imprimir("ERROR!!!!!");
		}
		defecto:{
			Imprimir("No debio haber entrado al defecto");
		}
	}
}
Paisaje(20);