package chapter1;

/**
 * 我们无法在扩展可实例化的类的同时，既增加新的值组件，同时又保留equals约定，除非愿意放弃面向对象的抽象所带来的优势
 */
public class ColorPoint extends Point{

    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * broken - violates transitivity(传递性)
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ColorPoint) {
            ColorPoint colorPoint = (ColorPoint) obj;
            return super.equals(obj) && colorPoint.color == this.color;
        } else if (obj instanceof Point ) {
            return super.equals(obj);
        } else {
            return false;
        }
    }



    /**
     * breoken - violates symmetry（对称性）
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof ColorPoint) {
//            return super.equals(obj) && ((ColorPoint) obj).color == color;
//        }
//        return false;
//    }



    public static void main(String[] args) {
        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
        ColorPoint colorPoint1 = new ColorPoint(1, 2, Color.WHITE);
        System.out.println(point.equals(colorPoint));
        System.out.println(colorPoint.equals(point));
        System.out.println(point.equals(colorPoint1));
        System.out.println(colorPoint1.equals(point));
        System.out.println(colorPoint.equals(colorPoint1));
    }

    public enum Color {
        RED,
        WHITE
    }
}
