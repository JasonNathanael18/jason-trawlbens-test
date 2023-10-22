package core

internal object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val fragment = "androidx.fragment:fragment-ktx:1.5.2"

    const val composeMaterial = "androidx.compose.material:material:${Versions.materialVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
    const val composePreviewUi = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
    const val viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.runtimeComposeVersion}"
    //const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-common-java8:2.3.1"

    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltNavCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val rxJava3adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    const val okhHttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"

    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"


    //const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val jUnit = "junit:junit:4.13.2"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val jUnitExtKtx = "androidx.test.ext:junit-ktx:1.1.3"
    //const val jUnitTestUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
//    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
//    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    const val googleTruth = "com.google.truth:truth:1.1.3"
    const val mockitoCore = "org.mockito:mockito-core:3.11.2"
    const val mockitoInline = "org.mockito:mockito-inline:3.11.2"
    const val archCore = "androidx.arch.core:core-testing:2.1.0"
    const val archTestCore = "androidx.test:core-ktx:1.4.0"
    const val roboelectric = "org.robolectric:robolectric:4.7"
    const val testRunner = "androidx.test:runner:1.4.0"
    const val testRules = "androidx.test:rules:1.4.0"

    const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
    const val dexmakerMockito = "com.linkedin.dexmaker:dexmaker-mockito-inline:2.28.1"
    const val mockitoAndroid = "org.mockito:mockito-android:3.11.2"

}