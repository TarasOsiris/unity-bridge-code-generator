/**
 * Created by tarasleskiv on 10/05/16.
 */

package unitybridge.tarasleskiv.com.unitybridge;

import android.util.Log;
import com.unity3d.player.UnityPlayer;

@UnityBridge(fullClassName = "test")
public class UnityAndroidBridge {
	private static final String TAG = UnityAndroidBridge.class.getSimpleName();

	public static final String MOCK = "STRING_VALUE";

	public UnityAndroidBridge() {
		Log.d(TAG, "UnityAndroidBridge constructor without params " + UnityPlayer.currentActivity.getPackageName());
	}

	@InvokedFromUnity
	public void setStringValue(String strValue) {
	}

	@InvokedFromUnity
	public String getStringValue() {
		return MOCK;
	}
}
