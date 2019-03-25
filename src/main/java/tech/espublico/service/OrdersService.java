package tech.espublico.service;

public interface OrdersService {
	/**
	 * Get count of number of regions in BD.
	 * 
	 * @return Number of regions
	 */
	public int getTotalRegions();

	/**
	 * Get count of number of countries in BD.
	 * 
	 * @return Number of countries
	 */
	public int getTotalContries();
	
	/**
	 * Get count of number of item types in BD.
	 * 
	 * @return Number of item types
	 */
	public int getTotalItemTypes();

	/**
	 * Get count of number of channels in BD.
	 * 
	 * @return Number of channels
	 */
	public int getTotalChannels();
	
	/**
	 * Get count of number of orders procesed in BD.
	 * 
	 * @return Number of orders processed
	 */
	public int getTotalOrdersprocessed();
}
