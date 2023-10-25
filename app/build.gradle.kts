plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.kotlincomposenewapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlincomposenewapp"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.manifest)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(platform(Dependencies.composeBomTest))
    implementation(Dependencies.composeTestJUnit)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUIGraphics)
    implementation(Dependencies.jUnit4)
    implementation(Dependencies.composeUITest)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.esperessoCore)
    implementation(Dependencies.composeUITooling)
    implementation(Dependencies.material3)
    implementation(Dependencies.lifecycleRunTime)

    implementation(project(Modules.utiities))

    implementation(Dependencies.hiltAndroid)
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")
    kapt(Dependencies.hiltAndroidCompiler)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltNavigationCompose)


    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.loggingInterceptor)
    

    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.coroutinesCore)
}

kapt {
    correctErrorTypes = true
}