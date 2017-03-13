/**
 * 
 */
package jayray.net.stocks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import jayray.net.stocks.domain.UserStockRequest;

/**
 * responsible for storing and managing all stock requests received. It abstracts caching,
 * performance, etc of queries from others. 
 * 
 * It Queues requests. We will use a
 * PriorityQueue data structure. When query is received, it will put
 * UserStockRequest in the Q that is cached. Additionally system will write
 * query to persistent store.
 * 
 * Will avoid read/write on the same Q instance. Write to a Q instance, when
 * ScheduledAnalyzer asks, give the current Q instance, and start using new Q
 * instance for further writes. current Q instance discarded when done keeps
 * collections small at a given time Comparable on UserStockRequest to pick rank
 * based from the Q Why PriorityQueue?
 * 
 * 
 * @author Saroj
 *
 */
public class UserStockRequestDAO {

	// TODO: optimize based on load, externalize in config file
	private static final int INIT_CAPACITY_CACHE = 100;

	// TODO: using this for now. change to a list, and then copy that list to a
	// Q when needed for
	//
	// private static Collection<UserStockRequest> userStockRequestCache =
	// Collections
	// .synchronizedList(new ArrayList<UserStockRequest>(INIT_CAPACITY_CACHE));
	private static PriorityBlockingQueue<UserStockRequest> userStockRequestCache = new PriorityBlockingQueue<UserStockRequest>();

	/**
	 * saves the user trade query in the database and cache in a priority Q
	 * 
	 * @param userStockRequest
	 * @return true if success, false on failure
	 * 
	 */
	public static boolean saveStockRequest(UserStockRequest userStockRequest) {
		// TODO : implementation
		// TODO: exception handling, if DB fails, remove from Q

		// keeping a write through cache 
		// TODO: we cam use an ORM (hibernate) backed with caching solution to
		// implement this
		// right now handcoded
		userStockRequestCache.add(userStockRequest);

		// Add to StocksToTrade table
		//
		// TODO:
		MockDatabase.persistStockRequests(userStockRequest);

		return true;
	}
	
	public static boolean updateStockRequest(UserStockRequest userStockRequest) {
		
		//will update the user stock request in the persistent store
		//right now using Mock
		//
		MockDatabase.persistStockRequests(userStockRequest);
		
		return true;
	}

	/**
	 * Will return a batch of all stock requests that are marked NEW. It will
	 * attempt to read from a cache to improve performance.
	 * 
	 * @return - ranked ordered collection Q
	 */
	public static Queue<UserStockRequest> getNewRankedStockRequests() {

		// TODO: not optimized code, needs to copy from and send
		// right now happy path
		//

		// copy to a local priorityqueue that does not need threading
		//
		Queue<UserStockRequest> userStockPriorityQ = new PriorityQueue<>();
		int records = userStockRequestCache.drainTo(userStockPriorityQ);
		System.out.println("Number of ranked records to be processed:" + records);

		return userStockPriorityQ;

	}

	/**
	 * get stocks that are analyzed and ready for trade. Input
	 * @param tHRESOLD_RANK - 
	 * @return
	 * 		will return all request that are greater than the thresold rank
	 */
	public static Queue<UserStockRequest> getStockToTrade(int tHRESOLD_RANK) {
		//TODO: get the list
		Queue<UserStockRequest> stockRequests = MockDatabase.getStockRequestsForRankGreaterThan(tHRESOLD_RANK);
		System.out.println("Number of analyzed records to be processed for thresold:" + tHRESOLD_RANK + " are: "+ stockRequests.size());
		return stockRequests;
	}

}
