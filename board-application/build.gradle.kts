tasks {
    jar {
        isEnabled = true
    }
    bootJar {
        isEnabled = false
    }
}

dependencies {
    api (project(":board-application:article-application"))
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
        implementation(project(":board-common"))
    }
}