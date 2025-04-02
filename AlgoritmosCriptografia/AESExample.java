package AlgoritmosCriptografia;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) throws Exception {

        // Gera a chave secreta para AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Define o tamanho da chave como 128 bits
        // Pode ser 256 também, dependendo da necessidade. Quanto maior, mais complexo

        SecretKey secretKey = keyGenerator.generateKey(); // gera uma chave

        // Inicializando o cifrador para a encriptação
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedData = cipher.doFinal("Texto a ser criptografado".getBytes());

        // Exibe o texto em Base64, usado para codificar os dados criptografados em uma string legível
        System.out.println("Texto Criptografado: " + Base64.getEncoder().encodeToString(encryptedData));
    }
}
