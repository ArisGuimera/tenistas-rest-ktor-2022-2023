package joseluisgs.es

import io.ktor.server.application.*
import io.ktor.server.netty.*
import joseluisgs.es.plugins.*
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    logger.debug { "Starting Ktor Application" }
    // logger.debug { environment.config.property("ktor.environmet").getString() }


    // Configuramos e iniciamos cada elemento o Plugin que necesitamos

    // configureSecurity()
    configureSerialization() // Configuramos la serialización
    configureRouting() // Configuramos las rutas
    configureValidation() // Configuramos la validación de body en requests, puedes hacerlo a mano

    // Muy opcionales
    configureCachingHeaders() // Configuramos los headers de cacheo, sobre todo para web, no obligatorio
    configureCompression() // Configuramos el compreso de gzip, sobre todo para web, no obligatorio
    configureCors() // Configuramos el CORS, sobre todo para web, muy interesante para proteger consultas cruzadas)
}
