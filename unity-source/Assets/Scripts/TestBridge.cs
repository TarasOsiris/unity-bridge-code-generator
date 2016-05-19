using UnityEngine;
using System.Collections;

public class TestBridge : MonoBehaviour
{
    public void Click()
    {
//        var bridge = new AndroidNativeBridgeWrapper();
        using(AndroidJavaObject clazz = new AndroidJavaClass("unitybridge.tarasleskiv.com.unitybridge.UnityAndroidBridge"))
        {
            string x = clazz.CallStatic<string>("getStringValue");
            Debug.Log(x);
        }
    }
	
}
