tasks {
    jar {
        isEnabled = false
    }
    bootJar {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":board-api"))
    implementation(project(":board-application"))
    implementation(project(":board-domain"))
}