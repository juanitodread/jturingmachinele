/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import com.jturingmachinele.graphics.ObjetoGrafico;
import com.jturingmachinele.graphics.estados.Estado;
import com.jturingmachinele.graphics.estados.EstadoFinal;
import com.jturingmachinele.graphics.estados.EstadoInicial;
import java.awt.Point;


/**
 *
 * @author juan
 */
public class Test {
   public static void main(String[] args){
       Point a,b, c;
       a = new Point(5,5);
       b = new Point(10,10);
       c = new Point();
       c.setLocation( b.getX() - a.getX(), b.getY() - a.getY());
       

       FramePrueba app = new FramePrueba();
       app.setVisible(true);
   }
}
