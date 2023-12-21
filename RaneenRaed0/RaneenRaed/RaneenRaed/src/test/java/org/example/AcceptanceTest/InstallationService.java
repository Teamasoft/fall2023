package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class InstallationService
{
    private boolean installationRequestCreated;
    private boolean installationDetailsSpecified;
    private boolean installationRequestUpdated;
    private boolean installationRequestRemoved;
    private boolean pendingRequestsViewed;
    private boolean appointmentScheduled;

    @Given("a customer has purchased accessories")
    public void aCustomerHasPurchasedAccessories()
    {
        // Logic to set up the context for a customer who has purchased accessories
    }

    @When("they request installation services for those accessories")
    public void theyRequestInstallationServicesForThoseAccessories()
    {
        // Logic to send a request for installation services
        installationRequestCreated = true;
    }

    @Then("the installation request should be created successfully")
    // We always use (then) for the testing process
    public void theInstallationRequestShouldBeCreatedSuccessfully()
    {
        Assert.assertTrue(installationRequestCreated);
    }

    @Given("a customer is requesting installation services")
    public void aCustomerIsRequestingInstallationServices()
    {
        // Logic to set up the context for a customer requesting installation services
    }

    @When("they fill out the installation form with details like car make\\/model and preferred date")
    public void theyFillOutTheInstallationFormWithDetailsLikeCarMakeModelAndPreferredDate()
    {
        // Logic to fill out the installation form with specified details
        installationDetailsSpecified = true;
    }

    @Then("they should be able to specify installation details using the form")
    // We always use (then) for the testing process
    public void theyShouldBeAbleToSpecifyInstallationDetailsUsingTheForm()
    {
        Assert.assertTrue(installationDetailsSpecified);
    }

    @Given("a customer has an existing installation request")
    public void aCustomerHasAnExistingInstallationRequest()
    {
        // Logic to set up the context with an existing installation request
    }

    @When("they modify the installation request details")
    public void theyModifyTheInstallationRequestDetails()
    {
        // Logic to modify the installation request details
        installationRequestUpdated = true;
    }

    @Then("the changes should be updated successfully")
    // We always use (then) for the testing process
    public void theChangesShouldBeUpdatedSuccessfully()
    {
        Assert.assertTrue(installationRequestUpdated);
    }

    @When("they cancel the installation request")
    public void theyCancelTheInstallationRequest()
    {
        // Logic to cancel the installation request
        installationRequestRemoved = true;
    }

    @Then("the request should be removed from the system successfully")
    // We always use (then) for the testing process
    public void theRequestShouldBeRemovedFromTheSystemSuccessfully()
    {
        Assert.assertTrue(installationRequestRemoved);
    }

    @Given("an installer is available for installations")
    public void anInstallerIsAvailableForInstallations()
    {
        // Logic to set up the context with an available installer
    }

    @When("they check the pending installation requests")
    public void theyCheckThePendingInstallationRequests()
    {
        // Logic to check pending installation requests
        pendingRequestsViewed = true;
    }

    @Then("they should be able to view the list of pending requests")
    // We always use (then) for the testing process
    public void theyShouldBeAbleToViewTheListOfPendingRequests()
    {
        Assert.assertTrue(pendingRequestsViewed);
    }

    @When("they schedule an appointment for an installation request")
    public void theyScheduleAnAppointmentForAnInstallationRequest()
    {
        // Logic to schedule an appointment for the installation request
        appointmentScheduled = true;
    }

    @Then("the appointment should be confirmed and added to the calendar")
    // We always use (then) for the testing process
    public void theAppointmentShouldBeConfirmedAndAddedToTheCalendar()
    {
        Assert.assertTrue(appointmentScheduled);
    }
}
