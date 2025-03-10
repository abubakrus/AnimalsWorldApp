plugins{
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.retrofit)
    testImplementation(libs.junit)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}