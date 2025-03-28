import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        // Criação de um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando que o usuário informe o texto a ser criptografado
        System.out.print("Digite o texto a ser criptografado: ");
        String texto = scanner.nextLine();

        // Gerando o par de chaves pública e privada RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Chave de 2048 bits (mais segura)
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Obtenção das chaves pública e privada
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Criptografando os dados com a chave pública
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal(texto.getBytes());

        // Exibindo o texto criptografado em base64
        System.out.println("Texto Criptografado: " + Base64.getEncoder().encodeToString(encryptedData));

        // Descriptografando os dados com a chave privada
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Exibindo o texto descriptografado
        System.out.println("Texto Descriptografado: " + new String(decryptedData));

        // Fechando o scanner
        scanner.close();
    }
}