package io.kbastani.math.scale;

import org.junit.Assert;
import org.junit.Test;

public class LinearScaleTest {
    @Test
    public void get() {
        LinearScale scale = new LinearScale(new double[]{-5.0, 5.0}, new double[]{0.0, 10.0});
        double actual = scale.get(0.0);
        double expected = 5.0;
        Assert.assertEquals(expected, actual, 0.0);

        expected = 0.0;
        actual = scale.get(-5.0);
        Assert.assertEquals(expected, actual, 0.0);

        expected = 10.0;
        actual = scale.get(5.0);
        Assert.assertEquals(expected, actual, 0.0);

        scale = new LinearScale(new double[]{0.0, 2.0}, new double[]{-1.0, 1.0});
        actual = scale.get(0.0);
        expected = -1.0;
        Assert.assertEquals(expected, actual, 0.0);

        actual = scale.get(1.0);
        expected = 0.0;
        Assert.assertEquals(expected, actual, 0.0);

        actual = scale.get(2.0);
        expected = 1.0;
        Assert.assertEquals(expected, actual, 0.0);

        actual = scale.get(1.5);
        expected = .5;
        Assert.assertEquals(expected, actual, 0.0);

        scale = new LinearScale(new double[]{0, 900}, new double[]{0.0, 1.0});

        expected = .5;
        actual = scale.get(450);
        Assert.assertEquals(expected, actual, 0.0);

        expected = 1;

        PowScale powScale = new PowScale(new double[]{0, 10}, new double[]{0.0, 1.0});

        actual = powScale.get(10, 2);
        Assert.assertEquals(expected, actual, 0.0);

        expected = .25;
        actual = powScale.get(5, 2);
        Assert.assertEquals(expected, actual, 0.0);
    }
}