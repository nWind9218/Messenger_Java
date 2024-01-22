plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.messengerbluetooth"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.messengerbluetooth"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    /* Enable ViewBinding
    * ViewBinding is a feature that allows you to more easily write code that
    * interacts with views. Once viewbiding is enabled in a module, it generates a
    * binding class for each XML layout file present in that module. An instance of
    * a binding class contains direct references to all views that have an ID in
    * the corresponding layout*/
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //Firebase
    implementation("com.google.firebase:firebase-messaging:23.4.0")
    implementation("com.google.firebase:firebase-firestore:24.10.0")
    //

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Scalable Size Unit (support for different screen sizes)
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.intuit.ssp:ssp-android:1.0.6")
    // Rounded ImageView (a fast ImageView( and Drawable) that supports rounded corners (and ovals
    // or circles). It supports many additional features: including ovals, rounded rectangles, ScaleTypes, and TileModes
    implementation("com.makeramen:roundedimageview:2.3.0")
    implementation("com.google.firebase:firebase-analytics")
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    //MultiDex
    implementation("androidx.multidex:multidex:2.0.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
}
/*Enabling MultiDex
* APK files contain executable bytecode files in the form of Dalvik Executable (Dex) files, which contain the compiled code used to run your
* app. The Dalvik Executable specification limits the total number of methods that can be referenced within a single DEX file to 65,536,
* including Android framework methods, library methods, and methods in your own code. Getting past this limit requires that you configure
* your app build process to generate more than one DEX file, known as a MultiDEX configuration*/
// Sync Now: that helps you scan and install Gradle project built outside the IDE