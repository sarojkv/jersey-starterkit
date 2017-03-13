/**
 * 
 */
package jayray.net.stocks.bl;

import jayray.net.stocks.domain.ReceiptMessage;
import jayray.net.stocks.domain.UserStockRequest;

/**
 * Handles user request for trading
 * @author Saroj
 *
 */
public interface InvestmentQuery {
	/**
	 * receives user request to trade mainly to buy or sell a particular stock
	 * @param userStockRequest -  DTO/POJO object storing stock request
	 * @return -  message to confirm receipt of the request
	 */
	public ReceiptMessage trade(UserStockRequest  userStockRequest);
}
