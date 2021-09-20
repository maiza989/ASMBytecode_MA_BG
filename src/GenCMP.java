/**
 * A class that compare two number to determine which is bigger/smaller (Integer/Long/Double) in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class GenCMP {

	 public static void main(String[] args){

	        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"CMPNumbers", null, "java/lang/Object",null);
	        
	        {
				MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
				mv.visitCode();
				mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
				mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
				mv.visitInsn(Opcodes.RETURN);
				mv.visitMaxs(1,1);
				mv.visitEnd();
			}
	        
	        {

	            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
	            /**
	             * Creating Labels 
	             */
	            Label l0 = new Label();
	            Label l1 = new Label();
	            // end Of label CMP Double
	            Label l2 = new Label();
	            Label l3 = new Label();
	            // end of label CMP Long
	            Label l4 = new Label();
	            Label l5 = new Label();
	            // end of label CMP Float
	            
	            mv.visitCode();
	            
	            /**
	             * Comparing two Double/Long/Integer number with non-zero to determine which one is bigger/smaller 
	             */
	            mv.visitLdcInsn((Double)5.00);
	            mv.visitVarInsn(Opcodes.DSTORE, 1);
	            mv.visitLdcInsn((Double)4.00);
	            mv.visitVarInsn(Opcodes.DSTORE, 3);
	            mv.visitVarInsn(Opcodes.DLOAD,  1);
	            mv.visitVarInsn(Opcodes.DLOAD,  3);
	            mv.visitInsn(Opcodes.DCMPL);
	            mv.visitJumpInsn(Opcodes.IFLE, l0);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a > b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            mv.visitJumpInsn(Opcodes.GOTO, l1);
	            
	            mv.visitLabel(l0);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a < b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            
	            mv.visitLabel(l1);
	            // End of CMP Double
	            
	            mv.visitLdcInsn((Long) 5L);
	            mv.visitVarInsn(Opcodes.LSTORE, 1);
	            mv.visitLdcInsn((Long) 10L);
	            mv.visitVarInsn(Opcodes.LSTORE, 3);
	            mv.visitVarInsn(Opcodes.LLOAD,  1);
	            mv.visitVarInsn(Opcodes.LLOAD,  3);
	            mv.visitInsn(Opcodes.LCMP);
	            mv.visitJumpInsn(Opcodes.IFLE, l2);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a > b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            mv.visitJumpInsn(Opcodes.GOTO, l3);
	            
	            mv.visitLabel(l2);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a < b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            
	            mv.visitLabel(l3);
	            // End of CMP Long
	            
	            mv.visitIntInsn(Opcodes.BIPUSH, 15);
	            mv.visitVarInsn(Opcodes.ISTORE, 1);
	            mv.visitIntInsn(Opcodes.BIPUSH, 10);
	            mv.visitVarInsn(Opcodes.ISTORE, 2);
	            mv.visitVarInsn(Opcodes.ILOAD,  1);
	            mv.visitVarInsn(Opcodes.ILOAD,  2);
	            mv.visitJumpInsn(Opcodes.IF_ICMPLE, l5);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a > b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            mv.visitJumpInsn(Opcodes.GOTO, l5);
	            
	            mv.visitLabel(l4);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            mv.visitLdcInsn("a < b");
	            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	            
	            mv.visitLabel(l5);
	            // End of CMP Integer
 
 
	           
	            mv.visitInsn(Opcodes.RETURN);
	            mv.visitMaxs(2,3);
	            mv.visitEnd();
	        }// end of MethodVisiter
	        cw.visitEnd();

	        byte[] b = cw.toByteArray();

	        writeFile(b,"CMPNumbers.class");
	        
	        System.out.println("Done!");
	    }//end main
	}//end class


