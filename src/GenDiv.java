/**
 * A class that Divide two numbers (Integer/Long/Double) in bytecode using ASM 9.2
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 2
 * CS322 - Compiler Construction
 * Fall 2021
 */
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class GenDiv {

	public static void main(String[] args){

   	 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"DivNumbers", null, "java/lang/Object",null);
        
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
            * Dividing two number Double/Long/Integer and storing them
            */
           mv.visitLdcInsn((Double)100.00);
           mv.visitVarInsn(Opcodes.DSTORE, 1);
           mv.visitLdcInsn((Double)20.00);
           mv.visitVarInsn(Opcodes.DSTORE, 3);
           mv.visitVarInsn(Opcodes.DLOAD, 1);
           mv.visitVarInsn(Opcodes.DLOAD, 3);
           mv.visitInsn(Opcodes.DDIV);
           mv.visitVarInsn(Opcodes.DSTORE, 5);
           mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
           mv.visitVarInsn(Opcodes.DLOAD, 5);
           mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
           // end of Double MUL
           
           mv.visitLdcInsn((Long)2L);
           mv.visitVarInsn(Opcodes.LSTORE, 7);
           mv.visitLdcInsn((Long)4L);
           mv.visitVarInsn(Opcodes.LSTORE, 9);
           mv.visitVarInsn(Opcodes.LLOAD, 7);
           mv.visitVarInsn(Opcodes.LLOAD, 9);
           mv.visitInsn(Opcodes.LDIV);
           mv.visitVarInsn(Opcodes.LSTORE, 11);
           mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
           mv.visitVarInsn(Opcodes.LLOAD, 11);
           mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
           // end of Long MUL
           
           mv.visitIntInsn(Opcodes.BIPUSH, 90);
           mv.visitVarInsn(Opcodes.ISTORE, 13);
           mv.visitIntInsn(Opcodes.BIPUSH, 10);
           mv.visitVarInsn(Opcodes.ISTORE, 14);
           mv.visitVarInsn(Opcodes.ILOAD, 13);
           mv.visitVarInsn(Opcodes.ILOAD, 14);
           mv.visitInsn(Opcodes.IDIV);
           mv.visitVarInsn(Opcodes.ISTORE, 15);
           mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
           mv.visitVarInsn(Opcodes.ILOAD, 15);
           mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
           // end of Integer MUL
           
           mv.visitInsn(Opcodes.RETURN);
           mv.visitMaxs(0,0);
           mv.visitEnd();
           
           
       }// end of MethodVisiter

       cw.visitEnd();

       byte[] b = cw.toByteArray();

       writeFile(b,"DivNumbers.class");
       
       System.out.println("Done!");
   }//end main
}//end class