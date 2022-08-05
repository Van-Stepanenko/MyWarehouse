package dev.stepanenko.my.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Good
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")


public class Good {
    @JsonProperty("sku")
    private String sku = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("warehouse")
    private String warehouse = null;

    @JsonProperty("lastBuyPrice")
    private Integer lastBuyPrice = null;

    @JsonProperty("lastSellPrice")
    private Integer lastSellPrice = null;

    @JsonProperty("amount")
    private Integer amount = null;

    public Good sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get sku
     *
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
     *
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


    public Good warehouse(String warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    /**
     * Get warehouse
     *
     * @return warehouse
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Good lastBuyPrice(Integer lastBuyPrice) {
        this.lastBuyPrice = lastBuyPrice;
        return this;
    }

    /**
     * Get lastBuyPrice
     * minimum: 0
     *
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
     *
     * @return lastSellPrice
     **/
    @ApiModelProperty(value = "")

    @Min(0)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Good amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get lastSellPrice
     * minimum: 0
     *
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
                Objects.equals(this.warehouse, good.warehouse) &&
                Objects.equals(this.lastBuyPrice, good.lastBuyPrice) &&
                Objects.equals(this.lastSellPrice, good.lastSellPrice) &&
                Objects.equals(this.amount, good.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, warehouse, lastBuyPrice, lastSellPrice, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Good {\n");

        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    warehouse: ").append(toIndentedString(warehouse)).append("\n");
        sb.append("    lastBuyPrice: ").append(toIndentedString(lastBuyPrice)).append("\n");
        sb.append("    lastSellPrice: ").append(toIndentedString(lastSellPrice)).append("\n");
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

