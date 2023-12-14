plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.development.gocipes"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.development.gocipes"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(Modules.core))
    implementation(project(Modules.auth))
    implementation(project(Modules.food))
    implementation(project(Modules.article))
    implementation(project(Modules.technique))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)

    //ui
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    //testing
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.esspresso)

    //dagger-hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.daggerHiltCompiler)

    //navigation
    implementation(Dependencies.navigationKtx)
    implementation(Dependencies.navigationUiKtx)

    //circle-image
    implementation(Dependencies.hdodenhof)

    //prefs
    implementation(Dependencies.prefs)

    //lifecycle
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
}