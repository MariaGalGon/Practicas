# Procesos de Ingeniería del Software 1

El código de este proyecto está realizado con Dart y Flutter.

En esta práctica se desarrolló una aplicación para Tablet de gestión de requisitos y su base de datos. Existen dos tipos de usuarios:

- Desarrollador: puede crear proyectos, añadir requisitos y clientes a cada proyecto y generar versiones. Para seleccionar los requisitos de cada versión se usa un algoritmo de tipo mochila, que ordenará los requisitos de mayor a menor satisfacción. Sin embargo, el usuario puede cambiar manualmente estos requisitos y hacer la selección que desee. Además, se calculan distintas métricas para cada versión generada en los proyectos.
- Cliente: puede acceder a los proyectos que ha sido asignado y valorar cada requisito. Esta valoración se tendrá en cuenta al calcular la satisfacción de cada requisito en la generación de nuevas versiones.
