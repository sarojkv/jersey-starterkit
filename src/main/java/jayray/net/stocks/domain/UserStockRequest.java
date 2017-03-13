/**
 * 
 */
package jayray.net.stocks.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO for storing user stock trade request. Contains
 * 
	OrderID
	User ID
	Stock ID
	Stock Price
	NoOfStocks
	Action
	Rank
	DateTime
	Status - an enum

 * @author Saroj
 *
 */
public class UserStockRequest implements Serializable, Comparable<UserStockRequest> {

	
	private static final long serialVersionUID = 1L;


	/**
	 * @param orderID
	 * @param userID
	 * @param stockID
	 * @param stockPrice
	 * @param noOfStocks
	 * @param queryType
	 * @param rank
	 * @param date
	 * @param requestStatus
	 * @param failureReason
	 */
	public UserStockRequest(Long orderID, String userID, String stockID, Double stockPrice, Long noOfStocks,
			QueryType queryType, Integer rank, Date date, StockRequestStatus requestStatus, String failureReason) {
		super();
		OrderID = orderID;
		this.userID = userID;
		this.stockID = stockID;
		this.stockPrice = stockPrice;
		this.noOfStocks = noOfStocks;
		this.queryType = queryType;
		this.rank = rank;
		this.date = date;
		this.requestStatus = requestStatus;
		this.failureReason = failureReason;
	}

	private Long OrderID;
	private String userID;
	private String stockID;
	private Double stockPrice;
	private Long noOfStocks;
	private QueryType queryType;
	private Integer rank; 
	private Date date;
	private StockRequestStatus requestStatus;
	private String failureReason;
	
	
	/**
	 * @return the orderID
	 */
	public Long getOrderID() {
		return OrderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(Long orderID) {
		OrderID = orderID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

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
	 * @return the noOfStocks
	 */
	public Long getNoOfStocks() {
		return noOfStocks;
	}

	/**
	 * @param noOfStocks the noOfStocks to set
	 */
	public void setNoOfStocks(Long noOfStocks) {
		this.noOfStocks = noOfStocks;
	}

	/**
	 * @return the queryType
	 */
	public QueryType getQueryType() {
		return queryType;
	}

	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	/**
	 * @return the rank
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the requestStatus
	 */
	public StockRequestStatus getRequestStatus() {
		return requestStatus;
	}

	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(StockRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	/**
	 * @return the failureReason
	 */
	public String getFailureReason() {
		return failureReason;
	}

	/**
	 * @param failureReason the failureReason to set
	 */
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(UserStockRequest otherObject) {
		//-1 if this is small
		//1 if this is greater
		//0 if equal
		
		//if rank > otherObject rank then this is to be processed first so -1
		//if rank < otherObject rank then this to be processed later for 1
		//if rank is equal, then FIFO based on orderid
		//then based on orderid
		// again, orderid < otherObject, then it should be first, so -1
		//
		if(this.rank.intValue() > otherObject.rank.intValue())
			return -1;
		else if(this.rank.intValue() < otherObject.rank.intValue()){
			return 1;
		}else{
			if(this.OrderID.longValue() < otherObject.OrderID.longValue()){
				return -1;
			}else if(this.OrderID.longValue() > otherObject.OrderID.longValue()){
				return 1;
			}else{
				return 0;
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStockRequest other = (UserStockRequest) obj;
		if (OrderID == null) {
			if (other.OrderID != null)
				return false;
		} else if (!OrderID.equals(other.OrderID))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserStockRequest [rank=" + rank + ", OrderID=" + OrderID + ", queryType=" + queryType + ", userID="
				+ userID + ", stockID=" + stockID + ", noOfStocks=" + noOfStocks + ", requestStatus=" + requestStatus
				+ "]";
	}

}
