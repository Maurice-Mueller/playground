package annotations.processor;

import annotations.customannotations.CurrentDate;
import annotations.customannotations.SimpleStringAnnotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Set;

//based on: http://hannesdorfmann.com/annotation-processing/annotationprocessing101

@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@SupportedAnnotationTypes({})
public final class MyProcessor extends AbstractProcessor {

  private Types typeUtils;
  private Elements elementUtils;
  private Filer filer;
  private Messager messager; //for printing stuff for the third party developer (who is using your processor)

  /*
     * Every annotation processor class must have an empty constructor.
     * However, there is a special init() method which is invoked by the annotation processing tool
     * with the ProcessingEnviroment as parameter. The ProcessingEnviroment provides some useful util
     * classes Elements, Types and Filer.
     */
  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    typeUtils = processingEnv.getTypeUtils();
    elementUtils = processingEnv.getElementUtils();
    filer = processingEnv.getFiler();
    messager = processingEnv.getMessager();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    roundEnv.getElementsAnnotatedWith(CurrentDate.class).stream()
        .filter(element -> element.getKind() == ElementKind.FIELD)
        .forEach(element -> {
         // error(element, "test", new Object());
        });
    roundEnv.getElementsAnnotatedWith(SimpleStringAnnotation.class).stream()
        .filter(element -> element.getKind() == ElementKind.FIELD)
        .forEach(element -> {
          SimpleStringAnnotation annotation = element.getAnnotation(SimpleStringAnnotation.class);
          annotation.value();

        });
    return true;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> supportedAnnotations = new HashSet<>();
    supportedAnnotations.add(CurrentDate.class.getCanonicalName());
    supportedAnnotations.add(SimpleStringAnnotation.class.getCanonicalName());
    return supportedAnnotations;
  }

  private void error(Element element, String message, Object... args) {
    messager.printMessage(Diagnostic.Kind.ERROR, String.format(message, args), element);
  }
}
