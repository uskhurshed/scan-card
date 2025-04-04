plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
android {
    compileSdk = 35
    ndkVersion = "26.1.10909125"

    defaultConfig {
        applicationId = "lens24.demo"
        minSdk = 21
        targetSdk = 35
        versionCode = 8
        versionName = "1.1.5"
        multiDexEnabled = true
        resConfigs("en")
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
        debug {
            isMinifyEnabled = false
            isJniDebuggable = true
        }
    }
    packaging {
        resources {
            excludes.add("META-INF/LICENSE.txt")
            excludes.add("META-INF/NOTICE.txt")
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
    namespace="demo"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":sdk"))
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}

