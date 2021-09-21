/*
 * A class that gets input from the user using Scanner class for (Integer/Long/Double) in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */


import static utils.Utilities.writeFile;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class GenINPUT {

	 public static void main(String[] args){

	        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"GetInput", null, "java/lang/Object",null);
	        
	        {
				MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
				mv.visitCode();
				mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
				mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
				mv.visitInsn(Opcodes.RETURN);
				mv.visitMaxs(1,1);
				mv.visitEnd();
			}// end of constructor 

	        {
	            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
			
	            mv.visitCode();
	            /**
	             * Getting input from the user for Integer/Double/Long
	             */
	            
	            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            	mv.visitInsn(Opcodes.DUP);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            	mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            	mv.visitVarInsn(Opcodes.ASTORE, 1);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            	mv.visitLdcInsn("Enter an Integer: ");
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            	mv.visitVarInsn(Opcodes.ALOAD, 1);
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            	mv.visitInsn(Opcodes.POP);
            	//end Integer input
            
            
                                   
            	mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            	mv.visitInsn(Opcodes.DUP);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            	mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            	mv.visitVarInsn(Opcodes.ASTORE, 1);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            	mv.visitLdcInsn("Enter a Double: ");
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            	mv.visitVarInsn(Opcodes.ALOAD, 1);
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextDouble", "()D", false);
            	mv.visitInsn(Opcodes.POP2);
            	//end Double input
            
            
            
            	mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            	mv.visitInsn(Opcodes.DUP);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            	mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            	mv.visitVarInsn(Opcodes.ASTORE, 1);
            	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            	mv.visitLdcInsn("Enter a Long: ");
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            	mv.visitVarInsn(Opcodes.ALOAD, 1);
            	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextLong", "()J", false);
            	mv.visitInsn(Opcodes.POP2);
            	//end Long input
	            
	            
	            
	            
	        mv.visitInsn(Opcodes.RETURN);
	        mv.visitMaxs(0,0);
	        mv.visitEnd();
	        }// end of MethodVisitor

	        cw.visitEnd();

	        byte[] b = cw.toByteArray();

	        writeFile(b,"GetInput.class");
	        
	        System.out.println("Done!");
	    }//end main
	}//end class
