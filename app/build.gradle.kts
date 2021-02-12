plugins {
    id("com.android.application")
    //id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.android)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHiltAndroid)
}

android {

    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = TestLibraries.AndroidJunitRunner
        buildFeatures.dataBinding=true
        buildFeatures.viewBinding=true
        multiDexEnabled = true
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASEURL", BASEURL.baseUrl1)
            buildConfigField("String", "BASEURL_MOBILION", BASEURL.baseUrl2)
            isDebuggable = true
        }
        getByName("release") {
            buildConfigField("String", "BASEURL", BASEURL.baseUrl1)
            buildConfigField("String", "BASEURL_MOBILION", BASEURL.baseUrl2)
            isShrinkResources = true
            isMinifyEnabled = true
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}


dependencies {

    //KOTLIN
    implementation(Libraries.kotlinStdLib)
    implementation(kotlin("stdlib"))
    implementation(Libraries.ktxCore)

    //UI / UX
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.swipeRefreshLayout)
    implementation(Libraries.recyclerView)
    implementation(Libraries.multidex)
    implementation(Libraries.fragmentKTX)

    //ARCHITECTURE COMPONENTS
    implementation(ArchitectureComponents.lifecycleViewModelKtx)
    implementation(ArchitectureComponents.lifecycleViewModel)
    implementation(ArchitectureComponents.lifecycleExtentions)
    implementation(ArchitectureComponents.lifecycleLiveDataKtx)
    implementation(ArchitectureComponents.lifecycleRuntimeKtx)
    implementation(ArchitectureComponents.navigationFragment)
    implementation(ArchitectureComponents.navigationUi)
    implementation(ArchitectureComponents.roomRuntime)
    implementation(ArchitectureComponents.roomKtx)
    implementation(ArchitectureComponents.roomRx)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(ArchitectureComponents.roomCompilerKapt)

    //COROUTINES
    implementation(Coroutines.coroutinesCore)
    implementation(Coroutines.coroutinesAndroid)

    //WorkManager
    implementation(Libraries.workManager)

    //NETWORK
    implementation(APILibraries.retrofit)
    implementation(APILibraries.retrofitRXJava3)
    implementation(APILibraries.retrofitConverterMoshi)
    implementation(APILibraries.moshi)
    implementation(APILibraries.moshiKotlin)
    implementation(APILibraries.moshiAdapters)
    implementation(APILibraries.loggingInterceptor)

    //RX
    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)
    implementation(RXLibraries.adapterRxJava3)
    implementation(RXLibraries.rxKotlin)
    implementation(RXLibraries.rxPermission)

    //DAGGER HILT
    implementation(DILibraries.hiltAndroid)
    implementation(DILibraries.hiltViewModel)
    kapt(DILibraries.hiltAndroidCompiler)
    kapt(DILibraries.hiltCompiler)

    //HAWK PREFERENCES
    implementation(Libraries.hawk)

    //LOG
    implementation(Libraries.timber)

    //GLIDE
    implementation(Libraries.glideGlide)
    implementation(Libraries.glideCompiler)

    //TAB VIEW
    implementation(Libraries.tabView)

    //GOOGLE SERVICES
    implementation(BuildPlugins.googleLocation)
    //TEST UNIT
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    implementation(project(":library"))
}
