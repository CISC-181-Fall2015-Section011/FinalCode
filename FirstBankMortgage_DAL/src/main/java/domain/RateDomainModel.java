package domain;


import java.io.Serializable;
import java.time.LocalDate;

public class RateDomainModel implements Serializable {
	
	private int RateID;
	private int MinCreditScore;
	private double InterestRate;
	
	public RateDomainModel(int rateID, int minCreditScore, double interestRate){
		RateID = rateID;
		MinCreditScore = minCreditScore;
		InterestRate = interestRate;
	}
	
	public int getRateID() {
		return RateID;
	}
	public void setRateID(int rateID) {
		RateID = rateID;
	}
	public int getMinCreditScore() {
		return MinCreditScore;
	}
	public void setMinCreditScore(int minCreditScore) {
		MinCreditScore = minCreditScore;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	
	
}