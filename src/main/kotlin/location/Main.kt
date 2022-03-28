package location

import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

/**
 * @author    yiliyang
 * @date      2022/3/28 上午10:52
 * @version   1.0
 * @since     1.0
 */
fun main() {
    embeddedServer(Netty, port = 8081) {
        install(Locations)

        routing {
            get<Listing> { listing ->
                call.respondText("Listing ${listing.name}, page ${listing.page}")
            }
        }

    }.start(wait = true)
}