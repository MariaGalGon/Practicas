# Quizmaster

![Dart](https://img.shields.io/badge/dart-%230175C2.svg?style=for-the-badge&logo=dart&logoColor=white)
![Flutter](https://img.shields.io/badge/Flutter-%2302569B.svg?style=for-the-badge&logo=Flutter&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Firebase](https://img.shields.io/badge/firebase-%23039BE5.svg?style=for-the-badge&logo=firebase)
![Web](https://img.shields.io/badge/-Web-blue?style=for-the-badge&logo=appveyor?logoColor=blue)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)

En este trabajo se desarrolló una aplicación web de preguntas y respuestas, denominada Quizmaster, utilizando Flutter. Las funciones que puede realizar un usuario son:
- Registrarse o iniciar sesión.

![Login](img/login.png)

- Jugar una partida, introduciendo el número de preguntas que quiera que le aparezcan. Tras comprobar los resultados podrá guardar algunas de las preguntas para revisarlas más tarde.

![Login](img/game.png)

- Ver las preguntas que ha guardado y su respuesta correcta.
- Observar un listado con las ediciones actuales de Trivial Pursuit.
- Editar las datos de su perfil.

![Login](img/home.png)

Las preguntas y respuestas se obtuvieron utilizando la API [Open Trivia](https://opentdb.com/api_config.php). Para obtener las ediciones de Trivial Pursuit se realizó scraping a una página de [Wikipedia](https://en.wikipedia.org/wiki/List_of_Trivial_Pursuit_editions) con un proyecto de Spring Boot y una base de datos postgreSQL creada con Docker. Para guardar los datos de un usuario se utilizó Authentication y Firestore, disponibles en Firebase. También se incluyen los archivos necesarios para dockerizar el proyecto. Finalmente, se utilizó GitHub Actions y GitHub Pages para publicar la aplicación.
