plugins {
    id("fabric-loom") version "0.12-SNAPSHOT"
    kotlin("jvm") version "1.7.0"
    id("com.diffplug.spotless") version "6.9.1"
}

dependencies {
    // Fabric
    minecraft(group = "com.mojang", name = "minecraft", version = "${properties["minecraft_version"]}")
    mappings(group = "net.fabricmc", name = "yarn", version = "${properties["yarn_mappings"]}", classifier = "v2")
    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = "${properties["loader_version"]}")
    modImplementation(group = "net.fabricmc.fabric-api", name = "fabric-api", version = "${properties["fabric_api"]}")

    // Kotlin
    modImplementation(group = "net.fabricmc",name ="fabric-language-kotlin", version = "${properties["kotlin_mod_version"]}+kotlin.${properties["kotlin_version"]}")
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(properties)
    }
}

tasks.remapJar {
    archiveBaseName.set("${properties["mod_id"]}")
}

loom {
    accessWidenerPath.set(File("src/main/resources/mushroommod.accesswidener"))
}

repositories {
    mavenCentral()
}

spotless {
    java {
        eclipse()
    }
}