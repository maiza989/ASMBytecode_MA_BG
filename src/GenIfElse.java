
/**
 * A class that generate an If-else statement in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class GenIfElse {

	public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"GetIF", null, "java/lang/Object",null);
        
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
            mv.visitCode();
            /**
             *  Implementation of If-Else statement
             */
            mv.visitIntInsn(Opcodes.BIPUSH, 20);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitIntInsn(Opcodes.BIPUSH, 21);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, l0);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Good Day.");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, l1);
            
            mv.visitLabel(l0);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Good Evening.");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
          
            mv.visitLabel(l1);
            // end of If-Else Statement
            
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }// end of MethodVisiter

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"GetIF.class");
        
        System.out.println("Done!");
    }//end main
}//end class
