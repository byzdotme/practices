package me.tony.practice.java17.sealeds;

/**
 * @author tony.zhuby
 */
public sealed class Shape permits Shape.Unknown, Polygon, Triangle, Rectangle {

    public String description() {
        return "this is a shape";
    }

    public static final class Unknown extends Shape {

    }

}
