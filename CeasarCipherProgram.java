/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabAssignment3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class CeasarCipherProgram extends Application {
    static char currentLetter = 'h';
    static int currentIndex = -1;
    static int newIndex = -1;
    static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static String temp = "";
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Text text = new Text("How many places should your text be shifted?");
        ComboBox dropDown = new ComboBox();
        dropDown.getItems().addAll(
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26
        );
        dropDown.setValue(1);
        
        TextField input = new TextField();
        TextField output = new TextField();
        input.setPromptText("Your text here");
        input.setMinHeight(300);
        input.setMinWidth(500);
        output.setText("Your output will appear here");
        output.setEditable(false);
        output.setMinHeight(300);
        output.setMinWidth(500);
        
        Button runButton = new Button("Encipher!");
        runButton.setOnAction((e)->{
            output.setText(encrypt(input.getText(), Integer.parseInt(dropDown.getValue().toString())));
        });
        
        HBox topBox = new HBox();
        topBox.getChildren().addAll(text, dropDown);
        
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);
        pane.setTop(topBox);
        pane.setCenter(input);
        pane.setRight(output);
        pane.setBottom(runButton);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Ceaser Cipher");
    }
    
    public static void main(String[] args) {
        launch();
        
        
    }
    
    
    
    public static String encrypt(String message, int shift){
        String newMessage = "";
        Scanner scan = new Scanner(message);
        ArrayList words = new ArrayList(); 
        String currentWord = ""; char[] currentLetters;
        while (scan.hasNext()){
            words.add(scan.next());
        }
        for (int i = 0; i < words.size(); i++) {
            currentWord = words.get(i).toString();
            temp = "";
            for (int j = 0; j < currentWord.length(); j++) {
                currentLetter = currentWord.toCharArray()[j];
                currentIndex = Arrays.binarySearch(letters, currentLetter);
                if (currentIndex + shift < 0){
                    newIndex = (currentIndex + shift)%26 + 26;
                } else {
                    newIndex = (currentIndex + shift)%26;
                }
                if (isLetter(letters, currentLetter)){
                    currentLetter = letters[newIndex];
                }                
                temp += currentLetter;
            }
        newMessage += temp+" ";    
        }
        return newMessage;
        }
    
    public static boolean isLetter(char[] charArray, char character){
        boolean contains = false;
        for (char c : charArray) {
            
            if (c == character) {
            contains = true;
            break;
          
        }
        
        }
        return contains;
        }
}


    

