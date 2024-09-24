plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.openapi.generator") version "7.7.0"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("io.swagger.core.v3:swagger-annotations:2.1.12")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.7")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val relativePathToOpenApiGeneratedCode = "src/main/kotlin"
val openApiOutputDir = "$buildDir/generated-resources"
kotlin.sourceSets["main"].kotlin.srcDir("$openApiOutputDir/$relativePathToOpenApiGeneratedCode")

val openApiGeneratorConfig = mapOf(
    "dateLibrary" to "java.time",
    "serializationLibrary" to "jackson",
    "rootPackage" to "generated.com.example"
)

openApiGenerate {
    inputSpec.set("$rootDir/src/main/resources/static/openapi/server/openapi.yaml")
    generatorName.set("kotlin-spring")
    apiPackage.set("${openApiGeneratorConfig["rootPackage"]}.kotlincrud.api")
    packageName.set("${openApiGeneratorConfig["rootPackage"]}.kotlincrud.api")
    modelPackage.set("${openApiGeneratorConfig["rootPackage"]}.kotlincrud.model")
    outputDir.set("$buildDir/generated-resources")

    configOptions.put("dateLibrary", openApiGeneratorConfig["dateLibrary"]!!)
    configOptions.put("delegatePattern", "true")
    configOptions.put("interfaceOnly", "true")
    configOptions.put("modelMutable", "true")
    configOptions.put("enumPropertyNaming", "original")
    configOptions.put("useTags", "true")
    configOptions.put("serializationLibrary", openApiGeneratorConfig["serializationLibrary"]!!)
    configOptions.put("useJakarta", "true")
    configOptions.put("useSpringBoot3", "true")
    importMappings.set(
        mapOf(
            "ErrorResponse" to "com.arbm.digibank.rest.error.ErrorResponse"
        )
    )
}