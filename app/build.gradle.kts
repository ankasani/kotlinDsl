plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinAnnotationProcessor)
    id(BuildPlugins.androidxNavSafeArgs)
    id(BuildPlugins.pluginGoogleService)
    id(BuildPlugins.plugin_crashlytics)
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = ApplicationId.id
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        multiDexEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            resValue("string", "app_name", "kitchen-display-service-android")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            extra.set("enableCrashlytics", true)
            manifestPlaceholders = mapOf("crashlyticsCollectionEnabled" to "true")
        }

        getByName("debug") {
            buildConfigField("boolean", "MYVALUE", "true")
            resValue("string", "app_name", "KDS Debug")
            applicationIdSuffix = ".debug"

            extra.set("enableCrashlytics", false)
            manifestPlaceholders = mapOf("crashlyticsCollectionEnabled" to "false")
        }
    }

    flavorDimensions("odoo")
    productFlavors {
        create(Flavor.SIT) {
            setDimension("odoo")
            buildConfigField("String", "ODOO_URL", Environment.ODOO_SIT)
        }

        create(Flavor.STAGING) {
            setDimension("odoo")
            buildConfigField("String", "ODOO_URL", Environment.ODOO_STAGING)
        }

        create(Flavor.PROD) {
            setDimension("odoo")
            buildConfigField("String", "ODOO_URL", Environment.ODOO_PROD)
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.datasource))
    implementation(project(Modules.featureMain))

    // Firebase
    api(Dependencies.firebaseAnalytics)
    api(Dependencies.firebaseMessaging)
    api(Dependencies.firebaseCrashlytics)
    implementation(project(Modules.featureHome))
    implementation(project(Modules.featureLogin))
}
