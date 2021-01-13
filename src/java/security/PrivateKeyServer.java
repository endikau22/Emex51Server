/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

/**
 *
 * @author xabig
 */
public class PrivateKeyServer {
    
        /**
     * Descifra un texto con RSA, modo ECB y padding PKCS1Padding (asim�trica) y lo
     * retorna
     * 
     * @param mensaje El mensaje a descifrar
     * @return El mensaje descifrado
     */
    public static byte[] descifrarTexto(String mensaje) {
        byte[] decodedMessage = hexToByte(mensaje);
        try {
            // Clave p�blica
            byte fileKey[] = fileReader("C:\\Users\\xabig\\OneDrive\\Documentos\\NetBeansProjects\\EMEX51Server\\Private.key");
            System.out.println("Tama�o -> " + fileKey.length + " bytes");

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(fileKey);
            PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            decodedMessage = cipher.doFinal(decodedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodedMessage;
    }

    /**
     * This method converts the hexadecimal string text received to byte array.
     *
     * @param hexText hexadecimal text to convert.
     * @return converted text in byte array.
     */
public static byte[] hexToByte(String s) {
    System.out.println("Codigo que llega: "+s);
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}
    
    /**
     * Retorna el contenido de un fichero
     * 
     * @param path Path del fichero
     * @return El texto del fichero
     */
    private static byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
