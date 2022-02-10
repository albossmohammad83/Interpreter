package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class DefineFunctionStatement implements Statement {
    private String functionName;
    private List<String> parameterNames;
    private List<Statement> functionStatements;

    public DefineFunctionStatement(String functionName, List<String> parameterList, List<Statement> functionStatements) {
        this.functionName = functionName;
        this.parameterNames = parameterList;
        this.functionStatements = functionStatements;
    }

    @Override
    public void run(ProgramState programState) {
        programState.registerFunction(functionName, parameterNames, functionStatements);
    }
}
