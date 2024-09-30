/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Họ tên sinh viên: Phạm Thành Đạt 
 */
public class FileHelper {
   
    public static ArrayList<String> readFileText(String fileName) {
        ArrayList<String> data = new ArrayList<>();        
        try {
            // Mở file để đọc
            FileReader fr = new FileReader(fileName);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                // Đọc từng dòng và thêm vào danh sách
                while ((line = br.readLine()) != null) {
                    data.add(line);
                }
                // Đóng BufferedReader
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.toString());
        }        
        return data;      
    }
   

    public static boolean writeFileText(String fileName, ArrayList<String> data) {
        try {
            // Ghi từng dòng vào file
            try ( // Mở file để ghi
                    FileWriter fw = new FileWriter(fileName)) {

                for (String item : data) {
                    fw.write(item + "\n");
                }
                // Đóng FileWriter
            }
            return true;
        } catch (IOException ex) {
            System.err.println("Error: " + ex.toString());
            return false;
        }            
    }    
}
