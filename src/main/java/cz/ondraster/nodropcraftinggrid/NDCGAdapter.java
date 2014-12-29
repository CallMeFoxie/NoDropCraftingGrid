package cz.ondraster.nodropcraftinggrid;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class NDCGAdapter extends AdviceAdapter {
   /**
    * Creates a new {@link org.objectweb.asm.commons.AdviceAdapter}.
    *
    * @param api    the ASM API version implemented by this visitor. Must be one
    * of {@link org.objectweb.asm.Opcodes#ASM4} or {@link org.objectweb.asm.Opcodes#ASM5}.
    * @param mv     the method visitor to which this adapter delegates calls.
    * @param access the method's access flags (see {@link org.objectweb.asm.Opcodes}).
    * @param name   the method's name.
    * @param desc   the method's descriptor (see {@link Type Type}).
    */

   boolean deobfEnv;

   protected NDCGAdapter(MethodVisitor mv, int access, String name, String desc, boolean deobf) {
      super(Opcodes.ASM4, mv, access, name, desc);
      deobfEnv = deobf;
   }

   @Override
   protected void onMethodEnter() {
      super.onMethodEnter();
      Label l3 = new Label();
      mv.visitVarInsn(ALOAD, 0);
      mv.visitVarInsn(ALOAD, 1);
      if (!deobfEnv)
         mv.visitMethodInsn(INVOKESPECIAL, "net/minecraft/inventory/Container", "onContainerClosed", "(Lnet/minecraft/entity/player/EntityPlayer;)V", false);
      else
         mv.visitMethodInsn(INVOKESPECIAL, "net/minecraft/inventory/Container", "func_75134_a", "(Lnet/minecraft/entity/player/EntityPlayer;)V", false);
      mv.visitInsn(Opcodes.RETURN);
      mv.visitLabel(l3);
   }
}
