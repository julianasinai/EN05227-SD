package engine;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.io.*;
import engine.Profile;

public class Seed {

    public static void main(String[] args) {

        HashMap<String,Profile> map = new HashMap<String,Profile>();

        List<String> profile_exp = new LinkedList<String>();
        profile_exp.add("Estágio de 1 ano na Empresa X, onde trabalhei como analista de dados");
        profile_exp.add("Trabalhei com IoT e Computação em Nuvem por 5 anos na Empresa Y");
        Profile profile = new Profile("maria_silva@gmail.com", "Maria", "Silva", "https://images.unsplash.com/photo-1605993439219-9d09d2020fa5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80", "Belém", "Ciência da Computação", "Análise de Dados, Internet das Coisas, Computação em Nuvem", profile_exp);
        map.put("maria_silva@gmail.com", profile);

        profile_exp = new LinkedList<String>();
        profile_exp.add("Estágio de 2 ano no laboratório Lasse");
        profile = new Profile("damasceno@ufpa.itec.br", "Lucas", "Damasceno", "https://www.lasse.ufpa.br/wp-content/uploads/2019/08/site-lucas-damasceno-rename-1000-IMG_7161-63-370x370.jpg", "Belém", "Engenharia da Computação", "Lasse boy", profile_exp);
        map.put("damasceno@ufpa.itec.br", profile);

        profile_exp = new LinkedList<String>();
        profile_exp.add("Estágio de 1 ano na Fábrica de Software");
        profile_exp.add("Engenheiro de Softwate na empresa AUA");
        profile = new Profile("matheus@ufpa.itec.br", "Matheus", "Araújo", "https://auaconecta.com.br/wp-content/uploads/2020/06/IMG_20200606_164612_773-768x768.jpg", "Tão Tão Distante", "Engenharia da Computação", "Web development", profile_exp);
        map.put("matheus@ufpa.itec.br", profile);

        profile_exp = new LinkedList<String>();
        profile_exp.add("Sistemas Distribuídos");
        profile_exp.add("Redes de Computadores");
        profile = new Profile("helder@ufpa.itec.br", "Helder", "May", "http://www.lrc.ic.unicamp.br/~helder/home/data/uploads/sistema/Helder.jpg" ,"Arapiraca", "Ciência da Computação", "Especialista em redes ópticas", profile_exp);
        map.put("helder@ufpa.itec.br", profile);

        profile_exp = new LinkedList<String>();
        profile_exp.add("Análise de exames no LAC da ufpa");
        profile = new Profile("beatrizmed@gmail.com", "Beatriz", "Oliveira", "https://www.thispersondoesnotexist.com/image", "Porto Alegre", "Engenharia Biomédica", "Hemograma", profile_exp);
        map.put("beatrizmed@gmail.com", profile);

        profile_exp = new LinkedList<String>();
        profile = new Profile("fulano@gmail.com", "Fulano", "da Silva", "https://3.bp.blogspot.com/-7JRKR4Wwwco/VvRrJB69fMI/AAAAAAAADMo/xU62Xq8nzwYwKfQpvs5yR72HlwNEpSZtw/s1600/fulano.jpg", "Recife", "Engenharia da Elétrica", "Nenhuma", profile_exp);
        map.put("fulano@gmail.com", profile);

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
            return;
        }
        return;
    }
}
