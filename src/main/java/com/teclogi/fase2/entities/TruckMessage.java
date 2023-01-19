package com.teclogi.fase2.entities;

import java.util.LinkedList;

public class TruckMessage {
    private LinkedList<String> message;
    private Boolean exitsColumn = false;
    private Boolean exitsRow = false;
    private Boolean exitsDiagonal = false;


    public TruckMessage() {
    }

    public TruckMessage(LinkedList<String> message) {
        this.message = message;
    }

    public LinkedList<String> getMessage() {
        return message;
    }

    public void setMessage(LinkedList<String> message) {
        this.message = message;
    }

    public char[][] parseToChar(LinkedList<String> message) {
        char[][] messageArray = new char[message.size()][];

        for(int i = 0; i < message.size(); i++) {
            messageArray[i] = message.get(i).toCharArray();
        }

        return messageArray;
    }

    public Boolean searchColumn(char[][] messageArray) {
        for(int j = 0; j < messageArray.length; j++) {
            int count = 0;
            char current = messageArray[0][j];

            for(int i = 0; i < messageArray.length; i++) {
                if(messageArray[i][j] == current) {
                    count++;
                    if(count == 4) {
                        exitsColumn = true;
                        break;
                    }
                } else {
                    count = 1;
                    current = messageArray[i][j];
                }
            }
        }
        return exitsColumn;
    }

    public Boolean searchRow(char[][] messageArray) {
        for(int i = 0; i < messageArray.length; i++) {
            int count = 0;
            char current = messageArray[i][0];

            for(int j = 0; j < messageArray.length; j++) {
                if(messageArray[i][j] == current) {
                    count++;
                    if(count == 4){
                        exitsRow = true;
                        break;
                    }
                } else {
                    count = 1;
                    current = messageArray[i][j];
                }
            }
        }
        return exitsRow;
    }

    public Boolean searchDiagonal(char[][] messageArray) {
        int rows = messageArray.length;
        int cols = messageArray[0].length;
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (messageArray[i][j] == messageArray[i + 1][j + 1] && messageArray[i][j] == messageArray[i + 2][j + 2] && messageArray[i][j] == messageArray[i + 3][j + 3]) {
                    exitsDiagonal = true;
                }
            }
        }
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 3; j < cols; j++) {
                if (messageArray[i][j] == messageArray[i + 1][j - 1] && messageArray[i][j] == messageArray[i + 2][j - 2] && messageArray[i][j] == messageArray[i + 3][j - 3]) {
                    exitsDiagonal = true;
                }
            }
        }
        return exitsDiagonal;
    }

    public Boolean validateMessage() {
        Boolean truckDanger = false;
        char[][] messageArray = this.parseToChar(message);
        Boolean column = this.searchColumn(messageArray);
        Boolean row = this.searchRow(messageArray);
        Boolean diagonal = this.searchDiagonal(messageArray);

        if(column || row || diagonal) {
            truckDanger = true;
        }

        return truckDanger;
    }
}
