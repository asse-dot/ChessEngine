package me.asse.chessengine.drawfigure;

import java.awt.*;

public class Arrow {

    public Segment r;
    public Segment b;
    public Segment c;

    private double beta;
    private int k;


    public Arrow(Segment r, int k, double beta) {
        this.r = r;
        this.beta = beta;
        this.k = k;
        setLineB();
        setLineC();
    }
    private void setLineB() {

    }

    private void setLineC() {
        double m_first = Math.tan(Math.toRadians(180 - this.beta - this.r.getAlfa()));
        double q_first = - (this.r.y2 - this.r.x2 * m_first);
        System.out.println(q_first);
        double x1 = this.r.x2 + this.k;
        double y1 = m_first * x1 + q_first;

        this.c = new Segment(this.r.x2, (int)x1, this.r.y2, (int)y1);

    }

    public Segment getLineB() {
        return this.b;
    }

    public Segment getLineC() {
        return this.c;
    }

    public void draw(Graphics g) {
        this.r.draw(g);
        this.c.draw(g);
    }
}
