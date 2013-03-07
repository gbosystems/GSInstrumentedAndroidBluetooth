GSInstrumentedAndroidBluetooth
==============================

A package useful during the development of Android applications that utilize Bluetooth functionality. Allows for testing/debugging using only a single device. The package can operate in three (3) modes:

+ Simulate. Read and write functions go nowhere, delays are simulated.
+ File. Read functions pull from the local filesystem, write functions write to per-device files.
+ Loopback. Anything written to the device socket is looped around and can be read from the same device socket.

In all cases, the number of simulated connected devices can be configured.

[Blog Post](http://www.gbosystems.com/blog/2013/1/1/instrumented-android-bluetooth-package)
