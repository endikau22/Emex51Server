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
import javax.xml.bind.DatatypeConverter;

/**
 * Class that hashes the user password before storing it in the database.
 *
 * @author Markel Lopez de Uralde, Endika Ubierna, Xabier Carnero.
 */
public class Hashing {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(Hashing.class.getName());

    /**
     * Aplica SHA al texto pasado por parámetro
     *
     * @param texto
     * @return
     */
    public static String cifrarTexto(String contrasenia) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(contrasenia.getBytes());
            byte[] db = md.digest();
            hash = DatatypeConverter.printHexBinary(db).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            //LOGGER.severe("Error al cifrar SHA1 " + e.getMessage());
        }
        return hash;
    }

    // Convierte Array de Bytes en hexadecimal
    static String Hexadecimal(byte[] resumen) {
        String HEX = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1) {
                HEX += "0";
            }
            HEX += h;
        }
        return HEX.toUpperCase();
    }
}
