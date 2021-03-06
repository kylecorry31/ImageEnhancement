package com.kylecorry.stargazer.ui;

import com.kylecorry.stargazer.imageProcessing.ImageProcessor;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.opencv.core.Mat;


/**
 * Created by Kylec on 5/12/2017.
 */
class SubtractionService extends Service<Mat> {

    private final ImageProcessor imageProcessor;
    private final Mat blackImage;
    private final Mat lightImage;

    public SubtractionService(ImageProcessor imageProcessor, Mat blackImage, Mat lightImage) {
        this.imageProcessor = imageProcessor;
        this.blackImage = blackImage;
        this.lightImage = lightImage;
    }

    @Override
    protected Task<Mat> createTask() {
        return new Task<Mat>() {

            @Override
            protected Mat call() {
                updateMessage("Calibrating normal frames using black frames");
                updateProgress(0, 1.0);
                Mat diff = imageProcessor.subtractImages(lightImage, blackImage);
                updateMessage("Calibrated images");
                updateProgress(1.0, 1.0);
                return diff;
            }
        };
    }
}
