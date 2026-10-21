package vector.panel.drawing.dragoncurve;

import vector.panel.jpanel.Panel;
import vector.panel.jpanel.paincomponents.linecomponents.Line;
import vector.panel.jpanel.paincomponents.linecomponents.LineCoordinates;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        int iterations = 23;
        for (int j = 0; j < iterations; j++) {
            List<int[]> currentPath = new ArrayList<>(this.panel.path);
            int[] lastPath = currentPath.getLast();
            int cx = lastPath[0];
            int cy = lastPath[1];
            for(int i = currentPath.size() - 1; i >= 0; i--){
                int[] line = currentPath.get(i);

                int x2 = line[0];
                int y2 = line[1];

                int newX2 = cx - (y2 - cy);
                int newY2 = cy + (x2 - cx);

                this.panel.addPath(new int[]{newX2, newY2});
            }
        }
        this.panel.repaint();
    }

    public void paintFirstLine() {
        int x = (int) (Math.random() * Panel.dimension.width) + 1;
        int y = (int) (Math.random() * Panel.dimension.height) + 1;
        int lineLength = (int) (Math.random() * this.lineLengthRange) + 15;
        this.panel.addPath(new int[]{x, y});
        this.panel.addPath(new int[]{x+lineLength, y+lineLength});

    }
}
