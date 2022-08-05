package main.java.chap03;

import java.time.LocalDate;

public class PayData {
	private LocalDate firstBillingDate;
	private LocalDate billingDate;
	private int paymentAmount;

	public PayData() {}

	public PayData(LocalDate firstBillingDate,LocalDate billingDate, int paymentAmount) {
		this.firstBillingDate = firstBillingDate;
		this.billingDate = billingDate;
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getFirstBillingDate() {
		return firstBillingDate;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private PayData data = new PayData();

		public Builder firstBillingDate(LocalDate firstBillingDate) {
			data.firstBillingDate = firstBillingDate;
			return this;
		}

		public Builder billingDate(LocalDate billingDate) {
			data.billingDate = billingDate;
			return this;
		}

		public Builder payAmount(int payAmount) {
			data.paymentAmount = payAmount;
			return this;
		}

		public PayData build() {
			return data;
		}
	}
}
