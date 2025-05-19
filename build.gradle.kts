plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
}

group = "com.kontenery.library"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(kotlin("test"))
}

//tasks.test {
//    useJUnitPlatform()
//}
kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["java"])
            groupId = "com.kontenery.library"
            artifactId = "library"
            version = "1.0.0"
        }
    }
}