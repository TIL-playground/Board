dependencies {
    api (project(":board-application:article-application"))
}

subprojects {
    dependencies {
        implementation(project(":board-common"))
    }
}