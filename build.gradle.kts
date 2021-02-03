import java.net.URI
plugins {
    kotlin("multiplatform") version "1.4.21"
    publishing
}

group = "me.arslan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
    jcenter()
}

val compilerArgs = listOf(
    "-Xopt-in=kotlin.time.ExperimentalTime"
)
val klockVersion = "2.0.0-alpha"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js(BOTH) {
        nodejs {}
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }.apply {
        binaries.executable()
    }
    explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Strict
    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.time.ExperimentalTime")
        }
        val commonMain by getting {
            dependencies {
                implementation("com.soywiz.korlibs.klock:klock:$klockVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}

subprojects {
    apply(plugin = "kotlin")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = URI("https://maven.pkg.github.com/arslanarm/planner")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}