/**
 * 
 */
package jayray.net.stocks.bl;

import jayray.net.stocks.dao.StocksDAO;
import jayray.net.stocks.dao.UserStockRequestDAO;
import jayray.net.stocks.domain.StockRequestStatus;
import jayray.net.stocks.domain.UserStockRequest;
import jayray.net.stocks.util.StockProcessingException;

/**
 * @author Saroj
 *
 */
public class StocksTraderImpl implements StocksTrader {

	/* (non-Javadoc)
	 * @see jayray.net.stocks.bl.StocksTrader#processStocks(jayray.net.stocks.domain.UserStockRequest)
	 */
	@Override
	public void processStocks(UserStockRequest userStockRequest) {
		System.out.println("Processing stock:"+userStockRequest);
		// do the actual trade ...
		//
		boolean success = true;
		try {
			performTradingOnStock(userStockRequest);
			userStockRequest.setRequestStatus(StockRequestStatus.TRADE_SUCCESS);
		} catch (StockProcessingException e) {
			success = false;
			System.err.println("Exception while processing stocks" + e.getMessage());
			userStockRequest.setRequestStatus(StockRequestStatus.TRADE_FAIL);
			userStockRequest.setFailureReason(e.getMessage());
		}

		try {
			// update stock request whether sucess or failure
			//
			UserStockRequestDAO.updateStockRequest(userStockRequest);

			if (success) {
				//TODO: implement
				
				// UserStocks - insert record that a new trade for user happened
				//
				
				// update the stocks with the changed count based on buy/sell
				//
				//StocksDAO.updateStocks(stockid,numberOfStocks);

				// send notitifcation to the user (save in persistent store, and
				// can
				// be delivered by another process
				//
				
				
			}

		} catch (Exception e) {// DAO exceptions
			System.err.println("Exception while saving" + e.getMessage());
			//TODO: handle error
		}
	}

	/**
	 * actual buy or sell process wih trading house
	 * 
	 * @param userStockRequest
	 * @throws StockProcessingException
	 */
	private void performTradingOnStock(UserStockRequest userStockRequest) throws StockProcessingException {
		System.out.println("Processing stock: " + userStockRequest);
	}

}
