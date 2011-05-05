package net.caimito.courseware.cashregister;

import java.util.Collection;

public interface InventoryAgent {

	public void inquireAvailability(String petName);

	public boolean isAvailable(String petName);

	public void retrieveFromShelter(String petName);

	public void removeFromInventory(Collection<String> petNames);

	public void setAvailable(String petName);

}
