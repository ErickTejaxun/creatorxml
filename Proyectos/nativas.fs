var ar = [5,6,2,4,992,0,- 11, -10, 222, 10,100];


var data = crearArrayDesdeArchivo("data.gdato");
var data2 = ar.descendente().descendente().ascendente().descendente();
data2.ascendente();
var c= 0;
while(c < 11)
{
	imprimir(data2[c]);
	c++;	
}
imprimir("El maximo es "  + ar.maximo());
imprimir("El minimo es "  + ar.minimo());

c= 0;
data.descendente();

var ages = [32, 33, 16, 40];
var lista =  ages.filtrar(checkAdult);
while(c < 4 )
{
	//imprimir(c+")" + data[c].ctnombre );
	imprimir(c+")" + lista[c]);
	c++;	
}

funcion checkAdult( var age) 
{ 
	retornar age >= 33; 
}