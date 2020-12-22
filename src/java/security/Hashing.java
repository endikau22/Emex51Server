/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that hashes the user password before storing it in the database.
 * @author Markel Lopez de Uralde, Endika Ubierna, Xabier Carnero.
 */
public class Hashing {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(Hashing.class.getName());
    /**
     * Aplica SHA al texto pasado por parámetro
     * @param texto
     * @return 
     */
    public static String cifrarTexto(String texto) {
        LOGGER.log(Level.INFO, "Metodo cifrarTexto de la clase PasswordHash");
        MessageDigest messageDigest;
        try {
                // Obtén una instancia de MessageDigest que usa SHA
            messageDigest = MessageDigest.getInstance("SHA1");
                // Convierte el texto en un array de bytes
            messageDigest.update(texto.getBytes());
            byte[] resumen = messageDigest.digest();
                // Actualiza el MessageDigest con el array de bytes
            messageDigest.update(resumen);
                // Calcula el resumen (función digest)
            messageDigest.digest(resumen);

            return resumen.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
        }

    // Convierte Array de Bytes en hexadecimal
    static String Hexadecimal(byte[] resumen) {
        String HEX = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1)
                    HEX += "0";
            HEX += h;
        }
        return HEX.toUpperCase();
    }    
}