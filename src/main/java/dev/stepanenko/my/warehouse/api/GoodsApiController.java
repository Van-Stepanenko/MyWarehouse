package dev.stepanenko.my.warehouse.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.stepanenko.my.warehouse.model.AmountWarehouse;
import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.GoodWarehouses;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-29T09:17:33.220Z")

@Controller
public class GoodsApiController implements GoodsApi {

    private static final Logger log = LoggerFactory.getLogger(GoodsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GoodsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<GoodWarehouses>> goodsGet( @Valid @RequestParam(value = "name", required = false) String name,
                                                          @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                          @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
      //  String accept = request.getHeader("Accept");
   //     if (accept != null && accept.contains("application/json")) {
 //           try {
   //     log.info("name = {}, pageNumber = {}, pageSize = {}", name, pageNumber,pageSize);

                return ResponseEntity.ok(List.of(new GoodWarehouses(new Good(), List.of(new AmountWarehouse(name, pageNumber)))));
               // return new ResponseEntity<List<GoodWarehouses>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<List<GoodWarehouses>>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
 //           }

 //       return new ResponseEntity<List<GoodWarehouses>>(HttpStatus.NOT_IMPLEMENTED);
    }


}
