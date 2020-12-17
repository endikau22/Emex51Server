
import javax.mail.Multipart;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


/**
 * Builds an Email Service capable of sending normal email to a given SMTP Host.
 * Currently <b>send()</b> can only works with text.
 */
public class ServicioMail {

     // Server mail user & pass account
    private String user = null;
    private String pass = null;

    // DNS Host + SMTP Port
    private String smtp_host = null;
    private int smtp_port = 0;

    @SuppressWarnings("unused")
    private ServicioMail() {
    }

    /**
     * Builds the EmailService. 
     * 
     * @param user User account login
     * @param pass User account password
     * @param host The Server DNS
     * @param port The Port
     */
    public ServicioMail(String user, String pass, String host, int port) {
            this.user = user;
            this.pass = pass;
            this.smtp_host = host;
            this.smtp_port = port;
    }

    /**
     * Sends the given <b>text</b> from the <b>sender</b> to the <b>receiver</b>. In
     * any case, both the <b>sender</b> and <b>receiver</b> must exist and be valid
     * mail addresses. The sender, mail's FROM part, is taken from this.user by 
     * default<br/>
     * <br/>
     * 
     * Note the <b>user</b> and <b>pass</b> for the authentication is provided in
     * the class constructor. Ideally, the <b>sender</b> and the <b>user</b>
     * coincide.
     * 
     * @param receiver The mail's TO part
     * @param subject  The mail's SUBJECT
     * @param text     The proper MESSAGE
     * @throws MessagingException Is something awry happens
     * 
     */
    public void sendMail(String receiver, String subject, String text) throws MessagingException {

            // Mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtp_host);
        properties.put("mail.smtp.port", smtp_port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", smtp_host);
        properties.put("mail.imap.partialfetch", false);
            
            // Authenticator knows how to obtain authentication for a network connection.
        Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pass);
        }
        });

            // MIME message to be sent
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(receiver));
            message.setRecipients(RecipientType.TO, InternetAddress.parse(receiver)); // Ej: receptor@gmail.com
            message.setSubject(subject); // Asunto del mensaje
            
                // A mail can have several parts
            Multipart multipart = new MimeMultipart();

            // A message part (the message, but can be also a File, etc...)
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(text, "text/html");
            multipart.addBodyPart(mimeBodyPart);
            
             // Adding up the parts to the MIME message
            message.setContent(multipart);
            
            // And here it goes...
            Transport.send(message);           
        } catch (AddressException ex) {
            Logger.getLogger(ServicioMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(ServicioMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ServicioMail emailService = new ServicioMail("nobody@gmail.com", 
                "somePassword", "smtp.gmail.com", 465);
        try {
            emailService.sendMail("receiver@gmail.com", "Mensaje de prueba", 
                    "Correo de vital importancia");
            System.out.println("Ok, mail sent!");
        } catch (MessagingException e) {
            System.out.println("Doh! " + e.getMessage());
        }
    }
    
}