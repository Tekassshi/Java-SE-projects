plugins {
    java
    application
    id("com.github.seanrl.jaxb") version "2.5.1"
}

group = "org.example"
version = "0.3"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-parameter-names
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.14.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jdk8
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.14.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-jaxb-annotations
    implementation("com.fasterxml.jackson.module:jackson-module-jaxb-annotations:2.14.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass.set("Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.jar {
    manifest{
        attributes["Main-Class"] = "Main"
    }
}