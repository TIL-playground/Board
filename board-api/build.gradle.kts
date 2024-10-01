dependencies {
    api (project(":board-api:article-api"))
}

subprojects {
    dependencies {
        implementation (project(":board-common"))
    }
}