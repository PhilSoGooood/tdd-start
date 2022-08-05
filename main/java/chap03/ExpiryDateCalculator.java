package main.java.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

	public LocalDate calculateExpiryDate(PayData payData) {
		int addedMonths = calculateAddedMonths(payData);
		if (payData.getFirstBillingDate() != null) {
			return expiryDateUsingFirstBillingDate(payData, addedMonths);
		} else {
			return payData.getBillingDate().plusMonths(addedMonths);
		}
	}

	private int calculateAddedMonths(PayData payData) {
		int years = payData.getPaymentAmount() / 100_000;
		int months = (payData.getPaymentAmount() % 100_000) / 10_000;
		return (years * 12) + months;
	}

	private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
		LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
		if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
			final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
			final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
			if (dayLenOfCandiMon < dayOfFirstBilling) {
				return candidateExp.withDayOfMonth(dayLenOfCandiMon);
			}
			return candidateExp.withDayOfMonth(dayOfFirstBilling);
		} else {
			return candidateExp;
		}
	}

	private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
		return date1.getDayOfMonth() != date2.getDayOfMonth();
	}

	private int lastDayOfMonth(LocalDate date) {
		return YearMonth.from(date).lengthOfMonth();
	}

}
