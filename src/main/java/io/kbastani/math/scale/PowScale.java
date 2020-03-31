package io.kbastani.math.scale;

/**
 * Interpolates a domain over an exponentially distributed range.
 *
 * @author Kenny Bastani
 */
public class PowScale extends LinearScale {

    private double[] domain = new double[2];
    private double[] range = new double[2];
    private double exp = 1.0;

    public PowScale(double x1, double y1, double x2, double y2, double[] domain, double[] range, double exp) {
        super(x1, y1, x2, y2);
        this.domain = domain;
        this.range = range;
        this.exp = exp;
    }

    public PowScale(double[] domain, double[] range, double[] domain1, double[] range1, double exp) {
        super(domain, range);
        this.domain = domain1;
        this.range = range1;
        this.exp = exp;
    }

    public PowScale(double x1, double y1, double x2, double y2, double exp) {
        super(x1, y1, x2, y2);
        this.domain = new double[]{x1, y1};
        this.range = new double[]{x2, y2};
        this.exp = exp;
    }

    public PowScale(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
        this.domain = new double[]{x1, y1};
        this.range = new double[]{x2, y2};
    }

    public PowScale(double[] domain, double[] range) {
        super(domain, range);
        this.domain = domain;
        this.range = range;
    }

    public double get(double val, double exp) {
        return get(val, domain, range, exp);
    }

    @Override
    protected double get(double val, double[] domain, double[] range) {
        return get(val, domain, range, exp);
    }

    private double get(double val, double[] domain, double[] range, double exp) {
        double dD = Math.abs(Math.pow(domain[1], exp) - domain[0]);
        double dV = Math.abs(Math.pow(val, exp) - domain[0]);
        double d = dV / dD;

        double rD = (range[1] - range[0]) * d;

        if (rD > domain[1]) {
            return range[1];
        } else if (rD < domain[0]) {
            return range[0];
        }

        return (range[0] + rD);
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }
}
