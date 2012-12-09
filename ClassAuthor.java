import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@ClassAuthor(who="Michael Ion")
public @interface ClassAuthor {
	@MethodAuthor(who="Michael Ion")
	String who() default "OOP134";
}