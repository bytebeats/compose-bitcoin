# compose-bitcoin
Android Bitcoin market app base on Jetpack Compose and MVVM & MVI.

## Features

* Current bitcoin market price.
* K-line charts of history prices.
* Popular stats for blockchain.

## Tech stack and whys 
* [Kotlin](https://kotlinlang.org/) - Kotlin on Android is a “first-class” language and it has [a lot of benefits](https://developer.android.com/kotlin).
* [MVVM & MVI Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google suggested app architecture.
* [Dagger Hilt](https://dagger.dev/hilt/) - Easy implementation and less boilerplate code than Dagger2.
* [Coroutine](https://developer.android.com/kotlin/coroutines) + [Flow](https://developer.android.com/kotlin/flow) = [MVI](https://github.com/Kotlin-Android-Open-Source/MVI-Coroutines-Flow)
* [Retrofit](https://square.github.io/retrofit/) - Type-safe HTTP client for Android and Java.
* [OkHttp](https://square.github.io/okhttp/) - Meticulous HTTP client for the JVM, Android, and GraalVM.
* [Moshi](https://github.com/square/moshi) - Modern JSON library for Android, Java and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes.
* [Jetpack Components](https://developer.android.com/jetpack) - Compose, ViewModel and more.
* [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) - Powerful Android chart view / graph view library, supporting line- bar- pie- radar- bubble- and candlestick charts as well as scaling, panning and animations.
* [Lottie](https://github.com/airbnb/lottie-android) -  Mobile library for Android and iOS that parses Adobe After Effects animations exported as json with Bodymovin and renders them natively on mobile!
* [Truth](https://truth.dev/) & [Mockk](https://mockk.io/) - For more readable unit tests.
