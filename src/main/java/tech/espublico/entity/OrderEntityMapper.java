package tech.espublico.entity;
/**
 * Represents the mapper needed to convert a ResultSet into a OrderEntity
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OrderEntityMapper implements RowMapper<OrderEntity> {
  
  /**
   * Maps a ResultSet into a OrderEntity.
   * 
   * @param rs ResultSet from DB
   * @param rowNum Row num of result set
   * @return OrderEntity
   */
  public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
    OrderEntity order = new OrderEntity();
    order.setCountry(rs.getString("country"));
    order.setItemType(rs.getString("item_type"));
    order.setOrderDate(rs.getString("order_date"));
    order.setOrderId(rs.getString("order_id"));
    order.setOrderPriority(rs.getString("order_priority"));
    order.setRegion(rs.getString("region"));
    order.setSalesChannel(rs.getString("sales_channel"));
    order.setShipDate(rs.getString("ship_date"));
    order.setTotalCost(rs.getString("total_cost"));
    order.setTotalProfit(rs.getString("total_profit"));
    order.setTotalRevenue(rs.getString("total_revenue"));
    order.setUnitCost(rs.getString("unit_cost"));
    order.setUnitPrice(rs.getString("unit_price"));
    order.setUnitsSold(rs.getString("units_sold"));
    return order;
  }
}
