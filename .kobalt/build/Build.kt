import com.beust.kobalt.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*
import com.beust.kobalt.plugin.packaging.*
// /Users/axj1l59/Desktop/kotlin-server/kobalt/src/Build.kt


val p = project {
    name = "kotlin-server"
    group = "com.example"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.11")
        compile("io.ktor:ktor-server-netty:0.9.2")
    }

    dependenciesTest {
        compile("org.testng:testng:6.11")
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