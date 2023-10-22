import dependencies.addAndroidUiDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.example.router"
}

dependencies {
    addAndroidUiDependencies()
}