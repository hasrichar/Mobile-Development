pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "GoCipes"
include(":app")
include(":core")
include(":auth")
include(":food")
include(":article")
include(":technique")
include(":home")
include(":analysis")
include(":profile")
include(":chatbot")
