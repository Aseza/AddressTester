package com.adrs.tester;

import com.adrs.models.Subscriber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Stepdefs {
	private Subscriber subscriber;

	@Given("^un abonné avec une adresse principale active en France")
	public void subscriber_address_isValid() {
		subscriber = new Subscriber("Charlie", "12th Broadway", 4);
	}

	@When("^le conseiller connecté à \"([^\"]*)\" modifie l\'adresse de l'abonné sans date d'effet")
	public void adviser_connected_to_channel_modified_the_address(String channel) {
		subscriber.setCurrentAddress("33rd Main Street, HL");
	}

	@Then("l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
	public void subscriber_address_is_modified_across_all_contracts() {
		for (Subscriber.Contract ctr : subscriber.getContractList()) {
			assertEquals(ctr.getSubscriberValidAddress(), "33rd Main Street, HL");
		}

	}

	@Then("un mouvement de modification d'adresse est créé")
	public void address_list_has_been_modified() {
		assertEquals(2, subscriber.getAddressesList().size());

	}

	@Then("la nouvelle adresse peut être recherchée")
	public void new_address_can_be_searched() {
		boolean found = false;

		for (String adrs : subscriber.getAddressesList()) {
			if (adrs.equals("33rd Main Street, HL")) {
				found = true;
			}

		}
		assertTrue(found);
	}
}
