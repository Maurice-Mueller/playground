package usingclasses;

import customannotations.Annotayception;
import customannotations.ForAnnotayception;

@Annotayception(
    subAnnotation = @ForAnnotayception(value = 200),
    subAnnotations = {@ForAnnotayception(200), @ForAnnotayception(300)}
    )
public final class WithAnnotayception {

}
