Consultas();
funcion Consultas(){
	var datosCarrito = CrearArrayDesdeArchivo("Carrito.gdato");
	Imprimir("1) Total Carrito por usuario");
	var Usuarios10 = datosCarrito.filtrar(TotalUsua10);
	var Usuarios11 = datosCarrito.filtrar(TotalUsua11);
	var Usuarios12 = datosCarrito.filtrar(TotalUsua12);		
	var Total10 = Usuarios10.map(totales).reduce(Suma);
	var Total11 = Usuarios11.map(totales).reduce(Suma);
	var Total12 = Usuarios12.map(totales).reduce(Suma);
	Imprimir("		Total usuario 10: " + Total10);
	Imprimir("		Total usuario 11: " + Total11);
	Imprimir("		Total usuario 12: " + Total12);

	var datosProducto = CrearArrayDesdeArchivo("Producto.gdato");
	Imprimir("2) Productos Mayores a 100");

	datosProducto.filtrar(Mayores100).map(ImprimirNombres);

	Imprimir("3) Productos mas comprados");
	var Productos100 = datosCarrito.filtrar(Producto100).map(totales).reduce(Suma);
	var Productos200 = datosCarrito.filtrar(Producto200).map(totales).reduce(Suma);
	var Productos300 = datosCarrito.filtrar(Producto300).map(totales).reduce(Suma);

	Imprimir("		Total producto 100: " + Productos100);
	Imprimir("		Total producto 200: " + Productos200);
	Imprimir("		Total producto 300: " + Productos300);

	Imprimir("4) Productos mas comprados por estudiantes");
	var Productos100E = datosCarrito.filtrar(SoloEstudiantes).filtrar(Producto100).map(totales).reduce(Suma);	
	var Productos200E = datosCarrito.filtrar(SoloEstudiantes).filtrar(Producto200).map(totales).reduce(Suma);
	var Productos300E = datosCarrito.filtrar(SoloEstudiantes).filtrar(Producto300).map(totales).reduce(Suma);

	Imprimir("		Total producto 100 de estudiantes: " + Productos100E);
	Imprimir("		Total producto 200 de estudiantes: " + Productos200E);
	Imprimir("		Total producto 300 de estudiantes: " + Productos300E);

	Imprimir("5) Productos mas comprados por estudiantes");
	var Productos100M = datosCarrito.filtrar(SoloMaestros).filtrar(Producto100).map(totales).reduce(Suma);
	var Productos200M = datosCarrito.filtrar(SoloMaestros).filtrar(Producto200).map(totales).reduce(Suma);
	var Productos300M = datosCarrito.filtrar(SoloMaestros).filtrar(Producto300).map(totales).reduce(Suma);

	Imprimir("		Total producto 100 de maestros: " + Productos100M);
	Imprimir("		Total producto 200 de maestros: " + Productos200M);
	Imprimir("		Total producto 300 de maestros: " + Productos300M);

	Imprimir("6) Productos mas comprados por estudiantes mayores");
	var Productos100EM = datosCarrito.filtrar(SoloMayores).filtrar(SoloEstudiantes).filtrar(Producto100).map(totales).reduce(Suma);
	var Productos200EM = datosCarrito.filtrar(SoloMayores).filtrar(SoloEstudiantes).filtrar(Producto200).map(totales).reduce(Suma);
	var Productos300EM = datosCarrito.filtrar(SoloMayores).filtrar(SoloEstudiantes).filtrar(Producto300).map(totales).reduce(Suma);

	Imprimir("		Total producto 100 de estudiantes mayores: " + Productos100EM);
	Imprimir("		Total producto 200 de estudiantes mayores: " + Productos200EM);
	Imprimir("		Total producto 300 de estudiantes mayores: " + Productos300EM);
	Imprimir("7) Comparacion Productos de estudiantes y maestros");
	
	Imprimir("		Total producto 100: Estudiantes->" + Productos100E + " Maestros->" + Productos100M);
	Imprimir("		Total producto 200: Estudiantes->" + Productos200E + " Maestros->" + Productos200M);
	Imprimir("		Total producto 300: Estudiantes->" + Productos300E + " Maestros->" + Productos300M);

	Imprimir("8) Listado de alumnos por curso");

	var datosAlumnos = CrearArrayDesdeArchivo("Alumno.gdato");
	Imprimir("    --> Curso 100");
	datosAlumnos.filtrar(Curso100).map(ImprimirNombres);
	Imprimir("    --> Curso 200");
	datosAlumnos.filtrar(Curso200).map(ImprimirNombres);
	Imprimir("    --> Curso 300");
	datosAlumnos.filtrar(Curso300).map(ImprimirNombres);

	Imprimir("9) Creditos por alumno");

	var datosCursos = CrearArrayDesdeArchivo("Curso.gdato");
	Imprimir("    --> Alumno 1");
	datosCursos.filtrar(SoloAlumno1).map(ObtenerCreditos).reduce(Suma);
	Imprimir("    --> Alumno 2");
	datosCursos.filtrar(SoloAlumno2).map(ObtenerCreditos).reduce(Suma);
	Imprimir("    --> Alumno 3");
	datosCursos.filtrar(SoloAlumno3).map(ObtenerCreditos).reduce(Suma);

	Imprimir("11) Cursos de Maestros");

	Imprimir("    --> Maestro 1");
	datosCursos.filtrar(SoloMaestro10).map(ImprimirNombres);
	Imprimir("    --> Maestro 2");
	datosCursos.filtrar(SoloMaestro11).map(ImprimirNombres);
	Imprimir("    --> Maestro 3");
	datosCursos.filtrar(SoloMaestro12).map(ImprimirNombres);

	Imprimir("11) Cursos de alumnos");

	Imprimir("    --> Alumno 1");
	datosCursos.filtrar(SoloAlumno1).map(ImprimirNombres);
	Imprimir("    --> Alumno 2");
	datosCursos.filtrar(SoloAlumno2).map(ImprimirNombres);
	Imprimir("    --> Alumno 3");
	datosCursos.filtrar(SoloAlumno3).map(ImprimirNombres);
}

funcion SoloMaestro10(var item){
	Si(item.CTCodigo == 10){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloMaestro11(var item){
	Si(item.CTCodigo == 11){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloMaestro12(var item){
	Si(item.CTCodigo == 12){
		retornar verdadero;
	}
	retornar falso;
}

funcion ObtenerCreditos(var item){
	retornar item.CCreditos;
}

funcion SoloAlumno1(var item){
	Si(item.CID == 1){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloAlumno2(var item){
	Si(item.CID == 2){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloAlumno3(var item){
	Si(item.CID == 3){
		retornar verdadero;
	}
	retornar falso;
}

funcion Curso100(var item){
	Si(item.CCurso == 100){
		retornar verdadero;
	}
	retornar falso;
}

funcion Curso200(var item){
	Si(item.CCurso == 200){
		retornar verdadero;
	}
	retornar falso;
}

funcion Curso300(var item){
	Si(item.CCurso == 300){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloMayores(var item){
	Si(item.CTipo == "Mayor"){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloEstudiantes(var item){
	Si(item.CCategoria == 1){
		retornar verdadero;
	}
	retornar falso;
}

funcion SoloMaestros(var item){
	Si(item.CCategoria == 2){
		retornar verdadero;
	}
	retornar falso;
}

funcion ImprimirNombres(var item){
	Imprimir("		" + item.CTNombre);
}

funcion Producto100(var item){
	Si(item.CID == 100){
		retornar verdadero;
	}
	retornar falso;
}

funcion Producto200(var item){
	Si(item.CID == 200){
		retornar verdadero;
	}
	retornar falso;
}

funcion Producto300(var item){
	Si(item.CID == 300){
		retornar verdadero;
	}
	retornar falso;
}

funcion Mayores100(var item){
	Si(item.CPrecio >= 100){
		retornar verdadero;
	}
	retornar falso;
}

funcion TotalUsua10(var item)
{	
	Si(item.CUsuario == 10)
	{		
		retornar verdadero;		
	}	
	retornar falso;
}

funcion TotalUsua11(var item){
	Si(item.CUsuario == 11){
		retornar verdadero;
	}
	retornar falso;
}

funcion TotalUsua12(var item){
	Si(item.CUsuario == 12){
		retornar verdadero;
	}
	retornar falso;
}

funcion Suma(var total, var item){
 	retornar total + item;
}

funcion totales(var item)
{	
	retornar item.CTCantidad * item.CID;
}

Consultas();