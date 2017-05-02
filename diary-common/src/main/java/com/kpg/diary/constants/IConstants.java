package com.kpg.diary.constants;

/**
 * The Interface IConstants.
 *
 * @author Ankit Sood Dec 6, 2016
 */
public interface IConstants {

    /**
     * This is use for set navigation menu name and unique for navigation
     * 
     * @author Ankit Sood Dec 6, 2016
     */
    public enum NavigationMenu {

	ADDRESS("address", "Address"), PERSON("person", "Person"), ADDRESS_VIEW("addressView", "Address VIew");

	String key;
	String lblName;

	/**
	 * Instantiates a new navigation menu name.
	 *
	 * @param key
	 *            the key
	 * @param lblName
	 *            the lbl name
	 */
	NavigationMenu(String key, String lblName) {
	    this.key = key;
	    this.lblName = lblName;
	}

	public String getKey() {
	    return key;
	}

	public String getLblName() {
	    return lblName;
	}
    }

    /**
     * 
     * Address Screen interface has AddressUi constants
     * 
     * @author Ankit Sood Dec 6, 2016
     */
    public interface AddressSceeen {
	public static final String PAGE_HEADING = "Add Address";
    }

    /**
     * 
     * Address Screen interface has PersonUi constants
     * 
     * @author Ankit Sood Dec 6, 2016
     */
    public interface PersonSceeen {
	public static final String PAGE_HEADING = "Add Person";
    }

}
