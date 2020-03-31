package io.kbastani.math.stats;

/**
 * Used to easily create statistical moving averages.
 *
 * @author Kenny Bastani
 */
public class MovingAverage {

	private int size;
	private double total = 0d;
	private int index = 0;
	private final double[] samples;
	private int added = 0;

	public MovingAverage(int size) {
		this.size = size;
		this.samples = new double[size];
		for (int i = 0; i < size; i++) samples[i] = 0d;
	}

	public void add(double x) {
		synchronized (samples) {
			added++;
			total -= samples[index];
			samples[index] = x;
			total += x;
			if (++index == size) index = 0;
		}
	}

	public double getAverage() {
		return total / Math.min(added, size);
	}
}
