# Real-Time Analytics Dashboard
## I choose Scenario #2 : Real-Time Analytics Dashboard
We picked the Real-Time Dashboard project because it feels like a real-world problem we can learn a lot from. It lets us practice the main topics from our backend training in a single, practical project.

### Why?
1. It uses everything we’ve learned.
How services talk to each other: We can try out different methods like HTTP and WebSockets and see which one works better for live data.
Handling data: We get to decide should we store temporary data in memory for speed, or use a database.

2. It’s all about handling high volume.
The numbers are big 10,000 servers. This forces us to think about questions like:
How do we build an API that doesn’t crash when it gets thousands of requests every second?
How do we send live updates to 500 people at once without overloading the server?

3. The result is something we can actually see.
Even though we aren't building the front-end visual dashboard itself, we are building the entire backend API and we can test this by sending data in and watching our APIs return real-time results.

4. It Lets Us Build a  Multi-Service System.

5. Solves Key Technical Challenges: The system must efficiently manage high CPU load from data aggregation and I/O-intensive tasks like storing historical data.
   
## Setup the enviroment:

- Downlaod JDK
- BellSoft Liberica JDK (https://bell-sw.com/pages/downloads/#jdk-21-lts)
- install: VS Code then => install: Spring Boot tool, spring initialiser java support, and Spring Boot Extension Pack.

For Runing the Spring Boot App:
pre request: (jdk)

```bash
.\mvnw.cmd spring-boot:run
```


