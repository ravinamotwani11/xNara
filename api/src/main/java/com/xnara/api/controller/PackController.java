/**
* PackController
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xnara.api.model.request.CustomerRequest;
import com.xnara.api.model.response.CustomerPackCombinedResponse;
import com.xnara.api.service.LoggerService;
import com.xnara.api.service.PackService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PackController {

	private final PackService packService;
	private final Logger logger;

	public PackController(PackService packService, LoggerService loggerService) {
		this.packService = packService;
		this.logger = loggerService.getLogger(PackController.class);
	}

	/**
	 * This method is used to get combined pack data
	 * 
	 * @param request - {@link CustomerRequest}
	 * @return ResponseEntity of {@link CustomerPackCombinedResponse}
	 */
	@ApiOperation(value = "Combine Pack 1 and Pack 2 data for a customer", response = CustomerPackCombinedResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully combined pack data"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
	@PostMapping("/api/combine-packs")
	public ResponseEntity<CustomerPackCombinedResponse> combinePacks(@RequestBody CustomerRequest request) {
		try {
			logger.info("Received request from customer: {}", request);
			String customerId = request.getCustomer_id();
			logger.info("Calling packService.getCombinedData() by customerId: {}", customerId);
			CustomerPackCombinedResponse combinedData = packService.getCombinedPackData(customerId);
			return ResponseEntity.ok(combinedData);
		} catch (Exception e) {
			logger.error("Error processing request: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
