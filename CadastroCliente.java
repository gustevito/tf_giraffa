public class CadastroCliente {
    private int index;
    private Cliente cliente[];

    public CadastroCliente() {
        this.index = 0;
        this.cliente = new Cliente[10];
    }

    public boolean adicionaCliente(Cliente cliente) {
        if (this.index < this.cliente.length) {
            this.cliente[this.index] = cliente;
            this.index++;
            return true;
        }
        return false;
    }
    
    public void mostraClientes () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.cliente[i]);
        }
    }
    
    public void showClients () {
        for (int i = 0; i < this.index; i++) {
            System.out.println (this.cliente[i].toStringENG());
        }
    }
    
    public boolean verificaMatricula (int matricula) {
        for (int i = 0; i < this.index; i++) {
            if (cliente[i].getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }
    
    public Cliente buscaClientePeloNome(String nome) {
        for (int i = 0; i < this.index; i++) {
            if (this.cliente[i].getNome().equalsIgnoreCase(nome)) {
                return this.cliente[i];
            }
        }
        return null;
    }

    
    public boolean retiraCliente (String nome) {
        int pos = 0;
        boolean achou = false;
        
        for (int i = 0; i < this.index; i++) {
            if (this.cliente[i].getNome().equalsIgnoreCase(nome)) {
                pos = i;
                achou = true;
                break;
            }
        }
        if (achou) {
            for (int i = pos; i < this.cliente.length-1; i++) {
                this.cliente[i] = this.cliente[i+1];
            }
            this.cliente[this.cliente.length-1] = null;
            index--;
            return true;
        }
        return false;
    }
}