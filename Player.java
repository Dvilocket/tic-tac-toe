public class Player {
    int row;
    int column;
    String name;
    int turn;
    Player(){
        row = 0;
        column = 0;
        name = "";
        turn = -1;
    }
    //Methodz
    public void saveName(String nameUsuary){
        name = nameUsuary;
    }
}
