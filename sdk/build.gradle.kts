plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = 35
    ndkVersion = "28.2.13676358"

    defaultConfig {
        minSdk = 21
        externalNativeBuild {
            cmake {
                abiFilters("armeabi-v7a", "arm64-v8a", "x86_64")
                arguments("-DANDROID_STL=c++_shared")
            }
        }
    }

    externalNativeBuild { cmake { path("src/main/cpp/CMakeLists.txt") } }

    buildTypes {
       release {
            isMinifyEnabled = true
            isJniDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
            consumerProguardFiles(file("proguard-customer.pro"))
        }
       debug {
            isJniDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }

    namespace = "scan.sdk"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}