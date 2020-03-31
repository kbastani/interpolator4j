package io.kbastani.math.scale;

/**
 * This is a factory class for instantiating different scales that interpolates a value over a range inside a
 * target domain.
 *
 * @author Kenny Bastani
 */
public class Scales {

    /**
     * The linear scale will interpolate a range (x1, y1) into a domain (x2, y2) using a linear scale. This is more
     * commonly known as linear interpolation.
     *
     * @param x1 is the lower bound of the range to convert from
     * @param y1 is the upper bound of the range to convert from
     * @param x2 is the lower bound of the range to convert to
     * @param y2 is the upper bound of the range to convert to
     * @return a {@link LinearScale} with the specified range and domain attribute
     */
    public static LinearScale linear(double x1, double y1, double x2, double y2) {
        return new LinearScale(x1, y1, x2, y2);
    }

    public static LinearScale linear(double x1, double y1) {
        return new LinearScale(x1, y1, 0.0, 1.0);
    }

    /**
     * The {@link PowScale} will interpolate a range (x1, y1) into a domain (x2, y2) using an exponential scale. This
     * is more commonly known as exponential interpolation.
     *
     * @param x1 is the lower bound of the range to convert from
     * @param y1 is the upper bound of the range to convert from
     * @param x2 is the lower bound of the range to convert to
     * @param y2 is the upper bound of the range to convert to
     * @return a {@link PowScale} with the specified range and domain attribute
     */
    public static PowScale pow(double x1, double y1, double x2, double y2) {
        return new PowScale(x1, y1, x2, y2);
    }

    /**
     * The {@link SineScale} will interpolate a range (x1, y1) into a domain (x2, y2) using a sine scale. This is not a
     * common method of interpolation. The purpose of this scale is to interpolate linearly over a sine function
     * with a specified period (hz) and amplitude. This is typically used for generating signals varying frequencies.
     * This scale is typically used to generate realistic sounds by approximating an analog signal.
     *
     * @param x1 is the lower bound of the range to convert from
     * @param y1 is the upper bound of the range to convert from
     * @param x2 is the lower bound of the range to convert to
     * @param y2 is the upper bound of the range to convert to
     * @return a {@link LinearScale} with the specified range and domain attribute
     */
    public static SineScale sine(double x1, double y1, double x2, double y2) {
        return new SineScale(x1, y1, x2, y2);
    }

    public static SineScale sine(double x1, double y1, double x2, double y2, double hz) {
        return new SineScale(x1, y1, x2, y2, hz);
    }

    /**
     * The {@link GaussianScale} will interpolate a range (x1, y1) into a domain (x2, y2) using a normal distribution.
     * This function will interpolate the range into a Gaussian distribution.
     *
     * @param x1 is the lower bound of the range to convert from
     * @param y1 is the upper bound of the range to convert from
     * @param x2 is the lower bound of the range to convert to
     * @param y2 is the upper bound of the range to convert to
     * @return a {@link GaussianScale} with the specified range and domain attribute
     */
    public static GaussianScale gaussian(double x1, double y1, double x2, double y2) {
        return new GaussianScale(x1, y1, x2, y2);
    }

	/**
	 * The {@link SigmoidScale} will interpolate a range (x1, y1) into a domain (x2, y2) using a normal distribution.
	 * This function will interpolate the range into a Sigmoid distribution.
	 *
	 * @param x1 is the lower bound of the range to convert from
	 * @param y1 is the upper bound of the range to convert from
	 * @param x2 is the lower bound of the range to convert to
	 * @param y2 is the upper bound of the range to convert to
	 * @return a {@link SigmoidScale} with the specified range and domain attribute
	 */
    public static SigmoidScale sigmoid(double x1, double y1, double x2, double y2) {
        return new SigmoidScale(x1, y1, x2, y2);
    }
}
