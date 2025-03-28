import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AESExample2 {
    public static void main(String[] args) throws Exception {
        // Criação de um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando que o usuário informe o texto a ser criptografado
        System.out.print("Digite o texto a ser criptografado: ");
        String texto = scanner.nextLine();

        // Gerando a chave secreta para AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Define o tamanho da chave (128 bits)
        SecretKey secretKey = keyGenerator.generateKey();

        // Inicializando o Cipher para o modo de encriptação
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Criptografando os dados
        byte[] encryptedData = cipher.doFinal(texto.getBytes());

        // Exibindo o texto criptografado em base64
        System.out.println("Texto Criptografado: " + Base64.getEncoder().encodeToString(encryptedData));

        // Fechando o scanner
        scanner.close();
    }
}