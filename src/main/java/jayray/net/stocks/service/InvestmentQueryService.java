/**
 * 
 */
package jayray.net.stocks.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import jayray.net.stocks.bl.InvestmentQuery;
import jayray.net.stocks.bl.InvestmentQueryImpl;
import jayray.net.stocks.domain.ReceiptMessage;
import jayray.net.stocks.domain.UserStockRequest;

/**
 * @author Saroj
 *
 */
@Path("/stocks")
public class InvestmentQueryService {
	
	@POST
	@Path("/trade")
	@Consumes({"application/xml","application/json"})
	public ReceiptMessage trade(UserStockRequest userStockRequest) {
		InvestmentQuery query = new InvestmentQueryImpl();
		return query.trade(userStockRequest);
	}
	
	
//	@GET
//	@Path("portfolio/{userid}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Portfolio getPortfolio(@PathParam("userid") String userId) {
//		//TODO: check if userid is valid
//		//
//		//UserIdValidator.validateUserId(userId);
//		
//		//TODO: Add factory for getting objects
//		//
//		//Investment investment = new InvestmentImpl();
//		
//		return null;
//	}
	
	
}

