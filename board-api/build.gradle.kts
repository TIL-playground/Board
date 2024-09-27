tasks {
    jar {
        isEnabled = true
    }
    bootJar {
        isEnabled = false
    }
}

dependencies {
    api (project(":board-api:article-api"))
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