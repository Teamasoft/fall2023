package org.example.AcceptanceTest;


        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import io.cucumber.junit.CucumberOptions.SnippetType;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "cases",
        plugin = {"summary","html:target/cucumber/wikipedia.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,glue = {""})

public class acceptanceTest
{

}
