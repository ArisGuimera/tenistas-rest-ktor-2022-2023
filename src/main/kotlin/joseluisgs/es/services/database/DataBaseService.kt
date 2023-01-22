package joseluisgs.es.services.database

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactoryOptions
import joseluisgs.es.config.DataBaseConfig
import joseluisgs.es.entities.UsersTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.koin.core.annotation.Single
import org.ufoss.kotysa.H2Tables
import org.ufoss.kotysa.r2dbc.sqlClient
import org.ufoss.kotysa.tables

private val logger = KotlinLogging.logger {}

@Single
class DataBaseService(
    private val dataBaseConfig: DataBaseConfig
) {


    private val connectionOptions = ConnectionFactoryOptions.builder()
        .option(ConnectionFactoryOptions.DRIVER, dataBaseConfig.driver)
        .option(ConnectionFactoryOptions.PROTOCOL, dataBaseConfig.protocol)  // file, mem
        .option(ConnectionFactoryOptions.USER, dataBaseConfig.user)
        .option(ConnectionFactoryOptions.PASSWORD, dataBaseConfig.password)
        .option(ConnectionFactoryOptions.DATABASE, dataBaseConfig.database)
        .build()

    val client = ConnectionFactories
        .get(connectionOptions)
        .sqlClient(getTables())

    val initData get() = dataBaseConfig.initDatabaseData


    fun initDataBaseService() {
        logger.debug { "Inicializando servicio de Bases de Datos: ${dataBaseConfig.database}" }
        // creamos las tablas
        createTables()
    }


    private fun getTables(): H2Tables {
        // Creamos un objeto H2Tables con las tablas de la base de datos
        // Entidades de la base de datos
        return tables()
            .h2(UsersTable)
    }

    private fun createTables() = runBlocking {
        val scope = CoroutineScope(Dispatchers.IO)
        logger.debug { "Creando tablas de la base de datos" }
        // Creamos las tablas
        scope.launch {
            client createTableIfNotExists UsersTable
        }
    }
}