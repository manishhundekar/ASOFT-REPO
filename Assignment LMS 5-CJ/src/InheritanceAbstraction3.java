abstract class PrepaidCard
{
	private int cardNo;
	private double availableBalance;
	private double swipeLimit;
	
	abstract public boolean swipeCard(double amount);
	
	public PrepaidCard() {}
	
	public PrepaidCard(int cardNo, double availableBalance, double swipeLimit) {
		this.cardNo = cardNo;
		this.availableBalance = availableBalance;
		this.swipeLimit = swipeLimit;
	}

	public void rechargeCard(double amount)
	{
		this.setAvailableBalance(this.getAvailableBalance() + amount);
		System.out.println("Recharge Done.");
	}
	
	@Override
	public String toString(){
		return "Card No :" + this.cardNo + "\nAvailable Balance :" + this.availableBalance + "\nSwipe Limit : " + this.swipeLimit;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getSwipeLimit() {
		return swipeLimit;
	}

	public void setSwipeLimit(double swipeLimit) {
		this.swipeLimit = swipeLimit;
	}
	
	
}


class TravelCard extends PrepaidCard{
	private int rewardPoints;
	
	
	public TravelCard(int cardNo, double availableBalance, double swipeLimit,int rewardPoints) {
		super(cardNo,availableBalance,swipeLimit);
		this.rewardPoints = rewardPoints;
	}

	
	public void CalculateRewardPoints(double amount)
	{
		int points = (int) amount/100 ;
		setRewardPoints(points);
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}



	public boolean swipeCard(double amount)
	{
		amount = amount * 60; // conversion from USD to INR
		if(amount<= super.getSwipeLimit() && amount<= super.getAvailableBalance())
		{
			setAvailableBalance(getAvailableBalance() - amount - (0.05*amount));
			CalculateRewardPoints(amount);
			return true;
		}
		return false;
	}
}


public class InheritanceAbstraction3 {

	public static void main(String[] args) {
		TravelCard tc = new TravelCard(142536,5000,10000,0);
		System.out.println("Card Details :" + tc);
		System.out.println("Reward Points : " + tc.getRewardPoints());
		tc.rechargeCard(5000);
		if(tc.swipeCard(50))
		{
			System.out.println("Swipe Successfull");;
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
		System.out.println("Card Details :" + tc);
		System.out.println("Reward Points : " + tc.getRewardPoints());
	}

}
