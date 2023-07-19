/**
* PackService
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.service;

import org.springframework.stereotype.Service;

import com.xnara.api.model.response.CustomerPackCombinedResponse;

@Service
public interface PackService {

	/**
	 * This method is used to get the combined data of pack1 and pack2
	 * 
	 * @param customer_id - The id of customer
	 * @return {@link CustomerPackCombinedResponse}
	 */
	public CustomerPackCombinedResponse getCombinedPackData(String customer_id);
}
