tasks {
    jar {
        isEnabled = true
    }
    bootJar {
        isEnabled = false
    }
}

subprojects {
    tasks {
        jar {
            isEnabled = true
        }
        bootJar {
            isEnabled = false
        }
    }

    dependencies {
        implementation (project(":board-common"))
    }
}