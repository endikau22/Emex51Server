/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * This class contains the methods to decrypt passwords.
 * @author xabig
 */
public class PrivateKeyServer {
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PrivateKeyServer.class.getName());  
    /**
     * Descifra un texto con RSA, modo ECB y padding PKCS1Padding (asim�trica) y lo
     * retorna
     * 
     * @param mensaje El mensaje a descifrar
     * @return El mensaje descifrado
     */
    public static byte[] descifrarTexto(String mensaje) {
        LOGGER.info("Metodo descifrarTexto de la PrivateKeyServer.");
        byte[] decodedMessage = null;
        try {
            // Clave p�blica
            ResourceBundle fichero = ResourceBundle.getBundle("security.privateKeyFile");
            String rutaFichero = fichero.getString("filepath");
            byte fileKey[] = fileReader(rutaFichero);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(fileKey);
            PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            decodedMessage = cipher.doFinal(hexToByte(mensaje));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
             LOGGER.log(Level.SEVERE,"Catch al descifrar la password");
        } catch(IOException e){
            LOGGER.log(Level.SEVERE,"Catch al descifrar la password no encuentra el fichero");
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
    LOGGER.info("Metodo pasar la contraseña de hexadecimal a byte de la PrivateKeyServer.");
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
    private static byte[] fileReader(String path) throws IOException {
        ByteArrayOutputStream os = null;
        InputStream keyfis = PrivateKeyServer.class.getClassLoader()
                .getResourceAsStream(path);

        os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        // read bytes from the input stream and store them in buffer
        while ((len = keyfis.read(buffer)) != -1) {
            // write bytes from the buffer into output stream
            os.write(buffer, 0, len);
            keyfis.close();
        }
        return os.toByteArray();
    }
    
}
