package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<VideoGame> list;

	public CatalogMaker() {
		list = new ArrayList<VideoGame>();
		list.add(new VideoGame("Portal 2","Valve","2012"));
		list.add(new VideoGame("CS:GO","Valve","2011"));
		list.add(new VideoGame("Overwatch","Blizzard","2015"));
		list.add(new VideoGame("Left 4 Dead 2","Valve","2013"));
		list.add(new VideoGame("Team Fortress 2","Valve","2007"));
		list.add(new VideoGame("HearthStone","Blizzard","2014"));
	}

	public static void main(String[] args) {

		CatalogMaker test = new CatalogMaker();
		System.out.println(test.getCSVContent());
		System.out.println("Type what you would like to add to the Video Game List");
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		System.out.println("Type who made it!");
		while(!a.equals("done")) {
			String b = in.nextLine();
			System.out.println("Type when it was released!");
			String c = in.nextLine();
			test.addNewItem(a,b,c);
			System.out.println("Type who made it or type 'done' to stop.");
			a = in.nextLine();
		}
		System.out.println("Type what you would like the file to be saved as.");
		String fileName = in.nextLine();
		test.testSaveContent(fileName);
		System.out.println("Here is the new CSV file.");
		System.out.println(test.getCSVContent());
		System.out.println("What file would you like to load?\n");
		a = in.nextLine();
	}

	public String getCSVContent() {
		String data = "Title,Company,Year\n";
		for(VideoGame vg: list) {
			data += vg+"\n";
		}
		return data;
	}

	public void addNewItem(String name, String company, String date) {
		list.add(new VideoGame(name,company,date));
		System.out.println("Item added!");
	}

	private void testSaveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter(fileName+".csv");    
			for(VideoGame vg: list)
				fw.write(vg+"\n");
			System.out.println("Success! File \""+fileName+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private List<String> testFileLoading() {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		List<String> content = new ArrayList<String>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {
					String[] parem = line.split(",");
					list.add(new VideoGame(parem[0],parem[1],parem[2]));
				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		//close the Scanner
		in.close();
		return content;
	}
}
