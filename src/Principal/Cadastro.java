
package Principal;

public class Cadastro {
    private int ID;
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;
    private String tipoSanguineo;
    private String curso;
    private String contatoEmergencia;
    private String telefoneEmergencia;

    
    
    //construtor

    public Cadastro(String nome, String endereco, String telefone, String CPF, String tipoSanguineo, String curso, String contatoEmergencia, String telefoneEmergencia) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.tipoSanguineo = tipoSanguineo;
        this.curso = curso;
        this.contatoEmergencia = contatoEmergencia;
        this.telefoneEmergencia = telefoneEmergencia;
    }
    


 
    
    
    
    
    //Getters
   
    
    
    
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public String getCurso() {
        return curso;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }
    
    
    
    
    //Setters

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }


}
