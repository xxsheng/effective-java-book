package chapter1;

public class ColorPoint1 {
    Point point;
    ColorPoint.Color color;

    public ColorPoint1(int x, int y, ColorPoint.Color color) {
        if (color == null) {
            throw new NullPointerException();
        }
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint1)) {
            return false;
        }

        return ((ColorPoint1) obj).point.equals(point) && ((ColorPoint1) obj).color == color;
    }
}
