
public class Map {
    //Atributes
     Cells mapCell[][] = new Cells[3][3];
     boolean isGameOver;


    //Methods
      Map(){
          generateMap();
          isGameOver = false;

      }
    public void generateMap() {
        mapCell[0][0] = new Cells();
        mapCell[0][1] = new Cells();
        mapCell[0][2] = new Cells();
        mapCell[1][0] = new Cells();
        mapCell[0][2] = new Cells();
        mapCell[1][1] = new Cells();
        mapCell[1][2] = new Cells();
        mapCell[2][0] = new Cells();
        mapCell[2][1] = new Cells();
        mapCell[2][2] = new Cells();
    }
    public void drawMap(){
        int counter = 0;
        System.out.println("\t\t   TIC TAC TOC");
        System.out.print("----0-----------1-----------2----" + "\n");
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                System.out.print("|\t"+mapCell[row][column].id + "\t|\t");
            }
            System.out.print("\n");
            System.out.print( counter + "--------------------------------" +  "\n");
            counter += 1;
        }
    }
    public boolean accesMove(int number1, int number2){
          if(number1 >= 0 && number1 <= 3 && number2 >= 0 && number2 <= 3){
              return (true);
          }else{
            return false;
          }
    }

    public boolean accesCell(int number1, int number2){
          if(mapCell[number1][number2].id == 'X' || mapCell[number1][number2].id == 'O'){
              return (false);
          }else{
              return (true);
          }
    }
    public void changeCell(int number1, int number2, char caracter){
          mapCell[number1][number2].id = caracter;
    }

    public boolean isFull(){
        int counterCells = 0;
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(mapCell[row][column].id == 'X' || mapCell[row][column].id == 'O'){
                    counterCells += 1;
                }
            }
        }
        if(counterCells == 9){
            return (true);
        }else{
            return (false);
        }
    }
    public boolean isTricky(){
          int counterCella, counterCellb, counterCellc, counterCelld, counterCelle,counterCellf, counterCellg, counterCellh;
          int counterCella1, counterCellb1, counterCellc1, counterCelld1, counterCelle1,counterCellf1, counterCellg1, counterCellh1;

          counterCella = 0; //1
          counterCella1 = 0; //1A
          counterCellb = 0; //2
          counterCellb1 = 0; //1B
          counterCellc = 0; //3
          counterCellc1 = 0; //3C
          counterCelld = 0; //4
          counterCelld1 = 0; //4D
          counterCelle = 0; //5
          counterCelle1 = 0; //5E
          counterCellf = 0; //6
          counterCellf1 = 0; //6F
          counterCellg = 0; //7
          counterCellg1 = 0; //7G
          counterCellh = 0; //8
          counterCellh1 = 0; //8H
            //Aumnta Columna
           //Parte 0 a 2
          for(int counter = 0; counter < 3; counter++){
              if(mapCell[0][counter].id == 'X'){
                  counterCella++;

              }
          }
          for(int counter = 0; counter < 3; counter++){
              if(mapCell[0][counter].id == 'O'){
                  counterCella1++;
              }
          }
          //Parte 1 a 2
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[1][counter].id == 'X'){
                counterCellb++;
            }
        }
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[1][counter].id == 'O'){
                counterCellb1++;
            }
        }
        //Parte de 2 a 2
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[2][counter].id == 'X'){
                counterCellc++;
            }
        }
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[2][counter].id == 'O'){
                counterCellc1++;
            }
        }
         //Aumenta Fila
         //Parte 0 a 2
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][0].id == 'X'){
                counterCelld++;
            }
        }
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][0].id == 'O'){
                counterCelld1++;
            }
        }
        //Parte 1 a 2
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][1].id == 'X'){
                counterCelle++;
            }
        }
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][1].id == 'O'){
                counterCelle1++;
            }
        }
        //Parte de 2 a 2
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][2].id == 'X'){
                counterCellf++;
            }
        }
        for(int counter = 0; counter < 3; counter++){
            if(mapCell[counter][2].id == 'O'){
                counterCellf1++;
            }
        }
        if(mapCell[0][0].id == 'X'){
            counterCellg++;
            if(mapCell[1][1].id == 'X'){
                counterCellg++;
                if(mapCell[2][2].id == 'X'){
                    counterCellg++;
                }
            }

        }
        if(mapCell[0][0].id == 'O'){
            counterCellg1++;
            if(mapCell[1][1].id == 'O'){
                counterCellg1++;
                if(mapCell[2][2].id == 'O'){
                    counterCellg1++;
                }
            }

        }
        if(mapCell[0][2].id == 'X'){
            counterCellh++;
            if(mapCell[1][1].id == 'X'){
                counterCellh++;
                if(mapCell[2][0].id == 'X'){
                    counterCellh++;
                }
            }

        }
        if(mapCell[0][2].id == 'O'){
            counterCellh1++;
            if(mapCell[1][1].id == 'O'){
                counterCellh1++;
                if(mapCell[2][0].id == 'O'){
                    counterCellh1++;
                }
            }

        }
        //System.out.println(counterCella);
        //Sigue la parte diagonales del tricky
         if(counterCella == 3 || counterCella1 == 3 || counterCellb == 3 || counterCellb1 == 3 || counterCellc == 3 || counterCellc1 == 3 || counterCelld == 3 || counterCelld1 == 3 || counterCelle == 3 || counterCelle1 == 3 || counterCellf == 3 || counterCellf1 == 3 || counterCellg == 3 || counterCellg1 == 3 || counterCellh == 3 || counterCellh1 == 3){

             return true;
         }else{
             return  false;
         }

    }
}