package com.jetbrains.python.codeInsight.controlflow;

import com.intellij.codeInsight.controlflow.ControlFlowBuilder;
import com.intellij.codeInsight.controlflow.Instruction;
import com.intellij.util.containers.CollectionFactory;

import java.util.List;

/**
 * @author traff
 */
public class InstructionBuilder {
  public static List<Instruction> buildInstructions(ControlFlowBuilder builder, List<PyTypeAssertionEvaluator.Assertion> assertions) {
    List<Instruction> result = CollectionFactory.arrayList();
    for (PyTypeAssertionEvaluator.Assertion def: assertions) {
      processDef(builder, def, result);
    }
    return result;
  }

  private static void processDef(ControlFlowBuilder builder, PyTypeAssertionEvaluator.Assertion def, List<Instruction> result) {
    result.add(ReadWriteInstruction.writeType(builder, def.getElement(), def.getName()));            
  }

  public static void addAssertInstructions(ControlFlowBuilder builder, PyTypeAssertionEvaluator assertionEvaluator) {
    for (Instruction instr : buildInstructions(builder, assertionEvaluator.getDefinitions())) {
        builder.addNode(instr);
      }

  }
}
