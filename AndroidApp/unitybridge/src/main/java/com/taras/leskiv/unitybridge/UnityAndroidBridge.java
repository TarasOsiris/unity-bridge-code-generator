package com.taras.leskiv.unitybridge;

import android.util.Log;

@UnityBridge(fullClassName = "com.taras.leskiv.unitybridge.UnityAndroidBridge")
public class UnityAndroidBridge {
	private static final String TAG = UnityAndroidBridge.class.getSimpleName();

	public static final String MOCK = "STRING_VALUE";

	public UnityAndroidBridge() {
		Log.d(TAG, "ctor 0 args");
	}

	@InvokedFromUnity
	public void setStringValue(String strValue) {
	}

	// region same-thread-getters
	@InvokedFromUnity
	public String getStringValue() {
		return MOCK;
	}

	@InvokedFromUnity
	public String[] getStringArrayValue() {
		return new String[]{"x", "y", "z"};
	}

	@InvokedFromUnity
	public int getIntValue() {
		return 0;
	}
	// endregion
}
