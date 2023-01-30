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
            // is.read(mensaje);

            int resultado;
            // is.read();
            int operador = is.read(mensaje);
            switch (operador) {
                InputStream is1 = newSocket.getInputStream();
                byte[] operando = new byte[10];
                is1.read(operando);
                case 1:
                    resultado = Integer.parseInt(new String(operando)) / 120;
                    System.out.println("El resultado es : " + resultado + "campos de fútbol");
                    os.write();
                case 2:
                    resultado = 420 - Integer.parseInt(new String(operando));
                    System.out.println("Te quedan " + resultado + "meses para llegar a la jubilación completa");
                    os.write();
                case 3:
                    resultado = Integer.parseInt(new String(operando)) / 34;
                    System.out.println("El resultado es : " + resultado + "libros de Pérez-Reverte");
                    os.write();
                case 4:
                    resultado = (int) (Integer.parseInt(new String(operando)) - 1.397);
                    System.out.println("La diferencia es de : " + Math.abs(resultado) + "€");
                    os.write();
                case 5:
                    System.out.println("Cerrando el nuevo socket");

                    newSocket.close();

                    System.out.println("Cerrando el socket servidor");

                    serverSocket.close();

                    System.out.println("Terminado");

            }

            System.out.println("Mensaje recibido: " + new String(mensaje));
            os.write();


        } catch (IOException e) {
        }
    }
}
