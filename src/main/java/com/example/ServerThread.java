package com.example;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    Socket s;

    public ServerThread (Socket s){
        this.s=s;
    }


    public void run(){
        try {
            System.out.println("un client si è connesso");
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String risposta;
            String note ="";
            String nota="";
            int a=0;
            out.writeBytes("connnessione effetuata con successo"+ '\n');
            do {
                out.writeBytes("Digita AGGIUNGI per aggiungiere una nota, LISTA per la lista delle note,ESCI per uscire"+ '\n');
                risposta = in.readLine();
                if(risposta.equals("AGGIUNGI"))
                {
                    nota=in.readLine();
                    nota=nota+'\n';
                    note=note+nota;
                    out.writeBytes("nota aggiunta con successo"+ '\n');
                }
                else if(risposta.equals("LISTA"))
                {
                    out.writeBytes(note+ '\n');
                }
                else if(risposta.equals("ESCI"))
                {
                    a=1;
                    System.out.println("un client ha terminato la connesssione");
                }
                else{
                    out.writeBytes("scelta non valida"+ '\n');
                }

            } while (a == 0);
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server !");
            System.exit(1);
        }
    }
}

