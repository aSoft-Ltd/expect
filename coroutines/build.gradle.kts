plugins {
    kotlin("multiplatform")
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
                api(projects.expectCore)
                api(kotlinx.coroutines.test)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.foundation.get(),
    description = "Extension of the expect-core library to add coroutines StateFlow support"
)
