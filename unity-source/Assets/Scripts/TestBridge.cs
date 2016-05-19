using UnityEngine;
using System.Collections;

public class TestBridge : MonoBehaviour
{
    public void Click()
    {
        var bridge = new AndroidNativeBridgeWrapper();
    }
}
