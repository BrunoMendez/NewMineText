package mineText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class A {

	public BufferedReader br = null;
	public String line = "";
	public List<String[]> list = new ArrayList<String[]>();
	public Scanner sc = new Scanner(System.in); 
	public int score, continuar;
	public boolean correct = true;
	public A(int puntaje){ //object
		score = puntaje;
	}
	public boolean readWrite() {
		String[] array = null;
		try {
			br = new BufferedReader(new FileReader("a.txt"));

			while ((line = br.readLine()) != null) {
				array = line.split(" ");
				list.add(array);
			}
		}catch (FileNotFoundException e){ //Must be before IOException
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		String test = null;
		int scenario = (int)(5*Math.random());
		int counter = 1;
		int counter2 = 0, pass = 0, rand = 0, randnum = 0, i = -1, z = -1;
		for(int a = 0; a<list.size(); a++){
			for(int b = 0; b<list.get(a).length; b++){
				scenario = (int)(5*Math.random());
				try{
					test=list.get(a)[0];
				}catch(Exception e){
				}
				if(test.equals("["+(Integer.toString(counter))+"A]["+(Integer.toString(scenario))+"]")) {
					counter++;
					correct = choosingScenario(array, counter2, pass, rand, randnum, i, z, a, b);
					if(!correct || continuar == 2){
						break;
					}
				}
			}
			if(!correct || continuar == 2){
				break;
			}
		}
		return(correct);
	}
	public boolean choosingScenario(String[] array,int counter2, int pass, int rand, int randnum, int i, int z, int a, int b) {
		counter2++;
		boolean validation = false;
		for(z = a; z<list.size(); z++){
			if((list.get(z)[0]).equals("/")){
				for(int j = b+1; j<list.get(z).length; j++){
					if((list.get(z)[j]).equals("/")){
						validation = true;
						break;
					}
					System.out.print(list.get(z)[j]+" ");
				}
				if(validation){
					System.out.println("");
					break;
				}
			}
		}
		int counter = 1;
		pass = 0;
		rand = 0; 
		randnum = 0;
		validation = false;
		for(i = i+1; i<list.size(); i++){
			if(counter2 > 1){
				i = i+i;
			}
			for(int j = 0; j<list.get(i).length; j++){
				if((list.get(i)[j]).equals("*") || (list.get(i)[j]).equals("+") || (list.get(i)[j]).equals("=")){
					System.out.print(counter+". ");
					if ((list.get(i)[j]).equals("+")){
						pass=counter;
					}
					if ((list.get(i)[j]).equals("=")){
						rand = counter;
						randnum=(int)(2*Math.random());
					}
					counter = counter+1;
					for(int x = i; x<list.size(); x++){
						for(int y = 1; y<list.get(x).length; y++){
							if((list.get(x)[y]).equals("{")){
								validation = true;
								break;
							}
							System.out.print(list.get(x)[y]+" ");
						}
						if(validation){
							System.out.println("");
							break;
						}
					}
				}
				if(counter>4){
					break;
				}
			}
			if(counter>4){
				break;
			}
		}
		validation = true;
		int choices = 0;
		while(validation){ //loop de validación para el input del usuario
			try{
				choices = sc.nextInt(); //aquí se pide el input
			}
			catch(Exception e){ //si el input es algo que no reconoce el programa entra en acción este catch y se vuelve a preguntar
				choices = 0;
				sc.nextLine();
				System.out.println("Intenta de nuevo");
			}
			if(choices == 1 || choices == 2 || choices == 3 || choices == 4){ //esta parte del loop limita al usuario a ingresar un número del 1 al 4 (el número de opciones)
				validation = false;
			}
			else{
				System.out.println("Ingrese un número entre 1 y 4");
			}
		}
		if (choices == pass){
			score = score+5;
			System.out.println("Pasas a la siguiente ronda");
		}
		else if(rand == choices && randnum == 1){
			score = score+15;
			System.out.println("Pasas a la siguiente ronda");
		}
		else if((rand != choices && randnum != 1) || choices != pass){
			System.out.println("Has Muerto");
			correct = false;
			//preguntar si te quieres salir o no, y save game
		}
		validation = true;
		int save = 0;
		if(correct){
		continuar = continuar(correct);
		}
		if(continuar == 2){
			System.out.println("Deseas guardar tu juego? 1 = si, 2 = no");
			while(validation){//Validación
				try{
					save = sc.nextInt();
				}
				catch(Exception e){
					save = 0;
					sc.nextLine();
					System.out.println("Intenta de nuevo");
				}
				if(save == 1 || save == 2){//Si escoge 1 o 2 sale del loop
					validation = false;
				}
				else{//Sino sale eso
					System.out.println("Ingrese un número entre 1 y 2");
				}
			}
		}
		if(save == 1){
			saveGame(counter, pass, rand, randnum, i, z, a, b);
		}
		return correct;
	}
	public int getScore(){
		return score;
	}
	public int getContinuar(){
		return continuar;
	}
	public int continuar(boolean correct) {
		int continuar = 0;
		boolean validation = true;
		System.out.println("Quieres seguir jugando? 1 = Si, 2 = No");
		while(validation){//Validación
			try{
				continuar = sc.nextInt();
			}
			catch(Exception e){
				continuar = 0;
				sc.nextLine();
				System.out.println("Intenta de nuevo");
			}
			if(continuar == 1 || continuar == 2){//Si escoge 1 o 2 sale del loop
				validation = false;
			}
			else{//Sino sale eso
				System.out.println("Ingrese un número entre 1 y 2");
			}
		}//Si escoge no seguir imprime esto y te lleva al menu
		return continuar;
	}
	public void saveGame(int counter, int pass, int rand, int randnum, int i, int z, int a, int b){
		BufferedWriter writer = null;
		System.out.println(".");
        try {
            File logFile = new File("savedGame.txt");

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(Integer.toString(counter));
            writer.write(" ");
            writer.write(Integer.toString(pass));
            writer.write(" ");
            writer.write(Integer.toString(rand));
            writer.write(" ");
            writer.write(Integer.toString(randnum));
            writer.write(" ");
            writer.write(Integer.toString(i));
            writer.write(" ");
            writer.write(Integer.toString(z));
            writer.write(" ");
            writer.write(Integer.toString(a));
            writer.write(" ");
            writer.write(Integer.toString(b));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	writer.flush();
                writer.close();
            } catch (Exception e) {
            }
        }
	}
}