import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckBookStepdefs {
    @When("I search for book with title started with {string}")
    public void iSearchForBookWithTitleStartedWith(String arg0) {
    }

    @ParameterType(value = "true|false")
    private Boolean booleanType(String value) {
        return Boolean.valueOf(value);
    }
    @Then("The result should Be {booleanType}")
    public void theResultShouldBeTrue(boolean booleanCondition) {
        
    }
}
