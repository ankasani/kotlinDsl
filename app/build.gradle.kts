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
    
    flavorDimensions ("version")
    productFlavors {
        create("demo") {
            // Assigns this product flavor to the "version" flavor dimension.
            // If you are using only one dimension, this property is optional,
            // and the plugin automatically assigns all the module's flavors to
            // that dimension.
            dimension = "version"
            applicationIdSuffix = ".demo"
            versionNameSuffix = "-demo"
        }

        create("full") {
            dimension = "version"
            applicationIdSuffix = ".full"
            versionNameSuffix = "-full"
        }
    }
}

dependencies {
    kapt(AppDependencies.daggerHiltCompiler)
    implementation(AppDependencies.appLibraries)
    implementation(AppDependencies.retrofitLibraries)
    implementation(project(Modules.onboarding))
    implementation(project(Modules.core_base))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
