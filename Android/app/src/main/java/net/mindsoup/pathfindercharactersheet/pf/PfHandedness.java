package net.mindsoup.pathfindercharactersheet.pf;

public enum PfHandedness {
	ONEHAND, TWOHAND, OFFHAND;
	
	public static PfHandedness getHandedness(int i) {
		return PfHandedness.values()[i];
	}
}
