/**
 * Created by tarasleskiv on 13/05/16.
 */
package com.leskiv.taras.bridgeparser;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.*;
import japa.parser.ast.expr.*;
import japa.parser.ast.visitor.DumpVisitor;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

public class JavaBridgeParser {
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println("app is running! " + args[0]);

		FileInputStream in = new FileInputStream("/Users/tarasleskiv/dev/repo/gs/unity-bridge-code-generator/AndroidApp/app/src/main/java/unitybridge/tarasleskiv/com/androidsource/unity/UnityAndroidBridge.java");

		CompilationUnit cu;
		try {
			// parse the file
			cu = JavaParser.parse(in);
		} finally {
			in.close();
		}

		// visit and print the methods names
		new MethodVisitor().visit(cu, null);

	}

	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes.
	 */
	private static class MethodVisitor extends VoidVisitorAdapter {

		@Override
		public void visit(MethodDeclaration n, Object arg) {
			// here you can access the attributes of the method.
			// this method will be called for all methods in this
			// CompilationUnit, including inner class methods

			System.out.println("arg: " + arg + "\n");


			System.out.println("name: " + n.getName() + "\n");
			System.out.println("body: " + n.getBody() + "\n");
			System.out.println("return type: " + n.getType() + "\n");
			System.out.println("return type: " + n.getType() + "\n");

			List<AnnotationExpr> annotations = n.getAnnotations();
			if(annotations != null)
			{
				System.out.println("ANNOTATIONS: \n");
				for (AnnotationExpr annotation : annotations)
				{
					System.out.println("annotation: " + annotation.toString() + "\n");
					System.out.println("annotation: " + annotation.getName() + "\n");
				}
			}

			if (n.getParameters() != null)
			{
				System.out.println("PARAM: \n");
				for (Parameter param : n.getParameters()) {
					System.out.println("param: " + param.toString() + "\n");
					System.out.println("param type: " + param.getType() + "\n");
					System.out.println("param name: " + param.getId() + "\n");
					System.out.println("param name: " + param.getId() + "\n");
				}
			}
			System.out.println("============================================================");
			super.visit(n, arg);
		}


		@Override
		public void visit(ClassOrInterfaceDeclaration n, Object arg) {
			System.out.println("CLASS: " + n.getName() + "\n");

			List<AnnotationExpr> annotations = n.getAnnotations();
			if(annotations != null)
			{
				System.out.println("CLASS ANNOTATIONS: \n");
				for (AnnotationExpr annotationExpr : annotations)
				{
					System.out.println("annotationExpr: " + annotationExpr.toString() + "\n");
					System.out.println("annotationExpr: " + annotationExpr.getName() + "\n");
				}
			}

			super.visit(n, arg);
		}

		@Override
		public void visit(MarkerAnnotationExpr n, Object arg) {
			System.out.println(">>> MarkerAnnotationExpr " + n.getName());
			super.visit(n, arg);
		}

		@Override
		public void visit(SingleMemberAnnotationExpr n, Object arg) {
			System.out.println(">>> SingleMemberAnnotationExpr " + n.getName());
			super.visit(n, arg);
		}

		@Override
		public void visit(NormalAnnotationExpr n, Object arg) {
			System.out.println(">>> NormalAnnotationExpr " + n.getName());
			for (MemberValuePair vp : n.getPairs())
			{
				System.out.println("\t>>> NormalAnnotationExpr " + vp.toString());
				System.out.println("\t>>> NormalAnnotationExpr " + vp.getName());
				System.out.println("\t>>> NormalAnnotationExpr " + vp.getValue());
			}
			super.visit(n, arg);
		}

		@Override
		public void visit(AnnotationMemberDeclaration n, Object arg) {
			System.out.println(">>> AnnotationMemberDeclaration " + n.getName());

			super.visit(n, arg);
		}

		@Override
		public void visit(AnnotationDeclaration n, Object arg) {
			System.out.println(">>> AnnotationDeclaration " + n.getName());

			super.visit(n, arg);
		}
	}
}
