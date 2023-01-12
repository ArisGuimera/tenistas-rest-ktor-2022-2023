# Tenistas REST Ktor

Api REST de Tenistas con Ktor para Programación de Servicios y Procesos de 2º de DAM. Curso 2022/2023

[![Kotlin](https://img.shields.io/badge/Code-Kotlin-blueviolet)](https://kotlinlang.org/)
[![LICENSE](https://img.shields.io/badge/Lisence-CC-%23e64545)](https://joseluisgs.dev/docs/license/)
![GitHub](https://img.shields.io/github/last-commit/joseluisgs/tenistas-rest-ktor-2022-2023)

![imagen](./images/ktor.png)

- [Tenistas REST Ktor](#tenistas-rest-ktor)
  - [Descripción](#descripción)
    - [Tecnologías](#tecnologías)
  - [Problema](#problema)
  - [Ktor](#ktor)
    - [Punto de Entrada](#punto-de-entrada)
    - [Creando rutas](#creando-rutas)
  - [Recursos](#recursos)
  - [Autor](#autor)
    - [Contacto](#contacto)
    - [¿Un café?](#un-café)
  - [Licencia de uso](#licencia-de-uso)

## Descripción
El siguiente proyecto es una API REST de Tenistas con Ktor para Programación de Servicios y Procesos de 2º de DAM. Curso 2022/2023. En ella se pretende crear un servicio completo para la gestión de tenistas, raquetas y representantes de marcas de raquetas.

El objetivo es que el alumnado aprenda a crear un servicio REST con Ktor, con las operaciones CRUD, securizar el servicio con JWT y usar un cliente para consumir el servicio.

Se pretende que el servicio completo sea asíncrono y reactivo en lo máximo posible.

Además que permita escuchar cambios en tiempo real usando websocket y tener una página web de presentación

### Tecnologías
- [Ktor](https://ktor.io/) - Framework para crear servicios web en Kotlin asíncronos y multiplataforma.
- [JWT](https://jwt.io/) - JSON Web Token para la autenticación y autorización.
- [Bcrypt](https://en.wikipedia.org/wiki/Bcrypt) - Algoritmo de hash para encriptar contraseñas.
- [Koin](https://insert-koin.io/) - Framework para la inyección de dependencias.

## Problema
Gestionar tenistas, raquetas y representantes de marcas de raquetas.


## Ktor
[Ktor](https://ktor.io/) es el framework para desarrollar servicios y clientes asincrónicos. Es 100% [Kotlin](https://kotlinlang.org/) y se ejecuta en usando [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html). Admite proyectos multiplataforma, lo que significa que puede usarlo para cualquier proyecto dirigido a JVM, Android, iOS, nativo o Javascript. En este proyecto aprovecharemos Ktor para crear un servicio web para consumir una API REST. Además, aplicaremos Ktor para devolver páginas web.

### Punto de Entrada
El servidor tiene su entrada y configuración en la clase Application. Esta lee la configuración en base al [fichero de configuración](./src/main/resources/application.conf) y a partir de aquí se crea una instancia de la clase Application en base a la configuración de module().

### Creando rutas
Las rutas se definen creando una función de extensión sobre Route. A su vez, usando DSL se definen las rutase en base a las petición HTTP sobre ella. Podemos responder a la petición usando call.respondText(), para texto; call.respondHTML(), para contenido HTML usando [Kotlin HTML DSL](https://github.com/Kotlin/kotlinx.html); o call.respond() para devolver una respuesta en formato JSON o XML.
finalmente asignamos esas rutas a la instancia de Application, es decir, dentro del método module(). Un ejemplo de ruta puede ser:

```kotlin
routing {
    // Entrada en la api
    get("/") {
        call.respondText("👋 Hola Kotlin REST Service con Kotlin-Ktor")
    }
}
```

## Recursos
- Twitter: https://twitter.com/joseluisgonsan
- GitHub: https://github.com/joseluisgs
- Web: https://joseluisgs.github.io
- Discord del módulo: https://discord.gg/RRGsXfFDya
- Aula DAMnificad@s: https://discord.gg/XT8G5rRySU


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/joseluisgonsan)

[![Twitter](https://img.shields.io/twitter/follow/joseluisgonsan?style=social)](https://twitter.com/joseluisgonsan)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto
<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.github.io/" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/joseluisgonsan" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://discordapp.com/users/joseluisgs#3560" target="_blank">
        <img src="https://logodownload.org/wp-content/uploads/2017/11/discord-logo-4-1.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>    
</p>

### ¿Un café?
<p><a href="https://www.buymeacoffee.com/joseluisgs"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" height="50" alt="joseluisgs" /></a></p><br><br><br>

## Licencia de uso

Este repositorio y todo su contenido está licenciado bajo licencia **Creative Commons**, si desea saber más, vea la [LICENSE](https://joseluisgs.dev/docs/license/). Por favor si compartes, usas o modificas este proyecto cita a su autor, y usa las mismas condiciones para su uso docente, formativo o educativo y no comercial.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">JoseLuisGS</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="https://joseluisgs.dev/" property="cc:attributionName" rel="cc:attributionURL">José Luis González Sánchez</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional License</a>.<br />Creado a partir de la obra en <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/joseluisgs" rel="dct:source">https://github.com/joseluisgs</a>.
