/**
 * 
 */
package jayray.net.stocks.domain;

import java.util.Date;

/**
 * @author Saroj
 *
 */
public class Stock {
	
	private String stockID;
	private Double stockPrice;
	private Long noOfAvailableStocks;
	private Date lastUpdated;
	/**
	 * @return the stockID
	 */
	public String getStockID() {
		return stockID;
	}
	/**
	 * @param stockID the stockID to set
	 */
	public void setStockID(String stockID) {
		this.stockID = stockID;
	}
	/**
	 * @return the stockPrice
	 */
	public Double getStockPrice() {
		return stockPrice;
	}
	/**
	 * @param stockPrice the stockPrice to set
	 */
	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
	/**
	 * @return the noOfAvailableStocks
	 */
	public Long getNoOfAvailableStocks() {
		return noOfAvailableStocks;
	}
	/**
	 * @param noOfAvailableStocks the noOfAvailableStocks to set
	 */
	public void setNoOfAvailableStocks(Long noOfAvailableStocks) {
		this.noOfAvailableStocks = noOfAvailableStocks;
	}
	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
