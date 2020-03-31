package io.kbastani.math.scale;

/**
 * Interpolates a domain over a linearly distributed range.
 *
 * @author Kenny Bastani
 */
public class LinearScale {

    private double[] domain = new double[2];
    private double[] range = new double[2];

    public LinearScale(double x1, double y1, double x2, double y2) {
        this.domain = new double[]{x1, y1};
        this.range = new double[]{x2, y2};
    }

    public LinearScale(double[] domain, double[] range) {
        this.domain = domain;
        this.range = range;
    }

    public double get(double val) {
        return get(val, domain, range);
    }

    protected double get(double val, double[] domain, double[] range) {
        double dD = Math.abs(domain[1] - domain[0]);
        double dV = Math.abs(val - domain[0]);
        double d = dV / dD;

        double rD = (range[1] - range[0]) * d;

        return Math.min(Math.max(range[0], (range[0] + rD)), range[1]);
    }

    public double invert(double val) {
        return get(val, range, domain);
    }

    public double[] getDomain() {
        return domain;
    }

    public void setDomain(double[] domain) {
        this.domain = domain;
    }

    public double[] getRange() {
        return range;
    }

    public void setRange(double[] range) {
        this.range = range;
    }
}
