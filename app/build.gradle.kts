@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.parcelize.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.hilt.get().pluginId)
    id(libs.plugins.navigation.safe.args.get().pluginId)
}

android {
    namespace = "com.example.codingtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.codingtest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            buildConfigField("String", "BASE_URL", "\"https://restcountries.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

//    implementation(libs.core.ktx)
//    implementation(libs.appcompat)
//    implementation(libs.material)
//    implementation(libs.constraintlayout)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.test.ext.junit)
//    androidTestImplementation(libs.espresso.core)

    implementation(libs.kotlin.stdlib)
    implementation(libs.core.ktx)
    implementation(libs.kotlin.stdlib.jdk7)

    // Retrofit
    api(libs.retrofit)
    api(libs.okhttp3.logging.interceptor)
    api(libs.retrofit.converter.gson)

    // Gson
    api(libs.gson)

    api(libs.material)
    implementation(libs.hilt.android)
    testImplementation(libs.jupiter.junit)
    testImplementation(libs.junit)
    kapt(libs.hilt.android.compiler)

    // Kotlin-coroutines
    api(libs.kotlinx.coroutines.core)
    api(libs.kotlinx.coroutines.android)

    // androidx
    api(libs.appcompat)
    api(libs.recyclerview)
    api(libs.cardview)
    api(libs.swiperefreshlayout)
    api(libs.constraintlayout)

    implementation(libs.fragment.ktx)
    implementation(libs.activity.ktx)

    // Kotlin
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // Feature module Support
    implementation(libs.navigation.dynamic.features)

    // Glide
    api(libs.glide)
    kapt(libs.glide.compiler)

    implementation(libs.paging)

    //Test
    testImplementation(libs.junit)
    testImplementation(libs.jupiter.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.espresso)
}