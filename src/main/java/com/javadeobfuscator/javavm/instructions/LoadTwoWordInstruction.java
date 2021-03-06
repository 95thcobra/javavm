package com.javadeobfuscator.javavm.instructions;

import com.javadeobfuscator.javavm.Locals;
import com.javadeobfuscator.javavm.MethodExecution;
import com.javadeobfuscator.javavm.Stack;
import com.javadeobfuscator.javavm.VirtualMachine;
import com.javadeobfuscator.javavm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.List;
import java.util.function.Function;

public class LoadTwoWordInstruction extends Instruction {
    private final Function<VirtualMachine, JavaWrapper> _javaValueSupplier;

    public LoadTwoWordInstruction(Function<VirtualMachine, JavaWrapper> supplier) {
        _javaValueSupplier = supplier;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        stack.push(_javaValueSupplier.apply(execution.getVM()));
    }
}
