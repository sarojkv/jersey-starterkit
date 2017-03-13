/**
 * 
 */
package jayray.net.stocks.demo;

import java.util.Date;
import java.util.Queue;
import java.util.Timer;

import jayray.net.stocks.bl.InvestmentQuery;
import jayray.net.stocks.bl.InvestmentQueryImpl;
import jayray.net.stocks.dao.UserStockRequestDAO;
import jayray.net.stocks.domain.QueryType;
import jayray.net.stocks.domain.StockRequestStatus;
import jayray.net.stocks.domain.UserStockRequest;
import jayray.net.stocks.tasks.InvestmentAnalyzerTask;
import jayray.net.stocks.tasks.StocksTradingTask;

/**
 * @author Saroj
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//demoSimpleRankAndOrder();

		 //demoSchedulersRunning();

		demoSimpleRankAndOrderProcessingPipeline();
	}

	private static void demoSimpleRankAndOrder() {

		// create stocks in certain with different rank and must return sorted
		// with ranked order, order id
		//

		UserStockRequest stockRequest1 = new UserStockRequest(new Long(1), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 100/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest2 = new UserStockRequest(new Long(2), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 150/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest3 = new UserStockRequest(new Long(3), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 500/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest4 = new UserStockRequest(new Long(4), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 150/* Rank */, new Date(), StockRequestStatus.NEW, "");

		// send 3 requests
		InvestmentQuery query = new InvestmentQueryImpl();
		// send 3 requests
		query.trade(stockRequest1);
		query.trade(stockRequest2);
		query.trade(stockRequest3);
		query.trade(stockRequest4);

		// get back the 3 request
		//
		Queue<UserStockRequest> rankeOrderedQ = UserStockRequestDAO.getNewRankedStockRequests();

		// for each, run the investment analyzer
		// and save the status of the stock anal;yzed - sucess/failure in the
		// database
		//
		UserStockRequest userStockRequest = null;
		while ((userStockRequest = rankeOrderedQ.poll()) != null) {
			System.out.println(userStockRequest);
		}

	}

	
	private static void demoSchedulersRunning() {
		Timer time = new Timer(); // Instantiate Timer Object
		InvestmentAnalyzerTask analyzerTask = new InvestmentAnalyzerTask();
		time.schedule(analyzerTask, 0, 2000);// every 2 secs

		Timer time2 = new Timer(); // Instantiate Timer Object
		StocksTradingTask tradingTask = new StocksTradingTask();
		time2.schedule(tradingTask, 0, 2000);// every 2 secs
	}

	private static void demoSimpleRankAndOrderProcessingPipeline() {

		demoSchedulersRunning();
		
		UserStockRequest stockRequest1 = new UserStockRequest(new Long(1), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 100/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest2 = new UserStockRequest(new Long(2), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 150/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest3 = new UserStockRequest(new Long(3), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 500/* Rank */, new Date(), StockRequestStatus.NEW, "");

		UserStockRequest stockRequest4 = new UserStockRequest(new Long(4), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 150/* Rank */, new Date(), StockRequestStatus.NEW, "");
		
		UserStockRequest stockRequest5 = new UserStockRequest(new Long(5), "U1", "S1", new Double(100), new Long(5),
				QueryType.BUY, 75/* Rank */, new Date(), StockRequestStatus.NEW, "");

		// send 3 requests
		InvestmentQuery query = new InvestmentQueryImpl();
		// send 3 requests
		query.trade(stockRequest1);
		query.trade(stockRequest2);
		query.trade(stockRequest3);
		query.trade(stockRequest4);
		query.trade(stockRequest5);
		
		
	}

}
