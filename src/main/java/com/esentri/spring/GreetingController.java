package com.esentri.spring;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();
  private final Map<String, String> values = new HashMap<>();

  @RequestMapping("/")
  public String index() {
    return "<h1>HELLO</h1>";
  }

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
        String.format(template, name));
  }

  @RequestMapping("/double")
  public DoubleGreeting greeting(@RequestParam(value="name1", defaultValue="Max") String name1,
                                 @RequestParam(value="name2", defaultValue="Moritz") String name2) {
    return new DoubleGreeting(String.format(template, name1), String.format(template, name2));
  }

  @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
  public String simplePost(@PathVariable String id, @RequestBody String requestBody) {
    values.put(id, requestBody);
    return "200";
  }

  @RequestMapping(value = "/value", method = RequestMethod.GET)
  public String getValueById(@RequestParam String id) {
    return values.get(id);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable String id) {
    values.remove(id);
    return "200";
  }

  @RequestMapping(value = "/put/{id}/{value}", method = RequestMethod.PUT)
  public String put(@PathVariable String id, @PathVariable String value) {
    values.put(id, value);
    return "200";
  }
}
