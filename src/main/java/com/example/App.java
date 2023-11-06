package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket server = new ServerSocket(6790);

        while(true){
            Socket s=server.accept();
            ServerThread thread=new ServerThread(s);
            thread.start();
        }
    }
}