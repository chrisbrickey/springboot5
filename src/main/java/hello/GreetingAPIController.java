package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //marks the class as a controller where every method returns a domain object instead of a view. It’s shorthand for @Controller and @ResponseBody rolled together.
public class GreetingAPIController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  // The below example does not specify GET vs. PUT, POST, and so forth, because @RequestMapping maps all HTTP operations by default. Use @RequestMapping(method=GET) to narrow this mapping
  @RequestMapping("/api/greeting") //ensures that HTTP requests to api/greeting are mapped to the greetingAPI() method

  // @RequestParam binds the value of the query string parameter name into the name parameter of the greetingAPI() method.
  // http://localhost:8080/api/greeting => { id:1, content: "Hello, World!"}
  // http://localhost:8080/api/greeting?name=Chris => { id;2, content: "Hello, Chris!"}
  // ...it's creating a new object every time
  public GreetingModel greetingAPI(@RequestParam(value="name", defaultValue="World") String name) {
    return new GreetingModel(counter.incrementAndGet(), String.format(template, name));
  }
}

// The GreetingModel object must be converted to JSON.
//Thanks to Spring’s HTTP message converter support, you don’t need to do this conversion manually.
//Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the GreetingModel instance to JSON.
