package mineText;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class MineText {
	public static Scanner sc = new Scanner(System.in);
	public static int score, record1, record2, record3, record4, record5;
	public static String nombre1, nombre2, nombre3, nombre4, nombre5;
	public static boolean correct;
	public static void main(String[] args){
		menu();
	}

	public static void newGame(){ //esta es la situación inicial de la cual se derivan las 5 historias
		int option = 0, continuar = 0;
		System.out.println("Despiertas por un golpeteo en la puerta y te levantas a checar qué es. Cuando abres la puerta ves que hay una criatura, \ncon apariencia humana pero sin vida, que está intentando morderte. Rápidamente cierras la puerta y:");
		System.out.println("1) Sales por la puerta trasera.");
		System.out.println("2) Agarras una pistola y sales por la puerta principal.");
		System.out.println("3) Te escondes en el sótano.");
		System.out.println("4) Te sales por la ventana de tu cuarto.");
		System.out.println("5) Abres la puerta y no haces nada");
		//while(option >= 0 && option <= 5){//Validacion
			try{
				option = sc.nextInt();
			}
			catch (Exception e){
				sc.nextLine();
				System.out.println("Por favor ingrese un número válido.");
				option = 0;
				option = sc.nextInt();
			}
		//}
			switch(option){ //este switch llama a los diferentes objetos dependiendo de la opción que se escogió al principio
			case 1:
				correct = true;
				while(correct){
				A roundsA = new A(score);//Actualiza las variables del objeto
				correct = roundsA.readWrite();//Corre el randomScenario y regresa el correct
				score = roundsA.getScore();//regresa el score
				continuar = roundsA.getContinuar();
				if(continuar == 2){
					break;
				}
				}
				System.out.println("\nBuen intento! Tus puntos acumulados son: "+score+"\n");
				records(score);
				score = 0;
				menu();//Te regresa al menu principal.
				break;
			case 2:
				correct = true;
				while(correct){
				B roundsB = new B(score);//Actualiza las variables del objeto
				correct = roundsB.readWrite();//Corre el randomScenario y regresa el correct
				score = roundsB.getScore();//regresa el score
				continuar = roundsB.getContinuar();
				if(continuar == 2){
					break;
				}
				}
				System.out.println("\nBuen intento! Tus puntos acumulados son: "+score+"\n");
				records(score);
				score = 0;
				menu();//Te regresa al menu principal.
				break;
			case 3:
				correct = true;
				while(correct){
				C roundsC = new C(score);//Actualiza las variables del objeto
				correct = roundsC.readWrite();//Corre el randomScenario y regresa el correct
				score = roundsC.getScore();//regresa el score
				continuar = roundsC.getContinuar();
				if(continuar == 2){
					break;
				}
				}
				System.out.println("\nBuen intento! Tus puntos acumulados son: "+score+"\n");
				records(score);
				score = 0;
				menu();//Te regresa al menu principal.
				break;
			case 4:
				correct = true;
				while(correct){
				D roundsD = new D(score);//Actualiza las variables del objeto
				correct = roundsD.readWrite();//Corre el randomScenario y regresa el correct
				score = roundsD.getScore();//regresa el score
				continuar = roundsD.getContinuar();
				if(continuar == 2){
					break;
				}
				}
				System.out.println("\nBuen intento! Tus puntos acumulados son: "+score+"\n");
				records(score);
				score = 0;
				menu();//Te regresa al menu principal.
				break;
			case 5:
				correct = true;
				while(correct){
				E roundsE = new E(score);//Actualiza las variables del objeto
				correct = roundsE.readWrite();//Corre el randomScenario y regresa el correct
				score = roundsE.getScore();//regresa el score
				continuar = roundsE.getContinuar();
				if(continuar == 2){
					break;
				}
				}
				System.out.println("\nBuen intento! Tus puntos acumulados son: "+score+"\n");
				records(score);
				score = 0;
				menu();//Te regresa al menu principal.
				break;
			default:
				System.out.println("Ingrese un número del 1 al 5");
				break;
			}
		}
	public static void menu() { //método que se llama para desplegar el menu
		boolean validation = true;
		int menu = 0;
		System.out.println("Menu");
		System.out.println("1. Jugar");
		System.out.println("2. Checar records");
		System.out.println("3. Salir");
		while(validation){//validación del menu
			try{
				menu = sc.nextInt();
			}
			catch (Exception e){
				menu = 0;
				sc.nextLine();
			}
			if(menu == 1 || menu == 2 || menu == 3){
				validation = false;
			}
			else{
				System.out.println("Ingrese un número del 1 al 3");
			}
		}
		switch(menu){
		case 1:
			newGame();//corre el metodo newgame
			break;
		case 2://Imprime el los records
			System.out.println("Top 5 records:\n#1 "+nombre1+" "+record1+"\n#2 "+nombre2+" "+record2+"\n#3 "+nombre3+" "+record3+"\n#4 "+nombre4+" "+record4+"\n#5 "+nombre5+" "+record5+"\n");
			menu();
			break;
		case 3://Se sale de el juego
			break;
		default:
			System.out.println("Ingrese un número del 1 al 3");
		}	
	}
	public static void records(int score) {
		if(score > record1){//Si es mas grande que el record actual
			record1 = score;//Se guarda la puntuación
			System.out.println("Ingresa tus iniciales: ");
			nombre1 = sc.next();//Se guardan las iniciales
		}
		else if(score > record2 && score < record1){//Lo mismo pero para el segundo lugar
			record2 = score;
			System.out.println("Ingresa tus iniciales: ");
			nombre2 = sc.next();
		}
		else if(score > record3 && score < record2){//Lo mismo pero para el tercer lugar
			record3 = score;
			System.out.println("Ingresa tus iniciales: ");
			nombre3 = sc.next();
		}
		else if(score > record4 && score < record3){//Lo mismo pero para el cuarto lugar
			record4 = score;
			System.out.println("Ingresa tus iniciales: ");
			nombre4 = sc.next();
		}
		else if(score > record5 && score < record4){//Lo mismo pero para el quinto lugar
			record5 = score;
			System.out.println("Ingresa tus iniciales: ");
			nombre5 = sc.next();
		}
		BufferedWriter writer = null;
		System.out.println(".");
        try {
            File logFile = new File("records.txt");

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("Top 5 records:\n#1 "+nombre1+" "+(Integer.toString(record1))+"\n#2 "+nombre2+" "+(Integer.toString(record2))+"\n#3 "+nombre3+" "+(Integer.toString(record3))+"\n#4 "+nombre4+" "+(Integer.toString(record4))+"\n#5 "+nombre5+" "+(Integer.toString(record5))+"\n");
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