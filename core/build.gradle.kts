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
    val nativeTargets = nativeTargets(supportedByCoroutines = false)
    sourceSets {
        val commonMain by getting {
            dependencies {
                if (System.getenv("INCLUDE_BUILD") == "true") {
                    api(asoft.functions.core)
                } else {
                    api(project(":functions-core"))
                }
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
    version = asoft.versions.root.get(),
    description = "A Minimal kotlin multiplatform assertion library"
)
