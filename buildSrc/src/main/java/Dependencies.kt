object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val extJunit by lazy { "androidx.test.ext:junit:${Versions.extJunit}" }
    val esspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.esspresso}" }
    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val daggerHiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }
    val navigationKtx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationKtx}" }
    val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationKtx}" }
    val hdodenhof by lazy { "de.hdodenhof:circleimageview:${Versions.hdodenhof}" }
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val youtubePlayer by lazy { "com.pierfrancescosoffritti.androidyoutubeplayer:core:${Versions.youtubePlayer}" }
    val sonicCountDown by lazy { "com.github.orbitalsonic:SonicCountDownTimer:${Versions.sonicCountDown}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val liveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val prefs by lazy { "com.pixplicity.easyprefs:EasyPrefs:${Versions.prefs}" }
    val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.dataStore}" }
    val shimmer by lazy { "com.facebook.shimmer:shimmer:${Versions.shimmer}" }
}