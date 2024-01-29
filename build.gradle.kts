import org.gradle.internal.impldep.org.bouncycastle.its.asn1.EndEntityType.app

plugins {
    java
    alias(libs.plugins.quarkus) apply false
    alias(libs.plugins.lombok) apply false
}

allprojects {
    group = "com.github.andregpereira.ifood"
    version = "0.0.1-SNAPSHOT"
    apply {
        plugin("java")
    }
}

subprojects {
    apply {
        plugin(rootProject.libs.plugins.lombok.get().pluginId)
        plugin(rootProject.libs.plugins.quarkus.get().pluginId)
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

tasks.withType<JavaCompile> { enabled = false }
tasks.withType<Jar> { enabled = false }
