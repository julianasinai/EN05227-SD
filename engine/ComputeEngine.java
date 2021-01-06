package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import engine.Profile;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.lang.*;
import java.io.*;

public class ComputeEngine implements Compute {

    public HashMap<String,Profile> map = null;

    public ComputeEngine() {
        super();
    }

    public String executeTask(String request) {
        String response = "";

        long startTime = System.nanoTime();

        // De-serialization
        try {
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return "Reading database error";
        } catch(ClassNotFoundException cnf) {
    	    return "Class not found";
    	}

        try {
            String[] input = request.split(" ", 2);
            //input[0] = número da operação
            //input[1] = informação adicional
            if (input[0].equals("info")){
                return "Operações: \n" +
                       "1 - listar nomes dos perfis por curso; \n" +
                       "2 - listar as habilidades dos perfis por cidade; \n" +
                       "3 - adicionar experiência em um perfil; \n" +
                       "4 - listar experiência filtrando por email; \n" +
                       "5 - listar todos os perfis; \n" +
                       "6 - listar informações filtrando por email.\n";
            }

            switch(Integer.parseInt(input[0])) {
                case 1:
                    response = namesByCourse(input[1]);
                    break;
                case 2:
                    response = habilitiesByCity(input[1]);
                    break;
                case 3:
                    response = addExperience(input[1]);
                    break;
                case 4:
                    response = getExperience(input[1]);
                    break;
                case 5:
                    response = getAllProfiles();
                    break;
                case 6:
                    response = getProfile(input[1]);
                    break;
                default:
                    response = "Operação Inválida";
            }
        } catch(NumberFormatException nfe) {
            return "Operação Inválida: " + nfe.getMessage();
        }

        // Serialization
        try {
            FileOutputStream fos =
            new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return "Saving database error";
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println(timeElapsed);

        return response;
    }

    public String namesByCourse(String course) {
        // String names = "Graduados em " + course + ":\n";
        String names = "";

        for (Profile p : map.values()) {
            if (p.getFormacao().equals(course)) {
                names += p.getNomeCompleto() + "\n";
            } else {
                names = "Curso não encontrado";
            }
        }
        return names;
    }

    public String habilitiesByCity(String city) {
        String habilities = "";

        for (Profile p : map.values()) {
            if (p.getResidencia().equals(city)) {
                habilities += p.getNomeCompleto() + ": " + p.getHabilidades() + "\n";
            } else {
                habilities = "Cidade não encontrada";
            }
        }

        return habilities;
    }

    public String addExperience(String data) {
        String response;

        String[] token = data.split(" ", 2);
        //token[0] = email
        //token[1] = experiencia
        if (map.containsKey(token[0])) {
            Profile p = map.get(token[0]);
            p.addExperiencia(token[1]);
            response = "Experiência adicionada";
        }
        else {
            response = "Perfil não encontrado";
        }

        return response;
    }

    public String getExperience(String email) {
        String experience;

        if (map.containsKey(email)) {
            Profile p = map.get(email);
            experience = p.getExperiencia();
        }
        else {
            experience = "Perfil não encontrado";
        }

        return experience;
    }

    public String getAllProfiles() {
        String response = "";

        for (Profile p : map.values()) {
            response += p.toString();
        }

        return response;
    }

    public String getProfile(String email) {
        String response;

        if (map.containsKey(email)) {
            Profile p = map.get(email);
            response = p.toString();
        }
        else {
            response = "Perfil não encontrado";
        }

        return response;
    }

    public static void main(String[] args) {
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
