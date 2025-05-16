pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.2.0" // Use your AGP version
        id("org.jetbrains.kotlin.android") version "1.9.0" // Use your Kotlin version
        id("com.google.dagger.hilt.android") version "2.48" // ✅ Add this for Hilt
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TODO_app"
include(":app")
