# Custom Watch face for an Android Wear

![alt text](https://raw.githubusercontent.com/9elements/9elements-One-for-Android-Wear/master/9elements-one-blog.jpg "Custom Watch Face - 9elements One")

This is an example project that shows you how to implement a custom watch face.
The main project codes lies in the

## Modifying the AndroidManifest.xml

```
<activity
    android:theme="@android:style/Theme.DeviceDefault.NoActionBar"
    android:name=".NineWatchWearActivity"
    android:label="@string/app_name"
    android:allowEmbedded="true"
    >
    <!-- Preview for when the user goes to change watchfaces -->
    <meta-data android:name="com.google.android.clockwork.home.preview" android:resource="@drawable/preview" />
    <!-- Intent filter to make the activity show up in the watchface choices -->
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="com.google.android.clockwork.home.category.HOME_BACKGROUND" />
    </intent-filter>
</activity>
<meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version" />
```

# TODO

* Using `WatchViewStub` to differentiate between a square or round wearable.
* Finding out why the dim removes the views when the debug cable is connected.
* Checking why the battery is drained so fast.

# ENVIRONMENT

This example has been created with AndroidStudio 0.8.1 - it has also been tested on the Samsung Gear Live.

# CREDITS

Most of the code was found in a reddit thread. Thanks to the authors:

http://www.reddit.com/r/androiddev/comments/297r7m/watch_face_development_on_android_wear/

the design of the clock is inspired by this article:

http://java-articles.info/articles/?p=555

# License

Copyright (C) 2014 9elements GmbH

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is furnished to do
so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
