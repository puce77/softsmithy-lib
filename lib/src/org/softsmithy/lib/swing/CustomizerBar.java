/*
 * CustomizerBar.java
 *
 * Created on 11. September 2002, 16:47
 */

package org.softsmithy.lib.swing;

import java.awt.*;

/**
 *
 * @author  puce
 */
public interface CustomizerBar {
  void consumeSelection(JCustomizerPane pane, Point point);
  boolean hasSelection();
  void clearSelection();
}
