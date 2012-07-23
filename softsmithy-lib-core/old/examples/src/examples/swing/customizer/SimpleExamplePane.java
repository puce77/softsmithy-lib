/*
 *         COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Notice
 *
 * The contents of this file are subject to the COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL)
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.opensource.org/licenses/cddl1.txt
 *
 * The Original Code is Examples of SoftSmithy Utility Library. The Initial Developer of the
 * Original Code is Florian Brunner (Sourceforge.net user: puce). All Rights Reserved.
 *
 * Contributor(s): .
 */

/*
 * Example1Pane.java
 *
 * Created on 10. April 2004, 15:28
 */

package examples.swing.customizer;

import javax.swing.*;
import org.softsmithy.lib.awt.layout.*;
import org.softsmithy.lib.swing.*;

/**
 *
 * @author  puce
 */
public class SimpleExamplePane extends JPanel {
  
  /** Creates new form Example1Pane */
  public SimpleExamplePane() {
    // create a pane that supports customizers and "snap-to-grid" feature
    initComponents();
    // create a CustomizerLayout (here: InfiniteTableLayout); set the default width and height of the cells to '50'
    InfiniteTableLayout itl = new InfiniteTableLayout(50, 50, pane);
    // set the layout
    pane.setCustomizerLayout(itl);
    // create a JCustomizer that wraps a component and listens to mouse events
    JCustomizer simpleCustomizer = new JCustomizer(new JLabel("A Simple Component"));
    // add it to the JCustomizerPane
    pane.addCustomizer(simpleCustomizer, new AbsoluteTableConstraints(0, 0, 150, 50, simpleCustomizer, itl));
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {//GEN-BEGIN:initComponents
    pane = new org.softsmithy.lib.swing.JCustomizerPane();

    setLayout(new java.awt.BorderLayout());

    add(pane, java.awt.BorderLayout.CENTER);

  }//GEN-END:initComponents
  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private org.softsmithy.lib.swing.JCustomizerPane pane;
  // End of variables declaration//GEN-END:variables
  
}
