/**
 * 
 */
package jayray.net.stocks.domain;

/**
 * NEW - Each new user request saved will have the status as NEW. 
 * 
 * ANALYZED-
 * After the Investment Analyzer has performed calculations required, the status
 * will be changed to READY state. 
 * 
 * TRADE_SUCCESS - Once the user request has
 * finally been traded and notification created for the user, the status will be
 * changed to this state.
 * 
 * @author Saroj
 *
 */
public enum StockRequestStatus {
	NEW, ANALYZE_FAILED, ANALYZE_SUCCESS, TRADE_SUCCESS, TRADE_FAIL
}
