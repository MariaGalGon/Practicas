# Procesos de Ingeniería del Software 1

![Dart](https://img.shields.io/badge/dart-%230175C2.svg?style=for-the-badge&logo=dart&logoColor=white)
![Flutter](https://img.shields.io/badge/Flutter-%2302569B.svg?style=for-the-badge&logo=Flutter&logoColor=white)
![Moor](https://img.shields.io/badge/-Moor-blue?style=for-the-badge&logo=appveyor?logoColor=blue)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![IOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=ios&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)

En esta práctica se desarrolló una aplicación para Tablet (Android e iOS) de gestión de requisitos y su base de datos. Existen dos tipos de usuarios:

- Desarrollador: puede crear proyectos, añadir requisitos y clientes a cada proyecto y generar versiones. Para seleccionar los requisitos de cada versión se usa un algoritmo de tipo mochila, que ordenará los requisitos de mayor a menor satisfacción. Sin embargo, el usuario puede cambiar manualmente estos requisitos y hacer la selección que desee. Además, se calculan distintas métricas para cada versión generada en los proyectos.
- Cliente: puede acceder a los proyectos que ha sido asignado y valorar cada requisito. Esta valoración se tendrá en cuenta al calcular la satisfacción de cada requisito en la generación de nuevas versiones.
