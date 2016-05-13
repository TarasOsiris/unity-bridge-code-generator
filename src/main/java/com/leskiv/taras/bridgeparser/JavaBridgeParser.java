/**
 * Created by tarasleskiv on 13/05/16.
 */
package com.leskiv.taras.bridgeparser;

import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaBridgeParser {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("app is running! " + args[0]);

		FileInputStream in = new FileInputStream("/Users/tarasleskiv/dev/repo/gs/unity-bridge-code-generator/AndroidApp/app/src/main/java/unitybridge/tarasleskiv/com/androidsource/unity/UnityAndroidBridge.java");

		CompilationUnit cu;

	}
}
