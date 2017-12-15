package guiPlayer;

import java.util.ArrayList;
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
		String b = in.nextLine();

		System.out.println("Type when it was released!");
		String c = in.nextLine();
		test.addNewItem(a,b,c);
		
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
	
}
