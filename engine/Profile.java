package engine;

import java.io.Serializable;
import java.util.List;

public class Profile implements Serializable {
  private String email;
  private String nome;
  private String sobrenome;
  private String foto;
  private String residencia;
  private String formacao;
  private String habilidades;
  private List<String> experiencia;

  public Profile(String email, String nome, String sobrenome, String foto, String residencia, String formacao, String habilidades, List<String> experiencia) {
    this.email = email;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.foto = foto;
    this.residencia = residencia;
    this.formacao = formacao;
    this.habilidades = habilidades;
    this.experiencia = experiencia;
  }

  public String getEmail() {
    return this.email;
  }

  public String getNome() {
    return this.nome;
  }

  public String getSobrenome() {
    return this.sobrenome;
  }

  public String getNomeCompleto() {
    return this.nome + " " + this.sobrenome;
  }

  public String getResidencia() {
    return this.residencia;
  }

  public String getFormacao() {
    return this.formacao;
  }

  public String getHabilidades() {
    return this.habilidades;
  }

  public String getExperiencia() {
    String result = "";
    for (int i = 0; i < this.experiencia.size(); i++) {
      result += "(" + (i+1) + ") " + this.experiencia.get(i) + "\n";
    }
    return result;
  }

  public void addExperiencia(String experiencia) {
    this.experiencia.add(experiencia);
  }

  public String toString() {
    return "Email: " + this.email + "\n"
            + "Nome: " + this.nome + " Sobrenome: " + this.sobrenome + "\n"
            + "Foto_url: " + this.foto + "\n"
            + "Residência: " + this.residencia + "\n"
            + "Formação Acadêmica: " + this.formacao + "\n"
            + "Habilidades: " + this.habilidades + "\n"
            + "Experiência: \n" + this.getExperiencia() + "\n";
  }
}
