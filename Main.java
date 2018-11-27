package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static String alphabet;
	private static String states;
	private int numOfStates;
	private static String startState;
	private ArrayList<Vertex> acceptingStates;

	public static void main(String args[]) {

		//read file
		File dfa = importDFA();

		//set values

		//add transition states

		//test input string

		Vertex a = new Vertex();
		Vertex b = new Vertex();
		Vertex c = new Vertex();
		Vertex d = new Vertex();
		Vertex e = new Vertex();

		ArrayList<Vertex> acceptingStates = new ArrayList<Vertex>();
		acceptingStates.add(d);
		acceptingStates.add(e);

		Edge e1 = new Edge('0', a, b);
		Edge e2 = new Edge('1', a, c);

		Graph graph = new Graph(acceptingStates, a);
	}

	public static File importDFA(){
		File dfa = new File("C:\\Users\\daven_000\\Desktop\\dfa.txt");

		try{
			BufferedReader br = new BufferedReader(new FileReader(dfa));
		} catch (FileNotFoundException fnf1){
			System.out.println("Your file could not be found. Please input the path of your dfa file.");
			Scanner input = new Scanner(System.in);
			dfa = new File(input.next());
		}

		return dfa;
	}

	public static void applyDFA(File dfa){
		try (BufferedReader br = new BufferedReader(new FileReader(dfa))){
			String line;
			while ((line = br.readLine()) != null){
				String alphaBet = br.readLine();
				alphabet = alphaBet.replaceAll("[^a-zA-Z0-9]","");//this regex removes all symbols and leaves only letters

				String allStates = br.readLine();
				states = allStates.replaceAll("[^a-zA-Z0-9]","");

				startState = br.readLine();

				String acceptStates = br.readLine();//need to convert string values to an ArrayList<Vertex>

				List<String> list = new ArrayList<String>(); //adds all transition states to an array
				while((line = br.readLine()) != null){
				    list.add(line);
				}
				String[] transitionStates = list.toArray(new String[0]); // transitionStates[i].charAt(1) is state, transitionStates[i].charAt(3) is input, transitionStates[i].charAt(7) is destination


			}
		} catch (IOException ioe1){
			System.out.println("This file is invalid or isn't formatted properly.");
		}
	}



}
