plugins {
    java
    alias(libs.plugins.quarkus) apply false
    alias(libs.plugins.lombok) apply false
}

allprojects {
    group = "com.github.andregpereira.ifood"
    version = "0.0.1-SNAPSHOT"
}

subprojects {
    apply {
        plugin("java")
        plugin(rootProject.libs.plugins.lombok.get().toString().substringBefore(":"))
    }
    dependencies {
        implementation(enforcedPlatform(rootProject.libs.quarkus.bom))
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    tasks.withType<Test> {
        systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    }
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }
}

tasks.named("compileJava").configure { enabled = false }
tasks.named("jar").configure { enabled = false }
