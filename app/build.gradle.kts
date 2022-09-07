plugins {
    id(Plugins.application)
    kotlin(Plugins.android)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinAndroid)
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
        getByName ("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
