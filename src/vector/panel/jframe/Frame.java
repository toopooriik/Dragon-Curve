package vector.panel.jframe;

import vector.panel.jpanel.Panel;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private final Panel panel;

    public Frame() {
        this.panel = new Panel();
    }

    public void init() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Тест");
            this.start(frame);

        });
    }


    private void start(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(0));
        frame.add(this.panel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
