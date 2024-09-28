tasks {
    jar {
        isEnabled = true
    }
    bootJar {
        isEnabled = false
    }
}

dependencies {
    api (project(":board-domain:article-domain"))
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