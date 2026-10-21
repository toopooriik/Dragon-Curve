package vector.panel.drawing.dragoncurve;

import vector.panel.jpanel.Panel;
import vector.panel.jpanel.paincomponents.linecomponents.Line;
import vector.panel.jpanel.paincomponents.linecomponents.LineCoordinates;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DragonCurve {
    private final Panel panel;
    private final int lineLengthRange;
    private final Color colorLine = Color.WHITE;
    private final float widthLine = 2.0f;

    public DragonCurve(Panel panel) {
        this.panel = panel;
        this.lineLengthRange = 20;
    }

    public void paint() {
        this.paintFirstLine();
        int iterations = 10;
        for (int j = 0; j < iterations  ; j++) {
            List<Line> currentLines = new ArrayList<>(this.panel.lines);
            Line lastLine = currentLines.getLast();
            int cx = lastLine.coordinates.x2;
            int cy = lastLine.coordinates.y2;
            for(int i = currentLines.size() - 1; i >= 0; i--){
                Line line = currentLines.get(i);

                int x1 = line.coordinates.x2;
                int y1 = line.coordinates.y2;
                int x2 = line.coordinates.x1;
                int y2 = line.coordinates.y1;

                int newX1 = cx - (y1 - cy);
                int newY1 = cy + (x1 - cx);
                int newX2 = cx - (y2 - cy);
                int newY2 = cy + (x2 - cx);

                this.panel.addLine(
                        new LineCoordinates(newX1, newY1, newX2, newY2),
                        this.colorLine,
                        this.widthLine
                );
            }
        }
    }

    public void paintFirstLine() {
        int x = (int) (Math.random() * Panel.dimension.width) + 1;
        int y = (int) (Math.random() * Panel.dimension.height) + 1;
        int lineLength = (int) (Math.random() * this.lineLengthRange) + 15;
        this.panel.addLine(
                new LineCoordinates(x, y, x+lineLength, y+lineLength),
                this.colorLine,
                this.widthLine
        );
    }
}
