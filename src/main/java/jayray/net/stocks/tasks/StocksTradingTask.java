/**
 * 
 */
package jayray.net.stocks.tasks;

import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.TimerTask;

import jayray.net.stocks.bl.StocksTrader;
import jayray.net.stocks.bl.StocksTraderImpl;
import jayray.net.stocks.dao.UserStockRequestDAO;
import jayray.net.stocks.domain.UserStockRequest;

/**
 * @author Saroj
 *
 */
public class StocksTradingTask extends TimerTask {

	Date now; // to display current time

	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		int THRESOLD_RANK = 80;//from config file, and read in run() method
		
		System.out.println("StocksTradingTask started :" + now);

		// get the list of stocks that are available to be traded after being analyzed
		//
		Queue<UserStockRequest> userStocksToTrade = UserStockRequestDAO.getStockToTrade(THRESOLD_RANK);
		//TODO: move to a factory class
		StocksTrader stocksTrader = new StocksTraderImpl();
		
		for (UserStockRequest userStockRequest : userStocksToTrade) {
			stocksTrader.processStocks(userStockRequest);
			System.out.println("Traded record:"+userStockRequest);
		}
	}

}
