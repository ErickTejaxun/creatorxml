var archivo = LeerGXML("EntradaGXML.gxml");
imprimir (archivo);
//////////////////////////////// Ventana Inicio
var Inicio = archivo.ObtenerporId("Inicio");

var ventana = CrearVentana(Inicio.color, 1000, 3000, Inicio.id);
/*
var contenedores = archivo.ObtenerporEtiqueta("Contenedor");

//////////////////////////////// ContRegistro
var contenedor1 = contenedores[0];

var contRegistro = ventana.CrearContenedor(contenedor1.Alto, contenedor1.Ancho, contenedor1.Color, contenedor1.Borde, contenedor1.X, contenedor1.Y);

var Textos = archivo.ObtenerporEtiqueta("Texto");

/////////////////////////////// Creacion Nombre
var nombre = Textos[0];

var CTNombre = archivo.ObtenerporNombre("CTNombre", Inicio.id);

contRegistro.CrearTexto(nombre.Fuente, nombre.Tam, nombre.Color, nombre.X, nombre.Y, nombre.negrita, nombre.Cursiva, "Nombre:");

contRegistro.CrearCajaTexto(CTNombre.Alto, CTNombre.Ancho, CTNombre.Fuente, CTNombre.Tam, CTNombre.color, CTNombre.X, CTNombre.Y, CTNombre.negrita, CTNombre.Cursiva, "Ingrese aqui su nombre", CTNombre.nombre);

/////////////////////////////// Creacion Edad
var edad = Textos[1];

var CTEdad = archivo.ObtenerporNombre("CEdad", Inicio.id);

contRegistro.CrearTexto(edad.Fuente, edad.Tam, edad.Color, edad.X, edad.Y, edad.negrita, edad.Cursiva, "Edad:");

contRegistro.CrearControlNumerico(CTEdad.alto, CTEdad.Ancho, CTEdad.Maximo, CTEdad.Minimo, CTEdad.X, CTEdad.Y, 18, CTEdad.nombre);

/////////////////////////////// Creacion Descripcion
var descripcion = Textos[2];

var CADescripcion = archivo.ObtenerporNombre("CADescripcion", Inicio.id);

contRegistro.CrearTexto(descripcion.Fuente, descripcion.Tam, descripcion.Color, descripcion.X, descripcion.Y, descripcion.negrita, descripcion.Cursiva, "Descripcion:");

contRegistro.CrearAreaTexto(CADescripcion.Alto, CADescripcion.ancho, CADescripcion.fuente, CADescripcion.tam, CADescripcion.color, CADescripcion.x, CADescripcion.y, CADescripcion.negrita, CADescripcion.cursiva, "Descripcion: ", CADescripcion.nombre);

////////////////////////////// Contenedor 2

var contenedor2 = contenedores[1];

var contBtn = ventana.CrearContenedor(contenedor2.Alto, contenedor2.Ancho, contenedor2.Color, contenedor2.Borde, contenedor2.X, contenedor2.Y);

var boton = archivo.ObtenerporNombre("btnEnviar", Inicio.id);

var textoBoton = archivo.ObtenerporNombre("contenidoBoton", Inicio.id);

var bot = contBtn.CrearBoton(textoBoton.Fuente, textoBoton.Tam,textoBoton.color,textoBoton.x,textoBoton.y, nulo, "Registrar", boton.alto, boton.ancho);

bot.AlClic(MetodoRegistrar());

funcion MetodoRegistrar(){
	ventana.CrearArrayDesdeArchivo();
	ventana.AlCerrar();
}
*/
ventana.AlCargar();