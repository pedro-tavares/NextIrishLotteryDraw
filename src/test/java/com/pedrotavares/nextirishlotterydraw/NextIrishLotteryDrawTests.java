package com.pedrotavares.nextirishlotterydraw;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class NextIrishLotteryDrawTests {
	
	NextIrishLotteryDraw nextDraw = new NextIrishLotteryDraw();

	@Test
	void testForNextDrawOnWednesday() {
		Calendar date = Calendar.getInstance();
		date.set(2019, 11-1, 18); // Month value is 0-based. e.g., 0 for January.
		assertTrue(nextDraw.isNextDrawOnWednesday(date));
		assertFalse(nextDraw.isNextDrawOnSaturday(date));
	}
	
	@Test
	void testForNextDrawOnSaturday() {
		Calendar date = Calendar.getInstance();
		date.set(2019, 11-1, 21); // Month value is 0-based. e.g., 0 for January.
		assertFalse(nextDraw.isNextDrawOnWednesday(date));
		assertTrue(nextDraw.isNextDrawOnSaturday(date));
	}

}
