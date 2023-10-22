import dependencies.addEntityModule
import dependencies.addRoomDependencies

plugins {
    plugins.`android-core-library`
}
android {
    namespace = "com.example.domain"
}
dependencies {
    addEntityModule(configurationName = "api")
    addRoomDependencies()
}