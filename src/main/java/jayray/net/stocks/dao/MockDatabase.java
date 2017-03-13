/**
 * 
 */
package jayray.net.stocks.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import jayray.net.stocks.domain.StockRequestStatus;
import jayray.net.stocks.domain.UserStockRequest;

/**
 * Just a mock class that stores eveything in a memory. Used for testing. This
 * is crude and
 * 
 * Only the bare minimum
 * 
 * @author Saroj
 *
 */
public class MockDatabase {

	// TODO: clone the object

	// mock table
	private static final List<UserStockRequest> userStocks = Collections
			.synchronizedList(new ArrayList<UserStockRequest>(10));

	public static void persistStockRequests(UserStockRequest stockRequest) {
		// remove first, way .. just for testing ...
		//
		userStocks.remove(stockRequest);
		userStocks.add(stockRequest);
	}

	public static Queue<UserStockRequest> getStockRequestsForRankGreaterThan(int rank) {
		// TODO: can use someyhing like tyhis later :
		// http://code.google.com/p/jfilter/
		Queue<UserStockRequest> userStocksGreaterThan = new PriorityQueue<UserStockRequest>();
		for (UserStockRequest userStockRequest : userStocks) {
			if (userStockRequest.getRequestStatus().equals(StockRequestStatus.ANALYZE_SUCCESS)
					&& userStockRequest.getRank().intValue() >= rank) {
				userStocksGreaterThan.add(userStockRequest);
			}
		}
		System.out.println("Number of objects greater than rank " + rank + " are " + userStocksGreaterThan.size());
		return userStocksGreaterThan;
	}

	/**
	 * shows all records available
	 */
	public static void dumpCurrentDatabase() {
		System.out.println("Total objects in mock DB:" + userStocks.size());
		for (UserStockRequest userStockRequest : userStocks) {
			System.out.println("Mock DB stock object: " + userStockRequest);
		}
	}

}
