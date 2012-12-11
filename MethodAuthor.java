import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@ClassAuthor(who="Michael Ion")
/**
 * Ermöglicht Annotationen für Methoden zur Laufzeit,
 * die den Autor der Methode beinhalten. Wird keiner
 * angegeben, ist der Wert "OOP134"
 */
public @interface MethodAuthor {
	@MethodAuthor(who="Michael Ion")
	String who() default "OOP134";
}