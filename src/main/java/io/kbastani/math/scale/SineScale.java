package io.kbastani.math.scale;

/**
 * The {@link SineScale} will interpolate a range (x1, y1) into a domain (x2, y2) using a sine wave function.
 * This function will interpolate the range into a sine wave distribution.
 *
 * @author Kenny Bastani
 */
public class SineScale extends LinearScale {

	private double[] domain = new double[2];
	private double[] range = new double[2];
	private double frequency = 2;

	public SineScale(double x1, double y1, double x2, double y2, double frequency) {
		super(x1, y1, x2, y2);
		this.domain = new double[]{x1, y1};
		this.range = new double[]{x2, y2};
		this.frequency = frequency;
	}

	public SineScale(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);
		this.domain = new double[]{x1, y1};
		this.range = new double[]{x2, y2};
	}

	public SineScale(double[] domain, double[] range) {
		super(domain, range);
		this.domain = domain;
		this.range = range;
	}

	public double get(double val, double m) {
		return get(val, frequency, m);
	}

	public double get(double val, double hz, double m) {
		return get(val, domain, range, hz, m);
	}

	public double get(double val, double[] domain, double[] range, double hz, double m) {
		LinearScale piScale = new LinearScale(domain, new double[]{0, Math.PI * hz});

		LinearScale linearScale = new LinearScale(-1.0, 1.0, range[0], range[1]);

		return linearScale.get(Math.sin(piScale.get(val))) * m;
	}

	@Override
	protected double get(double val, double[] domain, double[] range) {
		return get(val, domain, range, frequency, 1.0);
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
}
