rootProject.name = "mushroom-mod"
// Required for fabric
pluginManagement {
    repositories {
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        gradlePluginPortal()
    }
}
include("fabric")
