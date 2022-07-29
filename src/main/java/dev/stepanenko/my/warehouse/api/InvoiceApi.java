/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package dev.stepanenko.my.warehouse.api;

import dev.stepanenko.my.warehouse.model.Invoice;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")

@Validated
@Api(value = "invoice", description = "the invoice API")
@RequestMapping(value = "")
public interface InvoiceApi {

    @ApiOperation(value = "Удаляет накладные", nickname = "invoiceDelete", notes = "", response = Invoice.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Накладная удалена", response = Invoice.class),
        @ApiResponse(code = 400, message = "Некорректный id"),
        @ApiResponse(code = 404, message = "Накладная не найдена") })
    @RequestMapping(value = "/invoice",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Invoice> invoiceDelete(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "id", required = true) Integer id);


    @ApiOperation(value = "Возвращает входящие накладные", nickname = "invoiceGet", notes = "", response = Invoice.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Возвращает накладные", response = Invoice.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Некорректный id"),
        @ApiResponse(code = 404, message = "Накладная не найдена") })
    @RequestMapping(value = "/invoice",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Invoice>> invoiceGet(@ApiParam(value = "") @Valid @RequestParam(value = "id", required = false) Integer id,@ApiParam(value = "") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize);


    @ApiOperation(value = "Создание накладных разных типов", nickname = "invoicePost", notes = "Принемает тип и шаблон накладной", response = Integer.class, tags={ "Поступление", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "id накладной", response = Integer.class),
        @ApiResponse(code = 400, message = "Некорректный запрос") })
    @RequestMapping(value = "/invoice",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Integer> invoicePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Invoice body,@NotNull @ApiParam(value = "", required = true, allowableValues = "incoming, outcoming, movement") @Valid @RequestParam(value = "type", required = true) String type);


    @ApiOperation(value = "Изменяет имя накладной", nickname = "invoicePut", notes = "", tags={ "Накладные", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Обновление накладной успешно"),
        @ApiResponse(code = 400, message = "Некорректные данные"),
        @ApiResponse(code = 404, message = "Накладная не найдена") })
    @RequestMapping(value = "/invoice",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> invoicePut(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "id", required = true) Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Invoice body);

}