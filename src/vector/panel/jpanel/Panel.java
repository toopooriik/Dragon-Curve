package vector.panel.jpanel;

import vector.panel.jpanel.paincomponents.linecomponents.Line;
import vector.panel.jpanel.paincomponents.linecomponents.LineCoordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
    public final List<Line> lines = new ArrayList<>();
    public final List<int[]> path = new ArrayList<>();

    private double zoom = 1.0;
    private double offsetX = 0;
    private double offsetY = 0;
    private Point dragStart;

    public static Dimension dimension = new Dimension(500, 500);

    public Panel() {
        setPreferredSize(Panel.dimension);
        setBackground(new Color(0, 0, 0));

        addMouseWheelListener((MouseWheelEvent e) -> {
               if(e.getPreciseWheelRotation() < 0) {
                   zoom *= 1.1;
               } else {
                   zoom /= 1.1;
               }
               repaint();
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(dragStart != null) {
                    offsetX += e.getX() - dragStart.x;
                    offsetY += e.getY() - dragStart.y;
                    dragStart = e.getPoint();
                    repaint();
                }
            }
        });

    }

    public void addLine(LineCoordinates coordinates, Color color, float widthLine) {
        this.lines.add(new Line(coordinates, color, widthLine));
        this.repaint();
    }
    public void addPath(int[] coordinates) {
        this.path.add(coordinates);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.translate(offsetX, offsetY);
        g2d.scale(zoom, zoom);
        Path2D.Float path = new Path2D.Float();

        int[] firstPathCoordinates = this.path.getFirst();

        path.moveTo(firstPathCoordinates[0], firstPathCoordinates[1]);
        for (int[] pathCoordinates : this.path) {
            path.lineTo(pathCoordinates[0], pathCoordinates[1]);
        }
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(path);
    }
}
