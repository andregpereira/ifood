pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    val quarkusGroupId: String by settings
    val quarkusVersion: String by settings
    val quarkusPluginId: String by settings
    val quarkusPluginVersion: String by settings
    val lombokPluginId: String by settings
    val lombokPluginVersion: String by settings
    val mapstructVersion: String by settings
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            version("quarkus-platform", quarkusVersion)
            version("mapstruct", mapstructVersion)
            val quarkus = version("quarkus-plugin", quarkusPluginVersion)
            val lombok = version("lombok-plugin", lombokPluginVersion)
            val quarkusResteasyProblem = version("quarkus-resteasy-problem", "3.0.0")
            plugin("quarkus", quarkusPluginId).versionRef(quarkus)
            plugin("lombok", lombokPluginId).versionRef(lombok)
            library("quarkus-bom", "io.quarkus.platform", "quarkus-bom").versionRef("quarkus-platform")
            library("quarkus-hibernate-reactive-panache", quarkusGroupId, "quarkus-hibernate-reactive-panache").withoutVersion()
            library("quarkus-hibernate-validator", quarkusGroupId, "quarkus-hibernate-validator").withoutVersion()
            library("quarkus-reactive-pg-client", quarkusGroupId, "quarkus-reactive-pg-client").withoutVersion()
            library("quarkus-resteasy-reactive-jsonb", quarkusGroupId, "quarkus-resteasy-reactive-jsonb").withoutVersion()
            library("quarkus-resteasy-problem", "com.tietoevry.quarkus", "quarkus-resteasy-problem").versionRef(quarkusResteasyProblem)
            library("quarkus-smallrye-jwt", quarkusGroupId, "quarkus-smallrye-jwt").withoutVersion()
            library("quarkus-smallrye-openapi", quarkusGroupId, "quarkus-smallrye-openapi").withoutVersion()
            library("quarkus-config-yaml", quarkusGroupId, "quarkus-config-yaml").withoutVersion()
            library("lombok-mapstructBinding", "org.projectlombok:lombok-mapstruct-binding:0.2.0")
            library("mapstruct", "org.mapstruct", "mapstruct").versionRef("mapstruct")
            library("mapstruct-processor", "org.mapstruct", "mapstruct-processor").versionRef("mapstruct")
            bundle("quarkus", listOf("quarkus-hibernate-reactive-panache", "quarkus-hibernate-validator", "quarkus-smallrye-jwt", "quarkus-reactive-pg-client", "quarkus-resteasy-reactive-jsonb", "quarkus-resteasy-problem", "quarkus-smallrye-openapi", "quarkus-config-yaml"))
            bundle("lombokMapstructProcessors", listOf("lombok-mapstructBinding", "mapstruct-processor"))
        }
        create("testLibs") {
            library("quarkus-junit5", quarkusGroupId, "quarkus-junit5").withoutVersion()
            library("rest-assured", "io.rest-assured", "rest-assured").withoutVersion()
            library("testcontainers-postgresql", "org.testcontainers", "postgresql").withoutVersion()
            bundle("quarkus", listOf("quarkus-junit5", "rest-assured", "testcontainers-postgresql"))
        }
    }
}

rootProject.name = "ifood"
include("cadastro", "marketplace", "pedido")
