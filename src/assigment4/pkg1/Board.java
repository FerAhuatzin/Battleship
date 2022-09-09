package assigment4.pkg1;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Board implements Serializable {

    //Creates the boards, with the 4 matrices of JButtons

    int n;
    int m;
    Color lightBlue;
    JButton[][] boardA1;
    JButton[][] boardA2;
    JButton[][] boardB1;
    JButton[][] boardB2;

    public Board(){

        n = 15;
        m = 15;

        lightBlue = new Color(26,180,224,255);
        boardA1 = new JButton[n][m];
        boardB1 = new JButton[n][m];
        boardA2 = new JButton[n][m];
        boardB2 = new JButton[n][m];

        for(int i = 0; i<n; i++){

            for(int j = 0; j<m; j++){

                //fills the matrices with the lightblue JButtons with size 12x12 and adds names with their coordenates to identify them

                boardA1[i][j] = new JButton();
                boardA2[i][j] = new JButton();
                boardB1[i][j] = new JButton();
                boardB2[i][j] = new JButton();

                boardA1[i][j].setBackground(lightBlue);
                boardA2[i][j].setBackground(lightBlue);
                boardB1[i][j].setBackground(lightBlue);
                boardB2[i][j].setBackground(lightBlue);

                boardA1[i][j].setSize(12,12);
                boardA2[i][j].setSize(12,12);
                boardB1[i][j].setSize(12,12);
                boardB2[i][j].setSize(12,12);

                boardA1[i][j].setName(""+i+","+j);
                boardA2[i][j].setName(""+i+","+j);
                boardB1[i][j].setName(""+i+","+j);
                boardB2[i][j].setName(""+i+","+j);

            } //end for

        } //end for

    } //end Board

    public boolean selectBoat(String coordenate, int placedBoats, boolean placingVertical){

        //with the received coordenates it is decided if there is a boat already placed there, and also it is decided to place
        // it horizontal or vertical, after that it places the boat with the number of boxes that it has.

        boolean correctlyPlaced;

        correctlyPlaced = false;

        if (!coordenate.equals("")){

            int i;
            int j;
            int boxes;
            int k;
            int length;
            StringBuilder iString;
            StringBuilder jString;
            boolean comma;
            //
            boxes = 0;
            iString = new StringBuilder();
            jString = new StringBuilder();
            k = 0;
            length=coordenate.length();
            comma = false;

            while(k<length){

                char compare;
                compare = coordenate.charAt(k);

                if(compare!=','){

                    if(!comma){

                        iString.append(coordenate.charAt(k));

                    } //end if

                    else{

                        jString.append(coordenate.charAt(k));

                    } //end else

                }//end if

                else{

                    comma = true;

                } //end else

                k=k+1;

            }//end while

            i = Integer.parseInt(iString.toString());
            j = Integer.parseInt(jString.toString());

            if(placedBoats == 0|| placedBoats == 5 || placedBoats == 1|| placedBoats == 6  ){
                boxes = 2;
            } //end if
            if(placedBoats == 2|| placedBoats == 7 || placedBoats == 3|| placedBoats == 8){
                boxes = 3;
            } //end if
            if(placedBoats == 4|| placedBoats == 9){
                boxes = 4;
            } //end if

            if(placingVertical && i<(16-boxes)){

                boolean noBoatPlaced;
                noBoatPlaced = true;

                for(int m = i; m<i+boxes; m++){

                    if (placedBoats<5) {

                        if (boardA1[m][j].getBackground().equals(Color.black)){

                            noBoatPlaced = false;

                        } //end if

                    } //end if
                    else{

                        if (boardB1[m][j].getBackground().equals(Color.black)){

                            noBoatPlaced = false;

                        } //end if

                    } //end if

                } //end for

                if (noBoatPlaced){

                    for(int m = i; m<i+boxes; m++){

                        if (placedBoats<5) {

                            boardA1[m][j].setBackground(Color.black);

                        } //end if
                        else{

                            boardB1[m][j].setBackground(Color.black);

                        } //end if

                    } //end for

                    correctlyPlaced = true;

                } //end if


            } //end if

            if(!placingVertical && j<(16-boxes)){

                boolean noBoatPlaced;
                noBoatPlaced = true;

                for(int n = j; n<j+boxes; n++){

                    if (placedBoats<5) {

                        if (boardA1[i][n].getBackground().equals(Color.black)){

                            noBoatPlaced = false;

                        } //end if

                    } //end if

                    else {

                        if (boardB1[i][n].getBackground().equals(Color.black)){

                            noBoatPlaced = false;

                        } //end if

                    } //end if


                } //end for

                if (noBoatPlaced) {

                    for(int n = j; n<j+boxes; n++){

                        if (placedBoats<5) {

                            boardA1[i][n].setBackground(Color.black);

                        } //end if
                        else{

                            boardB1[i][n].setBackground(Color.black);

                        } //end else


                    } //end for

                    correctlyPlaced = true;

                } //end if

            } //end if

        } //end if

        return correctlyPlaced;

    } //end selectBoats

    public void whipeBoard () {

        //restarts the board, giving it again its initial values, without creating another board

        for (int i = 0; i<15; i++) {

            for (int j = 0; j<15; j++) {

                boardA1[i][j].setBackground(lightBlue);
                boardA2[i][j].setBackground(lightBlue);
                boardB1[i][j].setBackground(lightBlue);
                boardB2[i][j].setBackground(lightBlue);

                boardA1[i][j].setName(""+i+","+j);
                boardA2[i][j].setName(""+i+","+j);
                boardB1[i][j].setName(""+i+","+j);
                boardB2[i][j].setName(""+i+","+j);

                boardA1[i][j].setIcon(null);
                boardA2[i][j].setIcon(null);
                boardB1[i][j].setIcon(null);
                boardB2[i][j].setIcon(null);

            } //end for

        } //end for

    } //end if

} //end class

