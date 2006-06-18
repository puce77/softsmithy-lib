/*
 * VisualFieldPane.java
 *
 * Created on 4. Mai 2006, 23:22
 */

package org.softsmithy.vep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Timer;
import org.softsmithy.lib.swing.icon.FullZooming;
import org.softsmithy.lib.swing.icon.XIcon;
import org.softsmithy.lib.swing.icon.XIcons;

/**
 *
 * @author  florian.brunner
 */
public class VisualFieldPane extends javax.swing.JPanel {
    
    private VisualField visualField;
    private Timer timer;
    private int currentIndex = 0;
    /**
     * Holds value of property visualFieldTest.
     */
    private VisualFieldTest visualFieldTest;
    private List<XIcon> visualFieldImages;
    private Map<XIcon, XIcon> scaledVisualFieldImages = new HashMap<XIcon, XIcon>();
    
    /** Creates new form VisualFieldPane */
    public VisualFieldPane() {
        initComponents();
        visualField = new VisualField(50, 150, 16, 4);
        timer = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextImage();
            }
        });
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                scaledVisualFieldImages.clear();
                displayCurrentImage();
            }
            
        });
    }
    
    private void nextImage(){
        if (currentIndex == (visualFieldImages.size() - 1)){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        displayCurrentImage();
    }
    
    public void start(){
        currentIndex = 0;
        timer.start();
    }
    
    public void stop(){
        timer.stop();
        currentIndex = 0;
    }
    
    private void displayCurrentImage(){
        XIcon currentIcon = visualFieldImages.get(currentIndex);
        XIcon icon;
        if (scaledVisualFieldImages.containsKey(currentIcon)){
            icon = scaledVisualFieldImages.get(currentIcon);
        } else {
            icon = XIcons.calculateScaledIcon(currentIcon, 
                    FullZooming.RESPECTING_ASPECT_RATIO_INSTANCE, 
                    this);
            scaledVisualFieldImages.put(currentIcon, icon);
        }
        visualFieldImageLabel.setIcon(icon);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        visualFieldImageLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        visualFieldImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(visualFieldImageLabel, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel visualFieldImageLabel;
    // End of variables declaration//GEN-END:variables
    
    
    
    /**
     * Getter for property visualFieldTest.
     * @return Value of property visualFieldTest.
     */
    public VisualFieldTest getVisualFieldTest() {
        return this.visualFieldTest;
    }
    
    /**
     * Setter for property visualFieldTest.
     * @param visualFieldTest New value of property visualFieldTest.
     */
    public void setVisualFieldTest(VisualFieldTest visualFieldTest) {
        this.visualFieldTest = visualFieldTest;
        visualFieldImages = visualFieldTest.getImages(visualField);
        scaledVisualFieldImages.clear();
    }


    /**
     * Setter for property frequency.
     * @param frequency New value of property frequency.
     */
    public void setFrequency(int frequency) {
        timer.setDelay(1000/frequency);
    }
    
}
