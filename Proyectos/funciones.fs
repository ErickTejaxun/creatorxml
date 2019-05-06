
importar ("/Funciones.fs");

var ventana0_Inicio= crearventana("#ffffff",800,1000,"Inicio");
var contenedor6_ContDatos=ventana0_Inicio.crearcontenedor(500,500,"#ffffff",falso,10,10);
contenedor6_ContDatos.creartexto("Arial",14,"#000000",10,20,falso,falso,"Nombre:");
contenedor6_ContDatos.CrearCajaTexto(20,200,"Arial",14,#000000,100,20,falso,falso,"Ingrese aqui su nombre","CTNombre");
contenedor6_ContDatos.creartexto("Arial",14,"#000000",10,100,falso,falso,"Apellido:");
contenedor6_ContDatos.CrearCajaTexto(20,200,"Arial",14,#000000,100,100,falso,falso,"Ingrese aqui su apellido","CTApellido");
contenedor6_ContDatos.creartexto("Arial",14,"#000000",10,200,falso,falso,"Edad:");
contenedor6_ContDatos.CrearControlNumerico(20,10,0,0,100,200,18,"CEdad");
contenedor6_ContDatos.creartexto("Arial",14,"#000000",10,300,falso,falso,"Sexo:");
var lista3 = ["Femenino","Masculino","Indefinido"];
contenedor6_ContDatos.CrearDesplegable(20,200,lista3,100,300,lista3[2],"CDSexo");
var contenedor7_ContBtn=ventana0_Inicio.crearcontenedor(200,400,"#ffffff",falso,10,520);
var boton_btnEnviar_contenedor7_ContBtn=contenedor7_ContBtn.crearBoton("Arial",14,"#000000",75,30,nulo,"",70,100);
boton_btnEnviar_contenedor7_ContBtn.alclic(Enviar());
var boton_btnEvaluacion2_contenedor7_ContBtn=contenedor7_ContBtn.crearBoton("Arial",14,"#000000",200,30,nulo,"Calificacion",70,100);
botbtnEvaluacion2_contenedor7_ContBtn.alclic(Calculos());
ventana0_Inicio.alcargar();