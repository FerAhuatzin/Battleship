package assigment4.pkg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class Interface implements MouseListener{

    JLabel startLabel;
    JLabel loadLabel;
    JLabel instructionsLabel;
    JLabel closeInstructionsLabel;
    JLabel playersLabel;
    JLabel saveGameLabel;
    JLabel cleanBoardLabel;
    JLabel changeBoardLabel;
    JLabel title;
    JLabel cover;
    JLabel instructions;
    JLabel indicateBoard1;
    JLabel indicateBoard2;
    JLabel confirmPlayerLabel;
    JLabel instructionsPlayer1;
    JLabel instructionsPlayer2;
    JLabel instructionsBothPlayers;
    JLabel boat1Label;
    JLabel boat2Label;
    JLabel boat3Label;
    JLabel boat4Label;
    JLabel boat5Label;
    JLabel confirmBoatSelectionLabel;
    JLabel horizontalLabel;
    JLabel verticalLabel;
    JLabel congratulationLabel;
    JLabel score;
    JLabel nextMatchLabel;
    JPanel jPanel1;
    JPanel jPanelA1;
    JPanel jPanelB1;
    JPanel jPanelA2;
    JPanel jPanelB2;
    JPanel jPanelForInstructions;
    JTextField player1Field;
    JTextField player2Field;
    Board board;
    Game game;
    Player player1;
    Player player2;
    Font baseFont;
    Font fontForLabels;
    Font fontForSmallText;
    Font fontForSmallInstructions;
    Font fontForMiniInstructions;
    Color darkBlue;
    Color lightBlue;
    boolean placingVertical;
    //
    public Interface(){

        placingVertical = true;

        try {
            baseFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Minecraft.ttf"));

            fontForLabels = baseFont.deriveFont(Font.PLAIN, 80);
            fontForSmallText = baseFont.deriveFont(Font.PLAIN, 40);
            fontForSmallInstructions = baseFont.deriveFont(Font.PLAIN, 35);
            fontForMiniInstructions = baseFont.deriveFont(Font.PLAIN, 20);

        } catch (FontFormatException e) {
            System.err.println("El archivo de fuente tiene un formato inválido: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de fuente: " + e.getMessage());
        }

        darkBlue = new Color(18,123,153,255);
        lightBlue = new Color(26,180,224,255);

        startLabel = new JLabel("");
        loadLabel = new JLabel("");
        instructionsLabel = new JLabel("");
        instructions = new JLabel("");
        closeInstructionsLabel = new JLabel("");
        playersLabel = new JLabel("", SwingConstants.CENTER);
        saveGameLabel = new JLabel();
        cleanBoardLabel = new JLabel();
        title = new JLabel();
        cover = new JLabel();
        indicateBoard1 = new JLabel("", SwingConstants.CENTER);
        indicateBoard2 = new JLabel("", SwingConstants.CENTER);
        changeBoardLabel = new JLabel();
        confirmPlayerLabel = new JLabel("");
        instructionsPlayer1 = new JLabel("", SwingConstants.CENTER);
        instructionsPlayer2 = new JLabel("", SwingConstants.CENTER);
        instructionsBothPlayers = new JLabel("", SwingConstants.CENTER);
        boat1Label = new JLabel("");
        boat2Label = new JLabel("");
        boat3Label = new JLabel("");
        boat4Label = new JLabel("");
        boat5Label = new JLabel("");
        confirmBoatSelectionLabel = new JLabel("");
        horizontalLabel = new JLabel("Horizontal");
        verticalLabel = new JLabel("Vertical");
        congratulationLabel = new JLabel("CONGRATULATIONS");
        score = new JLabel("", SwingConstants.CENTER);
        nextMatchLabel = new JLabel("");
        player1Field = new JTextField("");
        player2Field = new JTextField("");
        jPanel1 = new JPanel();
        jPanelA1 = new JPanel();
        jPanelB1 = new JPanel();
        jPanelA2 = new JPanel();
        jPanelB2 = new JPanel();
        jPanelForInstructions = new JPanel();

        jPanel1.setBounds(0,0,800,800);
        jPanel1.setBackground(new Color(255, 255, 255));

        jPanel1.add(startLabel);
        jPanel1.add(loadLabel);
        jPanel1.add(instructionsLabel);
        jPanel1.add(playersLabel);
        jPanel1.add(saveGameLabel);
        jPanel1.add(cleanBoardLabel);
        jPanel1.add(title);
        jPanel1.add(cover);
        jPanel1.add(indicateBoard1);
        jPanel1.add(indicateBoard2);
        jPanel1.add(changeBoardLabel);
        jPanel1.add(confirmPlayerLabel);
        jPanel1.add(instructionsPlayer1);
        jPanel1.add(instructionsPlayer2);
        jPanel1.add(instructionsBothPlayers);
        jPanel1.add(boat1Label);
        jPanel1.add(boat2Label);
        jPanel1.add(boat3Label);
        jPanel1.add(boat4Label);
        jPanel1.add(boat5Label);
        jPanel1.add(confirmBoatSelectionLabel);
        jPanel1.add(horizontalLabel);
        jPanel1.add(verticalLabel);
        jPanel1.add(congratulationLabel);
        jPanel1.add(score);
        jPanel1.add(nextMatchLabel);
        jPanel1.add(player1Field);
        jPanel1.add(player2Field);
        jPanel1.add(jPanelA1);
        jPanel1.add(jPanelB1);
        jPanel1.add(jPanelA2);
        jPanel1.add(jPanelB2);
        jPanel1.add(jPanelForInstructions);

        jPanelA1.setBounds(20,250,360,360);
        jPanelA1.setBackground(Color.white);
        jPanelA1.setLayout(new GridLayout(15, 15));
        jPanelA1.setVisible(false);

        jPanelB1.setBounds(20,250,360,360);
        jPanelB1.setBackground(Color.white);
        jPanelB1.setLayout(new GridLayout(15, 15));
        jPanelB1.setVisible(false);

        jPanelA2.setBounds(400,250,360,360);
        jPanelA2.setBackground(Color.white);
        jPanelA2.setLayout(new GridLayout(15, 15));
        jPanelA2.setVisible(false);

        jPanelB2.setBounds(400,250,360,360);
        jPanelB2.setBackground(Color.white);
        jPanelB2.setLayout(new GridLayout(15, 15));
        jPanelB2.setVisible(false);

        jPanelForInstructions.setBounds(100,50,600,700);
        jPanelForInstructions.setBackground(Color.white);
        jPanelForInstructions.setVisible(false);
        jPanelForInstructions.add(instructions);
        jPanelForInstructions.add(closeInstructionsLabel);

        startLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/StartIconOrange.png")));
        startLabel.setText("New Game");
        startLabel.addMouseListener(this);
        startLabel.setBounds(235,200,330,140);

        loadLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/LoadGameIconOrange.png")));
        loadLabel.setText("Load Game");
        loadLabel.addMouseListener(this);
        loadLabel.setBounds(235, 360, 330, 140);

        instructionsLabel.setBounds(235,520,330,140);
        instructionsLabel.setText("Instructions");
        instructionsLabel.addMouseListener(this);
        instructionsLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/InstructionIcon.png")));
        playersLabel.setBounds(0, 70, 800,140);
        playersLabel.setFont(fontForLabels);
        playersLabel.setVisible(false);

        saveGameLabel.setBounds(410, 10, 40, 40);
        saveGameLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/SaveIconOrange.png")));
        saveGameLabel.setText("Save");
        saveGameLabel.setVisible(false);
        saveGameLabel.addMouseListener(this);

        cleanBoardLabel.setBounds(460, 10, 41, 40);
        cleanBoardLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/CleanBoardIconOrange.png")));
        cleanBoardLabel.setText("Clean Board");
        cleanBoardLabel.setVisible(false);
        cleanBoardLabel.addMouseListener(this);

        changeBoardLabel.setBounds(235,360, 330, 130);
        changeBoardLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/ChangeIcon.png")));
        changeBoardLabel.setText("Change");
        changeBoardLabel.setVisible(false);
        changeBoardLabel.addMouseListener(this);

        title.setBounds(94, 20, 612,160);
        title.setIcon(new ImageIcon(getClass().getResource("/Icons/Title.png")));
        title.setVisible(true);

        cover.setBounds(0,480,800,320);
        cover.setIcon(new ImageIcon(getClass().getResource("/Icons/Cover.png")));
        cover.setVisible(true);

        indicateBoard1.setBounds(20,200,360,50);
        indicateBoard1.setFont(fontForSmallText);
        indicateBoard1.setText("Your Board :)");
        indicateBoard1.setVisible(false);

        indicateBoard2.setBounds(400,200,360,50);
        indicateBoard2.setText("Enemy's :/");
        indicateBoard2.setVisible(false);
        indicateBoard2.setFont(fontForSmallText);

        instructionsPlayer1.setBounds(50, 130, 700, 50);
        instructionsPlayer1.setVisible(false);
        instructionsPlayer1.setFont(fontForSmallText);

        instructionsPlayer2.setBounds(50, 330, 700, 50);
        instructionsPlayer2.setVisible(false);
        instructionsPlayer2.setFont(fontForSmallText);

        instructionsBothPlayers.setBounds(0,180,800,50);
        instructionsBothPlayers.setVisible(false);
        instructionsBothPlayers.setFont(fontForMiniInstructions);

        player1Field.setBounds(100, 200, 600, 60);
        player1Field.setVisible(false);
        player1Field.setFont(fontForSmallText);
        player1Field.setBackground(new Color(140, 214, 239, 255));
        player1Field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        player2Field.setBounds(100, 400, 600, 60);
        player2Field.setVisible(false);
        player2Field.setFont(fontForSmallText);
        player2Field.setBackground(new Color(140,214,239,255));
        player2Field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        boat1Label.setBounds(600,250, 100,50);
        boat1Label.setVisible(false);
        boat1Label.setIcon(new ImageIcon(getClass().getResource("/Icons/PTBoatIcon.png")));
        boat1Label.setText("2 boxes");

        boat2Label.setBounds(600,310, 100,50);
        boat2Label.setVisible(false);
        boat2Label.setIcon(new ImageIcon(getClass().getResource("/Icons/DestroyerIcon.png")));
        boat2Label.setText("2 boxes");

        boat3Label.setBounds(600,370, 100,50);
        boat3Label.setVisible(false);
        boat3Label.setIcon(new ImageIcon(getClass().getResource("/Icons/CruiserIcon.png")));
        boat3Label.setText("3 boxes");

        boat4Label.setBounds(600,430, 100,50);
        boat4Label.setVisible(false);
        boat4Label.setIcon(new ImageIcon(getClass().getResource("/Icons/BattleshipIcon.png")));
        boat4Label.setText("3 boxes");

        boat5Label.setBounds(600,490, 100,50);
        boat5Label.setVisible(false);
        boat5Label.setIcon(new ImageIcon(getClass().getResource("/Icons/PlaneCarrierIcon.png")));
        boat5Label.setText("4 boxes");

        confirmBoatSelectionLabel.setBounds(600,550, 127,50);
        confirmBoatSelectionLabel.setVisible(false);
        confirmBoatSelectionLabel.setText("Confirm Boat Selection");
        confirmBoatSelectionLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/SmallchangeIcon.png")));
        confirmBoatSelectionLabel.addMouseListener(this);

        confirmPlayerLabel.setBounds(235, 500, 330, 140);
        confirmPlayerLabel.setVisible(false);
        confirmPlayerLabel.setText("Confirm Names");
        confirmPlayerLabel.addMouseListener(this);
        confirmPlayerLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/ConfirmIcon.png")));

        horizontalLabel.setBounds(410,310,150,50);
        horizontalLabel.setVisible(false);
        horizontalLabel.addMouseListener(this);
        horizontalLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/HorizontalIconBW.png")));

        verticalLabel.setBounds(460,380,50,150);
        verticalLabel.setVisible(false);
        verticalLabel.addMouseListener(this);
        verticalLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/VerticalIcon.png")));

        congratulationLabel.setBounds(100,300,600,200);
        congratulationLabel.setVisible(false);
        congratulationLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/WinnerIcon.png")));

        score.setVisible(false);
        score.setBounds(300,650,200,50);
        score.setFont(fontForSmallText);

        nextMatchLabel.setVisible(false);
        nextMatchLabel.setText("Next match");
        nextMatchLabel.setBounds(300,580,200,50);
        nextMatchLabel.setFont(fontForSmallText);
        nextMatchLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/NextMatchIcon.png")));
        nextMatchLabel.addMouseListener(this);

        instructions.setVisible(true);
        instructions.setIcon(new ImageIcon(getClass().getResource("/Icons/Instructions.png")));
        instructions.setBounds(0,0,600,600);

        closeInstructionsLabel.setVisible(true);
        closeInstructionsLabel.setText("CloseInstructions");
        closeInstructionsLabel.setBounds(290,625,100,50);
        closeInstructionsLabel.addMouseListener(this);
        closeInstructionsLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/CloseIcon.png")));
        closeInstructionsLabel.setForeground(Color.white);

    } //end constructor

    public void startNewGame(){

        //creates the objects needed for the hole program, and also adds the board to the JPanels, so the player is able to see it

        board = new Board();
        game = new Game();
        player1 = new Player();
        player2 = new Player();

        for(int i = 0; i<15; i = i+1){

            for(int j = 0; j<15; j = j+1){

                jPanelA1.add(board.boardA1[i][j]);
                jPanelB1.add(board.boardB1[i][j]);
                jPanelA2.add(board.boardA2[i][j]);
                jPanelB2.add(board.boardB2[i][j]);

                board.boardA1[i][j].addMouseListener(this);
                board.boardB1[i][j].addMouseListener(this);
                board.boardA2[i][j].addMouseListener(this);
                board.boardB2[i][j].addMouseListener(this);

            } //end for

        } //end for

        game.firstGame = false;

        assignNames();

    } //end startGame

    public void assignNames (){

        //chance the initial interface for the players to introduce their names

        instructionsPlayer1.setText("Type here player 1 name :)");
        instructionsPlayer2.setText("Type here player 2 name :)");

        title.setVisible(false);
        startLabel.setVisible(false);
        loadLabel.setVisible(false);
        instructionsLabel.setVisible(false);

        player1Field.setVisible(true);
        player2Field.setVisible(true);
        confirmPlayerLabel.setVisible(true);
        instructionsPlayer1.setVisible(true);
        instructionsPlayer2.setVisible(true);

    } //end assignNames

    public void confirmNames(){

        //once that the player confirm the names it checks if they have typed a name and if so,
        // it starts preparing the interface to place the boats

        player1.name = player1Field.getText();
        player2.name = player2Field.getText();

        if((player1.name.equals("") || player2.name.equals(""))){

            instructionsPlayer2.setText("You haven't typed at least one name");
            instructionsPlayer1.setText("You haven't typed at least one name");

        } //end if
        else{

            player1Field.setVisible(false);
            player2Field.setVisible(false);
            confirmPlayerLabel.setVisible(false);
            instructionsPlayer1.setVisible(false);
            instructionsPlayer2.setVisible(false);

            changeInterfaceToSelectBoats();

        } //end else

    } //end confirmNames

    public void changeInterfaceToSelectBoats(){

        //sets the interface to place the boats, it works the first time the game is started, and it
        // returns to this method each time the player place a boat, so the next boat to place enlightens,
        // also it has a part if it is the second match

        if(game.placedBoats == 0|| game.placedBoats == 5){

            boat1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/PTBoatIcon.png")));
            boat2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DestroyerIconBW.png")));
            boat3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/CruiserIconBW.png")));
            boat4Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleshipIconBW.png")));
            boat5Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/PlaneCarrierIconBW.png")));

            if (game.placedBoats<5) {
                instructionsPlayer1.setText(player1.name + " place the boat with " + boat1Label.getText());
            } //end if
            else{
                instructionsPlayer2.setText(player2.name + " place the boat with " + boat1Label.getText());
            } //end if

        } //end if

        if(game.placedBoats == 1|| game.placedBoats == 6 ){

            boat1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/PTBoatIconBW.png")));
            boat2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DestroyerIcon.png")));

            if (game.placedBoats<5) {
                instructionsPlayer1.setText(player1.name + " place the boat with " + boat2Label.getText());
            } //end if
            else{
                instructionsPlayer2.setText(player2.name + " place the boat with " + boat2Label.getText());
            } //end if

        } //end if

        if(game.placedBoats == 2|| game.placedBoats == 7){

            boat2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DestroyerIconBW.png")));
            boat3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/CruiserIcon.png")));

            if (game.placedBoats<5) {
                instructionsPlayer1.setText(player1.name + " place the boat with " + boat3Label.getText());
            } //end if
            else{
                instructionsPlayer2.setText(player2.name + " place the boat with " + boat3Label.getText());
            } //end if

        } //end if

        if(game.placedBoats == 3|| game.placedBoats == 8){

            boat3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/CruiserIconBW.png")));
            boat4Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleshipIcon.png")));

            if (game.placedBoats<5) {
                instructionsPlayer1.setText(player1.name + " place the boat with " + boat4Label.getText());
            } //end if
            else{
                instructionsPlayer2.setText(player2.name + " place the boat with " + boat4Label.getText());
            } //end if

        } //end if

        if(game.placedBoats == 4|| game.placedBoats == 9){

            boat4Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleshipIconBW.png")));
            boat5Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/PlaneCarrierIcon.png")));

            if (game.placedBoats<5) {
                instructionsPlayer1.setText(player1.name + " place the boat with " + boat5Label.getText() );
            } //end if
            else{
                instructionsPlayer2.setText(player2.name + " place the boat with " + boat5Label.getText() );
            } //end if

        } //end if

        if(game.placedBoats==0){

            jPanelA1.setVisible(true);

            boat1Label.setVisible(true);
            boat2Label.setVisible(true);
            boat3Label.setVisible(true);
            boat4Label.setVisible(true);
            boat5Label.setVisible(true);
            horizontalLabel.setVisible(true);
            verticalLabel.setVisible(true);

            instructionsBothPlayers.setVisible(true);
            instructionsBothPlayers.setText("Click the arrows to change the orientation of the boat before placing it");

            instructionsPlayer1.setFont(fontForSmallInstructions);
            instructionsPlayer1.setText(player1.name + " place the boat with " + boat1Label.getText());
            instructionsPlayer1.setVisible(true);
            instructionsPlayer1.setBounds(0, 50,800,200);

                if (player1.score!=0||player2.score!=0) {

                    congratulationLabel.setVisible(false);
                    nextMatchLabel.setVisible(false);

                } //end if

        } //end


        if(game.placedBoats==5){

            instructionsPlayer2.setFont(fontForSmallInstructions);
            instructionsPlayer2.setBounds(0, 50,800,200);

            changeInterfaceToChangeBoard();

        } //end

    } //end changeInterfaceToSelectBoats

    public void selectBoat (String coordenate) {

        //once that the player selects the coordenates it calls the method inside boat to place it,
        // if it is correctly placed it decides when to show the change board label and also
        // when to deactivate the boards where the boats are shown

        int placedBoats;
        boolean orientation;
        boolean correctlyPlaced;

        placedBoats = game.placedBoats;
        orientation = placingVertical;
        correctlyPlaced = false;

        correctlyPlaced = board.selectBoat(coordenate, placedBoats, orientation);

        if (correctlyPlaced) {

            game.recountPlacedBoats();

        } //end if

        if (game.placedBoats<10){

            if (game.placedBoats!=5){

                changeInterfaceToSelectBoats();

            } //end if

            if (game.placedBoats==5) {

                confirmBoatSelectionLabel.setVisible(true);

                for(int o = 0; o<15; o = o+1){

                    for(int p = 0; p<15; p = p+1){

                        board.boardA1[o][p].setName("");

                    } //end for

                } //end for

            } //end if

        } //end if

        if (game.placedBoats>9){

            confirmBoatSelectionLabel.setVisible(true);

            for(int o = 0; o<15; o = o+1){

                for(int p = 0; p<15; p = p+1){

                    board.boardB1[o][p].setName("");

                } //end for

            } //end for

        } //end if

    } //end if

    public void confirmBoat(){

        //once that the confirmation label appears it decides if tha game can start or if it
        // keeps changing the interface to select the boats

        if (game.placedBoats==5){

            changeInterfaceToSelectBoats();

        } //end if

        if (game.placedBoats>9) {

            game.boatsSelected = true;

            playersLabel.setText(player1.name);

            boat1Label.setVisible(false);
            boat2Label.setVisible(false);
            boat3Label.setVisible(false);
            boat4Label.setVisible(false);
            boat5Label.setVisible(false);
            confirmBoatSelectionLabel.setVisible(false);
            horizontalLabel.setVisible(false);
            verticalLabel.setVisible(false);
            instructionsPlayer2.setVisible(false);
            instructionsBothPlayers.setVisible(false);

            jPanelB1.setVisible(false);
            jPanelB2.setVisible(false);

            changeInterfaceToChangeBoard();

            startLabel.setBounds(310,10, 40, 40);
            startLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/NewGameIconOrange.png")));
            startLabel.setText("New game inside game");
            startLabel.setVisible(true);
            loadLabel.setBounds(360, 10, 40, 40);
            loadLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/LoadIconOrange.png")));
            loadLabel.setText("Load inside game");
            loadLabel.setVisible(true);

            cleanBoardLabel.setVisible(true);
            saveGameLabel.setVisible(true);

            score.setText((player1.score) + "-" + (player2.score));
            score.setVisible(true);


        } //end if

    } // end confirmBoat

    public void openInstructions() {

        startLabel.setVisible(false);
        loadLabel.setVisible(false);
        instructionsLabel.setVisible(false);
        title.setVisible(false);
        cover.setVisible(false);

        jPanelForInstructions.setVisible(true);

    } //end openInstructions

    public void closeInstructions(){

        startLabel.setVisible(true);
        loadLabel.setVisible(true);
        instructionsLabel.setVisible(true);
        title.setVisible(true);
        cover.setVisible(true);

        jPanelForInstructions.setVisible(false);

    } //end closeInstructions

    public void loadGame(){

        //retrieves the last saved game, so it can be loaded in the program

        File file;
        FileInputStream inFileStream;
        ObjectInputStream inObjectStream;

        try {

            file = new File ("SavedGame/previousSavedGame.obj");
            inFileStream= new FileInputStream(file);
            inObjectStream = new ObjectInputStream(inFileStream);

            board = (Board) inObjectStream.readObject();
            game = (Game) inObjectStream.readObject();
            player1 = (Player) inObjectStream.readObject();
            player2 = (Player) inObjectStream.readObject();

            title.setVisible(false);
            instructionsLabel.setVisible(false);

            playersLabel.setVisible(true);
            saveGameLabel.setVisible(true);
            cleanBoardLabel.setVisible(true);
            loadLabel.setVisible(true);
            startLabel.setVisible(true);

            score.setText((player1.score) + "-" + (player2.score));
            score.setVisible(true);

            startLabel.setBounds(310,10, 40, 40);
            startLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/NewGameIconOrange.png")));
            startLabel.setText("New game inside game");

            loadLabel.setBounds(360, 10, 40, 40);
            loadLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/LoadIconOrange.png")));
            loadLabel.setText("Load inside game");

            for(int i = 0; i<15; i = i+1){

                for(int j = 0; j<15; j = j+1){

                    jPanelA1.add(board.boardA1[i][j]);
                    jPanelB1.add(board.boardB1[i][j]);
                    jPanelA2.add(board.boardA2[i][j]);
                    jPanelB2.add(board.boardB2[i][j]);

                    board.boardA2[i][j].addMouseListener(this);
                    board.boardB2[i][j].addMouseListener(this);

                } //end for

            } //end for

            System.out.println(game.turn);
            determineTurn();

        }//end try
        catch(Exception e){

            System.out.print("Something went wrong");
            e.printStackTrace();

        } //end catch

    } //end loadGame

    public void saveGame(){

        //the present game is saved within the program so when the next time you open the game you can follow playing the last game

        File file;
        FileOutputStream outFileStream;
        ObjectOutputStream outObjectStream;

        try{

            file = new File ("SavedGame/previousSavedGame.obj");
            outFileStream = new FileOutputStream(file);
            outObjectStream = new ObjectOutputStream(outFileStream);

            outObjectStream.writeObject(board);
            outObjectStream.writeObject(game);
            outObjectStream.writeObject(player1);
            outObjectStream.writeObject(player2);

            saveGameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/SaveCorrectlyIconOrange.png")));

        } //end try
        catch (Exception e){

            System.out.println("Something went wrong");
            e.printStackTrace();

        } //end catch

    } //end saveGame

    public void deletePreviousGame() {

        //it empties the interface and removes the present board from the panels

            for (int i=0;i<15;i++) {

                for (int j=0;j<15;j++){

                    jPanelA1.remove(board.boardA1[i][j]);
                    jPanelB1.remove(board.boardB1[i][j]);
                    jPanelA2.remove(board.boardA2[i][j]);
                    jPanelB2.remove(board.boardB2[i][j]);

                } //end for

            } //end for

            jPanelA1.setVisible(false);
            jPanelB2.setVisible(false);
            jPanelA2.setVisible(false);
            jPanelB1.setVisible(false);
            playersLabel.setVisible(false);
            indicateBoard1.setVisible(false);
            indicateBoard2.setVisible(false);
            changeBoardLabel.setVisible(false);
            score.setVisible(false);
            startLabel.setVisible(false);
            loadLabel.setVisible(false);
            cleanBoardLabel.setVisible(false);
            saveGameLabel.setVisible(false);

            instructionsPlayer1.setBounds(50, 130, 700, 50);
            instructionsPlayer2.setBounds(50, 330, 700, 50);

    } //end deletePreviousGame

    public void changeInterfaceToChangeBoard(){

        //deactivates the boards and shows the change board button if it is in the game, if it is still selecting boats it changes the interface

        if (game.boatsSelected) {

            if(!game.turn){
                jPanelA1.setVisible(false);
                jPanelA2.setVisible(false);
            } //end if
            else{
                jPanelB1.setVisible(false);
                jPanelB2.setVisible(false);
            } //end else

            playersLabel.setVisible(false);
            indicateBoard1.setVisible(false);
            indicateBoard2.setVisible(false);
            changeBoardLabel.setVisible(true);

            saveGameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/SaveIconOrange.png")));

        } //end if
        else{

            jPanelA1.setVisible(false);
            jPanelB1.setVisible(false);
            confirmBoatSelectionLabel.setVisible(false);
            boat1Label.setVisible(false);
            boat2Label.setVisible(false);
            boat3Label.setVisible(false);
            boat4Label.setVisible(false);
            boat5Label.setVisible(false);
            horizontalLabel.setVisible(false);
            verticalLabel.setVisible(false);
            instructionsPlayer1.setVisible(false);
            instructionsBothPlayers.setVisible(false);
            changeBoardLabel.setVisible(true);

        } //end else

    } //end changeBoard

    public void determineTurn(){

        //shows the board depending on the turn

        if (!game.boatsSelected){

            jPanelB1.setVisible(true);
            boat1Label.setVisible(true);
            boat2Label.setVisible(true);
            boat3Label.setVisible(true);
            boat4Label.setVisible(true);
            boat5Label.setVisible(true);
            horizontalLabel.setVisible(true);
            verticalLabel.setVisible(true);
            instructionsPlayer2.setVisible(true);
            instructionsBothPlayers.setVisible(true);
            changeBoardLabel.setVisible(false);

        } //end if
        else{

            changeBoardLabel.setVisible(false);
            playersLabel.setVisible(true);
            indicateBoard1.setVisible(true);
            indicateBoard2.setVisible(true);

            if(!game.turn){

                jPanelB1.setVisible(true);
                jPanelB2.setVisible(true);
                playersLabel.setText(player2.name);

            } //end if

            else{

                jPanelA1.setVisible(true);
                jPanelA2.setVisible(true);
                playersLabel.setText(player1.name);

            } //end else

        } //end else

    } //end determineTurn

    public void prepareInterfaceToCleanGame () {

        //deactivates some objects to prepare to select boats

        jPanelB2.setVisible(false);
        jPanelA2.setVisible(false);
        jPanelB1.setVisible(false);
        playersLabel.setVisible(false);
        indicateBoard1.setVisible(false);
        indicateBoard2.setVisible(false);
        changeBoardLabel.setVisible(false);
        saveGameLabel.setVisible(false);
        startLabel.setVisible(false);
        cleanBoardLabel.setVisible(false);
        loadLabel.setVisible(false);

        changeInterfaceToSelectBoats();

    } //end prepareInterfaceToCleanGame;

    public void shoot(String coordenate){

        //receive the coordenate and calls the method inside the object game to decide if the shot was good or bad

        String keyWordForShot;
        boolean winner;
        int i;
        int j;
        int k;
        int length;
        StringBuilder iString;
        StringBuilder jString;
        boolean comma;
        //
        winner = false;
        iString = new StringBuilder();
        jString = new StringBuilder();
        k = 0;
        length=coordenate.length();
        comma = false;

        if(!coordenate. equals("")){

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

            System.out.println("Selected coordenates: " + coordenate);
            System.out.println(game.turn);
            keyWordForShot = game.shoot(i, j, board.boardA1, board.boardB1, board.boardA2, board.boardB2); //receives the state of the shot

            if(keyWordForShot.equals("HitA")){
                board.boardA2[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Fire.png")));
                board.boardB1[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Fire.png")));
                board.boardB1[i][j].setBackground(lightBlue);
            } //end if
            if(keyWordForShot.equals("MissA")){
                board.boardA2[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Water.png")));
            } //end if
            if(keyWordForShot.equals("HitB")){
                board.boardB2[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Fire.png")));
                board.boardA1[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Fire.png")));
                board.boardA1[i][j].setBackground(lightBlue);
            } //end if
            if(keyWordForShot.equals("MissB")){
                board.boardB2[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Water.png")));
            } //end if

            winner = game.checkWin(board.boardA1, board.boardB1); //decides if someone has won
            System.out.println(game.turn);

            if (!winner) {

                changeInterfaceToChangeBoard();

            } //end if
            else { //increase the score if someone has won

                if (!game.turn) {
                    player1.score++;
                } //end if
                else {
                    player2.score++;
                } //end else

                jPanelA1.setVisible(false);
                jPanelB1.setVisible(false);
                jPanelA2.setVisible(false);
                jPanelB2.setVisible(false);
                indicateBoard1.setVisible(false);
                indicateBoard2.setVisible(false);
                congratulationLabel.setVisible(true);
                nextMatchLabel.setVisible(true);
                score.setText((player1.score) + "-" + (player2.score));

            } //end else


        } //end if

    } //end shoot

    public static void main(String[] args){

        JFrame frame;
        frame = new JFrame("Assignment 4");
        frame.setSize(800,800);
        frame.setContentPane(new Interface().jPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    } //end main

    public void mouseClicked(MouseEvent event){

    }
    public void mouseEntered(MouseEvent event){

    }
    public void mouseExited(MouseEvent event){

    }
    public void mousePressed(MouseEvent event){

    }
    public void mouseReleased(MouseEvent event){

        if(event.getSource() instanceof JButton clickedButton){

            if(game.boatsSelected){

                shoot(clickedButton.getName());

            } //end  if
            else{

                selectBoat(clickedButton.getName());

            } //end else

        } //End if

        if(event.getSource() instanceof JLabel clickedJLabel){

            if(clickedJLabel.getText().equals("New Game")){

                startNewGame();

            }//end if

            if (clickedJLabel.getText().equals("New game inside game")) {

                deletePreviousGame();
                startNewGame();

            } //end if

            if (clickedJLabel.getText().equals("Load inside game")) {

                deletePreviousGame();
                loadGame();

            } //end if

            if (clickedJLabel.getText().equals("Save")){

                saveGame();

            } //end if

            if (clickedJLabel.getText().equals("Load Game")){

                loadGame();

            } //end if

            if (clickedJLabel.getText().equals("Instructions")){

                openInstructions();

            } //emd if

            if (clickedJLabel.getText().equals("CloseInstructions")){

                closeInstructions();

            } //emd if

            if(clickedJLabel.getText().equals("Change")){

                determineTurn();

            } //end if

            if(clickedJLabel.getText().equals("Confirm Names")){

                confirmNames();

            } //end if

            if(clickedJLabel.getText().equals("Confirm Boat Selection")){

                confirmBoat();

            } //end if

            if(clickedJLabel.getText().equals("Vertical")){

                placingVertical = true;
                verticalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/VerticalIcon.png")));
                horizontalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/HorizontalIconBW.png")));

            } //end if

            if(clickedJLabel.getText().equals("Horizontal")){

                placingVertical = false;
                verticalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/VerticalIconBW.png")));
                horizontalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/HorizontalIcon.png")));

            } //end if

            if (clickedJLabel.getText().equals("Next match")) {

                board.whipeBoard();
                game.placedBoats = 0;
                game.boatsSelected = false;
                game.turn = true;
                prepareInterfaceToCleanGame();

            } //end if

            if ((clickedJLabel.getText().equals("Clean Board"))) {

                board.whipeBoard();
                game.placedBoats = 0;
                game.boatsSelected = false;
                game.turn = true;
                prepareInterfaceToCleanGame();

            } //end if

        } //end if

    } //end mouseReleased

} //end class


