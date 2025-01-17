@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.twofasAndroidApplication)
    alias(libs.plugins.twofasCompose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.kotlinKapt)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.twofasapp"
}

dependencies {
    implementation(project(":base"))
    implementation(project(":di"))
    implementation(project(":extensions"))
    implementation(project(":prefs"))
    implementation(project(":environment"))
    implementation(project(":serialization"))
    implementation(project(":time"))
    implementation(project(":spanner"))
    implementation(project(":truetime"))
    implementation(project(":truetime-rx"))
    implementation(project(":browserextension"))
    implementation(project(":parsers"))
    implementation(project(":resources"))
    implementation(project(":design"))
    implementation(project(":permissions"))
    implementation(project(":network"))
    implementation(project(":push"))
    implementation(project(":persistence"))
    implementation(project(":qrscanner"))
    implementation(project(":about"))
    implementation(project(":settings"))
    implementation(project(":widgets"))
    implementation(project(":services"))
    implementation(project(":services:domain"))
    implementation(project(":widgets:domain"))
    implementation(project(":notifications"))
    implementation(project(":navigation"))
    implementation(project(":backup"))
    implementation(project(":core"))
    implementation(project(":featuretoggle"))
    implementation(project(":developer"))
    implementation(project(":backup:domain"))
    implementation(project(":security"))
    implementation(project(":security:domain"))
    implementation(project(":start"))
    implementation(project(":start:domain"))
    implementation(project(":time:domain"))
    implementation(project(":externalimport"))
    implementation(project(":browserextension:domain"))

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:storage"))
    implementation(project(":data:session"))
    implementation(project(":feature:startup"))
    implementation(project(":feature:home"))

    implementation(libs.bundles.appCompat)
    implementation(libs.bundles.rxJava)
    implementation(libs.bundles.materialDialogs)
    implementation(libs.bundles.fastAdapter)
    implementation(libs.bundles.rxBinding)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.barcodeScanner)
    implementation(libs.bundles.room)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.viewModel)
    implementation(libs.bundles.playReview)
    implementation(libs.bundles.playUpdate)
    implementation(libs.timber)
    implementation(libs.webkit)
    implementation(libs.securityCrypto)
    implementation(libs.secureStorage)
    implementation(libs.lottie)
    implementation(libs.kotlinCoroutines)
    implementation(libs.coroutinesToRx)
    implementation(libs.workManager)
    implementation(libs.workManagerRx)

    implementation(libs.coreSplash)

    // Google
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.biometric:biometric:1.1.0")

    implementation("com.google.android.gms:play-services-auth:20.4.0"){
        exclude("com.google.http-client", "google-http-client")
        exclude("com.google.http-client", "google-http-client-jackson")
    }

    implementation("com.github.rafakob.google-http-java-client:google-http-client-gson:1.43.0")

    implementation("com.google.api-client:google-api-client-android:2.2.0") {
        exclude("org.apache.httpcomponents", "guava-jdk5")
        exclude("com.google.http-client","google-http-client")
    }
    implementation("com.google.apis:google-api-services-drive:v3-rev197-1.25.0") {
        exclude("org.apache.httpcomponents", "guava-jdk5")
        exclude("com.google.http-client","google-http-client")

    }

    // Utilities
    debugImplementation("io.objectbox:objectbox-android-objectbrowser:2.9.1")
    releaseImplementation("io.objectbox:objectbox-android:2.9.1")
    implementation("io.objectbox:objectbox-kotlin:2.9.1")
    kapt("io.objectbox:objectbox-processor:2.9.1")
    implementation("org.apache.commons:commons-text:1.9")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.1")

    implementation(platform("com.google.firebase:firebase-bom:31.1.0"))
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-crashlytics")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.1")
}