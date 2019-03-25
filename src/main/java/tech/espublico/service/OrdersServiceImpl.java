package tech.espublico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public OrdersServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Get count of number of regions in BD.
	 * 
	 * @return Number of regions
	 */
	@Override
	public int getTotalRegions() {
		String query = "SELECT count(distinct(region)) FROM order_processed";
		Integer count = (Integer) jdbcTemplate.queryForObject(query, Integer.class);
		return count.intValue();
	}

	/**
	 * Get count of number of countries in BD.
	 * 
	 * @return Number of countries
	 */
	@Override
	public int getTotalContries() {
		String query = "SELECT count(distinct(country)) FROM order_processed";
		Integer count = (Integer) jdbcTemplate.queryForObject(query, Integer.class);
		return count.intValue();
	}

	/**
	 * Get count of number of item types in BD.
	 * 
	 * @return Number of item types
	 */
	@Override
	public int getTotalItemTypes() {
		String query = "SELECT count(distinct(item_type)) FROM order_processed";
		Integer count = (Integer) jdbcTemplate.queryForObject(query, Integer.class);
		return count.intValue();
	}

	/**
	 * Get count of number of channels in BD.
	 * 
	 * @return Number of channels
	 */
	@Override
	public int getTotalChannels() {
		String query = "SELECT count(distinct(sales_channel)) FROM order_processed";
		Integer count = (Integer) jdbcTemplate.queryForObject(query, Integer.class);
		return count.intValue();

	}

	/**
	 * Get count of number of orders procesed in BD.
	 * 
	 * @return Number of orders processed
	 */
	@Override
	public int getTotalOrdersprocessed() {
		String query = "SELECT count(distinct(order_priority)) FROM order_processed";
		Integer count = (Integer) jdbcTemplate.queryForObject(query, Integer.class);
		return count.intValue();
	}

}
