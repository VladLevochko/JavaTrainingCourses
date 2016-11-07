package ua.training.lection5.example;

/**
 * Created by vlad on 04.11.16.
 */
public final class Line {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public Point getStart() {
        return new Point(start.getX(), start.getY());
    }

    public Point getEnd() {
        return new Point(end.getX(), end.getY());
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
