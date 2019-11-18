package com.pedrotavares.nextirishlotterydraw;

import java.util.Calendar;

public class NextIrishLotteryDraw {

	public static Calendar nextDayOfWeek(int dow) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MILLISECOND, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.HOUR, 20);

		int diff = dow - date.get(Calendar.DAY_OF_WEEK);
		if (diff <= 0) {
			diff += 7;
		}
		date.add(Calendar.DAY_OF_MONTH, diff);
		return date;
	}

	public boolean isNextDrawOnWednesday(Calendar date) {
		return date.before(nextDayOfWeek(Calendar.WEDNESDAY));
	}

	public boolean isNextDrawOnSaturday(Calendar date) {
		return !isNextDrawOnWednesday(date) && date.before(nextDayOfWeek(Calendar.SATURDAY));
	}
	
	public static void main(String[] args) {
		
		NextIrishLotteryDraw nextDraw = new NextIrishLotteryDraw();
		
		Calendar nextWednesday = nextDayOfWeek(Calendar.WEDNESDAY);
		Calendar nextSaturday = nextDayOfWeek(Calendar.SATURDAY);
		
		System.out.printf("Next Wednesday Draw: %ta, %<tb %<te, %<tY", nextWednesday);
		System.out.println();
		System.out.printf("Next Saturday Draw: %ta, %<tb %<te, %<tY", nextSaturday);
		System.out.println();		
		
		Calendar now = Calendar.getInstance();
		boolean boolIsNextDrawOnWednesday = nextDraw.isNextDrawOnWednesday(now);
		System.out.printf("Is next draw on Wednesday: " + boolIsNextDrawOnWednesday);
		if (!boolIsNextDrawOnWednesday) {
			System.out.printf("Is next draw on Saturday: " + nextDraw.isNextDrawOnSaturday(now));
		}
		
		
	}
}