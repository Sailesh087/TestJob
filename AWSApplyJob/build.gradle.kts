plugins {
    kotlin("jvm") version "1.8.0"  // Kotlin plugin
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.google.com")}
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Cucumber dependencies
    implementation("io.cucumber:cucumber-java:7.8.0")
    implementation("io.cucumber:cucumber-testng:7.8.0")

    // Selenium dependencies
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")

    // WebDriver Manager for managing browser drivers
    implementation("io.github.bonigarcia:webdrivermanager:5.3.0")

    // TestNG for test execution
    testImplementation("org.testng:testng:7.7.0")




}

tasks.withType<Test> {
    useTestNG()  // Use TestNG as the testing framework
}