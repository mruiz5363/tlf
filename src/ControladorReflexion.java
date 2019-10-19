

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author Mauricio
 */
public class ControladorReflexion {

    public static ControladorPaquetes pq = new ControladorPaquetes();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final File carpeta = new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Reflexio\\src\\Animales");

        pq.setNombre(carpeta.getName());
        listarFicherosPorCarpeta(carpeta, pq);

        VentanaPrincipal vist = new VentanaPrincipal(pq);
        vist.setVisible(true);

    }

    public static void listarFicherosPorCarpeta(final File carpeta, ControladorPaquetes paquete) {

        try {

            for (final File ficheroEntrada : carpeta.listFiles()) {

                if (ficheroEntrada.isDirectory()) {
                    ControladorPaquetes p = new ControladorPaquetes();
                    p.setNombre(ficheroEntrada.getName());
                    listarFicherosPorCarpeta(ficheroEntrada, p);
                    paquete.getListaPaquetes().add(p);
                } else {
                    String nombre = ficheroEntrada.getName();
                    String[] parts = nombre.split("\\.");
                    Class clazz;
                    
                        clazz = Class.forName("Animales." + parts[0]);
                    
                    ControladorClases cla = new ControladorClases();
                    cla.setNombreClase(parts[0]);
                    Method todasLosMetodos[] = clazz.getDeclaredMethods();

                    for (int i = 0; i < todasLosMetodos.length; i++) {
                        cla.getMetodos().add(todasLosMetodos[i].getName());
                    }

                    Field todasLasVariables[] = clazz.getDeclaredFields();

                    for (int i = 0; i < todasLasVariables.length; i++) {
                        cla.getAtributos().add(todasLasVariables[i].getName());
                    }
                    paquete.getListaClase().add(cla);
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
