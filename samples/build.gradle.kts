repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
    jcenter()
}

val klockVersion = "2.0.0-alpha"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":"))
    implementation("com.soywiz.korlibs.klock:klock:$klockVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
