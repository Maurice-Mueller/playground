package annotations.processor;

import annotations.customannotations.CurrentDate;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@SupportedAnnotationTypes({})
public final class MyProcessor extends AbstractProcessor {

  /*
   * Every annotation processor class must have an empty constructor.
   * However, there is a special init() method which is invoked by the annotation processing tool
   * with the ProcessingEnviroment as parameter. The ProcessingEnviroment provides some useful util
   * classes Elements, Types and Filer.
   */
  @Override
  public synchronized void init(ProcessingEnvironment env){

  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    return false;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> supportedAnnotations = new HashSet<>();
    supportedAnnotations.add(CurrentDate.class.getName());
    return supportedAnnotations;
  }
}
