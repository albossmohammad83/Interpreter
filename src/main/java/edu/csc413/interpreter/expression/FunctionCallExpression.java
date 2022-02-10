package edu.csc413.interpreter.expression;
import edu.csc413.interpreter.Interpreter;
import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionCallExpression implements Expression {
    private String functionName;
    private List<Expression> parameterNames;

    public FunctionCallExpression(String functionName, List<Expression> parameterNames) {
        this.functionName = functionName;
        this.parameterNames = parameterNames;
    }

    @Override
    public int evaluate(ProgramState programState) {
        List<String> paramNames = programState.getParameterNames(functionName);
        List<Statement> statementList = programState.getFunctionStatements(functionName);
        List<Integer> paramValues = new ArrayList<>();
        for (Expression parameterName : parameterNames) {
            paramValues.add(parameterName.evaluate(programState));
        }
        if(paramNames.size() == parameterNames.size()){
            programState.addCallFrame();
            for(int i = 0; i < parameterNames.size(); i++) {
                programState.setVariable(paramNames.get(i), paramValues.get(i));
            }
            for(Statement statement: statementList) {
                statement.run(programState);
                if (programState.hasReturnValue()) {
                    int returnValue = programState.getReturnValue();
                    programState.removeCallFrame();
                    programState.clearReturnValue();
                    return returnValue;
                }
            }
        }

        return '\0';
    }


}
