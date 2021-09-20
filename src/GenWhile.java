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
        	mv.visitVarInsn(Opcodes.ILOAD, 1);
        	mv.visitInsn(Opcodes.ICONST_5);
        	mv.visitVarInsn(Opcodes.ISTORE, 2);
        	mv.visitVarInsn(Opcodes.ILOAD, 2);
        	mv.visitJumpInsn(Opcodes.IF_ICMPGE, l0);
        	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        	mv.visitVarInsn(Opcodes.ILOAD, 1);
        	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        	mv.visitIincInsn(1, 1);
        	mv.visitJumpInsn(Opcodes.GOTO, l0);
        	
        	mv.visitLabel(l0);
        	// End of While loop
        	
        	
        	/*
            mv.visitLdcInsn((Double) 4.00);
            mv.visitVarInsn(Opcodes.DSTORE, 1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitInsn(Opcodes.DCONST_1);
            mv.visitInsn(Opcodes.DADD);
            mv.visitVarInsn(Opcodes.DSTORE, 1);
            mv.visitLdcInsn((Double) 7.00);
            mv.visitInsn(Opcodes.DCMPG);
            mv.visitJumpInsn(Opcodes.IFLT, l0);
            */
         
     
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
            
            
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"GetWhile.class");
        
        System.out.println("Done!");
    }//end main
}//end class