package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.expression.Condition;

import java.util.List;

public abstract class BlockStatement implements Statement {
    private Condition condition;
    private List<Statement> body;

    public BlockStatement(Condition condition, List<Statement> body) {
        this.condition = condition;
        this.body = body;
    }

    public Condition getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }
}
