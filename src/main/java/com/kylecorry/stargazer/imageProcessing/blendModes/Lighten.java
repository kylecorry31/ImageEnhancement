package com.kylecorry.stargazer.imageProcessing.blendModes;

import org.opencv.core.Core;
import org.opencv.core.Mat;

public class Lighten implements Blender {
    @Override
    public Mat blend(Mat a, Mat b) {
        Mat blended = new Mat();
        Core.max(a, b, blended);
        return blended;
    }
}
