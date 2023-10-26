object Dependencies {


    //  implementation{"androidx.core:core-ktx:1.9.0"}

    val coreKtx by lazy {"androidx.core:core-ktx:${Versions.coreKtx}"}
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}"}
    val lifecycleRunTime by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"}
    val activityCompose by lazy{"androidx.activity:activity-compose:${Versions.activityCompose}"}
    val composeBom by lazy {"androidx.compose:compose-bom:${Versions.composeBom}"}
    val composeUI by lazy {"androidx.compose.ui:ui"}
    val composeUIGraphics by lazy {"androidx.compose.ui:ui-graphics"}
    val composeUIToolingPreview by lazy {"androidx.compose.ui:ui-tooling-preview"}
    val material3 by lazy {"androidx.compose.material3:material3"}
    val jUnit4 by lazy {"junit:junit:${Versions.jUnit4}"}
    val composeTestJUnit by lazy {"androidx.test.ext:junit:${Versions.jUnit1}"}
    val esperessoCore by lazy {"androidx.test.espresso:espresso-core:${Versions.espressoCore}"}
    val composeBomTest by lazy {"androidx.compose:compose-bom:${Versions.composeBom}"}
    val composeUITest by lazy {"androidx.compose.ui:ui-test-junit4"}
    val composeUITooling by lazy {"androidx.compose.ui:ui-tooling"}
    val manifest by lazy {"androidx.compose.ui:ui-test-manifest"}
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    // Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}"}
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}"}
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"}
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}

    // Retrofit and okhttp
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"}

    // Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    //SplashScreen
    val splashScreen by lazy {"androidx.core:core-splashscreen:1.0.1"}

}

object Modules {
    const val utiities = ":utilities"
}