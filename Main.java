import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Me permite ingresar datos por teclado
        Player player1 = new Player(); //Creacion de un jugador
        Player player2 = new Player(); //Creacion del segundo jugador
        Map gameMap = new Map(); //Generamos el mapa
        String namePlayer1 , namePlayer2;

        //Nombres de jugadores
        System.out.print("Ingrese El Nombre Del Jugador(1):");
        namePlayer1 = scanner.next();
        System.out.print("Ingrese El Nombre Del Jugador(2):");
        namePlayer2 = scanner.next();
        //Se cargan a los objetos
        player1.saveName(namePlayer1);
        player2.saveName(namePlayer2);
        player1.turn = 1; // 1 significa que es su turno
        player2.turn = 0; // cero significa que no es su turno

        gameMap.drawMap();
        System.out.println("Jugador (1): " + player1.name); //Player1 es X
        System.out.println("Jugador (2): " + player2.name); //Player2 es O

          while(gameMap.isGameOver == false){

              if(player1.turn == 1){
                  System.out.println();
                  System.out.println("Turno Del Jugador: " + player1.name );
                  System.out.print("Ingrese Fila: ");
                  player1.row = scanner.nextInt();
                  System.out.print("Ingrese Columna: ");
                  player1.column = scanner.nextInt();
                  //Debemos Comprobar si las cordenadas se pueden
                  while(player1.turn == 1){
                      if(gameMap.accesMove(player1.row,player1.column) == true){
                          //Ahora debemos mirar si donde lo vamos a poner ya esta ocupado por algo
                          if(gameMap.accesCell(player1.row,player1.column) == true){
                              //Se Cambia la posicion
                              gameMap.changeCell(player1.row,player1.column,'X');
                              //Se cambian los turnos
                              player1.turn = 0;
                              player2.turn = 1;
                          }else{
                              //Debe escoger otra vez las cordenadas
                              System.out.println("!Error!....La celda (" + player1.row + "," + player1.column + ") ya esta ocupada, seleccione otra");
                              System.out.print("Ingrese Fila: ");
                              player1.row = scanner.nextInt();
                              System.out.print("Ingrese Columna: ");
                              player1.column = scanner.nextInt();
                          }
                      }else{
                          System.out.println("!Error!.... La cordenada (" + player1.row + "," + player1.column + ") no es posible, seleccione otra");
                          System.out.print("Ingrese Fila: ");
                          player1.row = scanner.nextInt();
                          System.out.print("Ingrese Columna: ");
                          player1.column = scanner.nextInt();
                      }

                  }
              } //Fin del player 1
               else if(player2.turn == 1){
                  System.out.println();
                  System.out.println("Turno Del Jugador: " + player2.name );
                  System.out.print("Ingrese Fila: ");
                  player2.row = scanner.nextInt();
                  System.out.print("Ingrese Columna: ");
                  player2.column = scanner.nextInt();
                  //Debemos comporbar si las cordenadas se pueden
                  while (player2.turn == 1){
                      if(gameMap.accesMove(player2.row,player2.column) == true){
                          //Ahora debemos mirar si donde la vamos a poner esta ocupado
                          if(gameMap.accesCell(player2.row,player2.column) == true){
                              //Se cambia la posicion
                              gameMap.changeCell(player2.row,player2.column,'O');
                              //Se cambia los turnos
                              player2.turn = 0;
                              player1.turn = 1;
                          }else{
                              //Debe escoger otra vez las cordenadas
                              System.out.println("!Error!....La celda (" + player2.row + "," + player2.column + ") ya esta ocupada, seleccione otra");
                              System.out.print("Ingrese Fila: ");
                              player2.row = scanner.nextInt();
                              System.out.print("Ingrese Columna: ");
                              player2.column = scanner.nextInt();
                          }
                      }else{
                          System.out.println("!Error!.... La cordenada (" + player2.row + "," + player2.column + ") no es posible, seleccione otra");
                          System.out.print("Ingrese Fila: ");
                          player2.row = scanner.nextInt();
                          System.out.print("Ingrese Columna: ");
                          player2.column = scanner.nextInt();
                      }

                  }
              }
              //Debemos comprobar cuando este llena la tabla
               gameMap.drawMap();

              if(gameMap.isFull() == true){
                  //Es por que esta lleno
                  System.out.println("Las Celdas Del Juego Estan Llenas.");
                  gameMap.isGameOver = true;
              }else if(gameMap.isTricky() == true){
                  //llega hasta aqui-debemos hacer si se hizo tricky
                  //Obtener nombre jugador
                  if(player1.turn == 0){
                      System.out.println("El jugador: " + player1.name + " Es El Ganador....");
                  }else if(player2.turn == 0){
                      System.out.println("El Jugador: " + player2.name + " Es El Ganador....");
                  }
                  gameMap.isGameOver = true;
              }
          }
        System.out.println("Gracias Por Jugar....");
        

    }
}
