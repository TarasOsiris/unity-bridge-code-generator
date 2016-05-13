using UnityEngine;
using System.CodeDom;
using UnityEditor;
using System.CodeDom.Compiler;
using System.IO;
using Google.Developers;

namespace BridgeGenerator.Editor
{
    public class AndroidBridgeClassGenerator
    {
        private const string OutputFileName = "UnityAndroidBridge.cs";

        private const string AndroidJavaObjFieldName = "_bridgeAndroidJavaObject";

        CodeCompileUnit targetUnit;
        CodeTypeDeclaration targetClass;

        [MenuItem("Generate/Android")]
        public static void GenerateBeidge()
        {
            var bridge = new AndroidBridgeClassGenerator();
            var path = Application.dataPath + "/Generated/" + OutputFileName;
            Debug.Log(path);

            bridge.AddFields();
            bridge.AddConstructor();
            bridge.GenerateCSharpCode(path);
            AssetDatabase.Refresh();
        }

        public AndroidBridgeClassGenerator()
        {
            targetUnit = new CodeCompileUnit();
            var codeNamespace = new CodeNamespace("GeneratedBridge");
            codeNamespace.Imports.Add(new CodeNamespaceImport("UnityEngine"));

            targetClass = new CodeTypeDeclaration("UnityAndroidBridge");
            targetClass.IsClass = true;
            targetClass.TypeAttributes = System.Reflection.TypeAttributes.Public | System.Reflection.TypeAttributes.Sealed;
            codeNamespace.Types.Add(targetClass);
            targetUnit.Namespaces.Add(codeNamespace);
        }

        public void AddFields()
        {
            CodeMemberField androidJavaObjectField = new CodeMemberField();
            androidJavaObjectField.Attributes = MemberAttributes.Private;
            androidJavaObjectField.Name = AndroidJavaObjFieldName;
            androidJavaObjectField.Type = new CodeTypeReference(typeof(AndroidJavaObject));
            androidJavaObjectField.Comments.Add(new CodeCommentStatement("AndroidJavaObject representing the bridge"));

            targetClass.Members.Add(androidJavaObjectField);
        }

        public void AddConstructor()
        {
            CodeConstructor constructor = new CodeConstructor();
            constructor.Attributes = MemberAttributes.Public | MemberAttributes.Final;

            targetClass.Members.Add(constructor);
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