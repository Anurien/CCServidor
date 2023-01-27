import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("10.0.9.14", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] mensaje = new byte[25];
            is.read(mensaje);

            /*InputStream entrada = nuevoSocket.getInputStream();
            OutputStream salida = nuevoSocket.getOutputStream();*/

            int resultado;
            int operador = 6;
            int[] operando = new int[10];
            switch (operador) {
                case 1:
                    resultado = operando[0] / 120;
                    System.out.println("El resultado es : " + resultado + "campos de fútbol");
                case 2:
                    resultado = 420 - operando[0];
                    System.out.println("Te quedan " + resultado + "meses para llegar a la jubilación completa");
                case 3:
                    resultado = operando[0] / 34;
                    System.out.println("El resultado es : " + resultado + "libros de Pérez-Reverte");
                case 4:
                    resultado = (int) (operando[0] - 1.397);
                    System.out.println("La diferencia es de : " + Math.abs(resultado) + "€");
                case 5:
                    newSocket.close();
                    serverSocket.close();

            }

            System.out.println("Mensaje recibido: " + new String(mensaje));

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
        }
    }
}
