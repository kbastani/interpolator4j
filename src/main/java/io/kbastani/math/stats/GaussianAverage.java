package io.kbastani.math.stats;

import io.kbastani.math.scale.GaussianScale;

/**
 * Creates a moving average that scales to a gaussian where the samples are re-normalized under a basic normal
 * distribution. Basically, the moving average puts less emphasis on the newest and oldest samples.
 *
 * @author Kenny Bastani
 */
public class GaussianAverage {

    private int size;
    private double total = 0d;
    private int index = 0;
    private double samples[];
    private GaussianScale scale;

    public GaussianAverage(int size) {
        this.size = size;
        this.samples = new double[size];
        this.scale = new GaussianScale(0, size, 0, 1);
        for (int i = 0; i < size; i++) samples[i] = 0d;
    }

    public void add(double x) {
        total -= samples[index];
        samples[index] = x * (((((scale.get(index))))));
        total += samples[index];
        if (++index == size) index = 0;
    }

    public double getAverage() {
        return total / size;
    }
}
