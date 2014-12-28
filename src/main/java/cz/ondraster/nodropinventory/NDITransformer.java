package cz.ondraster.nodropinventory;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;

public class NDITransformer implements IClassTransformer {
   @Override
   public byte[] transform(String className, String newClassName, byte[] origCode) {
      //System.out.println(className);
      if (className.equals("net.minecraft.inventory.ContainerPlayer") || className.equals("aap")) {
         return patchClass(className, origCode, true);
      }

      return origCode;
   }

   private byte[] patchClass(String className, byte[] origCode, boolean isDeobfEnv) {
      //final String methodToPatch = "b";
      final String methodToPatch = "onContainerClosed";
      final String methodToPatch2 = "b";

      ClassReader rd = new ClassReader(origCode);
      ClassWriter wr = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
      ClassVisitor cv = new ClassVisitor(Opcodes.ASM4, wr) {
         @Override
         public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (name.equals(methodToPatch) || name.equals(methodToPatch2) && desc.endsWith(";)V")) {
               MethodVisitor mv;
               mv = cv.visitMethod(access, name, desc, signature, exceptions);
               mv = new NDIAdapter(mv, access, name, desc, name.equals(methodToPatch2));
               return mv;

            }
            return super.visitMethod(access, name, desc, signature, exceptions);
         }
      };
      rd.accept(cv, ClassReader.EXPAND_FRAMES);
      return wr.toByteArray();
   }
}
