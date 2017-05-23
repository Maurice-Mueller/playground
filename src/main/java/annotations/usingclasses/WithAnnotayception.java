package annotations.usingclasses;

import annotations.customannotations.Annotayception;
import annotations.customannotations.ForAnnotayception;

@Annotayception(
    subAnnotation = @ForAnnotayception(value = 200),
    subAnnotations = {@ForAnnotayception(200), @ForAnnotayception(300)}
    )
public final class WithAnnotayception {

}
