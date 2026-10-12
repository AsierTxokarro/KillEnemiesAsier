## Extensión del juego: KillEnemiesAsier

### Organización del proyecto

El proyecto contiene la versión original del juego y una versión ampliada desarrollada como extensión opcional.

La versión ampliada se encuentra en el siguiente paquete dentro de `src`:

`org.cuatrovientos.KillEnemiesAsier.extension`

### Versión original

La versión original del juego se mantiene en el paquete principal:

`org.cuatrovientos.KillEnemiesAsier`

Esta versión conserva las clases y funcionalidades originales del ejercicio.

### Versión extendida

Dentro del paquete `extension` se encuentra la implementación de las nuevas funcionalidades del juego. Esta versión se ejecuta de forma independiente mediante la clase `mainExtendida`.

Las principales ampliaciones incorporadas son:

- **Nuevos personajes:** `SuperHero` y `DarkNight`, con características y comportamientos adicionales.
- **Sistema de vida:** los nuevos personajes disponen de puntos de vida que disminuyen al recibir daño.
- **Sistema de combate:** se incorpora daño variable y se establecen reglas de ataque según el tipo de personaje.
- **Eliminación de personajes:** los personajes pueden morir y ser retirados de la lista de personajes de la partida.
- **Selección de objetivos:** el programa muestra los objetivos válidos según el personaje seleccionado.
- **Persistencia de la partida:** se mantiene la posibilidad de guardar y cargar el estado del juego mediante serialización.

### Objetivo de la extensión

El objetivo de esta ampliación es añadir nuevas mecánicas y posibilidades al juego sin modificar las clases originales. De este modo, ambas versiones quedan diferenciadas y se puede ejecutar y probar la versión extendida de forma independiente.
