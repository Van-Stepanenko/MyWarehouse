package dev.stepanenko.my.warehouse.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Good
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")


public class Good   {
  @JsonProperty("sku")
  private String sku = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("lastBuyPrice")
  private Integer lastBuyPrice = null;

  @JsonProperty("lastSellPrice")
  private Integer lastSellPrice = null;

  public Good sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Get sku
   * @return sku
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Good name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Good lastBuyPrice(Integer lastBuyPrice) {
    this.lastBuyPrice = lastBuyPrice;
    return this;
  }

  /**
   * Get lastBuyPrice
   * minimum: 0
   * @return lastBuyPrice
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(0)
  public Integer getLastBuyPrice() {
    return lastBuyPrice;
  }

  public void setLastBuyPrice(Integer lastBuyPrice) {
    this.lastBuyPrice = lastBuyPrice;
  }

  public Good lastSellPrice(Integer lastSellPrice) {
    this.lastSellPrice = lastSellPrice;
    return this;
  }

  /**
   * Get lastSellPrice
   * minimum: 0
   * @return lastSellPrice
  **/
  @ApiModelProperty(value = "")

@Min(0)
  public Integer getLastSellPrice() {
    return lastSellPrice;
  }

  public void setLastSellPrice(Integer lastSellPrice) {
    this.lastSellPrice = lastSellPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Good good = (Good) o;
    return Objects.equals(this.sku, good.sku) &&
        Objects.equals(this.name, good.name) &&
        Objects.equals(this.lastBuyPrice, good.lastBuyPrice) &&
        Objects.equals(this.lastSellPrice, good.lastSellPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, name, lastBuyPrice, lastSellPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Good {\n");
    
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lastBuyPrice: ").append(toIndentedString(lastBuyPrice)).append("\n");
    sb.append("    lastSellPrice: ").append(toIndentedString(lastSellPrice)).append("\n");
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

