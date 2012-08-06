package aterm.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import aterm.ATermFactory;
import aterm.pure.PureFactory;


public class TestBAFReader {
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ATermFactory f = new PureFactory();
		for(int i = 0; i<10; i++) {
			final long start = System.currentTimeMillis();
			f.readFromBinaryFile(new FileInputStream(args[0]));
			final long end = System.currentTimeMillis();
			System.out.println("Elapsed : " + (end - start) + "ms");
		}
	}
}