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

	private String alphabet;
	private int numOfStates;
	private String startState;
	private ArrayList<Vertex> acceptingStates;

	public static void main(String args[]) {

		//read file
		File dfa = importDFA(); //done

		//set values and add transition states
		applyDFA(dfa); //halfway done

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
				String alphabet = br.readLine();
				String allStates = br.readLine();
				String startState = br.readLine();
				String acceptStates = br.readLine();

				List<String> list = new ArrayList<String>(); //adds all transition states to an array
				while((line = br.readLine()) != null){
				    list.add(line);
				}
				String[] transitionStates = list.toArray(new String[0]);


				//now need to parse the inputs into something that can be read

			}
		} catch (IOException ioe1){

		}
	}
}
