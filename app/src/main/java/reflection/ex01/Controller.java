package reflection.ex01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 타입은 클래스. 키워드를 쓰지 않기 위해 이렇게 작성
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

}
