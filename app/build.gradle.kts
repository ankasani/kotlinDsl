//apply plugin: 'com.android.application'
plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    kotlin(Plugins.android) 
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.daggerHilt)
}

android {
   namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
    
    buildTypes {

        getByName("release") {
            isMinifyEnabled = true // Enables code shrinking for the release build type.
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    flavorDimensions += "default"
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
