# Simple user API
I created this simple user API for my personal contribution to my theses which I had to write for school. It utilizes SpringBoot to host some simple REST endpoints for managing users, which are stored inside a MariaDB database. It also has OpenAPI and SwaggerUI built into it to visualize what it can do.

## Getting started
To run this simple API application on your server you only need to follow a few simple steps. <br>
**System requirements:** A Linux machine with a relatively modern version of docker-compose installed. (If you're running on another OS you might have to adjust some things inside the Dockerfile. For example, for Windows the `RUN ./gradlew build` has to be changed to `RUN ./gradlew.bat build`.)
### How to get it running
**1.** Clone this GitHub repository onto your machine by either running:
````shell
git clone https://github.com/trxsson/simple-user-api.git
````
or downloading the repository manually to your machine. <br><br>
**2.** Open up the ``docker-compose.yml`` file and change the values of the pre-defined environment variables to hold your database credentials. The user table is being created once the application runs. <br><br>
**3.** In your terminal, navigate inside the repository folder and run:
````shell
docker-compose build
````
**4.** After the process is finished (might take up to a minute), execute:
````shell
docker-compose up -d
````
**The application will now be available at http://localhost:8080, given you didn't change any of the port options.** <br>
To stop the application, head back to the repository folder and run:
````shell
docker-compose down
````
