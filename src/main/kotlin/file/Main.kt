package file

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import location.Listing
import java.io.File

/**
 * @author    yiliyang
 * @date      2022/3/28 上午11:03
 * @version   1.0
 * @since     1.0
 */
fun main() {
    embeddedServer(Netty, port = 8081) {
        install(DefaultHeaders)
        install(CallLogging)
        routing {
            routeFilesystem()
        }
    }.start(wait = true)
}

fun Route.routeFilesystem() {
    static("static") {
        // When running under IDEA make sure that working directory is set to this sample's project folder
        staticRootFolder = File("files")
        files("css")
        files("js")
        file("image.png")
        file("random.txt", "image.png")
        default("index.html")
    }
    static("custom") {
        staticRootFolder = File("tmp") // Establishes a root folder
        file("image-1.png")
        files("public") // For this to work, make sure you have /tmp/public on your system
        static("themes") {
            // services /custom/themes
            files("data")
        }
    }
}