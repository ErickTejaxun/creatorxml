funcion aritmeticas_basicas(){
        imprimir("1) Operaciones Aritmeticas Basicas");
        //1765
        var temp1 = 10+45*78/2;
        var texto = "1.1) ";
        imprimir(texto + ": " + temp1);
        //80
        var temp2 = 0+(10*8);
        texto = "1.2) ";
        imprimir(texto + ": " + temp2);
        //9
        var temp3 =  (8-7+2^(3));
        texto = "1.3) ";
        imprimir(texto + ": " + temp3);
}

funcion aritmeticas_avanzadas(){

        imprimir("2) Operaciones Aritmeticas Avanzadas");
        //112
        var temp1 = 15*7-2/2-8*(5-6);
        var texto = "2.1) ";
        imprimir(texto + " : " + temp1);
        //143
        var temp2 =  (0+(10*8)-18 + 3^(4));
        texto = "2.2) ";
        imprimir(texto + " : " + temp2);
        //14
        var temp3 =  ((8-7+2^(3)/3)*4);
        texto = "2.3) ";
        imprimir(texto + " : " + temp3);
}

funcion operaciones_relacionales_basicas(){

        imprimir("3) Operaciones Relacionales Basicas");
        var salida = 0;
        Si(salida < 10)
        {
            salida = 5*9;
            si(salida > 44)
            {
                 salida++;
            }
        }sino{
            salida = 1;
        }
       
        Si (salida != 1)
        {

            Si(salida == 46)
            {

                imprimir("Salida CORRECTA!!");
            }sino{
                imprimir("Salida incorrecta!!");

            }
        }sino{
            imprimir("Salida incorrecta!!");
        }
}

funcion operaciones_relacionales_avanzadas(){
        imprimir("4)Operaciones Relacionales Avanzadas");
        si(10-15 >= 0){
            imprimir("Salida incorrecta!!");
        }sino{
            si(15+8 == 22-10+5*3-4){
                si(10 != 11-2){
                    imprimir("Salida CORRECTA!!");
                }sino{
                    imprimir("Salida incorrecta!!");
                }
       }sino{
            si (1 == 1){
                imprimir("Salida incorrecta!!");
            }sino{
                imprimir("Salida incorrecta!!");
            }
        }
    }
}

funcion operaciones_logicas_basicas(){

        imprimir("5) Operaciones Logicas Basicas");
        si(((verdadero == verdadero) && (verdadero != falso)) || (1 > 10) && (!(verdadero) == verdadero)){
            imprimir("Salida CORRECTA!!");
        }sino{
            imprimir("Salida incorrecta!!");
        }
}

funcion operaciones_logicas_avanzadas(){
        imprimir("6) Operaciones Logicas Avanzadas");
        si((15 == 14) || (((15*2 >= 15) && (12 < 24))||((98/2 == 15)||(!(15 != 6-1)))))
        {
            imprimir("Salida CORRECTA!!");
        }sino{
            imprimir("Salida incorrecta!!");
        }
}

funcion operaciones_conjuntas(){
        imprimir("7) Operaciones Conjuntas");
        si(!(5*3-1 == 14) && !(!(15 == 6-1)))
        {
            imprimir("Salida incorrecta!!");
        }sino{
            var variable = -1*(54/6+9+9-1*8/2*17);
            var var2 = 48/4*79-2+8;
            var salida = variable + "" + var2;
            si(salida == "41954" || salida == "41.0954"){
                imprimir("Resultado: 41954");
            }sino{

                imprimir("Salida incorrecta!!");
            }
        }
}

funcion factorial_recursivo(var n){
     
     si(n==0){
        retornar 1;
     }sino{
        retornar n * factorial_recursivo(n - 1);
     }
}

funcion factorial_iterativo( var n){
     
     si(n==0){
        retornar 1;
     }sino{
        retornar n * factorial_iterativo(n - 1);
     }
}

funcion Calculos(){
    aritmeticas_basicas();
    aritmeticas_avanzadas();
    operaciones_relacionales_basicas();
    operaciones_relacionales_avanzadas();
    operaciones_logicas_basicas();
    operaciones_logicas_avanzadas();
    operaciones_conjuntas();
    var datos = CrearArrayDesdeArchivo("Inicio.gdato");
    var edades = datos.map(obtenerEdades);
    var promedio = edades.reduce(promedioEdad) / 10;
    Imprimir("Promedio :" + promedio);
    imprimir("8) factorial_recursivo");
    imprimir(factorial_recursivo(promedio));
    imprimir("9) factorial_iterativo");
    imprimir(factorial_iterativo(promedio));
    datos.map(ImprimirNombres);
    Imprimir("Suma de edades: " + edades.reduce(promedioEdad));
}

funcion obtenerEdades( var item){
    retornar item.Cedad;
}

funcion promedioEdad(var prom,  var item){
    retornar prom + item;
}

funcion ImprimirNombres(var item){
    Imprimir("Nombre: " + item.CTNombre + " apellido: " + item.CTApellido);
} 

 Calculos();