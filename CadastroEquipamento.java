public class CadastroEquipamento {
    private int index;
    private Equipamento equipamento[];

    // Método construtor;
    public CadastroEquipamento() {
        this.index = 0;
        this.equipamento = new Equipamento[10];
    }
    
    // Métodos para inserir e remover um equipamento no vetor;
    public boolean adicionaEquipamento (Equipamento equipamento) {
        if (this.index < this.equipamento.length) {
            this.equipamento[this.index] = equipamento;
            this.index++;
            return true;
        }
        return false;
    }
    public boolean apagaEquipamento (String nome) {
        int pos = 0;
        boolean achou = false;
        
        for (int i = 0; i < this.index; i++) {
            if (this.equipamento[i].getNomeEquipamento().equalsIgnoreCase(nome)) {
                pos = i;
                achou = true;
                break;
            }
        }
        if (achou) {
            for (int i = pos; i < this.equipamento.length-1; i++)
            {
                this.equipamento[i] = this.equipamento[i+1];
            }
            this.equipamento[this.equipamento.length-1] = null;
            index--;
            return true;
        }
        return false;
    }
    
    // Método para buscar um equipamento pelo nome no vetor;
    public Equipamento buscaEquipamentoPeloNome (String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.equipamento[i].getNomeEquipamento().equalsIgnoreCase(nome)) {
                return this.equipamento[i];
            }
        }
        return null;
    }
    
    // Método para o cálculo do total de equipamentos disponíveis;
    public int totalQuantidade () {
        int totalQuantidade = 0;
        for (int i = 0; i < this.index; i++) {
            totalQuantidade += this.equipamento[i].getQuantidade();
        }
        return totalQuantidade;
    }
    
    // Método para imprimir os dados do vetor/objeto equipamento;
    public void mostraEquipamentos () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.equipamento[i]);
        }
    }
    public void showEquipments () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.equipamento[i].toStringENG());
        }
    }
}