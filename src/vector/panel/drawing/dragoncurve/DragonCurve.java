package vector.panel.drawing.dragoncurve;

import java.awt.*;
import java.awt.geom.Path2D;

public class DragonCurve {
    public void addPoint(Path2D.Float path2D) {
        int iterations = 25;
        int totalSegments = 1 << iterations;
        float stepLength = 3.0f;
        float curX = 250.0f;
        float curY = 350.0f;
        path2D.moveTo(curX, curY);
        int direction = 0;
        for (int i = 1; i <= totalSegments; i++) {
            switch (direction) {
                case 0 -> curX += stepLength;
                case 1 -> curY += stepLength;
                case 2 -> curX -= stepLength;
                case 3 -> curY -= stepLength;
            }
            path2D.lineTo(curX, curY);
            int turn = (((i & -i) << 1) & i) == 0 ? 1 : -1;
            direction = (direction + turn + 4) % 4;
        }
    }
}
