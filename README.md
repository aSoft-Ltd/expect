# Expect
![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

An kotlin multiplatform assertion library

## Samples 
```kotlin
expect(1+1).toBe(2)
```
```kotlin
expect(2 + 2) {
    toBeEqualTo(4)
    toBeLessThan(5)
    toBeGreaterThan(1)
    toBeNonNull()
    toBe<Int>()
    toBe<Number>()
    toBe<Comparable<*>>()
}
```

## Setup: Gradle
```kotlin
dependencies {
    implementation("tz.co.asoft:expect-core:+") // use the latest version
    // - - - - - or - - - - - 
    implementation("tz.co.asoft:expect-coroutines:+") // for asserting StateFlow<T> easily
}
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/test/1.0.1?style=flat
[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat
[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat
[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat
[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
