package reflection.ex01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메서드 위에 붙이기
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String uri();
}
