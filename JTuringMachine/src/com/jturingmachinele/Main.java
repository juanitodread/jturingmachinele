/*
 *  TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 *   
 *  Copyright (C) 2009  SystarSystems.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or 
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 * 
 * @(#)Main.java	1.0 04/02/2010
 *
 */

package com.jturingmachinele;

import javax.swing.SwingUtilities;

import com.jturingmachinele.visual.Splash;

/**
 * Clase principal de la aplicación.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class Main {
    
    public static void main( String [ ] args ) {
        SwingUtilities.invokeLater( new Runnable( ) {
            public void run( ) {
                new Thread( new Splash( ) ).start( );
            }
        } );
    }
}
