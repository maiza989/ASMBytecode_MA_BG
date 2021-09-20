/**
 * A class that declare a String variable in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class GenString {

	 public static void main(String[] args){

    	 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
         cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"GetString", null, "java/lang/Object",null);
         
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
            mv.visitCode();
            /**
             * Declaring a String Variable
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); 
			mv.visitLdcInsn("This String Is Awesome");
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			// end of String Declaration 
     
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
            
            
        }// end of MethodVisister

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"GetString.class");
        
        System.out.println("Done!");
    }//end main
}//end class