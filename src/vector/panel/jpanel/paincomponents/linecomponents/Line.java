package vector.panel.jpanel.paincomponents.linecomponents;

import java.awt.*;

public class Line {
    public final LineCoordinates coordinates;
    public final Color color;
    public final float width;
    public Line(
            LineCoordinates coordinates,
            Color color,
            float width
    ) {
        this.coordinates = coordinates;
        this.color = color;
        this.width = width;
    }

}
