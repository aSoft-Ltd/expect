# Expect

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

An assertion library that can be used in

- JavaScript ecosystem (JS & TS)
- JVM ecosystems (Java, Scala, Groovy, e.t.c)
- Kotlin Multiplatform

## Samples

```kotlin
expect(1 + 1).toBe(2)
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
    implementation("tz.co.asoft:expect-core:0.0.42")
    // - - - - - or - - - - - 
    implementation("tz.co.asoft:expect-coroutines:0.0.42")
}
```

## Compatibility

|Expect Version|Kotlin Version|
|--------------|--------------|
| 0.0.42       | 1.5.10       |
| 0.0.41       | 1.5.10       |

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/expect-core/0.0.42?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
