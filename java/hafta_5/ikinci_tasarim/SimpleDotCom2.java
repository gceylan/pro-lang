import java.util.ArrayList;


public class SimpleDotCom2 {

	private int numOfHits;
	private int numOfFalse;
	
	//random ArrayList olu�turma fonksiyonu
	public ArrayList<Integer> myRandArr(int n) {
		ArrayList<Integer> randList = new ArrayList<Integer>();
		while (randList.size() < n) {
			int rand = (int)(Math.random() * 10);
			randList.add(rand);
		}
		return randList;
	}
	
	//bu fonksiyon ile �retti�im rastgele ArrayList' i String' e �evirdik.
	public String numbers (ArrayList<Integer> xArray) {
		String nums = "";
		for (int i : xArray) {
			nums += i + ", ";
		}
		return nums;
	}
	
	//rastgele dizimizde silme yapabilmek i�in myArr' ArrayListini olulturduk.
	public ArrayList<Integer> myArr = myRandArr(3);
	
	public String stringNumberOfArray = numbers(myArr);
	
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
		for (int cell : myArr) {
			if (guess == cell) {
				result = "hit";
				numOfHits++;
				int ind = myArr.indexOf(cell);	//ayn� eleman sorununu ��zd�k.
				myArr.remove(ind);
				break;
			} else
				numOfFalse++;
		}
		
		if (numOfHits == 3) {
			result = "kill";
		}
		System.out.println(stringGuess + " --> " + result);
		return result;
	}
}
