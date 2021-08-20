package scenarioGenerator.exceptions;

public class ScenarioGenerationException extends RuntimeException{
    public ScenarioGenerationException(String message) {
        super("Scenario Generator Exception: " + message);
    }
}
