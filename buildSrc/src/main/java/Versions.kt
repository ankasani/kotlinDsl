object Release {
    //val versionCode = 1
     val versionMajor = 0
     val versionMinor = 0
     val versionPatch = 0
     val versionBuild = 1
     val versionCode = versionMajor*10000 + versionMinor*1000 + versionPatch*100 + versionBuild
    val versionName = "1.0.0"
}

object Versions {

    /**
     * Sdk Versions
     */
    val compileSdkVersion = 28
    val minSdkVersion = 17
    val targetSdkVersion = 28

    /**
     * Dependency Versions
     */
    const val gradleVersion = "3.2.1"
    const val kotlinVersion = "1.3.11"
    const val appCompatVersion = "28.0.0"
    const val jUnitVersion = "4.12"
    const val testRunnerVersion = "1.0.2"
    const val espressoCoreVersion = "3.0.2"
}

