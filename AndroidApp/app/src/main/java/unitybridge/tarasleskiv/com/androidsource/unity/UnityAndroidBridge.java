/**
 * Created by tarasleskiv on 10/05/16.
 */

package unitybridge.tarasleskiv.com.androidsource.unity;

import android.util.Log;

@UnityBridge(fullClassName = "test")
public final class UnityAndroidBridge {
	private static final String TAG = UnityAndroidBridge.class.getSimpleName();

	public static final String MOCK = "STRING_VALUE";

	public UnityAndroidBridge() {
		Log.d(TAG, "UnityAndroidBridge constructor without params");
	}

	@InvokedFromUnity
	public static void setStringValue(String strValue) {
	}

	@InvokedFromUnity
	public static String getStringValue() {
		return MOCK;
	}
}
