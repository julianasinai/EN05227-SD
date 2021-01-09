package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import compute.Compute;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Client {
  public static void main(String args[]) {
    String request;

    try {
        String name = "Compute";
        Registry registry = LocateRegistry.getRegistry(args[0]);
        Compute comp = (Compute) registry.lookup(name);

        System.out.println(comp.executeTask("info"));

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){

          request = scanner.nextLine();

          if(request.equals("exit")){
              break;
          }

          long startTime = System.nanoTime();
          String response = comp.executeTask(request);
          long endTime = System.nanoTime();
          long timeElapsed = endTime - startTime;

          System.out.println(response);

          System.out.println("<<Tempo de execução em ns: " + timeElapsed + ">>");
          if (args.length > 1) {
            FileWriter fileWriter = new FileWriter(args[1], true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(timeElapsed + "\n");
            printWriter.close();
          }
        }
    } catch (Exception e) {
      System.err.println("Client exception:");
      e.printStackTrace();
    }
  }
}