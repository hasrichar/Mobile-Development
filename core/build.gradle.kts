import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
}

android {
    namespace = "com.development.gocipes.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField("String", "BASE_URL", "\"${properties.getProperty("BASE_URL")}\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)

    //ui
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    //navigation
    implementation(Dependencies.navigationKtx)
    implementation(Dependencies.navigationUiKtx)

    //testing
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.esspresso)

    //glide
    implementation(Dependencies.glide)

    //dagger-hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.daggerHiltCompiler)

    //retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)
    implementation(Dependencies.interceptor)

    //prefs
    implementation(Dependencies.prefs)

    //datastore
    implementation(Dependencies.dataStore)
}