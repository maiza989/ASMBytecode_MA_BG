import static utils.Utilities.writeFile;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class GenACC {

	 public static void main(String[] args){

	        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"GetACC", null, "java/lang/Object",null);
	        
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
	            Label l1 = new Label();
	            Label l2 = new Label();
	            mv.visitCode();
	            /**
	             * Getting input from the user
	             */
				
	            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            	mv.visitInsn(Opcodes.DUP);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
	            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
	            mv.visitVarInsn(Opcodes.ASTORE, 1);
	            mv.visitInsn(Opcodes.ICONST_0);
	            mv.visitVarInsn(Opcodes.ISTORE, 2);
	            mv.visitLabel(l1);
	            mv.visitInsn(Opcodes.ICONST_0);
	            mv.visitVarInsn(Opcodes.ISTORE, 3);
	            mv.visitVarInsn(Opcodes.ILOAD, 2);
	            mv.visitIntInsn(Opcodes.BIPUSH, 10);
	            mv.visitJumpInsn(Opcodes.IF_ICMPEQ, l2);
	            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); 
				mv.visitLdcInsn(" Enter a value for x: ");
				mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
				mv.visitVarInsn(Opcodes.ALOAD, 1);
				mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
				mv.visitVarInsn(Opcodes.ISTORE, 2);
				mv.visitVarInsn(Opcodes.ILOAD, 3);
				mv.visitVarInsn(Opcodes.ILOAD, 2);
				mv.visitInsn(Opcodes.IADD);
				mv.visitVarInsn(Opcodes.ISTORE, 3);
				mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"); 
				mv.visitVarInsn(Opcodes.ILOAD, 3);
				mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
				mv.visitJumpInsn(Opcodes.GOTO, l1);
	          //  mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "hava/util/Scanner","nextInt:", "()I", false);
	           // mv.visitVarInsn(Opcodes.ISTORE, 2);
	           // mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	            // end of GetInput
	            
	            
	            
				mv.visitLabel(l2);
	            mv.visitInsn(Opcodes.RETURN);
	            mv.visitMaxs(0,0);
	            mv.visitEnd();
	        }// end of MethodVisitor

	        cw.visitEnd();

	        byte[] b = cw.toByteArray();

	        writeFile(b,"GetACC.class");
	        
	        System.out.println("Done!");
	    }//end main
	}//end class