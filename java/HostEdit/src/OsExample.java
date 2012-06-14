
public class OsExample {
 
	public static boolean isWindows() {
 
		String os = System.getProperty("os.name").toLowerCase();
		String versionOS = System.getProperty("os.version").toLowerCase();
		String architectureOS = System.getProperty("os.arch").toLowerCase();
		
		System.out.println("The information about OS");
		
		System.out.println("\nName of the OS: "
				+ os);
		
		System.out.println("Version of the OS: "
				+ versionOS);
		
		System.out.println("Architecture of THe OS: "
				+ architectureOS);
		
		return (os.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Mac
		return (os.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
 
	}
 
	public static boolean isSolaris() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Solaris
		return (os.indexOf("sunos") >= 0);
 
	}
	
	public static void main(String[] args) {
		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
	}
 
}
