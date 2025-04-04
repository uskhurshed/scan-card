package scan.ndk;

import androidx.annotation.IntRange;

import scan.ndk.RecognitionConstants.WorkAreaOrientation;

public interface DisplayConfiguration {
    @WorkAreaOrientation
    int getNativeDisplayRotation();

    @IntRange(from=0, to=360)
    int getPreprocessFrameRotation(int width, int height);
}
