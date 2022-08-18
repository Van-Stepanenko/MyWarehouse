package dev.stepanenko.my.warehouse.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Invoice
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")


public class Invoice   {
  @JsonProperty("sourse")
  private String sourse = null;

  @JsonProperty("destination")
  private String destination = null;

  @JsonProperty("goods")
  @Valid
  private List<GoodAmount> goods = new ArrayList<GoodAmount>();

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("totalPrice")
  private Integer totalPrice = null;

  public Invoice sourse(String sourse) {
    this.sourse = sourse;
    return this;
  }

  /**
   * Если поле destination пустое - значит поле sourse обязательно
   * @return sourse
  **/
  @ApiModelProperty(value = "Если поле destination пустое - значит поле sourse обязательно")


  public String getSourse() {
    return sourse;
  }

  public void setSourse(String sourse) {
    this.sourse = sourse;
  }

  public Invoice destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Если поле sourse пустое - значит поле destination обязательно
   * @return destination
  **/
  @ApiModelProperty(value = "Если поле sourse пустое - значит поле destination обязательно")


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Invoice goods(List<GoodAmount> goods) {
    this.goods = goods;
    return this;
  }

  public Invoice addGoodsItem(GoodAmount goodsItem) {
    this.goods.add(goodsItem);
    return this;
  }

  /**
   * Get goods
   * @return goods
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<GoodAmount> getGoods() {
    return goods;
  }

  public void setGoods(List<GoodAmount> goods) {
    this.goods = goods;
  }

  public Invoice id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Invoice totalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * Get totalPrice
   * minimum: 0
   * @return totalPrice
  **/
  @ApiModelProperty(value = "")

@Min(0)
  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invoice invoice = (Invoice) o;
    return Objects.equals(this.sourse, invoice.sourse) &&
        Objects.equals(this.destination, invoice.destination) &&
        Objects.equals(this.goods, invoice.goods) &&
        Objects.equals(this.id, invoice.id) &&
        Objects.equals(this.totalPrice, invoice.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourse, destination, goods, id, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("    sourse: ").append(toIndentedString(sourse)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    goods: ").append(toIndentedString(goods)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

