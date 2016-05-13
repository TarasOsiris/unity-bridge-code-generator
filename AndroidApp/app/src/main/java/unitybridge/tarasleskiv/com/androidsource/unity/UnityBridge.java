package unitybridge.tarasleskiv.com.androidsource.unity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tarasleskiv on 13/05/16.
 */

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface UnityBridge {
	String fullClassName();
}
