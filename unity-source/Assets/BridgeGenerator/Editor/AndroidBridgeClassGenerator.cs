using UnityEngine;
using System.CodeDom;
using UnityEditor;
using System.CodeDom.Compiler;
using System.IO;

namespace BridgeGenerator.Editor
{
    public class AndroidBridgeClassGenerator
    {
        private const string OutputFileName = "UnityAndroidBridge.cs";

        CodeCompileUnit targetUnit;
        CodeTypeDeclaration targetClass;

        [MenuItem("Generate/Android")]
        public static void GenerateBeidge()
        {
            var bridge = new AndroidBridgeClassGenerator();
            var path = Application.dataPath + "/Generated/" + OutputFileName;
            Debug.Log(path);
            bridge.GenerateCSharpCode(path);
            AssetDatabase.Refresh();
        }

        public AndroidBridgeClassGenerator()
        {
            targetUnit = new CodeCompileUnit();
            var codeNamespace = new CodeNamespace("GeneratedBridge");

            targetClass = new CodeTypeDeclaration("UnityAndroidBridge");
            targetClass.IsClass = true;
            targetClass.TypeAttributes = System.Reflection.TypeAttributes.Public | System.Reflection.TypeAttributes.Sealed;
            codeNamespace.Types.Add(targetClass);
            targetUnit.Namespaces.Add(codeNamespace);
        }

        public void GenerateCSharpCode(string fileName)
        {
            CodeDomProvider provider = CodeDomProvider.CreateProvider("CSharp");
            var options = new CodeGeneratorOptions();
            options.BracingStyle = "C";
            using (StreamWriter sourceWriter = new StreamWriter(fileName))
            {
                provider.GenerateCodeFromCompileUnit(targetUnit, sourceWriter, options);
            }
        }
    }
}