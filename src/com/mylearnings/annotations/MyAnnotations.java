package com.mylearnings.annotations;

import java.lang.annotation.*;

/**
 * Created by ronnie on 4/11/17.
 */

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    String authorName();
    int revision() default 1;
    String comments();


}
