package assigment4.pkg1;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Game implements Serializable {

    boolean turn;
    Boolean boatsSelected;
    boolean firstGame;
    int placedBoats;

    public Game(){

        turn = true;
        boatsSelected = false;
        firstGame = true;
        placedBoats = 0;

    } //end Game

    public String shoot(int i, int j, JButton[][] boardA1, JButton[][] boardB1, JButton[][] boardA2, JButton[][] boardB2){

        //decides the state of the shot and who made it

        String statusOfShot;
        Color lightBlue;
        Color stateOfCoordenate;

        statusOfShot = "";
        lightBlue = new Color(26,180,224,255);

        if(turn){

            stateOfCoordenate = boardB1[i][j].getBackground();

            if(stateOfCoordenate.equals(Color.black)){

                statusOfShot = "HitA";

            } //end if

            if(stateOfCoordenate.equals(lightBlue)){

                statusOfShot = "MissA";

            } //end if

            boardA2[i][j].setName("");

        } //end if

        if(!turn){

            stateOfCoordenate = boardA1[i][j].getBackground();

            if(stateOfCoordenate.equals(Color.black)){

                statusOfShot = "HitB";

            } //end if

            if(stateOfCoordenate.equals(lightBlue)){

                statusOfShot = "MissB";

            } //end if

            boardB2[i][j].setName("");

        } //end if

        return statusOfShot;

    } //end shoot

    public boolean checkWin (JButton[][] boardA1, JButton[][] boardB1) {

        //decides if someone has won

        boolean winner;
        winner = true;

        if (turn) {

            for (int i =0; i<15; i=i+1){

                for (int j = 0; j<15; j=j+1) {

                    if (boardB1[i][j].getBackground().equals(Color.black)) {
                        winner = false;
                    } //end if

                } //end for

            } //end for

        } //end if
        else {

            for (int i =0; i<15; i=i+1){

                for (int j = 0; j<15; j=j+1) {

                    if (boardA1[i][j].getBackground().equals(Color.black)) {
                        winner = false;
                    } //end if

                } //end for

            } //end for

        } //end else

        turn = !turn;

        return winner;

    } //end check win

    public void recountPlacedBoats () {

        //adds 1 to the number of boats placed

        placedBoats =  placedBoats + 1;

    } //end placeBoat

} //end class
