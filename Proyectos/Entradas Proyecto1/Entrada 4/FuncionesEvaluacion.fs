Importar("./FuncionesAritmeticas.fs");

Importar("./FuncionesHistoricas.fs");
Importar("./FuncionesIngles.fs");
Importar("./FuncionesLogicas.fs");
Importar("./Reportes.fs");

funcion Bienvenido(){
	Imprimir("Bienvenido a la evaluacion usac, porfavor responda todas las respuestas hasta finalizar, en cada pregunta se les mostrara las respuestas correctas");
}

funcion BienvenidoReporte(){
	Imprimir("Bienvenido al area de reportes, porfavor haga clic en el boton para sacar el reporte deseado");
}

funcion EnviarSinFuncionalidad(){
	Imprimir("Este boton no guarda nada en su gdato, ya que no hay controles");
}
//calculos();
funcion Calculos(){
	Imprimir("1) Potencia con operador ternario");
	VerPotencia(5,5);
	Imprimir("2) Inversion de un numero");
	VerInvertido(12569);
	Imprimir("3) ObtenerMCD");
	VerMCD(240,506);
	Imprimir("4) Factorial");
	VerFactorial(7);
	Imprimir("5) Fibonacci");
	VerFibonacci(19);
	Imprimir("6) Hanoi");
	hanoi(3,1,2,3);
	Imprimir("7) Hoftater Femenino y Masculino");
	VerFemenina();
	VerMasculino();
	Imprimir("8) Paridad Par e Impar");
	VerPar(26);
	VerImpar(27);
	Imprimir("9) Ackermann");
	Pregunta("Resultado");

	Imprimir("10) Descendente, 13) Filtrar");
	ReporteHistorico();

	Imprimir("11) Ascendente, 12) Invertir");
	ReporteAritmetico();
	imprimir("----------------"+ invertirNumero(351230) +"-----------");
	Imprimir("15) Map, 16) Reduce");
	ReporteLogico();

	Imprimir("17) Todos, 18) Alguno");
	ReporteIngles();

}