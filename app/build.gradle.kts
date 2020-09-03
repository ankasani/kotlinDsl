//apply plugin: 'com.android.application'
plugins {
    id("com.android.application")
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Release.versionCode
        //versionName = Release.versionName
          versionName = !1
        testInstrumentationRunner = Config.testInstrumentationRunner
    }
    buildTypes {
        getByName ("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }  
    flavorDimensions("default")
    productFlavors {
        create("dev") {
            versionNameSuffix = " DEV"
        }
        create("prod")
        create("sim") {
            versionNameSuffix = " DEV-SIMULATED"
        }
    }
}

dependencies {
    // Core Libraries
    implementation(CoreLibraries.kotlin)

    // Support Libraries
    implementation(SupportLibraries.appCompat)

    // Testing
    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.runnner)
    androidTestImplementation(TestLibraries.espressoCore)
}
