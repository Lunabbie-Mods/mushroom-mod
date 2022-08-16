plugins {
    id("fabric-loom") version "0.12-SNAPSHOT"
    kotlin("jvm") version "1.7.0"
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
    dependsOn("runDatagenClient")
}

tasks.remapJar {
    archiveBaseName.set("${properties["mod_id"]}")
}

sourceSets {
    main {
        resources {
            srcDirs.add(file("src/main/generated"))
        }
    }
}

loom {
    accessWidenerPath.set(file("src/main/resources/mushroommod.accesswidener"))

    runs {
        create("datagenClient") {

            inherit(runConfigs.getByName("client"))

            name("dataGeneration")
            vmArgs(
                "-Dfabric-api.datagen",
                "-Dfabric-api.datagen.output-dir=${file("src/main/generated")}",
                "-Dfabric-api.datagen.strict-validation"
            )

            ideConfigGenerated(true)
            runDir("build/datagen")
        }
    }
}
