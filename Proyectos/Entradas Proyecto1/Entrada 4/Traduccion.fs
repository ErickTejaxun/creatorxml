importar("./FuncionesEvaluacion.fs");
Var vent_VentanaPrincipal=CrearVentana("#ffff88",1000,1000,"VentanaPrincipal");
Var cont_Contenedor1_VentanaPrincipal=vent_VentanaPrincipal.CrearContenedor(900,400,"#ffffff",verdadero,10,10);
cont_Contenedor1_VentanaPrincipal.CrearTexto("Arial",14,"#000000",10,10,verdadero,falso,"Haga clic en el siguiente boton para iniciar la evaluacion");

Var btn_btnEvaluacion_VentanaPrincipal=cont_Contenedor1_VentanaPrincipal.CrearBoton("Arial",14,"#00ff00",50,50,"VentanaAritmetica","Iniciar Evaluacion",30,200);

btn_btnEvaluacion_VentanaPrincipal.AlClic(Bienvenido());


cont_Contenedor1_VentanaPrincipal.CrearTexto("Arial",14,"#000000",10,250,falso,verdadero,"Haga clic en el siguiente boton para iniciar el area de reportes");

Var btn_btnReportes_VentanaPrincipal=cont_Contenedor1_VentanaPrincipal.CrearBoton("Arial",14,"#FFFFFF",50,280,"VentanaReportes","Iniciar Reportes",100,200);

btn_btnReportes_VentanaPrincipal.AlClic(BienvenidoReporte());

Var cont_ContBtn_VentanaPrincipal=vent_VentanaPrincipal.CrearContenedor(200,400,"#000000",falso,10,420);

Var btnE_btnEnviar_VentanaPrincipal=cont_ContBtn_VentanaPrincipal.CrearBoton("Arial",14,"#FFFFFF",75,30,nulo,"Enviar",100,100);

btnE_btnEnviar_VentanaPrincipal.AlClic(Guardar_VentanaPrincipal());

Var btn_btnEvaluacion2_VentanaPrincipal=cont_ContBtn_VentanaPrincipal.CrearBoton("Arial",14,"#FFFFFF",200,30,nulo,"Calificacions",100,100);

btn_btnEvaluacion2_VentanaPrincipal.AlClic(Calculos());

vent_VentanaPrincipal.AlCargar();
funcion CargarVentana_VentanaAritmetica(){
	vent_VentanaAritmetica.AlCargar();
}
funcion CargarVentana_VentanaReportes(){
	vent_VentanaReportes.AlCargar();
}
funcion Guardar_VentanaPrincipal(){
	vent_VentanaPrincipal.CrearArrayDesdeArchivo();
}

Var vent_VentanaAritmetica=CrearVentana("#2E2EFE",1000,1000,"VentanaAritmetica");

Var cont_ContenedorAritmeticas_VentanaAritmetica=vent_VentanaAritmetica.CrearContenedor(1000,1000,"#2E2EFE",verdadero,10,10);

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Times New Roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Aritmetica, responda las siguientes preguntas");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,50,falso,falso,"Ingrese su Nombre:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearCajaTexto(20,100,"Arial",12,"#000000",100,50,falso,falso,"Ingrese aqui su nombre","CTNombre");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,150,falso,falso,"Ingrese la potencia de 5 a la 5:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearControlNumerico(50,100,5000,0,150,150,0,"CPotencia");

Var btn_btnPotencia_VentanaAritmetica=cont_ContenedorAritmeticas_VentanaAritmetica.CrearBoton("Arial",14,"#FFFFFF",300,150,nulo,"Ver Respuesta",50,150);

btn_btnPotencia_VentanaAritmetica.AlClic(VerPotencia(5,5));

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,250,falso,falso,"Ingrese el Factorial de 7:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearControlNumerico(50,100,6000,0,150,250,0,"CFactorial");

Var btn_btnFactorial_VentanaAritmetica=cont_ContenedorAritmeticas_VentanaAritmetica.CrearBoton("Arial",14,"#FFFFFF",300,250,nulo,"Ver Respuesta",50,150);

btn_btnFactorial_VentanaAritmetica.AlClic(VerFactorial(7));

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,350,falso,falso,"Ingrese el numero invertido de 351230347:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearControlNumerico(50,100,nulo,0,150,350,0,"CInvertido");

Var btn_btnInvertido_VentanaAritmetica=cont_ContenedorAritmeticas_VentanaAritmetica.CrearBoton("New Times Romans",20,"#ff00ff",300,350,nulo,"Ver Respuesta",50,150);

btn_btnInvertido_VentanaAritmetica.AlClic(VerInvertido(351230347));

cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,450,falso,falso,"Ingrese el mcd de 240,506 con 10:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearControlNumerico(50,100,nulo,0,150,450,0,"CMCD");

Var btn_btnMCD_VentanaAritmetica=cont_ContenedorAritmeticas_VentanaAritmetica.CrearBoton("Arial",14,"#FFFFFF",300,450,nulo,"Ver Respuesta",50,100);

//btn_btnMCD_VentanaAritmetica.AlClic(VerMCD(240,506,10));
btn_btnMCD_VentanaAritmetica.AlClic(VerMCD(240,506));
cont_ContenedorAritmeticas_VentanaAritmetica.CrearTexto("Arial",14,"#000000",10,550,falso,falso,"Ingrese el Fibonacci de 19:");

cont_ContenedorAritmeticas_VentanaAritmetica.CrearControlNumerico(50,100,6000,0,150,550,0,"CFibonacci");

Var btn_btnFibonacci_VentanaAritmetica=cont_ContenedorAritmeticas_VentanaAritmetica.CrearBoton("Arial",14,"#FFFFFF",300,550,nulo,"Ver Respuesta",50,100);

btn_btnFibonacci_VentanaAritmetica.AlClic(VerFibonacci(19));

Var cont_ContEnviarAritmetica_VentanaAritmetica=vent_VentanaAritmetica.CrearContenedor(100,200,"#2E2EFE",falso,10,1010);

Var btnE_btnEnviar_VentanaAritmetica=cont_ContEnviarAritmetica_VentanaAritmetica.CrearBoton("Arial",14,"#FFFFFF",75,30,"VentanaHistoria","Contestar",70,40);

btnE_btnEnviar_VentanaAritmetica.AlClic(Guardar_VentanaAritmetica());

Var vent_VentanaHistoria=CrearVentana("#2E2EFE",1000,1000,"VentanaHistoria");

Var cont_ContenedorHistoria_VentanaHistoria=vent_VentanaHistoria.CrearContenedor(1000,1000,"#2E2EFE",verdadero,10,10);

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Times New Roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Historia, responda las siguientes preguntas");

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre:");

cont_ContenedorHistoria_VentanaHistoria.CrearCajaTexto(10,100,"Arial",12,"#000000",100,20,falso,falso,"Ingrese aqui su nombre","CTNombre");

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,250,falso,falso,"Ingrese el paisaje de la foto");

cont_ContenedorHistoria_VentanaHistoria.CrearDesplegable(50,100,list_CDPaisaje1_VentanaHistoria,150,250,"Playa","CDPaisaje1");

Var list_CDPaisaje1_VentanaHistoria=["Playa","Luna","Selva","Desierto","Oceano"];

cont_ContenedorHistoria_VentanaHistoria.CrearImagen("playa.jpg",300,250,100,100);

Var btn_btnPlaya_VentanaHistoria=cont_ContenedorHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",500,250,nulo,"Ver Respuesta",50,100);

btn_btnPlaya_VentanaHistoria.AlClic(Paisaje(10));

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,400,falso,falso,"Ingrese el paisaje de la foto");

cont_ContenedorHistoria_VentanaHistoria.CrearDesplegable(50,100,list_CDPaisaje2_VentanaHistoria,150,400,"Playa","CDPaisaje2");

Var list_CDPaisaje2_VentanaHistoria=["Playa","Luna","Selva","Desierto","Oceano"];

cont_ContenedorHistoria_VentanaHistoria.CrearImagen("luna.jpg",300,400,100,100);

Var btn_btnLuna_VentanaHistoria=cont_ContenedorHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",500,400,nulo,"Ver Respuesta",50,100);

btn_btnLuna_VentanaHistoria.AlClic(Paisaje(20));

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,550,falso,falso,"Ingrese el paisaje de la foto");

cont_ContenedorHistoria_VentanaHistoria.CrearDesplegable(50,100,list_CDPaisaje3_VentanaHistoria,150,550,"Playa","CDPaisaje3");

Var list_CDPaisaje3_VentanaHistoria=["Playa","Luna","Selva","Desierto","Oceano"];

cont_ContenedorHistoria_VentanaHistoria.CrearImagen("selva.jpg",300,550,100,100);

Var btn_btnSelva_VentanaHistoria=cont_ContenedorHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",500,550,nulo,"Ver Respuesta",50,100);

btn_btnSelva_VentanaHistoria.AlClic(Paisaje(30));

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,700,falso,falso,"Ingrese el paisaje de la foto");

cont_ContenedorHistoria_VentanaHistoria.CrearDesplegable(50,100,list_CDPaisaje4_VentanaHistoria,150,700,"Playa","CDPaisaje4");

Var list_CDPaisaje4_VentanaHistoria=["Playa","Luna","Selva","Desierto","Oceano"];

cont_ContenedorHistoria_VentanaHistoria.CrearImagen("Desierto.jpg",300,700,100,100);

Var btn_btnDesierto_VentanaHistoria=cont_ContenedorHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",500,700,nulo,"Ver Respuesta",50,100);

btn_btnDesierto_VentanaHistoria.AlClic(Paisaje(40));

cont_ContenedorHistoria_VentanaHistoria.CrearTexto("Arial",14,"#000000",10,850,falso,falso,"Ingrese el paisaje de la foto");

cont_ContenedorHistoria_VentanaHistoria.CrearDesplegable(50,100,list_CDPaisaje5_VentanaHistoria,150,850,"Playa","CDPaisaje5");

Var list_CDPaisaje5_VentanaHistoria=["Playa","Luna","Selva","Desierto","Oceano"];

cont_ContenedorHistoria_VentanaHistoria.CrearImagen("oceano.jpg",300,850,100,100);

Var btn_btnOceano_VentanaHistoria=cont_ContenedorHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",500,850,nulo,"Ver Respuesta",50,100);

btn_btnOceano_VentanaHistoria.AlClic(Paisaje(50));

Var cont_ContEnviarHistoria_VentanaHistoria=vent_VentanaHistoria.CrearContenedor(100,200,"#2E2EFE",falso,10,1010);

Var btnE_btnEnviar_VentanaHistoria=cont_ContEnviarHistoria_VentanaHistoria.CrearBoton("Arial",14,"#FFFFFF",75,30,"VentanaIngles","Contestar",70,40);

btnE_btnEnviar_VentanaHistoria.AlClic(Guardar_VentanaHistoria());

Var vent_VentanaIngles=CrearVentana("#2E2EFE",1000,1000,"VentanaIngles");

Var cont_ContenedorIngles_VentanaIngles=vent_VentanaIngles.CrearContenedor(1000,1000,"#2E2EFE",verdadero,10,10);

cont_ContenedorIngles_VentanaIngles.CrearTexto("Times New Roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Ingles, responda las siguientes preguntas");

cont_ContenedorIngles_VentanaIngles.CrearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre:");

cont_ContenedorIngles_VentanaIngles.CrearCajaTexto(10,100,"Arial",12,"#000000",100,20,falso,falso,"Ingrese aqui su nombre","CTNombre");

cont_ContenedorIngles_VentanaIngles.CrearReproductor("Ackermann.mp3",450,50,falso,50,100);

cont_ContenedorIngles_VentanaIngles.CrearTexto("Arial",14,"#000000",10,250,falso,falso,"What algorithm is the audio talking about?");

cont_ContenedorIngles_VentanaIngles.CrearCajaTexto(50,150,"Arial",12,"#000000",100,250,falso,falso,"Ingrese aqui su respuesta","CTPregunta");

Var btn_btnPregunta_VentanaIngles=cont_ContenedorIngles_VentanaIngles.CrearBoton("Arial",14,"#FFFFFF",300,250,nulo,"Ver Respuesta",50,100);

btn_btnPregunta_VentanaIngles.AlClic(Pregunta("Tipo"));

cont_ContenedorIngles_VentanaIngles.CrearTexto("Arial",14,"#000000",10,350,falso,falso,"Ingrese el ackerman de 3,7:");

cont_ContenedorIngles_VentanaIngles.CrearControlNumerico(50,100,nulo,0,150,350,0,"CAckerman");

Var btn_btnAckerman_VentanaIngles=cont_ContenedorIngles_VentanaIngles.CrearBoton("Arial",14,"#FFFFFF",300,350,nulo,"Ver Respuesta",50,100);

btn_btnAckerman_VentanaIngles.AlClic(Pregunta("Resultado"));

Var cont_ContEnviarIngles_VentanaIngles=vent_VentanaIngles.CrearContenedor(100,200,"#2E2EFE",falso,10,1010);

Var btnE_btnEnviar_VentanaIngles=cont_ContEnviarIngles_VentanaIngles.CrearBoton("Arial",14,"#FFFFFF",75,30,"VentanaLogica","Contestar",70,40);

btnE_btnEnviar_VentanaIngles.AlClic(Guardar_VentanaIngles());

Var vent_VentanaLogica=CrearVentana("#2E2EFE",1000,1000,"VentanaLogica");

Var cont_ContenedorLogica_VentanaLogica=vent_VentanaLogica.CrearContenedor(1000,1000,"#2E2EFE",verdadero,10,10);

cont_ContenedorLogica_VentanaLogica.CrearTexto("Times New Roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Logica, responda las siguientes preguntas");

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre:");

cont_ContenedorLogica_VentanaLogica.CrearCajaTexto(10,100,"Arial",12,"#000000",100,20,falso,falso,"Ingrese aqui su nombre","CTNombre");

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,150,falso,falso,"Resuelva las torres de Hanoi con 3 discos, origen 1, destino 3 y auxiliar 2");

cont_ContenedorLogica_VentanaLogica.CrearAreaTexto(150,100,"Arial",14,"#000000",150,150,falso,falso,"","CHanoi");

Var btn_btnHanoi_VentanaLogica=cont_ContenedorLogica_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",300,150,nulo,"Ver Respuesta",50,100);

btn_btnHanoi_VentanaLogica.AlClic(hanoi(3,1,2,3));

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,350,falso,falso,"Ingrese el Hofstader Femenina 10:");

cont_ContenedorLogica_VentanaLogica.CrearCajaTexto(50,100,"Arial",12,"#000000",150,350,falso,falso,"","CTHF");

Var btn_btnHF_VentanaLogica=cont_ContenedorLogica_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",300,350,nulo,"Ver Respuesta",50,100);

btn_btnHF_VentanaLogica.AlClic(VerFemenina());

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,450,falso,falso,"Ingrese el Hofstader Maculino 10:");

cont_ContenedorLogica_VentanaLogica.CrearCajaTexto(50,100,"Arial",12,"#000000",150,450,falso,falso,"","CTHM");

Var btn_btnHM_VentanaLogica=cont_ContenedorLogica_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",300,450,nulo,"Ver Respuesta",50,100);

btn_btnHM_VentanaLogica.AlClic(VerMasculino());

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,550,falso,falso,"Ingrese si 26 es par o impar");

cont_ContenedorLogica_VentanaLogica.CrearCajaTexto(50,100,"Arial",12,"#000000",150,550,falso,falso,"","CTPar");

Var btn_btnPar_VentanaLogica=cont_ContenedorLogica_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",300,550,nulo,"Ver Respuesta",50,100);

btn_btnPar_VentanaLogica.AlClic(VerPar(26));

cont_ContenedorLogica_VentanaLogica.CrearTexto("Arial",14,"#000000",10,650,falso,falso,"Ingrese si 27 es par o impar");

cont_ContenedorLogica_VentanaLogica.CrearCajaTexto(50,100,"Arial",12,"#000000",150,650,falso,falso,"","CTImpar");

Var btn_btnImpar_VentanaLogica=cont_ContenedorLogica_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",300,650,nulo,"Ver Respuesta",50,100);

btn_btnImpar_VentanaLogica.AlClic(VerImpar(27));

Var cont_ContEnviarLogicas_VentanaLogica=vent_VentanaLogica.CrearContenedor(100,200,"#2E2EFE",falso,10,1010);

Var btnE_btnEnviar_VentanaLogica=cont_ContEnviarLogicas_VentanaLogica.CrearBoton("Arial",14,"#FFFFFF",75,30,"VentanaReportes","Contestar",70,40);

btnE_btnEnviar_VentanaLogica.AlClic(Guardar_VentanaLogica());

funcion CargarVentana_VentanaHistoria(){
	vent_VentanaHistoria.AlCargar();
}
funcion Guardar_VentanaAritmetica(){
	vent_VentanaAritmetica.CrearArrayDesdeArchivo();
}

funcion CargarVentana_VentanaIngles(){
	vent_VentanaIngles.AlCargar();
}
funcion Guardar_VentanaHistoria(){
	vent_VentanaHistoria.CrearArrayDesdeArchivo();
}

funcion CargarVentana_VentanaLogica(){
	vent_VentanaLogica.AlCargar();
}
funcion Guardar_VentanaIngles(){
	vent_VentanaIngles.CrearArrayDesdeArchivo();
}

funcion Guardar_VentanaLogica(){
	vent_VentanaLogica.CrearArrayDesdeArchivo();
}

Var vent_VentanaReportes=CrearVentana("#000000",1000,1000,"VentanaReportes");

Var cont_ContenedorReportes_VentanaReportes=vent_VentanaReportes.CrearContenedor(800,800,"#000000",verdadero,10,10);

Var btn_btnEvaluacion1_VentanaReportes=cont_ContenedorReportes_VentanaReportes.CrearBoton("Arial",14,"#FFFFFF",60,40,nulo,"Reporte Aritmeticos",100,100);

btn_btnEvaluacion1_VentanaReportes.AlClic(ReporteAritmetico());

Var btn_btnEvaluacion2_VentanaReportes=cont_ContenedorReportes_VentanaReportes.CrearBoton("Arial",14,"#FFFFFF",60,40,nulo,"Reporte Historicos",100,100);

btn_btnEvaluacion2_VentanaReportes.AlClic(ReporteHistorico());

Var btn_btnEvaluacion3_VentanaReportes=cont_ContenedorReportes_VentanaReportes.CrearBoton("Arial",14,"#FFFFFF",60,40,nulo,"Reporte Ingles",100,100);

btn_btnEvaluacion3_VentanaReportes.AlClic(ReporteIngles());

Var btn_btnEvaluacion4_VentanaReportes=cont_ContenedorReportes_VentanaReportes.CrearBoton("Arial",14,"#FFFFFF",60,40,nulo,"Reporte Logicos",100,100);

btn_btnEvaluacion4_VentanaReportes.AlClic(ReporteLogico());

Var btnE_btnEnviar_VentanaReportes=cont_ContenedorReportes_VentanaReportes.CrearBoton("Arial",14,"#FFFFFF",60,350,nulo,"Sin funcionalidad",100,100);

btnE_btnEnviar_VentanaReportes.AlClic(EnviarSinFuncionalidad());

btnE_btnEnviar_VentanaReportes.AlClic(Guardar_VentanaReportes());

funcion Guardar_VentanaReportes(){
	vent_VentanaReportes.CrearArrayDesdeArchivo();
EnviarSinFuncionalidad();

}