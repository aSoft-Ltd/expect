plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm {
        library()
        withJava()
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
    js(IR) { library() }
    val darwinTargets = listOf(
        macosX64(),
        iosArm64(),
        iosArm32(),
        iosX64(),
        watchosArm32(),
        watchosArm64(),
        watchosX86(),
        tvosArm64(),
        tvosX64()
    )

    val linuxTargets = listOf(
        linuxArm64(),
        linuxArm32Hfp(),
        linuxX64()
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlin("test-junit5"))
            }
        }

        val jsAndNativeMain by creating {
            dependencies {
                dependsOn(commonMain)
            }
        }

        val jsMain by getting {
            dependencies {
                dependsOn(jsAndNativeMain)
            }
        }

        (darwinTargets + linuxTargets).forEach {
            val main by it.compilations.getting {}
            main.defaultSourceSet {
                dependsOn(jsAndNativeMain)
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.expect,
    description = "A Minimal kotlin multiplatform assertion library"
)
