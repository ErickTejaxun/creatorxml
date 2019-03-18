imprimir(verdadero ^ 1.2 + "=1.0");
imprimir(4.5 ^ verdadero +"= 1.0");

imprimir(4 ^ verdadero +"= 4");
imprimir(4 ^ falso  +" = 1");


var x = 4*9-5+1+(3*7/8)*10-22/5^3; // Esta operacion da por resultado 32
var y = x*2.05;
var z = -5;
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
//imprimir("El valor de 5-- es " + 5--);
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
var contador = 2 ;
contador += " Es el resultado";
contador += " , terminado " + " plus";
contador = -(43*3);
contador = - contador;
imprimir(contador);

var comparacion = "holb" >= "holb" ;
imprimir( comparacion);

var flag2 = verdadero ==  !falso && !comparacion || 5>9;
imprimir( !!(4 > 3) );

var uno, dos, tres = 0; 
Var cad = "hola";


imprimir("uno   x"+dos);
Var ar = [1, verdadero, "cadena", 5+2+3*9]; //arreglo heterogéneo con tres elementos de tipos
imprimir (ar[0] + " ar[0]");
while(verdadero){ imprimir(ar[2]); break;}