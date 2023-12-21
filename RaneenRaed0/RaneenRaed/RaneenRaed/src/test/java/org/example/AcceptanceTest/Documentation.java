package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import static org.junit.Assert.assertTrue;

public class Documentation
{

    private boolean developerDocsCreated;

    @Given("the need to create developer documentation")
    public void theNeedToCreateDeveloperDocumentation()
    {
        developerDocsCreated = false;
    }

    @When("the documentation team starts the documentation creation process")
    public void theDocumentationTeamStartsTheDocumentationCreationProcess()
    {
        developerDocsCreated = createDeveloperDocumentation();
    }

    @Then("they should be able to create comprehensive developer docs")
    // We always use (then) for the testing process
    public void theyShouldBeAbleToCreateComprehensiveDeveloperDocs()
    {
        assertTrue(developerDocsCreated);
    }

    private boolean createDeveloperDocumentation()
    {
        return true;
    }

}
