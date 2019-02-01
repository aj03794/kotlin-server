import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*

val bs = buildScript {
    repos(
        "https://dl.bintray.com/cbeust/maven/",
        "https://dl.bintray.com/kotlin/ktor"
    )
}

val p = project {
    name = "kotlin-server"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("src")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.11")
        compile("io.ktor:ktor-server-netty:0.9.2")
        compile("io.ktor:ktor-gson:0.9.2")
        compile("ch.qos.logback:logback-classic:1.2.1")
    }

    assemble {
       jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "com.example.MainKt")
            }
        }
    }

    application {
        mainClass = "com.example.MainKt"
    }
}