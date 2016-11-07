package ua.training.lection5.example;

/**
 * Created by vlad on 04.11.16.
 */
public class Main {

    public static void main(String[] args) {
        final Point point = new Point(3, 4) /*{
            @Override
            public int getX() {
                return super.getX() + 100500;
            }

            @Override
            public int getY() {
                return super.getY() - 100500;
            }
        }*/;

//        System.out.println(point.getX() + " " + point.getY());

        Point initialStart = new Point(1, 2);
        Line line = new Line(initialStart, new Point(3, 4));
        Point start = line.getStart();
        start.setX(100500);

        initialStart.setY(100500);
        System.out.println(line);
    }
}
