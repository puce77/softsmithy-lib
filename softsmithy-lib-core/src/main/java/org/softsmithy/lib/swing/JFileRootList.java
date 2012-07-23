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

package org.softsmithy.lib.swing;

import javax.swing.JList;
import org.softsmithy.lib.swing.filechooser.FileRootCellRenderer;
import org.softsmithy.lib.swing.filechooser.FileRootComboBoxModel;

/**
 *
 * @author puce
 */
public class JFileRootList extends JList{

    public JFileRootList() {
        super(new FileRootComboBoxModel());
        setCellRenderer(new XDefaultListCellRenderer(new FileRootCellRenderer()));
    }

}
