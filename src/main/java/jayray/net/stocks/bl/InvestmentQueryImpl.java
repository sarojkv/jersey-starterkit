/**
 * 
 */
package jayray.net.stocks.bl;

import jayray.net.stocks.dao.UserStockRequestDAO;
import jayray.net.stocks.domain.ReceiptMessage;
import jayray.net.stocks.domain.UserStockRequest;

/**
 * @author Saroj
 *
 */
public class InvestmentQueryImpl implements InvestmentQuery {

	/* (non-Javadoc)
	 * @see jayray.net.stocks.bl.InvestmentQuery#trade(jayray.net.stocks.domain.UserStockRequest)
	 */
	@Override
	public ReceiptMessage trade(UserStockRequest userStockRequest) {
		System.out.println("Trading stock: " + userStockRequest);
		ReceiptMessage receiptMessage = new ReceiptMessage();
		//exception handling to be done here.
		if(UserStockRequestDAO.saveStockRequest(userStockRequest)){
			receiptMessage.setSuccess(true);
			receiptMessage.setMessage("Added request for trade");
		}else{
			receiptMessage.setSuccess(false);
			receiptMessage.setMessage("Could not add");
			//todo: errror code and error via exceptions from QDM
		}
		return receiptMessage;
	}

}
