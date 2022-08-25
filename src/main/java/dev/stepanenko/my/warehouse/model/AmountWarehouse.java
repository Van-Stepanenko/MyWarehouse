package dev.stepanenko.my.warehouse.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AmountWarehouse
 *
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AmountWarehouse   {
  @JsonProperty("warehouseName")
  private String warehouseName = null;

  @JsonProperty("amount")
  private Integer amount = null;

  public AmountWarehouse warehouseName(String warehouseName) {
    this.warehouseName = warehouseName;
    return this;
  }

  /**
   * Get warehouseName
   * @return warehouseName
  **/
  @ApiModelProperty(value = "")


  public String getWarehouseName() {
    return warehouseName;
  }

  public void setWarehouseName(String warehouseName) {
    this.warehouseName = warehouseName;
  }

  public AmountWarehouse amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
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
    AmountWarehouse amountWarehouse = (AmountWarehouse) o;
    return Objects.equals(this.warehouseName, amountWarehouse.warehouseName) &&
        Objects.equals(this.amount, amountWarehouse.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(warehouseName, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmountWarehouse {\n");
    
    sb.append("    warehouseName: ").append(toIndentedString(warehouseName)).append("\n");
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

