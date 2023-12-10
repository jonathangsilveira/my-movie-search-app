plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.silveira.jonathang.android.mymoviesearch"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.silveira.jonathang.android.mymoviesearch"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Features.domain))
    implementation(project(Features.remote))

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinAndroidxCompose)

    implementation(Libs.coreKtx)
    implementation(Libs.lifecycleRuntimeKtx)
    implementation(Libs.activityCompose)
    implementation(platform(Compose.platform))
    implementation(Compose.ui)
    implementation(Compose.uiGraphics)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.material3)
    testImplementation(TestLibs.junit4)
    androidTestImplementation(TestLibs.junitExt)
    androidTestImplementation(TestLibs.espressoCore)
    androidTestImplementation(platform(Compose.platform))
    androidTestImplementation(Compose.uiTestJunit4)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)
}