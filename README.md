# Request

Maneira simples de fazer request no java.

Exemplo de uso:

    import request.Request;
    import java.io.IOException;

    public class Main {

        public static void main(String[] args) throws IOException {
            String response = new Request("http://www.google.com.br").send();
        }
        
    }

