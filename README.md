# Pranayama 3D Sanctuary — Android
The supplied HTML app is packaged in a native Android WebView wrapper.

## Build APK
1. Open this repository in Android Studio.
2. Install Android SDK Platform 35 and Java 17.
3. Sync Gradle, then choose Build > Build Bundle(s) / APK(s) > Build APK(s).
4. APK output: app/build/outputs/apk/debug/app-debug.apk

## Automatic build
GitHub Actions runs **Build Android APK** on pushes to main. Open Actions, select the completed run,
and download **Pranayama-3D-Sanctuary-debug-apk**.

The app loads JavaScript, CSS, fonts and icons from external CDNs and needs internet access.
This is a debug APK for testing, not a Play Store signed release. Review registration data handling
and the privacy notice before public distribution.
