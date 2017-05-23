package annotations.processor;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomAnnotationProcessor {
  static {
    ClassLoader classLoader = CustomAnnotationProcessor.class.getClassLoader();
    List<URL> urlList = new ArrayList<>();
    while(classLoader != null) {
      if(classLoader instanceof URLClassLoader) {
        Arrays.stream(((URLClassLoader) classLoader).getURLs())
            .filter(url -> url.getPath().startsWith("annotations."))
            .forEach(urlList::add);
      }
      classLoader = classLoader.getParent();
    }
    urlList.forEach(System.out::println);
  }
}
