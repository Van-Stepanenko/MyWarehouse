package dev.stepanenko.my.warehouse.model;

import java.util.HashMap;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Warehouse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")

/**
 * Класс хранит имя конкретного склада и его товары с их количеством.
 * хранит = можно записать и прочитать т.е. setX() + getX()
 * */
public class Warehouse  {
  @JsonProperty("warehouseName")
  private String warehouseName = null;

  @JsonProperty("goods")
  @Valid
  private HashMap<String, GoodAmount> goods = null;


  public Warehouse warehouseName(String warehouseName) {
    this.warehouseName = warehouseName;
    return this;
  }

  /**
   * Get warehouseName
   * @return warehouseName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getWarehouseName() {
    return warehouseName;
  }

  public void setWarehouseName(String warehouseName) {
    this.warehouseName = warehouseName;
  }

  public Warehouse goods(HashMap<String, GoodAmount> goods) {
    this.goods = goods;
    return this;
  }

  /*public Warehouse addGoodsItem(GoodAmount goodsItem) {
    if (this.goods == null) {
      this.goods = new HashMap<String, GoodAmount>();
    }
    this.goods.add(goodsItem);
    return this;
  }*/

  /**
   * Get goods
   * @return goods
  **/
  @ApiModelProperty(value = "")

  @Valid
  public HashMap<String, GoodAmount> getGoods() {
    return goods;
  }

  public void setGoods(HashMap<String, GoodAmount> goods) {
    this.goods = goods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Warehouse warehouse = (Warehouse) o;
    return Objects.equals(this.warehouseName, warehouse.warehouseName) &&
        Objects.equals(this.goods, warehouse.goods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(warehouseName, goods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Warehouse {\n");
    
    sb.append("    warehouseName: ").append(toIndentedString(warehouseName)).append("\n");
    sb.append("    goods: ").append(toIndentedString(goods)).append("\n");
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

