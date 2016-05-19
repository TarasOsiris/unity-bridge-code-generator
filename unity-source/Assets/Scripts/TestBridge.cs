using UnityEngine;
using System.Collections;

public class TestBridge : MonoBehaviour
{
    public void Click()
    {
//        var bridge = new AndroidNativeBridgeWrapper();
        using(AndroidJavaObject clazz = new AndroidJavaClass("com.taras.leskiv.unitybridge.AwesomeBridge"))
        {
            Debug.Log(clazz.ToString());
        }
    }
	
}
