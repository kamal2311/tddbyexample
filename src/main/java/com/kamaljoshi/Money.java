package com.kamaljoshi;

public class Money {

	private double amount;
	private String currency;
	private double unitsPerDollar;

	private Money(double d, String currency, double unitsPerDollar) {
		this.amount = d;
		this.currency = currency;
		this.unitsPerDollar = unitsPerDollar;
	}

	public Money times(int times) {
		return new Money(amount * times, currency, unitsPerDollar);
	}

	public String currency() {
		return currency;
	}

	@Override
	public boolean equals(Object other) {
		Money that = (Money) other;
		return amount / unitsPerDollar == that.amount / that.unitsPerDollar;
	}

	static Money dollar(double amount) {
		return new Money(amount, "USD", 1);
	}

	static Money franc(double amount) {
		return new Money(amount, "CHF", 2);
	}

	public Money plus(Money anotherMoney) {
		double dollarAmount = (this.amount / this.unitsPerDollar) + (anotherMoney.amount / anotherMoney.unitsPerDollar);
		return new Money(dollarAmount * this.unitsPerDollar, this.currency, this.unitsPerDollar);
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}

	public double unitsPerDollar() {
		return unitsPerDollar;
	}

}
