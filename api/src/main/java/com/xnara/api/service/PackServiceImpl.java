/**
* PackServiceImpl
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xnara.api.model.response.CustomerPack;
import com.xnara.api.model.response.CustomerPackCombinedResponse;
import com.xnara.api.model.response.Pack;

@Service
public class PackServiceImpl implements PackService {

	private final String pack1Url = "https://6466e9a7ba7110b663ab51f2.mockapi.io/api/v1/pack1";
	private final String pack2Url = "https://6466e9a7ba7110b663ab51f2.mockapi.io/api/v1/pack2";
	private final Logger logger;

	private final RestTemplate restTemplate;

	public PackServiceImpl(LoggerService loggerService) {
		restTemplate = new RestTemplate();
		this.logger = loggerService.getLogger(PackService.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerPackCombinedResponse getCombinedPackData(String customerId) {

		logger.info("Received data in packService with customerId: {}", customerId);

		List<String> combinedDataPack1 = new ArrayList<>();
		List<String> combinedDataPack2 = new ArrayList<>();
		CustomerPackCombinedResponse customerPackCombinedResponse = new CustomerPackCombinedResponse();

		try {
			// Fetch data from pack1Url with customer_id as a query parameter
			logger.info("Call pack1 api to get pack1 data via REST call");
			ResponseEntity<CustomerPack[]> customerPack1Response = restTemplate
					.getForEntity(pack1Url + "?customer_id={customerId}", CustomerPack[].class, customerId);
			CustomerPack[] customerPack1 = customerPack1Response.getBody();
			if (customerPack1 != null) {
				for (Pack pack1 : customerPack1[0].getPack_data()) {
					String entry = pack1.getIngredient() + " " + pack1.getQuantity() + " " + pack1.getUnit();
					combinedDataPack1.add(entry);
				}
				customerPackCombinedResponse.setCustomer_id(customerId);
				customerPackCombinedResponse.setId(customerPack1[0].getId());
				customerPackCombinedResponse.setPack1(combinedDataPack1);
			}

			// Fetch data from pack2Url with customer_id as a query parameter
			logger.info("Call pack2 api to get pack1 data via REST call");
			ResponseEntity<CustomerPack[]> customerPack2Response = restTemplate
					.getForEntity(pack2Url + "?customer_id={customerId}", CustomerPack[].class, customerId);
			CustomerPack[] customerPack2 = customerPack2Response.getBody();
			if (customerPack2 != null) {
				for (Pack pack2 : customerPack2[0].getPack_data()) {
					String entry = pack2.getIngredient() + " " + pack2.getQuantity() + " " + pack2.getUnit();
					combinedDataPack2.add(entry);
				}
			}
			customerPackCombinedResponse.setPack2(combinedDataPack2);

		} catch (Exception e) {
			logger.error("Error fetching combined data for customer {}: {}", customerId, e.getMessage());
		}

		return customerPackCombinedResponse;
	}
}
