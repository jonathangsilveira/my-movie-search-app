plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.silveira.jonathang.android.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kotlin {
        jvmToolchain(Config.jvmToolchain)
    }
}

dependencies {
    implementation(project(mapOf("path" to Features.domain)))

    implementation(Libs.kotlinXCoroutinesAndroid)
    implementation(Libs.kotlinXSerializationJson)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitKotlinSerializationConverter)

    implementation(Libs.loggingInterceptor)

    implementation(Libs.koinCore)

    testImplementation(TestLibs.junit4)
    testImplementation(TestLibs.mockk)
    testImplementation(TestLibs.kotlinXCoroutinesTest)

    androidTestImplementation(TestLibs.junitExt)
}