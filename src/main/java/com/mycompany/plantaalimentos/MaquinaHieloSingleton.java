package com.mycompany.plantaalimentos;

import java.awt.dnd.DropTargetAdapter;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MaquinaHieloSingleton {
    private static MaquinaHieloSingleton maquinaHieloInstance;
    private boolean estadoLlenado;
    private boolean unidadEnfriamiento;
    
    public MaquinaHieloSingleton(){
        this.estadoLlenado=false;
        this.unidadEnfriamiento=false;
        System.out.println("Estado llenado vacio y unidad enfriamiento apagada.");
    }
    
    public static MaquinaHieloSingleton getInstanciaMaquinaHieloSingleton() {
        if (maquinaHieloInstance == null) {
            maquinaHieloInstance = new MaquinaHieloSingleton();
        } else{
            System.err.println("Error: No puede crear una segunda instancia de la clase.");
        }
        return maquinaHieloInstance;
    }
    
    public void llenar() {
        if (!estadoLlenado && !unidadEnfriamiento) {
            estadoLlenado = true;
            System.out.println("______________________________________________________________");
            System.out.println("Estado de llenado de la maquina de hielo vacio:\nIniciando llenado maquina de hielo.");
            System.out.println("Maquina de hielo llenada correctamente.");
        } else {
            System.out.println("\n______________________________________________________________");
            System.out.println("No se puede llenar, revise si:");
            System.out.println("*Unidad de enfriamento encendida.");
            System.out.println("*La maquina ya esta llena.");
        }
    }

    public void iniciarCongelacion() {
        if (estadoLlenado && !unidadEnfriamiento) {
            unidadEnfriamiento = true;
            System.out.println("\n______________________________________________________________");
            System.out.println("Proceso de enfriamiento iniciado. Unidad enfriamiento encendida.");
            System.out.println("Maquina de hielo realizando proceso de enfriamiento");
            System.out.println("Por favor espere un momento...\n");
            //Simulamos el tiempo que la maquina demora enfriando...
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MaquinaHieloSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Proceso de enfriamiento completado.\n");
        } else {
            System.out.println("\n______________________________________________________________");
            System.out.println("No se puede refrigerar, revise si:");
            System.out.println("*Unidad de enfriamiento esta encendida.");
            System.out.println("*No se ha llenado la maquina.");
        }
    }

    public void vaciarBloquesHielo() {
        if (estadoLlenado && unidadEnfriamiento) {
            estadoLlenado = false;
            unidadEnfriamiento = false;
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MaquinaHieloSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\n______________________________________________________________");
            System.out.println("Iniciando proceso de vaciado de bloque de hielo, por favor espere...");
            
            //Simulamos el tiempo que se demora en vaciar la maquina de hielo...
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MaquinaHieloSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Bloques de hielo vaciados. Unidad de enfriamiento apagada.");
        } else {
            System.out.println("\n______________________________________________________________");
            System.out.println("No se pueden vaciar los bloques, revise si:");
            System.out.println("*La maquina esta obstruida.");
            System.out.println("*La unidad de enfriamiento esta encendida.");
            System.out.println("*No se ha llenado correctamente la maquina.");
        }
    }

    // Métodos opcionales para ver estado
    public boolean estadoLlenado() {
        return estadoLlenado;
    }

    public boolean unidadEnfriamiento() {
        return unidadEnfriamiento;
    }
    
    //Método para comprobar que no se genere una segunda instancia de la clase.
    public static MaquinaHieloSingleton getSegundaInstanciaMaquinaHieloSingleton() {
        if (maquinaHieloInstance == null) {
            maquinaHieloInstance = new MaquinaHieloSingleton();
        } else{
            System.err.println("Error: No puede crear una segunda instancia de la clase.");
        }
        return maquinaHieloInstance;
    }
    
    
}
