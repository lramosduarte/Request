# Request

Maneira simples de fazer request no java.

Exemplo de uso:

    import request.Request;
    import java.io.IOException;

    public class Main {

        public static void main(String[] args) throws IOException {
            String response = new Request("http://104.196.145.212:4567/cidades/1").send();
        }
        
    }

