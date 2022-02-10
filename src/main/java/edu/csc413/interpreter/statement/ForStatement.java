package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.expression.Expression;

import java.util.List;

public class ForStatement extends BlockStatement {
    private String loopVariable;
    private Expression rangeStart;
    private Expression rangeEnd;

    public ForStatement(List<Statement> body, String loopVariable, Expression rangeStart, Expression rangeEnd) {
        super(null, body);
        this.loopVariable = loopVariable;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run(ProgramState programState) {
        int start = rangeStart.evaluate(programState), end = rangeEnd.evaluate(programState);
        while (start < end && !programState.hasReturnValue()) {
            programState.setVariable(loopVariable, start);
            for (Statement statement: getBody()) {
                statement.run(programState);
                if (programState.hasReturnValue()) {
                    break;
                }
            }
            start++;
        }
    }
}
