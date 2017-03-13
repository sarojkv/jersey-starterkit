/**
 * 
 */
package jayray.net.stocks.bl;

import jayray.net.stocks.domain.UserStockRequest;
import jayray.net.stocks.util.StockProcessingException;

/**
 * @author Saroj
 *
 */
public interface StocksTrader {

	/**
	 * makes an actual trade and persists the trade made
	 * @param userStockRequest
	 */
	void processStocks(UserStockRequest userStockRequest);

}