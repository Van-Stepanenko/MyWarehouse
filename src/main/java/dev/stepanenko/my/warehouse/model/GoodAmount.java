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
 * GoodAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")


public class GoodAmount   {
  @JsonProperty("good")
  private Good good = null;

  @JsonProperty("amount")
  private Integer amount = null;

  public GoodAmount good(Good good) {
    this.good = good;
    return this;
  }

  /**
   * Get good
   * @return good
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Good getGood() {
    return good;
  }

  public void setGood(Good good) {
    this.good = good;
  }

  public GoodAmount amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 1
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(1)
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
    GoodAmount goodAmount = (GoodAmount) o;
    return Objects.equals(this.good, goodAmount.good) &&
        Objects.equals(this.amount, goodAmount.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(good, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodAmount {\n");
    
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

