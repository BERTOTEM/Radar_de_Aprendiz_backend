# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función “public static void main(String[] args)”.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**


### Punto de entrada crear radar
![Image text](./img/EntradaCrearRadar.png)


### Punto de salida crear radar
![Image text](./img/SalidaCrearRadar.png)


### Punto de entrada Listar radares
![Image text](./img/EntradaListarRadares.png)


### Punto de salida Listar radares
![Image text](./img/SalidaTraerRadares.png)


### Punto de entrada Agregar Area
![Image text](./img/EntradaCrearArea.png)


### Punto de salida Agregar Area
![Image text](./img/SalidaCrearArea.png)


### Punto de entrada Eliminar Radar
![Image text](./img/EntradaEliminarRadar.png)


### Punto de salida Eliminar Radar
![Image text](./img/SalidaEliminarRadar.png)


### Punto de entrada guardar liga
![Image text](./img/EntradaCrearLiga.png)


### Punto de salida guardar liga
![Image text](./img/SalidaCrearLiga.png)


### Punto de entrada Listar Ligas
![Image text](./img/EntradaListarLigas.png)


### Punto de salida Listar Ligas
![Image text](./img/SalidaListarLigas.png)


### Punto de entrada Traer Liga
![Image text](./img/EntradaTraerLigaPorId.png)


### Punto de salida Traer Liga
![Image text](./img/SalidaTraerLigaPorId.png)


### Punto de entrada Eliminar Liga
![Image text](./img/EntradaEliminarLiga.png)


### Punto de salida Eliminar Liga
![Image text](./img/SalidaEliminarLiga.png)


### Punto de entrada Actualizar Liga
![Image text](./img/EntradaActualizarLiga.png)


### Punto de salida Actualizar liga
![Image text](./img/SalidaActualizarLiga.png)



### Punto de entrada Traer Radar
![Image text](./img/EntradaTraerUnRadar.png)


### Punto de salida Traer Radar
![Image text](./img/SalidaTraerUnRadar.png)


### Punto de entrada Crear Aprendiz
![Image text](./img/EntradaCrearAprendiz.png)


### Punto de salida Crear Aprendiz
![Image text](./img/SalidaCrearAprendiz.png)


### Punto de entrada listar aprendices
![Image text](./img/EntradaListarAprendices.png)


### Punto de salida listar aprendices
![Image text](./img/SalidaListarAprendices.png)


### Punto de entrada Actualizar Área
![Image text](./img/EntradaActualizarArea.png)


### Punto de salida Actualizar Área
![Image text](./img/SalidaActualizarArea.png)


### Punto de entrada Eliminar Área
![Image text](./img/EntradaEliminarArea.png)


### Punto de salida Eliminar Área
![Image text](./img/SalidaEliminarArea.png)


### Punto de entrada Consultar un aprendiz
![Image text](./img/EntradaListarUnAprendiz.png)


### Punto de salida Consultar un aprendiz
![Image text](./img/SalidaListarUnAprendiz.png)


### Punto de entrada Consultar un radar
![Image text](./img/EntradaTraerUnRadar.png)


### Punto de salida Consultar un radar
![Image text](./img/SalidaTraerUnRadar.png)


## Autores

* [Julian Mazo Arroyave](https://github.com/BERTOTEM)
* [Andrés Castro](https://github.com/Nirsch95) :wolf:
* [David Santiago Benjumea Perez](https://github.com/dsbpajedrez)
* [Daniel Perez Vitola](https://github.com/dapevi1997)
* [Valentina Santa Muñoz](https://github.com/Valen2605)




