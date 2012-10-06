package com.gceylan.agyapilandirmasi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class SetIPAddres {

	String ip = null;
	String netmask = null;

	public SetIPAddres() {

		getIP();
		go();
	}

	public void getIP() {

		Scanner input = new Scanner(System.in);
		System.out.print("IP      : ");
		ip = input.next().trim();

		System.out.print("NETMASK : ");
		netmask = input.next().trim();
	}

	public static boolean isUnix() {

		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
	}

	public static boolean isWindows() {

		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("win") >= 0);
	}

	public void go() {
		
		StringBuffer command = null;
		
		String s = null;
		
		try {
			
			if (isUnix()) {
				command = new StringBuffer();
				command.append("sudo ifconfig eth0 ").append(ip).append(" netmask ").append(netmask).append(" up");
			}
			
			if (isWindows()) {
				command = new StringBuffer();
				// 192.168.0.1 1  default gateway
				command.append("netsh interface ip set address name=\"Local Area Connection\" static ").append(ip);
				command.append(" ").append(netmask).append(" 192.168.0.1 1");
			}

			// Process sayesinde istediğimiz konsol komutunu işletim sistemi üzerinde çalıştırıyoruz.
	        Process p = Runtime.getRuntime().exec(command.toString());
	        
			// alttaki 2 'BufferedReader' komutu işletmeye yarıyor varsa hataları da topluyor.
	        BufferedReader stdInput = new BufferedReader(new
	        		InputStreamReader(p.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new
	        		InputStreamReader(p.getErrorStream()));

	        // komut çalıştıktan sonra oluşan çıktı ekrana yazılıyor...
	        System.out.println("Here is the standard output of the command:\n");
	        while ((s = stdInput.readLine()) != null) {
	        	System.out.println(s);
	        }

	        // komut çalıştırdıktan sonra varsa oluşan hatalar ekrana yazılıyor...
	        System.out.println("Here is the standard error of the command (if any):\n");
	        while ((s = stdError.readLine()) != null) {
	        	System.out.println(s);
	        }

	        System.exit(0);
	    }
		catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		
		new SetIPAddres();
	}
}
