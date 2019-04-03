ReporteHistorico();
funcion ReporteHistorico(){
	var contenido = CrearArrayDesdeArchivo("Entrada Proyecto1/VentanaHistoria.gdato");	
	var TodoCorrecto = contenido.filtrar(RevisionHistoria);
	Imprimir("El primer alumno en contestar todo buen fue ");
	
	var c= 0;
	while(c < 6)
	{
		imprimir(TodoCorrecto[c].ctnombre);
		c++;	
	}
	todocorrecto.ascendente();
 	c= 0;
	while(c < 6)
	{
		imprimir(TodoCorrecto[c].ctnombre);
		c++;	
	}
	
	/*var primero = TodoCorrecto.Buscar(BuscarHistoria);
	Imprimir(primero.CTNombre);
    Imprimir("Todos Los estudiantes que ganaron la evaluacion de historia son: (Orden Descendente)");
    TodoCorrecto.Descendente();
	TodoCorrecto.map(ImprimirGanadores);*/
}

funcion BuscarHistoria(var item){
	retornar item.CDPaisaje1 == "Playa" && item.CDPaisaje2 == "Luna" && item.CDPaisaje3 == "Selva" && item.CDPaisaje4 == "Desierto" && item.CDPaisaje5 == "Oceano";
}

funcion RevisionHistoria(var item){
	retornar item.CDPaisaje1 == "Playa" && item.CDPaisaje2 == "Luna" && item.CDPaisaje3 == "Selva" && item.CDPaisaje4 == "Desierto" && item.CDPaisaje5 == "Oceano";
}