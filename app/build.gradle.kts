plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroidPlugin)
    id(BuildPlugins.kotlinAndroidExtensionsPlugin)
    id(BuildPlugins.kotlinAndroidKaptPlugin)
    id(BuildPlugins.googleServicesPlugin)
    id(BuildPlugins.crashlyticsPlugin)
    id(BuildPlugins.safeArgsPlugin)
}

android {
    compileSdkVersion(AndroidSdk.compileApi)
    buildToolsVersion(AndroidSdk.buildTools)
    defaultConfig {
        minSdkVersion(AndroidSdk.minApi)
        targetSdkVersion(AndroidSdk.targetApi)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.apply {
                    put("room.schemaLocation", "$projectDir/schemas")
                    put("room.incremental", "true")
                    put("room.expandProjection", "true")
                }
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.coroutines)
    implementation(Libraries.material)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    koin()
    lifecycle()
    navigation()
    network()
    firebase()
    room()
    implementation(Libraries.swiperefreshlayout)
    implementation(Libraries.coroutinesPlayServices)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.coroutinesTesting)
    testImplementation(TestLibraries.testing)
    testImplementation(TestLibraries.mockitoKotlin)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.testing)
    androidTestImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.mockitoKotlin)
    androidTestImplementation(TestLibraries.coroutinesTesting)
}
