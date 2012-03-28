
public class SimpleDotCom {
	
	private int[] locationCells;
	private int numOfHits;
	private int numOfFalse;
	
	public void setLocationCells(int[] loc) {
		locationCells = loc;
	}
	
	public void setNumOfHits(int num) {
		numOfHits = num;
	}
	
	public int getNumOfHits() {
		return numOfHits;
	}
	
	public int getnumOfFalse() {
		return numOfFalse;
	}
	
	public String checkYourSelf(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "miss";
		int i = 0;
		for (int cell : locationCells) {
			if (guess == cell) {
				locationCells[i] = -1;	//hit olan sayı -1 ile değiştiriliyor.
				result = "hit";
				numOfHits++;
				break;
			} else {
				numOfFalse++;
			}
			i++;
		}
		
		if (numOfHits == 3) {
			result = "kill";
		}
		System.out.println(stringGuess + " --> " + result);
		return result;
	}
}
