package com.taras.leskiv.unitybridge;

import android.util.Log;
import com.unity3d.player.UnityPlayer;

@UnityBridge(fullClassName = "test")
public class AwesomeBridge {
	static {
		AwesomeBridge X = new AwesomeBridge();
	}

	private static final String TAG = AwesomeBridge.class.getSimpleName();

	public static final String MOCK = "STRING_VALUE";

	public AwesomeBridge() {
		Log.d(TAG, "AwesomeBridge constructor without params " + UnityPlayer.currentActivity.getPackageName());
	}

	@InvokedFromUnity
	public void setStringValue(String strValue) {
	}

	@InvokedFromUnity
	public String getStringValue() {
		return MOCK;
	}
}
