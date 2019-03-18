/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestoreluce1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lampadina {

    private boolean gestione;

    public Lampadina(boolean gestione) {
        this.gestione = gestione;
    }
    
    public Lampadina(){
        
    }

    public boolean isGestione() {
        return gestione;
    }

    public void setGestione(boolean gestione) {
        this.gestione = gestione;
    }

    public String getGestione(boolean ordine) {
        String line="";
        String ipAcceso="http://192.168.0.200/io.cgi?DOA1=0";  // TODO forse da modificare l'indirizzo IP 
        String ipSpento="http://192.168.0.200/io.cgi?DOI1=0";  // TODO forse da modificare l'indirizzo IP
        
        if (ordine == true) {

            try {
                URL url = new URL(ipAcceso);
                InputStream is = url.openStream();
                InputStreamReader ir = new InputStreamReader(is); 
                try {
                        BufferedReader r = new BufferedReader(ir);
                        line = r.readLine(); 
                        System.out.println(line);
                } finally {
                    is.close();
                }
            } catch (Exception ex) {
               //ex.printStackTrace();
               line="Errore "+ex.toString();
                return line;
            }
        } else {

            try {
                URL url = new URL(ipSpento);
                InputStream is = url.openStream();
                 InputStreamReader ir = new InputStreamReader(is); 

                try {
                   BufferedReader r = new BufferedReader(ir);
                         line = r.readLine(); 
                        System.out.println(line);
                } finally {
                    is.close();
                }

                
            } catch (Exception ex) {
               //ex.printStackTrace();
                line="Errore "+ex.toString();
                return line;
            }
        }
           
    return line;
    }
 
}
