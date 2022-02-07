package me.asse.chessengine.drawfigure;

import java.awt.*;

public class Segment {

    public int x1;
    public int x2;
    public int y1;
    public int y2;

    private double m;
    private double q;
    private double alfa;

    public Segment(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        this.m = -(this.y2 - this.y1) / (this.x2 - this.x1);
        this.q = this.x1 * m - y1;
        this.alfa = Math.toDegrees(Math.atan(m));
    }

    public double get_coefficient_angular() {
        return this.m;
    }

    public double get_know_term() {
        return this.q;
    }

    public double getAlfa() {
        return this.alfa;
    }

    public void draw(Graphics g) {
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }



}
