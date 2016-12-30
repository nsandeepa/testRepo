package source;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nilupul on 12/28/16.
 */
public class Length_Elements {
    protected JPanel lengthPanel;
    protected JLabel headerLabel;
    protected JButton btn;

    protected JPanel length_elements() {
        lengthPanel = new JPanel();
        lengthPanel.setLayout(new FlowLayout());
        return lengthPanel;
    }
}
