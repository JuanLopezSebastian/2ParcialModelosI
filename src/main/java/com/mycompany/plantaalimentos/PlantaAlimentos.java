package com.mycompany.plantaalimentos;


public class PlantaAlimentos {

    public static void main(String[] args) {
        //Flujo correcto
        System.err.println("______________________________________________________________");
        System.err.println("Flujo completo esperado:\n");
        
        MaquinaHieloSingleton maquinaHielo = MaquinaHieloSingleton.getInstanciaMaquinaHieloSingleton();
        maquinaHielo.llenar();          // OK
        maquinaHielo.iniciarCongelacion();// OK
        maquinaHielo.vaciarBloquesHielo();// OK
        
        //Flujo incorrecto, esperamos excepciones
        System.err.println("\n\n______________________________________________________________");
        System.err.println("Comprobamos que cumpla con las excepciones(resultados esperados negativos):");
        maquinaHielo.vaciarBloquesHielo();// Falla (ya está vacío)
        maquinaHielo.iniciarCongelacion();// Falla (vacío)
        
        //Comprobamos que NO permita crear una segunda instancia de la clase
        System.err.println("\n______________________________________________________________");
        System.err.println("Comprobamos que no permita crear segundas instancias de la clase:\n");
        MaquinaHieloSingleton maquinaHielo2 = MaquinaHieloSingleton.getSegundaInstanciaMaquinaHieloSingleton();
        
    }

}
