//
//  Enums.h
//  CardRecognizer
//
//  Created by Vladimir Tchernitski on 16/03/16.
//  Copyright © 2016 Vladimir Tchernitski. All rights reserved.
//

#ifndef Enums_h
#define Enums_h

typedef enum RecognizerOrientation {
    RecognizerOrientationUnknown = 0,
    RecognizerOrientationPortrait = 1,
    RecognizerOrientationPortraitUpsideDown = 2,
    RecognizerOrientationLandscapeRight = 3,
    RecognizerOrientationLandscapeLeft = 4
} RecognizerOrientation;

typedef enum RecognizerMode {
    RecognizerModeNone = 0,
    RecognizerModeNumber = 1,
    RecognizerModeDate = 2,
    RecognizerModeName = 4,
    RecognizerModeGrabCardImage = 8
} RecognizerMode;


#endif /* Enums_h */
