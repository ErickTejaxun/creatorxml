

importar ("\formulas.fs");
importar ("\ventas.fs");

var ventana0_index= crearventana("#004fff",500,300,"index");
var contenedor0_cont1=ventana0_index.crearcontenedor(500,500,"#004fff",falso,0,0);
var contenedor1_cont2=ventana0_index.crearcontenedor(500,500,"#004fff",falso,0,500);
contenedor1_cont2.creartexto("Arial",14,"#000000",0,10,falso,falso,"Bienvenidos a la encuesta.");
contenedor1_cont2.creartexto("Arial",14,"#000000",0,10,falso,falso,"--------------");
contenedor1_cont2.CrearCajaTexto(10,100,"Arial",14,#000000,40,50,falso,falso,"Esta es un área de texto Que acepta textos con Múltiples líneas","CTCorreo");
contenedor1_cont2.CrearControlNumerico(10,100,0,0,40,50,78331339,"CTtelefono");
contenedor1_cont2.creartexto("Times New Roman",18,"#000000",450,20,verdadero,verdadero,"Bienvenido a la prueba de Historia, responda las siguientes preguntas");
contenedor1_cont2.creartexto("Arial",14,"#000000",10,20,falso,falso,"Ingrese su Nombre:");
contenedor1_cont2.CrearCajaTexto(10,100,"Arial",14,#000000,100,20,falso,falso,"Ingrese aqui su nombre","CTNombre");
contenedor1_cont2.creartexto("Arial",14,"#000000",10,250,falso,falso,"Ingrese el paisaje de la foto");
var lista0 = ["Playa","Luna","Selva","Desierto","Oceano"];
contenedor1_cont2.CrearDesplegable(50,100,lista0,150,250,lista0[2],"CDPaisaje1");
var lista1 = ["Fiat","Mitsubishi","Toyota","Jeep","Roll Roys","Ford",""];
contenedor1_cont2.CrearDesplegable(50,100,lista1,150,250,lista1[5],"CDAuto");
contenedor1_cont2.CrearControlNumerico(50,100,0,0,200,250,0,"cdedad");
contenedor1_cont2.crearareaTexto(50,100,"Arial",14,"#000000",200,250,falso,falso,"","cded2ad");
contenedor1_cont2.CrearReproductor("Ackermann.mp3",450,50,falso,50,100);
contenedor1_cont2.CrearReproductor("\tequieroputa.mp3",100,200,falso,200,200);
contenedor1_cont2.CrearReproductor("\tequieroputa.mp3",100,200,falso,200,200);
contenedor1_cont2.CrearReproductor("\tequieroputa.mp3",100,200,falso,200,200);
var boton_btnHM_contenedor1_cont2=contenedor1_cont2.crearBoton("Arial",14,"#000000",300,450,nulo,"Ver Respuesta",50,100);
botbtnHM_contenedor1_cont2.alclic(VerMasculino());
var boton_btnPar_contenedor1_cont2=contenedor1_cont2.crearBoton("Arial",14,"#000000",300,550,nulo,"Ver Respuesta",50,100);
botbtnPar_contenedor1_cont2.alclic(VerPar(26));
contenedor1_cont2.creartexto("Arial",14,"#000000",10,650,falso,falso,"Ingrese si 27 es par o impar");
contenedor1_cont2.CrearCajaTexto(50,100,"Arial",14,#000000,150,650,falso,falso,"","CTImpar");
var boton_btnImpar_contenedor1_cont2=contenedor1_cont2.crearBoton("Arial",14,"#000000",300,650,nulo,"Ver Respuesta",50,100);
botbtnImpar_contenedor1_cont2.alclic(VerImpar(27));
var boton_btnEnviar_contenedor1_cont2=contenedor1_cont2.crearBoton("Arial",14,"#000000",75,30,VentanaReportes,"Contestar",70,40);
boton_btnEnviar_contenedor1_cont2.alclic(Enviar());
ventana0_index.alcargar(funcion(52));
ventana0_index.alcargar();