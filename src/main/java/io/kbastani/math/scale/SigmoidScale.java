package io.kbastani.math.scale;

/**
 * The {@link SigmoidScale} will interpolate a range (x1, y1) into a domain (x2, y2) using a normal distribution.
 * This function will interpolate the range into a Sigmoid distribution.
 *
 * @author Kenny Bastani
 */
public class SigmoidScale extends LinearScale {

    private double window = 10;

    public SigmoidScale(double x1, double y1, double x2, double y2, double window) {
        super(x1, y1, x2, y2);
        this.window = window;
    }

    public SigmoidScale(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public SigmoidScale(double[] domain, double[] range) {
        super(domain, range);
    }

    private double get(double val, double[] domain, double[] range, double window) {
        double r = domain[1] / 2.0;
        double x1 = -r;
        double y1 = r;
        double g = val - r;
        double n = sigmoid(new LinearScale(new double[]{x1, y1}, new double[]{-window, window}).get(g));
        return Scales.linear(0, 1, range[0], range[1]).get(n);
    }

    @Override
    protected double get(double val, double[] domain, double[] range) {
        return get(val, domain, range, window);
    }

    public double get(double val, double window) {
        return get(val, this.getDomain(), this.getRange(), window);
    }

    public static double sigmoid(double x) {
        return (1 / (1 + Math.pow(Math.E, (-1 * x))));
    }
}
