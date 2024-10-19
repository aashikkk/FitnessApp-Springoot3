#### Different way to start the application

* Use play button
* by using cmd:
   ` ./mvnw spring-boot:run`
  * Can be found Under the 
  ```
  - maven runner
        - plugin 
            - spring-boot
      
  ```
    
* To check port: `jps`
* To kill: `kill -"code"`

Traditional way to call it,

        // WelcomeMessage.java
        @Component
        public class WelcomeMessage {
            public String getWelcomeMessage(){
                return "Welcome to Spring boot Application";
            }
        }
        
        //Application.java
        var welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.getWelcomeMessage());

But in spring we don't need to do it like here. That's why we are
using Spring to simplify things.

Huge container of all the classes in application called Application Context,
and we can ask the application context for the particular class. In this case, WelcomeMessage.

Create a context variable from SpringApplication.
Create getBean from that context then save it as welcomeMessage

### BEAN

Bean is nothing more than an instance of a class with some metadata around it.

Instance of a class that the Spring Container, this huge application context is container of Objects is managing for me

#### Special Log

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
            log.info("Application started successfully");

We can have structure like **model, controller, service and repository** etc. 
But having like feature function is kind easy to use and can have private access 
within as well.
    Ex: **user, run**

For Model, We need getters, setters, hashCode, equal, toString, Constructor.
But creating by record, we have all inside with that. also those entries immutable(Integer id)
Note: 
* To create an object.
  1. [x] context.getBean("nameOfClass").var --> enter, then it will create a Object.
* Also don't put code outside the pkg or in the default pkg.

```
// For the demonstration purpose
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
    System.out.println(welcomeMessage);
  
  ```

