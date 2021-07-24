package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static Console console = null;

	private Console(){
		//private for avoid creation
	}

	public static Console getInstance(){
		if (console == null){
			console = new Console();
		}
		return console;
	}

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("character string");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	public void writeln() {
		System.out.println();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	public void write(char character) {
		System.out.print(character);
	}

	public void writeln(int integer) {
		System.out.println(integer);
	}

	private void writeError(String format) {
		System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
	}
}
