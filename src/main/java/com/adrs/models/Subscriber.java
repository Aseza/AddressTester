package com.adrs.models;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
	public class Contract {
		String subscriberName = name;
		String subscriberValidAddress = currentAddress;

		public String getSubscriberValidAddress() {
			return subscriberValidAddress;
		}
	}

	String name;
	String currentAddress;
	List<String> addressesList;
	List<Contract> contractList;

	public Subscriber(String name, String currentAddress, int contractNumber) {
		this.name = name;
		addressesList = new ArrayList<>();
		setCurrentAddress(currentAddress);
		contractList = new ArrayList<>(contractNumber);
	}

	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	public List<Contract> getContractList() {
		return contractList;
	}

	public List<String> getAddressesList() {
		return addressesList;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
		addressesList.add(currentAddress);

	}
}