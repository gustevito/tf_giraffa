public class Cliente {
    private int matricula;
    private String nome;
    private String empresa;
    private int quantidadeEmprestimos;
    Equipamento equipamentoRetirado;

    public Cliente(int matricula, String nome, String empresa) {
        this.matricula = matricula;
        this.nome = nome;
        this.empresa = empresa;
        this.quantidadeEmprestimos = 0;
        this.equipamentoRetirado = null;
    }

    // getters
    public int getMatricula() {
        return matricula;
    }   
    public String getNome() {
        return nome;
    }
    public String getEmpresa(){
        return empresa;
    }
    public int getQuantidadeEmprestimos() {
        return quantidadeEmprestimos;
    }
    public Equipamento getEquipamentoRetirado() {
        return equipamentoRetirado;
    }
    
    // setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }   
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }
    public void setQuantidadeEmprestimos(int quantidadeEmprestimos) {
        this.quantidadeEmprestimos = quantidadeEmprestimos;
    }
    public void setEquipamentoRetirado(Equipamento equipamento) {
        this.equipamentoRetirado = equipamento;
    }
    
    
    // toString (portugues e ingles)
    public String toString(){
        return "\nCLIENTE " + 
        "\nNome: " + nome +
        "\nMatrícula: " + matricula +
        "\nEmpresa: " + empresa +
        "\nEquipamento Retirado: " + (equipamentoRetirado != null ? equipamentoRetirado.getNomeEquipamento() : "Nenhum");
    }
    public String toStringENG(){
        return "\nCLIENT " + 
        "\nName: " + nome +
        "\nRegistration: " + matricula +
        "\nCompany: " + empresa +
        "\nEquipment Rented: " + (equipamentoRetirado != null ? equipamentoRetirado.getNomeEquipamento() : "None");
    }
}