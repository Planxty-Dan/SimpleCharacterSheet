package net.mindsoup.pathfindercharactersheet.pf.util;

public class Dice {
	int numSides;
	int numDice;
	
	public Dice(int argNumSides, int argNumDice) {
		init(argNumSides, argNumDice);
	}
	
	public Dice(String dice) {
		String[] bits = dice.split("d");
		
		if(bits.length == 2) {
			init(Integer.parseInt(bits[1]), Integer.parseInt(bits[0]));
		} else {
			throw new RuntimeException("Invalid dice string: " + dice);
		}
	}
	
	private void init(int argNumSides, int argNumDice) {
		numSides = argNumSides;
		numDice = argNumDice;
	}
	
	public String toString() {
		return Integer.toString(numDice) + "d" + Integer.toString(numSides);
	}
	
	public int getMax() {
		return numSides * numDice;
	}
}
