package garuntimeenv.apicomponents;

import garuntimeenv.interfaces.IFitnessFunction;
import garuntimeenv.interfaces.IProblem;
import garuntimeenv.interfaces.IProblemRepresentation;
import garuntimeenv.interfaces.ISolution;

import java.io.File;

public class GeanAPI {

    private IProblem problem;
    private IFitnessFunction<?> fitnessFunction;
    private ISolution solution;
    private IProblemRepresentation problemRepresentation;
    private ProblemConstrainDefinition jsonProblem;

    public GeanAPI() {}

    public GeanAPI(IProblem problem, IFitnessFunction<Number> fitnessFunction, ISolution solution, IProblemRepresentation problemRepresentation) {
        this.problem = problem;
        this.fitnessFunction = fitnessFunction;
        this.solution = solution;
        this.problemRepresentation = problemRepresentation;
    }

    public IProblem getProblem() {
        return problem;
    }

    public void setProblem(IProblem problem) {
        this.problem = problem;
    }

    public IFitnessFunction<?> getFitnessFunction() {
        return fitnessFunction;
    }

    public void setFitnessFunction(IFitnessFunction<?> fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
    }

    public ISolution getSolution() {
        return solution;
    }

    public void setSolution(ISolution solution) {
        this.solution = solution;
    }

    public IProblemRepresentation getProblemRepresentation() {
        return problemRepresentation;
    }

    public void setProblemRepresentation(IProblemRepresentation problemRepresentation) {
        this.problemRepresentation = problemRepresentation;
    }
}
