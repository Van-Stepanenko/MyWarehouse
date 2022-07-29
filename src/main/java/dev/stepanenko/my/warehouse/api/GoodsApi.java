/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package dev.stepanenko.my.warehouse.api;

import dev.stepanenko.my.warehouse.model.GoodWarehouses;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")

@Validated
@Api(value = "goods", description = "the goods API")
@RequestMapping(value = "")
public interface GoodsApi {

    @ApiOperation(value = "Возвращает товар", nickname = "goodsGet", notes = "", response = GoodWarehouses.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Количество товаров на складах", response = GoodWarehouses.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Товар не найден")})
    @RequestMapping(value = "/goods",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<GoodWarehouses>> goodsGet(@ApiParam(value = "") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber, @ApiParam(value = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize);

}