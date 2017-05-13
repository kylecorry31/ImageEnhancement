package com.kylecorry.stargazer.ui;

import com.kylecorry.stargazer.imageProcessing.ImageProcessor;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.opencv.core.Mat;

import java.util.List;

/**
 * Created by Kylec on 5/12/2017.
 */
public class BlackImageService extends Service<Mat> {

    private ImageProcessor imageProcessor;

    private List<String> blackFiles;

    public BlackImageService(ImageProcessor imageProcessor, List<String> blackFiles) {
        this.imageProcessor = imageProcessor;
        this.blackFiles = blackFiles;
    }

    protected Task<Mat> createTask() {
        return new Task<Mat>() {
            @Override
            protected Mat call() throws Exception {
                updateProgress(0, 1.0);

                imageProcessor.imageNumber.addListener((observable, oldValue, newValue) -> {
                    updateMessage("Processing black frame " + newValue.intValue() + " of " + blackFiles.size());
                    updateProgress(newValue.intValue() / (double) blackFiles.size(), 1.0);
                });

                return imageProcessor.reduceNoise(blackFiles);
            }
        };
    }
}
