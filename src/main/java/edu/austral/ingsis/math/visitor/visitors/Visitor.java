package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;

public interface Visitor<T> {
    T visitValue(Value value);
    T visitVariable(Variable variable);
    T visitSum(Sum sum);
    T visitSub(Sub sub);
    T visitMult(Mult mult);
    T visitDiv(Div div);
    T visitPow(Pow pow);
    T visitModule(Module module);
    T visitParenthesis(ParenthesisOperand parenthesis);
}
