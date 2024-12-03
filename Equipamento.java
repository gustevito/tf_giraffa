public class Equipamento {
    private int codigo;
    private String nomeEquipamento;
    private int quantidade;
    private String tipo;
    private double valorBase; // Valor do empréstimo por 1 semana
    private boolean seguro;  // Indica se o equipamento possui seguro

    public Equipamento(int codigo, String nomeEquipamento, int quantidade, int tipoInput, double valorBase, boolean seguro) {
        this.codigo = codigo;
        this.nomeEquipamento = nomeEquipamento;
        this.quantidade = quantidade;
        this.valorBase = valorBase;
        this.seguro = seguro;
        setTipo(tipoInput); // Define o tipo com base no input
    }

    // getters
    public int getCodigo() {
        return codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public String getNomeEquipamento() {
        return nomeEquipamento;
    }
    public String getTipo() {
        return tipo;
    }
    public double getValorBase() {
        return valorBase;
    }
    public boolean isSeguro() {
        return seguro;
    }

    // setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }
    public void setTipo(int tipoInput) {
        switch (tipoInput) {
            case 1:
                this.tipo = "notebook";
                break;
            case 2:
                this.tipo = "impressora";
                break;
            case 3:
                this.tipo = "desktop";
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido. Escolha 1 (notebook), 2 (impressora) ou 3 (desktop).");
        }
    }
    public void setValorBase(double valorBase) {
        if (valorBase < 0) {
            throw new IllegalArgumentException("O valor base não pode ser negativo.");
        }
        this.valorBase = valorBase;
    }
    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    // métodos
    public boolean retirada() {
        if (this.quantidade > 0) {
            this.quantidade--;
            return true;
        }
        return false;
    }
    public void devolucao() {
        this.quantidade++;
    }

    public double calculaValorEmprestimo(int dias) {
        double valor = valorBase;
        if (dias > 7 || dias <= 15) {
            valor *= 0.95; // Desconto de 5%
        } else if (dias > 15 || dias <= 30) {
            valor *= 0.90; // Desconto de 10%
        } else if (dias != 7) {
            throw new IllegalArgumentException("Duração inválida. Escolha 7, 15 ou 30 dias.");
        }

        // Acrescentar 2% caso o seguro esteja ativo
        if (seguro) {
            valor *= 1.02;
        }

        return valor;
    }

    // métodos toString (português e inglês)
    public String toString() {
        return "\nEQUIPAMENTO" +
            "\nNome: " + nomeEquipamento +
            "\nCodigo: " + codigo +
            "\nQuantidade: " + quantidade +
            "\nTipo: " + tipo +
            "\nValor Base: R$ " + String.format("%.2f", valorBase) +
            "\nSeguro: " + (seguro ? "Sim" : "Não");
    }
    public String toStringENG() {
        return "\nEQUIPMENT" +
            "\nName: " + nomeEquipamento +
            "\nCode: " + codigo +
            "\nQuantity: " + quantidade +
            "\nType: " + tipo +
            "\nBase Value: $ " + String.format("%.2f", valorBase) +
            "\nInsurance: " + (seguro ? "Yes" : "No");
    }
}
