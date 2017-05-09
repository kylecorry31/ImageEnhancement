package com.kylecorry.imageEnhancement;

import java.awt.*;

/**
 * Created by Kylec on 5/9/2017.
 */
public class RotationMath {

    public static Point centerOfRotation(Point a, Point aPrime, Point b, Point bPrime) {
        Pair mA = midPoint(a, aPrime);
        double sPA = -1 / slope(a, aPrime);
        Pair mB = midPoint(b, bPrime);
        double sPB = -1 / slope(b, bPrime);
        double x = (sPA * (-mA.x) + mA.y + sPB * mB.x - mB.y) / (sPB - sPA);
        double y = (sPA * x + sPA * -mA.x + mA.y);
        return new Point((int) Math.round(x), (int) Math.round(y));
    }


    static double slope(Point a, Point b) {
        return (b.y - a.y) / (double) (b.x - a.x);
    }

    static Pair midPoint(Point a, Point b) {
        return new Pair((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
    }

    public static double angleBetween(Point origin, Point a, Point b) {

        Point normA = new Point(a.x - origin.x, a.y - origin.y);
        Point normB = new Point(b.x - origin.x, b.y - origin.y);

        return Math.atan2(normB.y, normB.x) - Math.atan2(normA.y, normA.x);
    }


    static class Pair {
        public double x, y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return other.x == x && other.y == y;
        }
    }
}
