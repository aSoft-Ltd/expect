plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm {
        library(); withJava()
    }
    js(IR) { library() }
    val nativeTargets = nativeTargets(supportedByCoroutines = true)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.functions)
                api(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlin("test-junit5"))
            }
        }

        val jsAndNativeMain by creating {
            dependsOn(commonMain)
        }

        val nativeMain by creating {
            dependsOn(jsAndNativeMain)
        }

        val jsMain by getting {
            dependsOn(jsAndNativeMain)
        }

        nativeTargets.forEach {
            val main by it.compilations.getting {}
            main.defaultSourceSet {
                dependsOn(nativeMain)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.foundation.get(),
    description = "A Minimal kotlin multiplatform assertion library"
)
