# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

-dontwarn org.apiguardian.api.API$Status
-dontwarn org.apiguardian.api.API

-keep class com.tradingview.lightweightcharts.** {
  public protected private *;
}

-keep class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-dontwarn com.sun.jna.FunctionMapper
-dontwarn com.sun.jna.JNIEnv
-dontwarn com.sun.jna.Library
-dontwarn com.sun.jna.Native
-dontwarn com.sun.jna.Platform
-dontwarn com.sun.jna.Pointer
-dontwarn com.sun.jna.Structure
-dontwarn com.sun.jna.platform.win32.Kernel32
-dontwarn com.sun.jna.platform.win32.Win32Exception
-dontwarn com.sun.jna.platform.win32.WinDef$LPVOID
-dontwarn com.sun.jna.platform.win32.WinNT$HANDLE
-dontwarn com.sun.jna.win32.StdCallLibrary
-dontwarn edu.umd.cs.findbugs.annotations.SuppressFBWarnings
-dontwarn java.lang.instrument.ClassDefinition
-dontwarn java.lang.instrument.IllegalClassFormatException
-dontwarn java.lang.instrument.UnmodifiableClassException
-dontwarn org.slf4j.Logger
-dontwarn org.slf4j.LoggerFactory

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile