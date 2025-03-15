plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Agrega esto directamente en lugar de alias, añadido a mano la linea
}

android {
    namespace = "es.upsa.a1_prueba1_android_kotlin"
    compileSdk = 35

    defaultConfig {
        applicationId = "es.upsa.a1_prueba1_android_kotlin"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    //_____________ ViewBinding _____________
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview) // añadido listado
    implementation("com.github.bumptech.glide:glide:4.16.0")  // Para cargar imágenes, junto con el kapt
    implementation(libs.sdkcoroutines) // Para las corrutinas
    implementation(libs.common)  // Para lifecycle: Lifecycle Scope
    kapt("com.github.bumptech.glide:compiler:4.16.0") // Para generar código si usas GlideApp, añadido a mano la linea
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}