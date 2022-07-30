import java.awt.Color;

import javax.swing.*;

public class SplitPane extends JFrame {

    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JSplitPane jsp;

    public SplitPane() {
        super("SplitPane example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p1.setBackground(Color.black);
        p1.add(new JTextArea());

        p2.setBackground(Color.red);

        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p1, p2);
        jsp.setDividerLocation(getWidth() / 2);
        setContentPane(jsp);

        setSize(300, 300);

        setLocationRelativeTo(null);

        setVisible(true);

    }
}