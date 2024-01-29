dependencies {
    implementation(libs.bundles.quarkus)
    implementation(libs.mapstruct)
    annotationProcessor(libs.bundles.lombokMapstructProcessors)
    testImplementation(testLibs.bundles.quarkus)
}
