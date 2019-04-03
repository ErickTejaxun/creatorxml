var ar = [5,6,2,4,992,0, 10,100];
//var ar = ["Banana", "Orange", "Apple", "Mango"];
ar.invertir().invertir().invertir().invertir().invertir();
ar.ascendente().invertir().invertir().invertir().invertir();

var c= 0;
while(c < 8 )
{
	imprimir(ar[c]);
	c++;	
}
imprimir("El maximo es "  + ar.maximo());
imprimir("El minimo es "  + ar.minimo());
var objeto = 
{
	nombrE: "Erick",
	Apellido:"Tejaxun"
};

var enterito = objeto.nombre=="erick" ? 12: 69;
imprimir(enterito);
/*
ar.ascendente();
c=0;
while(c < 7 )
{
	imprimir(ar[c]);
	c++;	
}*/