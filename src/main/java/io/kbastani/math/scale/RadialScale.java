package io.kbastani.math.scale;

/**
 * Creates a radially interpolated index which can be used to generate normally distributed matrices.
 * <p>
 * Here is an example of generating a scaled matrix of numbers between 0-5.
 * <p>
 * 0 0 0 2 4 4 2 0 0 0
 * 0 0 2 4 4 2 0 0 0 0
 * 0 2 4 4 2 0 0 0 0 0
 * 2 4 4 2 0 0 0 0 0 0
 * 4 4 2 0 0 0 0 0 0 2
 * 4 2 0 0 0 0 0 0 2 4
 * 2 0 0 0 0 0 0 2 4 4
 * 0 0 0 0 0 0 2 4 4 2
 * 0 0 0 0 0 2 4 4 2 0
 * 0 0 0 0 2 4 4 2 0 0
 *
 * @author Kenny Bastani
 */
public class RadialScale extends LinearScale {
    public RadialScale(double x1, double y1) {
        super(x1, y1, -Math.PI, Math.PI);
    }

    public RadialScale(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public double interpolate(double center, double index, double length) {
        double angle = (this.get((center + index) % (length)) - Math.PI) % (2.0 * Math.PI);
        double ang = this.invert(angle);
        LinearScale gaussian = Scales.gaussian(0, 1, 0, 1);
        return (gaussian.get((((length / 2.0) - ang) / (length / 2.0)) / 2.0));
    }
}
