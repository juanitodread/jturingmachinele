/*
 * @(#)PersistirXML.java	1.0 27/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.persistencia;

import com.jturingmachinele.graphics.ObjetoGrafico;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que permite serializar y deserializar los grafos que representan a las
 * máquinas de Turing.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class PersistirXML {

    private static XMLEncoder escritor;
    private static XMLDecoder lector;

    /**
     * Serializa un objeto de tipo <code>ArrayList<ObjetoGrafico></code>
     * en en el archivo que se le indique.
     *
     * @param archivo En donde guardara los datos.
     * @param objetos Datos a guardar.
     * @return <code>true</code>Si se almacenaron correctamente y <code>false</code>
     * si ocurrio un error al almacenar.
     */
    public static boolean guardar(File archivo, ArrayList<ObjetoGrafico> objetos){
        try{
            escritor = new XMLEncoder(new FileOutputStream(archivo));
            escritor.writeObject(objetos);
            escritor.close();
            return true;
        }catch(IOException ex){
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Abre un archivo y los deserializa para obtener un <code>ObjetosGrafico</code>.
     *
     * @param archivo De donde obtendra los datos.
     * @return Un <code>ArrayList<ObjetoGrafico></code> con los datos.
     */
    public static ArrayList<ObjetoGrafico> abrir(File archivo){
        ArrayList<ObjetoGrafico> objetos = null;
        try{
            lector = new XMLDecoder(new FileInputStream(archivo));
            objetos = (ArrayList<ObjetoGrafico>) lector.readObject();
            lector.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return objetos;
    }
}
