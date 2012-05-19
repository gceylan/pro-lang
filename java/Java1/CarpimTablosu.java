
public class CarpimTablosu {

	public static void main(String[] args) {
		System.out.println("\t\tÇarpım Tablosu");
		
		System.out.print("    ");
		for(int j = 1; j <= 9; j++) {
			System.out.print("    " + j);
		}
		
		System.out.println("\n-------------------------------------------------");
		String output = "";
		
		for(int i = 1; i <= 9; i++) {
			output += i + " | ";
			for(int j = 1; j <= 9; j++) {
				if (i * j < 10)
					output += "    " + i * j;
				else
					output += "   " + i * j;
			}
			output += "\n";
		}
		
		System.out.println(output);
	}
}
