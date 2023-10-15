plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}

dependencies {
    implementation(Libs.kotlinXCoroutinesAndroid)

    testImplementation(TestLibs.junit4)

    testImplementation(TestLibs.kotlinXCoroutinesTest)
    testImplementation(TestLibs.mockk)
}