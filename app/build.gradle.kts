plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.AnimalsWorldApp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.AnimalsWorldApp"
        minSdk = 24
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
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}


dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

//Room
    ksp(libs.room.compiler)
    ksp(libs.room.ktx.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

//Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

//Coil
    implementation(libs.coil.compose)

//Coroutines
    implementation(libs.kotlinx.coroutines.android)

//Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

//Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
//ExoPlayer
    implementation(libs.exoPlayer)
    implementation(libs.exoPlayer.core)
    implementation(libs.exoPlayer.ui)
    implementation(libs.media.exoPlayer)
    implementation(libs.systemuicontroller)
    implementation(libs.exoPlayer.session)


// Pager
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

// Lottie
    implementation(libs.lottie.compose)

    implementation(libs.foundation)

    implementation(libs.parse.android)

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    val bom = libs.androidx.compose.bom
    implementation(platform(bom))
    androidTestImplementation(platform(bom))
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    androidTestImplementation(libs.androidx.compose.ui.test)

    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.junit)
}