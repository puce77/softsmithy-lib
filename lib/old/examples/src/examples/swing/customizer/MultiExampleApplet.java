/*
 *                  Sun Public License Notice
 *
 * The contents of this file are subject to the Sun Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.sun.com/
 *
 * The Original Code is Examples of SoftSmithy Utility Library. The Initial Developer of the
 * Original Code is Florian Brunner (Sourceforge.net user: puce). All Rights Reserved.
 *
 * Contributor(s): .
 */

/*
 * Example1.java
 *
 * Created on 9. M�rz 2003, 18:23
 */

package examples.swing.customizer;

import java.awt.*;
import java.awt.geom.*;
import java.net.*;
import javax.swing.*;
import org.softsmithy.lib.awt.*;
import org.softsmithy.lib.awt.layout.*;
import org.softsmithy.lib.swing.*;


/**
 *
 * @author  puce
 */
public class MultiExampleApplet extends JXApplet {
  
  /** Creates new form Example1 */
  public MultiExampleApplet() {
    initComponents();
    validate();
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {//GEN-BEGIN:initComponents
    pane = new org.softsmithy.lib.swing.JCustomizerPane();

    getContentPane().add(pane, java.awt.BorderLayout.CENTER);

  }//GEN-END:initComponents
  
  /** Called by the browser or applet viewer to inform
   * this applet that it has been loaded into the system. It is always
   * called before the first time that the <code>start</code> method is
   * called.
   * <p>
   * A subclass of <code>Applet</code> should override this method if
   * it has initialization to perform. For example, an applet with
   * threads would use the <code>init</code> method to create the
   * threads and the <code>destroy</code> method to kill them.
   * <p>
   * The implementation of this method provided by the
   * <code>Applet</code> class does nothing.
   *
   * @see     java.applet.Applet#destroy()
   * @see     java.applet.Applet#start()
   * @see     java.applet.Applet#stop()
   *
   */
  public void init() {
    super.init();
    InfiniteTableLayout itl = new InfiniteTableLayout(pane);
    pane.setCustomizerLayout(itl);
    
    //create and configure a customizer for a simple component
    JCustomizer simpleCustomizer = new JCustomizer(new JLabel("A Simple Component"));
    pane.addCustomizer(simpleCustomizer, new AbsoluteTableConstraints(0, 0, 140, 20, simpleCustomizer, itl));
    
    //create and configure an editable customizer for a label
    JLabelCustomizer labelCustomizer = new JLabelCustomizer("A Label Customizer - double click to edit!");
    pane.addCustomizer(labelCustomizer, new AbsoluteTableConstraints(50, 50, 270, 20, labelCustomizer, itl));
    
    //create and configure a customizer for a shape
    JShapeCustomizer starCustomizer = new JShapeCustomizer(new Star(0, 0, 100, 100));
    //starCustomizer.setFilled(true);
    //starCustomizer.setOpaque(false);
    starCustomizer.setForeground(Color.YELLOW);
    pane.addCustomizer(starCustomizer, new AbsoluteTableConstraints(200, 100, 100, 100, starCustomizer, itl));
    
    JShapeCustomizer ellipseCustomizer = new JShapeCustomizer(new Ellipse2D.Float(0, 0, 100, 100));
    ellipseCustomizer.setOpaque(false);
    ellipseCustomizer.setForeground(Color.BLUE);
    pane.addCustomizer(ellipseCustomizer, new AbsoluteTableConstraints(0, 150, 100, 100, ellipseCustomizer, itl));
    JShapeCustomizer rectangleCustomizer1 = new JShapeCustomizer(new Rectangle(0, 0, 150, 50));
    rectangleCustomizer1.setFilled(true);
    rectangleCustomizer1.setForeground(Color.RED);
    rectangleCustomizer1.setOpaque(false);
    pane.addCustomizer(rectangleCustomizer1, new AbsoluteTableConstraints(200,  300, 150, 50, rectangleCustomizer1, itl));
    JShapeCustomizer rectangleCustomizer2 = new JShapeCustomizer(new Rectangle(0, 0, 150, 50));
    rectangleCustomizer2.setForeground(Color.GREEN);
    rectangleCustomizer2.setOpaque(false);
    pane.addCustomizer(rectangleCustomizer2, new AbsoluteTableConstraints(400,  400, 150, 50, rectangleCustomizer2, itl));
    try{
      //      JImageCustomizer logoCustomizer = new JImageCustomizer(getImage(new URL(getDocumentBaseDir() + "logo.jpg")));
      //      pane.addCustomizer(logoCustomizer, new AbsoluteTableConstraints(150, 150, 200, 170, logoCustomizer, itl));
    } catch(Exception ex){
      ex.printStackTrace();
    }
  }
  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private org.softsmithy.lib.swing.JCustomizerPane pane;
  // End of variables declaration//GEN-END:variables
  
}
