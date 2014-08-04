/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ferris.sockettest.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael Remijan <mjremijan@yahoo.com> [@mjremijan]
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Socket s;
        System.out.println("Create new Socket");
        s = new Socket("REMIJAN-SERVER", 3700);
        
        PrintWriter pw = new PrintWriter(s.getOutputStream(), false);
         // native line endings are uncertain so add them manually
         pw.print("GET index.html HTTP/1.0\r\n");
         pw.print("Accept: text/plain, text/html, text/*\r\n");
         pw.print("\r\n");
         pw.flush();
         
        System.out.println("getInputStream()");
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        System.out.println("readLine()");
        String answer = input.readLine();
        
        System.out.println(answer);
        for (String str = input.readLine(); str != null; str = input.readLine()) {
            System.out.println(str);
        }
        
        System.out.println("showMessageDialog");
        JOptionPane.showMessageDialog(null, answer);
        
        System.out.println("exit");
        System.exit(0);

    }
}
