dependencies {
    api (project(":board-api:article-api"))
}

allprojects {
    dependencies {
        implementation (project(":board-common"))
    }
}