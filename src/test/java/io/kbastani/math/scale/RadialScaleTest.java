package io.kbastani.math.scale;

import org.junit.jupiter.api.Test;

public class RadialScaleTest {

    @Test
    void interpolate() {
        int[] arr = new int[10];

        RadialScale radialScale = new RadialScale(0, arr.length - 1);

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print((int)(radialScale.interpolate(i, j, arr.length) * 5.0) + " ");
            }
            System.out.println();
        }
    }
}