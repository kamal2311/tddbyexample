package com.kamaljoshi;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void should_support_equality() throws Exception {

		Money tenDollars = Money.dollar(10);
		Money anotherTenDollars = Money.dollar(10);
		Money fiveDollars = Money.dollar(5);
		Money tenFrancs = Money.franc(10);

		assertThat(tenDollars).isEqualTo(anotherTenDollars);
		assertThat(tenDollars).isNotEqualTo(fiveDollars);
		assertThat(tenDollars).isNotEqualTo(tenFrancs);
		assertThat(tenFrancs).isEqualTo(fiveDollars);
	}

	@Test
	public void should_support_multiplication() throws Exception {

		Money fiveDollars = Money.dollar(5);
		Money tenDollars = Money.dollar(10);

		assertThat(fiveDollars.times(2)).isEqualTo(tenDollars);

		Money fifteenFrancs = Money.franc(15);
		Money thirtyFrancs = Money.franc(30);

		assertThat(fifteenFrancs.times(2)).isEqualTo(thirtyFrancs);
	}

	@Test
	public void should_support_addition_of_francs_to_francs() throws Exception {

		Money initiallyFiveFrancs = Money.franc(5);

		Money sum = initiallyFiveFrancs.plus(Money.franc(10));

		assertThat(sum).isEqualTo(Money.franc(15));

	}

	@Test
	public void should_support_addition_of_dollars_to_francs() throws Exception {
		
		Money initiallyFiveFrancs = Money.franc(5);
		
		Money sum = initiallyFiveFrancs.plus(Money.dollar(10));
		
		assertThat(sum).isEqualTo(Money.franc(25));
		
	}

	@Test
	public void should_support_addition_of_dollars_to_dollars() throws Exception {

		Money initiallyFiveDollars = Money.dollar(5);

		Money sum = initiallyFiveDollars.plus(Money.dollar(5));

		assertThat(sum).isEqualTo(Money.dollar(10));

	}

	@Test
	public void should_support_addition_of_francs_to_dollars() throws Exception {

		Money initiallyFiveDollars = Money.dollar(5);

		Money sum = initiallyFiveDollars.plus(Money.franc(10));

		assertThat(sum).isEqualTo(Money.dollar(10.0));

	}

	@Test
	public void should_have_exchange_rate() throws Exception {

		assertThat(Money.franc(5).unitsPerDollar()).isEqualTo(2.0);

	}

	@Test
	public void should_create_dollars() throws Exception {

		assertThat(Money.dollar(10)).isNotNull();
	}

	@Test
	public void should_create_francs() throws Exception {

		assertThat(Money.franc(5)).isNotNull();
	}

	@Test
	public void should_know_its_currency() throws Exception {

		assertThat(Money.dollar(0).currency()).isEqualTo("USD");
		assertThat(Money.franc(0).currency()).isEqualTo("CHF");
	}

}