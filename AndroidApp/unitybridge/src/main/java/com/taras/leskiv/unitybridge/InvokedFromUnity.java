package com.taras.leskiv.unitybridge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tarasleskiv on 13/05/16.
 */

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface InvokedFromUnity {
}
