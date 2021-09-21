/**
 * A class that implement a while loop in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Porject 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

public class GenWhile {

	 public static void main(String[] args){

    	 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
         cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"GetWhile", null, "java/lang/Object",null);
         
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
        	 * Creating labels
        	 */
            Label l0 = new Label();  
            Label l1 = new Label();
        	mv.visitCode();
            /**
             * Generating while loop 
             */
        	mv.visitInsn(Opcodes.ICONST_0);  	
        	mv.visitVarInsn(Opcodes.ISTORE, 1);
        	mv.visitLabel(l0);
        	mv.visitVarInsn(Opcodes.ILOAD, 1);
        	mv.visitInsn(Opcodes.ICONST_5);	
        	mv.visitJumpInsn(Opcodes.IF_ICMPGE, l1);
        	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        	mv.visitVarInsn(Opcodes.ILOAD, 1);
        	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        	mv.visitIincInsn(1, 1);
        	mv.visitJumpInsn(Opcodes.GOTO, l0);	
        	// End of While loop

            mv.visitLabel(l1);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(2,3);
            mv.visitEnd();
            
            
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"GetWhile.class");
        
        System.out.println("Done!");
    }//end main
}//end class