// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
//    alias(libs.plugins.com.android.application) apply false
//    alias(libs.plugins.org.jetbrains.kotlin.android) apply false

    `kotlin-dsl`
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.navigation.safe.args) apply false
}

dependencies {
    compileOnly(libs.gradle.plugin)
    compileOnly(libs.hilt.plugin)
    compileOnly(libs.navigation.safe.args.plugin)
}
buildscript {
    repositories {
        mavenCentral()
        google()
    }
}

true // Needed to make the Suppress annotation work for the plugins block