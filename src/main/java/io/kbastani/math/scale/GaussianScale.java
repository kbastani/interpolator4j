package io.kbastani.math.scale;

/**
 * Interpolates a domain over a normally distributed range.
 *
 * @author Kenny Bastani
 */
public class GaussianScale extends LinearScale {

    public GaussianScale(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public GaussianScale(double[] domain, double[] range) {
        super(domain, range);
    }

    @Override
    protected double get(double val, double[] domain, double[] range) {
        double r = domain[1] / 2.0;
        double x1 = -r;
        double y1 = r;
        double g = val - r;
        double n = norm(new LinearScale(new double[]{x1, y1}, new double[]{-4.0, 4.0}).get(g));
        return Scales.linear(0, norm(0), range[0], range[1]).get(n);
    }

    public double norm(double x) {
        double a = 1.0;
        double u = 0.0;
        double g = (1.0 / Math.sqrt(2.0 * Math.PI * a));

        return g * Math.pow(Math.E, -(Math.pow(x - u, 2.0) / (2.0 * a)));
    }
}
