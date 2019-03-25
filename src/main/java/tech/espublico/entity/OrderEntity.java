package tech.espublico.entity;
/**
 * Represents ORDER table needed to store orders read
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "order_processed",
    indexes = {@Index(name = "index_region", columnList = "region", unique = false),
        @Index(name = "index_country", columnList = "country", unique = false),
        @Index(name = "index_itemType", columnList = "item_type", unique = false),
        @Index(name = "index_salesChannel", columnList = "sales_channel", unique = false),
        @Index(name = "index_orderPriority", columnList = "order_priority", unique = false)})
public class OrderEntity {
  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String region;
  private String country;

  @Column(name = "item_type")
  private String itemType;

  @Column(name = "sales_channel")
  private String salesChannel;

  @Column(name = "order_priority")
  private String orderPriority;

  @Column(name = "order_date")
  private String orderDate;

  @Column(name = "order_id")
  private String orderId;

  @Column(name = "ship_date")
  private String shipDate;

  @Column(name = "units_sold")
  private String unitsSold;

  @Column(name = "unit_price")
  private String unitPrice;

  @Column(name = "unit_cost")
  private String unitCost;

  @Column(name = "total_revenue")
  private String totalRevenue;

  @Column(name = "total_cost")
  private String totalCost;

  @Column(name = "total_profit")
  private String totalProfit;

  public OrderEntity() {

  }

  /**
   * BatchStepExecutionContext constructor with all fields. constructor with all fields.
   * 
   * @param id Id
   * @param region Region
   * @param country Country
   * @param itemType Item type
   * @param salesChannel Sales channel
   * @param orderPriority Order priority
   * @param orderDate Order date
   * @param orderId Order id
   * @param shipDate Ship date
   * @param unitsSold Units sold
   * @param unitPrice Unit price
   * @param unitCost Unit cost
   * @param totalRevenue Total revenue
   * @param totalCost Total cost
   * @param totalProfit Total profit
   */
  public OrderEntity(long id, String region, String country, String itemType, String salesChannel,
      String orderPriority, String orderDate, String orderId, String shipDate, String unitsSold,
      String unitPrice, String unitCost, String totalRevenue, String totalCost,
      String totalProfit) {
    super();
    this.id = id;
    this.region = region;
    this.country = country;
    this.itemType = itemType;
    this.salesChannel = salesChannel;
    this.orderPriority = orderPriority;
    this.orderDate = orderDate;
    this.orderId = orderId;
    this.shipDate = shipDate;
    this.unitsSold = unitsSold;
    this.unitPrice = unitPrice;
    this.unitCost = unitCost;
    this.totalRevenue = totalRevenue;
    this.totalCost = totalCost;
    this.totalProfit = totalProfit;
  }

  public String getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getSalesChannel() {
    return salesChannel;
  }

  public void setSalesChannel(String salesChannel) {
    this.salesChannel = salesChannel;
  }

  public String getOrderPriority() {
    return orderPriority;
  }

  public void setOrderPriority(String orderPriority) {
    this.orderPriority = orderPriority;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getShipDate() {
    return shipDate;
  }

  public void setShipDate(String shipDate) {
    this.shipDate = shipDate;
  }

  public String getUnitsSold() {
    return unitsSold;
  }

  public void setUnitsSold(String unitsSold) {
    this.unitsSold = unitsSold;
  }

  public String getUnitCost() {
    return unitCost;
  }

  public void setUnitCost(String unitCost) {
    this.unitCost = unitCost;
  }

  public String getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(String totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public String getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(String totalCost) {
    this.totalCost = totalCost;
  }

  public String getTotalProfit() {
    return totalProfit;
  }

  public void setTotalProfit(String totalProfit) {
    this.totalProfit = totalProfit;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "OrderEntity [region=" + region + ", country=" + country + ", itemType=" + itemType
        + ", salesChannel=" + salesChannel + ", orderPriority=" + orderPriority + ", orderDate="
        + orderDate + ", orderId=" + orderId + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold
        + ", unitPrice=" + unitPrice + ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue
        + ", totalCost=" + totalCost + ", totalProfit=" + totalProfit + "]";
  }

}
