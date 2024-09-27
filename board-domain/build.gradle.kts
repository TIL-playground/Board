tasks {
    bootJar {
        isEnabled = false
    }
    jar {
        isEnabled = true
    }
}

subprojects {
    tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        isEnabled = false
    }
    tasks.withType<Jar> {
        isEnabled = true
    }

    val useMySQL: Boolean by extra(false)

    afterEvaluate {
        dependencies {
            implementation(project(":board-common"))

            if (useMySQL) {
                implementation("org.springframework.boot:spring-boot-starter-data-jpa")
                runtimeOnly("com.mysql:mysql-connector-j")
            }
        }
    }
}