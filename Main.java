package program;
import java.util.Scanner;
public class Main {
		//pentru a lucra pe parcursul programului cu o copie a vectorului format din elementele introduse de la tastatura
		public static int[] arr;
		//pentru monitorizarea perechilor deja existente
		public static String pairs = "";
		public static void findElement(int currentIndex,int sub_result) {
			//Eu caut b
			//Exista 2 cazuri in care poate fi gasit, ca descazut, respectiv scazator
			//a - b = rezultat; => b = a - rezultat
			int posibilitate_Elem1 = arr[currentIndex] - sub_result;
			//b - a = rezultat => b = a + rezultat
			int posibilitate_Elem2 = arr[currentIndex] + sub_result;
			
			String pair = null; 
			for(int k = 0; k<arr.length;k++) {
				//Se evita indexul elementului pe care il avem deja pentru pereche
				if(k == currentIndex) {
					continue;
				}
				else {
					//Daca indexul este diferit , atunci cautam ca elementul din vector sa fie egal cu una din posibilitatile date
					if(arr[k] == posibilitate_Elem1) {
						pair = "(" + currentIndex + " " + k + ")";
						//De asemenea verificam ca perechea nu a fost gasita deja 
						if(pairs.contains(pair) == false){
							//Iar daca este o pereche noua, o adaugam la vectorul de perechi
							pairs = pairs + pair + ",";
						}
						
					}
					//Procedeul este analog pentru a doua varianta de rezultat
					if(arr[k] == posibilitate_Elem2) {
						pair  = "(" + k + " " + currentIndex + ")";
						if(pairs.contains(pair) == false){
							pairs = pairs + pair + ",";
						}
					}
				}
			}
		}
		//Se afiseaza toate perechile gasite
		public static void displayAllPairs() {
			System.out.println(pairs);
		}
		//Se apeleaza pentru a forma sirul ce contine perechile gasite
		public static void findPairs(int sub_result) {
			for(int j = 0; j < arr.length; j++) {
				findElement(j,sub_result);
			}
			
		}
		//Se afiseaza elementele vectorului format din intrari
		public static void displayArrayElements() {
			System.out.println("The array: ");
			for (int i = 0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
		}
		@SuppressWarnings("resource")
		//Se creeaza vectorul original
		public static int[] takeInputs(int nr) {
			int[] array = new int[nr];
			Scanner scan = new Scanner(System.in);
			for(int i = 0;i<nr;i++) {
				array[i] = Integer.parseInt(scan.next());
			}
			return array;
		}
		
		public static void displayErrorMessage() {
			System.err.println("The array must be at least 2 elements long!");
		}
		public static void usage(int arg1, int arg2) {
			System.out.println("Performante timp: O(n^2) - algoritm de căutare secvențială a perechii fiecărui element");
			System.out.println("Performanțe spațiu: O(n)");
			System.out.println("Se vor da ca argumente : ");
			System.out.println("Lungimea sirului A in care se cauta perechile:");
			System.out.println("Diferenta cautata");
			System.out.println("Se ruleaza programul");
			System.out.println("Dimensiunea vectorului de intrare: n = " + arg1);
			System.out.println("Diferenta cautata:" + arg2);
		}
		public static void main(String[] args) {
			//Primul argument este dimensiunea vectorului de intrare 
			//Al doilea argument este rezultatul dorit pentru scaderi
			usage(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			int noOfInputs = Integer.parseInt(args[0]);
			if(noOfInputs<2) {
				displayErrorMessage();
				System.exit(1);
			}
			else {
				int substractionResult = Integer.parseInt(args[1]);
				arr = takeInputs(noOfInputs).clone();
				displayArrayElements();
				findPairs(substractionResult);
				displayAllPairs();
			}
		}

}
