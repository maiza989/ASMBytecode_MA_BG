/**
 * A class that gets input from the user using Scanner class for (Integer/Long/Double) in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class GenInput {

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
	            /**
	             * Creating labels
	             */
	            Label l0 = new Label();
	            mv.visitCode();
	            /**
	             * Getting input from the user
	             */
	            
				
	            mv.visitTypeInsn(Opcodes.NEW, "class java/util/Scanner");
	            mv.visitInsn(Opcodes.DUP);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
	            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner","<init>","(Ljava/io/InputStream;)V", false);
	            mv.visitVarInsn(Opcodes.ASTORE, 1);
	            mv.visitVarInsn(Opcodes.ALOAD, 1);
	            mv.visitLabel(l0);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); 
				mv.visitLdcInsn("Enter a number between 0 and 100:");
				mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	          //  mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "hava/util/Scanner","nextInt:", "()I", false);
	           // mv.visitVarInsn(Opcodes.ISTORE, 2);
	           // mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            // end of GetInput
	            
	            
	            
	            
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