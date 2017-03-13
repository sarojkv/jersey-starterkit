/**
 * 
 */
package jayray.net.stocks.tasks;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;

import jayray.net.stocks.dao.UserStockRequestDAO;
import jayray.net.stocks.domain.StockRequestStatus;
import jayray.net.stocks.domain.UserStockRequest;
import jayray.net.stocks.util.InvestmentAnalyzer;
import jayray.net.stocks.util.StockProcessingException;

/**
 * Picks most important queries available - sorted by rank. Gets a prioritizedQ
 * from QueryDataManager. Then for each request, will call InvestmentAnalyzer to
 * analyze/validate. Update success/failure of analyze in the persitent store
 * 
 * TODO: Now java has ExecutorService. Use it later
 * 
 * @author Saroj
 *
 */
public class InvestmentAnalyzerTask extends TimerTask {

	Date now; // to display current time

	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		System.out.println("ScheduledAnalyzer started :" + now);

		// get the ranked order data of stock requests,
		// all records currently marked NEW status are returned
		//
		Queue<UserStockRequest> rankeOrderedQ = UserStockRequestDAO.getNewRankedStockRequests();

		// for each, run the investment analyzer
		// and save the status of the stock anal;yzed - sucess/failure in the
		// database
		//
		UserStockRequest userStockRequest = null;
		while ((userStockRequest = rankeOrderedQ.poll()) != null) {

			try {
				InvestmentAnalyzer.analyze(userStockRequest);
				// success
				//
				userStockRequest.setRequestStatus(StockRequestStatus.ANALYZE_SUCCESS);
			} catch (StockProcessingException e) {
				System.err.println("Exception while analyzing"+e.getMessage());
				userStockRequest.setRequestStatus(StockRequestStatus.ANALYZE_FAILED);
				userStockRequest.setFailureReason(e.getMessage());
			}
			
			//update the stock object it ...
			//TODO: exception handling for DAOs
			UserStockRequestDAO.updateStockRequest(userStockRequest);
			System.out.println("Analyzed record:"+userStockRequest);
		}
	}

}
