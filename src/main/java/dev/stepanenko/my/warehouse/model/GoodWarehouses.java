package dev.stepanenko.my.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * GoodWarehouses
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")
@Data

public class GoodWarehouses   {
  @JsonProperty("good")
  private Good good = null;

  @JsonProperty("amount")
  private AmountWarehouse amount = null;

  public GoodWarehouses(Good good, AmountWarehouse amount) {
    this.good = good;
    this.amount = amount;
  }

  public GoodWarehouses() {
  }

  public GoodWarehouses good(Good good) {
    this.good = good;
    return this;
  }

  /**
   * Get good
   * @return good
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Good getGood() {
    return good;
  }

  public void setGood(Good good) {
    this.good = good;
  }

  public GoodWarehouses amount(AmountWarehouse amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AmountWarehouse getAmount() {
    return amount;
  }

  public void setAmount(AmountWarehouse amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodWarehouses goodWarehouses = (GoodWarehouses) o;
    return Objects.equals(this.good, goodWarehouses.good) &&
        Objects.equals(this.amount, goodWarehouses.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(good, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodWarehouses {\n");
    
    sb.append("    good: ").append(toIndentedString(good)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

