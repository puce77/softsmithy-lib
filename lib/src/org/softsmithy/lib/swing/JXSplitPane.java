/*
 *                  Sun Public License Notice
 *
 * The contents of this file are subject to the Sun Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.sun.com/
 *
 * The Original Code is SoftSmithy Utility Library. The Initial Developer of the
 * Original Code is Florian Brunner (Sourceforge.net user: puce). All Rights Reserved.
 *
 * Contributor(s): .
 */

/*
 * JXSplitPane.java
 *
 * Created on 6. Mai 2003, 09:05
 */

package org.softsmithy.lib.swing;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import javax.swing.*;
import org.softsmithy.lib.swing.customizer.*;
import org.softsmithy.lib.swing.style.*;


/**
 *
 * @author  puce
 */
public class JXSplitPane extends JSplitPane implements Styleable{
  
  /** Holds value of property noneStyle. */
  private final Style noneStyle = new NoneStyle();
  
  /** Holds value of property parentStyle. */
  private final Style parentStyle = new ParentStyle();
  
  /** Holds value of property style. */
  private Style style = noneStyle;
  
  private boolean inited = false;
  
  public JXSplitPane(){
    inited = true;
  }
  
  public JXSplitPane(int newOrientation){
    super(newOrientation);
    inited = true;
  }
  
  public JXSplitPane(int newOrientation, boolean newContinuousLayout){
    super(newOrientation, newContinuousLayout);
    inited = true;
  }
  
  public JXSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent, Component newRightComponent){
    super(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent);
    inited = true;
  }
  
  public JXSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent){
    super(newOrientation, newLeftComponent, newRightComponent);
    inited = true;
  }
  
  
  /** Getter for property style.
   * @return Value of property style.
   *
   */
  public Style getStyle() {
    return this.style;
  }
  
  /** Setter for property style.
   * @param style New value of property style.
   *
   */
  public void setStyle(Style style) {
    Style oldStyle = this.style;
    oldStyle.stopListening();
    if (style == null){
      this.style = getNoneStyle();
    } else {
      this.style = style.getStyleProvider().getStyle(this);
    }
    this.style.startListening();
    setBackgroundOnly(this.style.getBackground());
    setForegroundOnly(this.style.getForeground());
    setFontOnly(this.style.getFont());
    setOpaqueOnly(this.style.isOpaque());
    firePropertyChange("style", oldStyle, this.style);
  }
  
  private void ensureNoneStyle(){
    if (inited && ! style.isNull()){
      setStyle(getNoneStyle());
    }
  }
  
  /** Getter for property noneStyle.
   * @return Value of property noneStyle.
   *
   */
  public Style getNoneStyle() {
    return this.noneStyle;
  }
  
  /** Getter for property parentStyle.
   * @return Value of property parentStyle.
   *
   */
  public Style getParentStyle() {
    return this.parentStyle;
  }
  
  /** Gets the background color of this component.
   * @return this component's background color; if this component does
   * 		not have a background color,
   * 		the background color of its parent is returned
   * @see #setBackground
   * @since JDK1.0
   *
   */
  public Color getBackground() {
    if (inited){
      return getStyle().getBackground();
    } else {
      return super.getBackground();
    }
    //return (fComponent != null) ? fComponent.getBackground() : super.getBackground();
  }
  
  /** Sets the background color of this component.
   *
   * @param bg the desired background <code>Color</code>
   * @see java.awt.Component#getBackground
   *
   * @beaninfo
   *    preferred: true
   *        bound: true
   *    attribute: visualUpdate true
   *  description: The background color of the component.
   *
   */
  public void setBackground(Color bg) {
    ensureNoneStyle();
    setBackgroundOnly(bg);
  }
  
  protected void setBackgroundOnly(Color bg){
    super.setBackground(bg);
  }
  
  /** Gets the foreground color of this component.
   * @return this component's foreground color; if this component does
   * not have a foreground color, the foreground color of its parent
   * is returned
   * @see #setForeground
   * @since JDK1.0
   * @beaninfo
   *       bound: true
   *
   */
  public Color getForeground() {
    if (inited){
      return getStyle().getForeground();
    } else {
      return super.getForeground();
    }
    //return (fComponent != null) ? fComponent.getForeground() : super.getForeground();
  }
  
  
  /** Sets the foreground color of this component.
   *
   * @param fg  the desired foreground <code>Color</code>
   * @see java.awt.Component#getForeground
   *
   * @beaninfo
   *    preferred: true
   *        bound: true
   *    attribute: visualUpdate true
   *  description: The foreground color of the component.
   *
   */
  public void setForeground(Color fg) {
    ensureNoneStyle();
    setForegroundOnly(fg);
  }
  
  protected void setForegroundOnly(Color fg){
    super.setForeground(fg); // to update listeners etc.
  }
  
  /** Gets the font of this component.
   * @return this component's font; if a font has not been set
   * for this component, the font of its parent is returned
   * @see #setFont
   * @since JDK1.0
   *
   */
  public Font getFont() {
    if (inited){
      return getStyle().getFont();
    } else {
      return super.getFont();
    }
    //return (fComponent != null) ? fComponent.getFont() : super.getFont();
  }
  
  /** Sets the font for this component.
   *
   * @param the desired <code>Font</code> for this component
   * @see java.awt.Component#getFont
   *
   * @beaninfo
   *    preferred: true
   *        bound: true
   *    attribute: visualUpdate true
   *  description: The font for the component.
   *
   */
  public void setFont(Font font) {
    ensureNoneStyle();
    setFontOnly(font);
  }
  
  protected void setFontOnly(Font font){
    super.setFont(font);
  }
  
  /** Returns true if this component is completely opaque.
   * <p>
   * An opaque component paints every pixel within its
   * rectangular bounds. A non-opaque component paints only a subset of
   * its pixels or none at all, allowing the pixels underneath it to
   * "show through".  Therefore, a component that does not fully paint
   * its pixels provides a degree of transparency.
   * <p>
   * Subclasses that guarantee to always completely paint their contents
   * should override this method and return true.
   *
   * @return true if this component is completely opaque
   * @see #setOpaque
   *
   */
  public boolean isOpaque() {
    if (inited){
      return getStyle().isOpaque();
    } else {
      return super.isOpaque();
    }
    //return (fComponent != null) ? fComponent.isOpaque() : super.isOpaque();
  }
  
  /** If true the component paints every pixel within its bounds.
   * Otherwise, the component may not paint some or all of its
   * pixels, allowing the underlying pixels to show through.
   * <p>
   * The default value of this property is false for <code>JComponent</code>.
   * However, the default value for this property on most standard
   * <code>JComponent</code> subclasses (such as <code>JButton</code> and
   * <code>JTree</code>) is look-and-feel dependent.
   *
   * @param isOpaque  true if this component should be opaque
   * @see #isOpaque
   * @beaninfo
   *        bound: true
   *       expert: true
   *  description: The component's opacity
   *
   */
  public void setOpaque(boolean isOpaque) {
    ensureNoneStyle();
    setOpaqueOnly(isOpaque);
  }
  
  
  
  protected void setOpaqueOnly(boolean isOpaque){
    super.setOpaque(isOpaque);
  }
  
  
  
  protected class NoneStyle implements Style{
    
    public Color getBackground() {
      return JXSplitPane.super.getBackground();
    }
    
    public Font getFont() {
      return JXSplitPane.super.getFont();
    }
    
    public Color getForeground() {
      return JXSplitPane.super.getForeground();
    }
    
    public String getName(Locale locale) {
      return Customizers.getNoneStyleName(locale);
    }
    
    public boolean isOpaque() {
      return JXSplitPane.super.isOpaque();
    }
    
    public boolean isNull() {
      return true;
    }
    
    public StyleProvider getStyleProvider(){
      return NoneStyleProvider.INSTANCE;
    }
    
    public void startListening() {
    }
    
    public void stopListening() {
    }
    
  }
  
  public class ParentStyle extends AbstractStyle{
    private HierarchyListener parentListener = new ParentListener();
    private PropertyChangeListener parentBackgroundListener = new ParentBackgroundListener();
    private PropertyChangeListener parentForegroundListener = new ParentForegroundListener();
    private PropertyChangeListener parentFontListener = new ParentFontListener();
    private PropertyChangeListener parentOpaqueListener = new ParentOpaqueListener();
    
    public Color getBackground() {
      return JXSplitPane.this.getParent() != null ? JXSplitPane.this.getParent().getBackground() :
        JXSplitPane.this.getNoneStyle().getBackground();
    }
    
    public Font getFont() {
      return JXSplitPane.this.getParent() != null ? JXSplitPane.this.getParent().getFont() :
        JXSplitPane.this.getNoneStyle().getFont();
    }
    
    public Color getForeground() {
      return JXSplitPane.this.getParent() != null ? JXSplitPane.this.getParent().getForeground() :
        JXSplitPane.this.getNoneStyle().getForeground();
    }
    
    public String getName(Locale locale) {
      return Customizers.getParentStyleName(locale);
    }
    
    public boolean isOpaque() {
      return JXSplitPane.this.getParent() != null ? JXSplitPane.this.getParent().isOpaque() :
        JXSplitPane.this.getNoneStyle().isOpaque();
    }
    
    public StyleProvider getStyleProvider(){
      return ParentStyleProvider.INSTANCE;
    }
    
    public void startListening() {
      super.startListening();
      JXSplitPane.this.addHierarchyListener(parentListener);
      if (JXSplitPane.this.getParent() != null){
        JXSplitPane.this.getParent().addPropertyChangeListener("background", parentBackgroundListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("foreground", parentForegroundListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("font", parentFontListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("opaque", parentOpaqueListener);
      }
      
    }
    
    public void stopListening() {
      super.stopListening();
      JXSplitPane.this.removeHierarchyListener(parentListener);
      if (JXSplitPane.this.getParent() != null){
        JXSplitPane.this.getParent().removePropertyChangeListener("background", parentBackgroundListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("foreground", parentForegroundListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("font", parentFontListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("opaque", parentOpaqueListener);
      }
    }
    
    private class ParentListener implements HierarchyListener{
      
      /** Called when the hierarchy has been changed. To discern the actual
       * type of change, call <code>HierarchyEvent.getChangeFlags()</code>.
       *
       * @see HierarchyEvent#getChangeFlags()
       *
       */
      public void hierarchyChanged(HierarchyEvent e) {
        System.out.println("hierarchyChanged");
        // optimize??
        JXSplitPane.this.getParent().removePropertyChangeListener("background", parentBackgroundListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("foreground", parentForegroundListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("font", parentFontListener);
        JXSplitPane.this.getParent().removePropertyChangeListener("opaque", parentOpaqueListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("background", parentBackgroundListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("foreground", parentForegroundListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("font", parentFontListener);
        JXSplitPane.this.getParent().addPropertyChangeListener("opaque", parentOpaqueListener);
      }
      
    }
    
    private class ParentBackgroundListener implements PropertyChangeListener{
      
      /** This method gets called when a bound property is changed.
       * @param evt A PropertyChangeEvent object describing the event source
       *   	and the property that has changed.
       *
       */
      public void propertyChange(PropertyChangeEvent evt) {
        JXSplitPane.this.setBackgroundOnly((Color) evt.getNewValue());
      }
      
    }
    private class ParentForegroundListener implements PropertyChangeListener{
      
      /** This method gets called when a bound property is changed.
       * @param evt A PropertyChangeEvent object describing the event source
       *   	and the property that has changed.
       *
       */
      public void propertyChange(PropertyChangeEvent evt) {
        JXSplitPane.this.setForegroundOnly((Color) evt.getNewValue());
      }
      
    }
    
    private class ParentFontListener implements PropertyChangeListener{
      
      /** This method gets called when a bound property is changed.
       * @param evt A PropertyChangeEvent object describing the event source
       *   	and the property that has changed.
       *
       */
      public void propertyChange(PropertyChangeEvent evt) {
        JXSplitPane.this.setFontOnly((Font) evt.getNewValue());
      }
      
    }
    
    private class ParentOpaqueListener implements PropertyChangeListener{
      
      /** This method gets called when a bound property is changed.
       * @param evt A PropertyChangeEvent object describing the event source
       *   	and the property that has changed.
       *
       */
      public void propertyChange(PropertyChangeEvent evt) {
        JXSplitPane.this.setOpaqueOnly(((Boolean) evt.getNewValue()).booleanValue());
      }
      
    }
  }
  
}
