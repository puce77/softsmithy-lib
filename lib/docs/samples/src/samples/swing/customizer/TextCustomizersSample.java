/*
 * TextCustomizersSample.java
 *
 * Created on 8. April 2007, 12:49
 */

package samples.swing.customizer;

import org.softsmithy.lib.awt.layout.AbsoluteTableConstraints;
import org.softsmithy.lib.awt.layout.InfiniteTableLayout;
import org.softsmithy.lib.swing.JButtonCustomizer;
import org.softsmithy.lib.swing.JHtmlCustomizer;
import org.softsmithy.lib.swing.JLabelCustomizer;

/**
 *
 * @author  Florian
 */
public class TextCustomizersSample extends javax.swing.JFrame {
    
    /** Creates new form TextCustomizersSample */
    public TextCustomizersSample() {
        initComponents();
         // create a CustomizerLayout
        InfiniteTableLayout itl = new InfiniteTableLayout(customizerPane);
        // set the layout
        customizerPane.setCustomizerLayout(itl);
        // create a JLabelCustomizer, which supports inline editing of a text
        JLabelCustomizer labelCustomizer = new JLabelCustomizer("A Label Customizer - double click to edit!");
        // add it to the JCustomizerPane
        customizerPane.addCustomizer(labelCustomizer, new AbsoluteTableConstraints(50, 50,  270, 20, labelCustomizer, itl));
        // create a JButtonCustomizer, which supports inline editing of a text
        JButtonCustomizer buttonCustomizer = new JButtonCustomizer("Double click to edit this button!");
        // add it to the JCustomizerPane
        customizerPane.addCustomizer(buttonCustomizer, new AbsoluteTableConstraints(300, 100,  210, 50, buttonCustomizer, itl));
        // create a JLabelCustomizer, which supports inline editing of a text
        JHtmlCustomizer htmlCustomizer = new JHtmlCustomizer();
        htmlCustomizer.setHtmlBody("<b>This is an <i>editable</i> HTML</b> text! Double click!<br> " +
                "<a href=\"http://www.softsmithy.org\">This is a link!</a><br>" +
                "<font color=\"#FF0000\">And this </font>" +
                "<font color=\"#00FF00\">is a </font>" +
                "<font color=\"#00FFFF\">colored text!</font><br><br>" +
                "This is a very long text that shows automatic line wrapping!");
        // add it to the JCustomizerPane
        customizerPane.addCustomizer(htmlCustomizer, new AbsoluteTableConstraints(150, 200,  270, 150, htmlCustomizer, itl));
        setSize(640, 480);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        contentPane = new javax.swing.JPanel();
        contentScrollPane = new javax.swing.JScrollPane();
        customizerPane = new org.softsmithy.lib.swing.JCustomizerPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Text Customizers Sample");
        contentPane.setLayout(new java.awt.BorderLayout());

        contentScrollPane.setViewportView(customizerPane);

        contentPane.add(contentScrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextCustomizersSample().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JScrollPane contentScrollPane;
    private org.softsmithy.lib.swing.JCustomizerPane customizerPane;
    // End of variables declaration//GEN-END:variables
    
}
