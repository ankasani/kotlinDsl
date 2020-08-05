apply plugin: 'com.android.application'
plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        applicationId = Config.applicatiınId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Release.versionCode
        versionName = Release.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    
    //flavorDimensions("brand")
    //productFlavors {
     //   create("brand1") {
      //      setDimension("brand")
       // }
      //  create("brand2") {
       //     setDimension("brand")
       // }
     //}
    
             flavorDimensions "version"
               productFlavors {
                   dev {
                       dimension "version"
                       applicationIdSuffix = ".dev"
                       versionNameSuffix "-dev"
                       resValue "string", "Stadium", "Stadium dev"
                   }
                   prod {
                       dimension "version"
                       resValue "string", "Stadium", "Stadium"
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
