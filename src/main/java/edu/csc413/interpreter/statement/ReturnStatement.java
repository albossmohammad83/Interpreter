package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

public class ReturnStatement implements Statement {
    private Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void run(ProgramState programState) {
        programState.setReturnValue(expression.evaluate(programState));
    }
}
