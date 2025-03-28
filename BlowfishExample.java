import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class BlowfishExample {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite o texto a ser criptografado: ");
        String textoOriginal = scanner.nextLine();

        // Gerar chave Blowfish (128 bits)
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128); // Definindo tamanho da chave, podendo ir até 448 bits
        SecretKey secretKey = keyGenerator.generateKey();

        // Criptografar
        String textoCriptografado = criptografar(textoOriginal, secretKey);
        System.out.println("Texto Criptografado: " + textoCriptografado);

        // Descriptografar
        String textoDescriptografado = descriptografar(textoCriptografado, secretKey);
        System.out.println("Texto Descriptografado: " + textoDescriptografado);

        scanner.close();
    }

    public static String criptografar(String texto, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    public static String descriptografar(String textoCriptografado, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
        return new String(textoDescriptografado);
    }
}