plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    nativeTargets(supportedByCoroutines = true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":expect-core"))
                api(asoft("test-coroutines", vers.asoft.test))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.expect,
    description = "Extension of the expect-core library to add coroutines StateFlow support"
)
