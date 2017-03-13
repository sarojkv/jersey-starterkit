/**
 * 
 */
package jayray.net.stocks.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jayray.net.stocks.bl.Investment;
import jayray.net.stocks.bl.InvestmentImpl;
import jayray.net.stocks.domain.Portfolio;

/**
 * @author Saroj
 *
 */
@Path("investment")
public class InvestmentQueryService {
	
	@GET
	@Path("portfolio/{userid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Portfolio getPortfolio(@PathParam("userid") String userId) {
		//TODO: check if userid is valid
		//
		//UserIdValidator.validateUserId(userId);
		
		//TODO: Add factory for getting objects
		//
		//Investment investment = new InvestmentImpl();
		
		return null;
	}
}

