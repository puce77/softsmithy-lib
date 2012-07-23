/*
 *         COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Notice
 *
 * The contents of this file are subject to the COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL)
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.opensource.org/licenses/cddl1.txt
 *
 * The Original Code is SoftSmithy Utility Library. The Initial Developer of the
 * Original Code is Florian Brunner (Sourceforge.net user: puce). All Rights Reserved.
 *
 * Contributor(s): .
 */

package org.softsmithy.lib.awt.layout;



/**
 * Constants used by TableLayout.
 *
 * http://java.sun.com/products/jfc/tsc/articles/tablelayout/
 * @author  Daniel E. Barbalace
 */

public interface TableLayoutConstants
{



/** Indicates that the component is left justified in its cell */
public static final int LEFT = 0;

/** Indicates that the component is top justified in its cell */
public static final int TOP = 0;

/** Indicates that the component is centered in its cell */
public static final int CENTER = 1;

/** Indicates that the component is full justified in its cell */
public static final int FULL = 2;

/** Indicates that the component is bottom justified in its cell */
public static final int BOTTOM = 3;

/** Indicates that the component is right justified in its cell */
public static final int RIGHT = 3;

/** Indicates that the row/column should fill the available space */
public static final double FILL = -1.0;

/** Indicates that the row/column should be allocated just enough space to
    accomidate the preferred size of all components contained completely within
    this row/column. */
public static final double PREFERRED = -2.0;

/** Indicates that the row/column should be allocated just enough space to
    accomidate the minimum size of all components contained completely within
    this row/column. */
public static final double MINIMUM = -3.0;

/** Minimum value for an alignment */
public static final int MIN_ALIGN = 0;

/** Maximum value for an alignment */
public static final int MAX_ALIGN = 3;



}
