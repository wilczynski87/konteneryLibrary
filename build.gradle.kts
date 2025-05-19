plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
    `maven-publish`
}

group = "com.github.wilczynski87"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["java"])
        }
    }
}