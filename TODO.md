# Bug

## Using ´WatchViewStub´ to differentiate between a square or round wearable.

## When relaunching the app while swiping right:

6659-6659/firstwatch.com.nineelements.nineelementswatch E/ActivityThread﹕ Activity firstwatch.com.nineelements.nineelementswatch.NineWatchWearActivity has leaked IntentReceiver firstwatch.com.nineelements.nineelementswatch.NineWatchWearActivity$1@ae0843b8 that was originally registered here. Are you missing a call to unregisterReceiver()?
    android.app.IntentReceiverLeaked: Activity firstwatch.com.nineelements.nineelementswatch.NineWatchWearActivity has leaked IntentReceiver firstwatch.com.nineelements.nineelementswatch.NineWatchWearActivity$1@ae0843b8 that was originally registered here. Are you missing a call to unregisterReceiver()?
            at android.app.LoadedApk$ReceiverDispatcher.<init>(LoadedApk.java:796)
            at android.app.LoadedApk.getReceiverDispatcher(LoadedApk.java:597)
            at android.app.ContextImpl.registerReceiverInternal(ContextImpl.java:1447)
            at android.app.ContextImpl.registerReceiver(ContextImpl.java:1427)
            at android.app.ContextImpl.registerReceiver(ContextImpl.java:1421)
            at android.content.ContextWrapper.registerReceiver(ContextWrapper.java:467)
            at firstwatch.com.nineelements.nineelementswatch.NineWatchWearActivity.onCreate(NineWatchWearActivity.java:38)
            at android.app.Activity.performCreate(Activity.java:5242)
            at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1087)
            at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2161)
            at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2258)
            at android.app.ActivityThread.access$800(ActivityThread.java:138)
            at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1209)
            at android.os.Handler.dispatchMessage(Handler.java:102)
            at android.os.Looper.loop(Looper.java:136)
            at android.app.ActivityThread.main(ActivityThread.java:5026)
            at java.lang.reflect.Method.invokeNative(Native Method)
            at java.lang.reflect.Method.invoke(Method.java:515)
            at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:777)
            at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:602)
            at dalvik.system.NativeStart.main(Native Method)
