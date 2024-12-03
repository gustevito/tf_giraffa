import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroCliente clientes = new CadastroCliente();
        CadastroEquipamento equipamentos = new CadastroEquipamento();
        
        System.out.println("Selecione o idioma de sua preferência:");
        System.out.println("(Select your preferred language:)");
        System.out.println("\n1 – Português");
        System.out.println("2 – English");
        
        int lingua = teclado.nextInt();
        teclado.nextLine();
        
        while (lingua >= 3 || lingua <= 0) {
            System.out.println ("### ERROR ###");
            System.out.println ("Por favor, digite um nº válido:");
            System.out.println ("(Please, enter a valid number:)");
            System.out.println("\n1 – Português");
            System.out.println("2 – English");
            lingua = teclado.nextInt();
            teclado.nextLine();
        }
        
        switch (lingua) {
            case 1:
                System.out.print('\u000C');
                System.out.print(
                "             ,----------------,              ,---------,\n" +
                "        ,-----------------------,          ,\"        ,\"|\n" +
                "      ,\"                      ,\"|        ,\"        ,\"  |      Boas vindas a nossa empresa LESS IS MORE!\n" +
                "     +-----------------------+  |      ,\"        ,\"    |\n" +
                "     |  .-----------------.  |  |     +---------+      |       Oferecemos a melhor solução para sua empresa quando\n" +
                "     |  |                 |  |  |     | -==----'|      |       o assunto é eletrônicos!\n" +
                "     |  |  LESS IS MORE!  |  |  |     |         |      |\n" +
                "     |  |  Insira um nº:  |  |  |/----|`---=    |      |       Para começar, siga as instruções abaixo:\n" +
                "     |  |  C:\\>_          |  |  |   ,/|==== ooo |      ;\n" +
                "     |  |                 |  |  |  // |(((( [33]|    ,\"\n" +
                "     |  `-----------------'  |,\" .;'| |((((     |  ,\"\n" +
                "     +-----------------------+  ;;  | |         |,\"     \n" +
                "        /_)______________(_/  //'   | +---------+\n" +
                "   ___________________________/___  `,\n" +
                "  /  oooooooooooooooo  .o.  oooo /,   \\,\"-----------\n" +
                " / ==ooooooooooooooo==.o.  ooo= //   ,`\\--{)B     ,\"\n" +
                "/_==__==========__==_ooo__ooo=_/'   /___________,\" \n" +
                "`-----------------------------'\n"
            );

                
                opcoes(teclado, equipamentos, clientes);
                
            break;
            case 2:
                System.out.print('\u000C');
                System.out.print(
                "             ,----------------,              ,---------,\n" +
                "        ,-----------------------,          ,\"        ,\"|\n" +
                "      ,\"                      ,\"|        ,\"        ,\"  |      Boas vindas a nossa empresa LESS IS MORE!\n" +
                "     +-----------------------+  |      ,\"        ,\"    |\n" +
                "     |  .-----------------.  |  |     +---------+      |       Oferecemos a melhor solução para sua empresa quando\n" +
                "     |  |                 |  |  |     | -==----'|      |       o assunto é eletrônicos!\n" +
                "     |  |  LESS IS MORE!  |  |  |     |         |      |\n" +
                "     |  |  Insira um nº:  |  |  |/----|`---=    |      |       Para começar, siga as instruções abaixo:\n" +
                "     |  |  C:\\>_          |  |  |   ,/|==== ooo |      ;\n" +
                "     |  |                 |  |  |  // |(((( [33]|    ,\"\n" +
                "     |  `-----------------'  |,\" .;'| |((((     |  ,\"\n" +
                "     +-----------------------+  ;;  | |         |,\"     \n" +
                "        /_)______________(_/  //'   | +---------+\n" +
                "   ___________________________/___  `,\n" +
                "  /  oooooooooooooooo  .o.  oooo /,   \\,\"-----------\n" +
                " / ==ooooooooooooooo==.o.  ooo= //   ,`\\--{)B     ,\"\n" +
                "/_==__==========__==_ooo__ooo=_/'   /___________,\" \n" +
                "`-----------------------------'\n"
            );
                options(teclado, equipamentos, clientes);
                
            break;
        }        
    }
    
    public static void opcoes (Scanner teclado, CadastroEquipamento equipamentos, CadastroCliente clientes){
        Random matricula = new Random();
        while(true){
            exibirMenu();
            int opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1: // incluir cliente
                    System.out.print('\u000C');
                    System.out.println("OPÇÃO ESCOLHIDA – Inserir cliente");
                    
                    System.out.println("\nInforme o nome do novo cliente: ");
                    String nome = teclado.nextLine();
                    System.out.println("Informe a empresa do novo cliente: ");
                    String empresa = teclado.nextLine();
                    int mat = matricula.nextInt(100);
                    do {
                        mat = matricula.nextInt(100);
                    } while (clientes.verificaMatricula(mat));
                    Cliente novoCliente = new Cliente(mat, nome, empresa);
                    if (clientes.adicionaCliente(novoCliente)) {
                        System.out.println("Cliente inserido com sucesso!");
                        System.out.println(novoCliente);
                    } else {
                        System.out.println("ERRO" + 
                        "\nNão foi possível cadastrar o(a) cliente(a) '" + nome + "'." +
                        "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                    break;
                    
                    
                case 2: // remover o cliente
                    System.out.print('\u000C');
                    System.out.println("OPÇÃO ESCOLHIDA – Excluir cliente");
                    
                    System.out.println("\nInforme o nome do cliente que precisa ser apagado: ");
                    nome = teclado.nextLine();
                    if (clientes.retiraCliente(nome)) {
                        System.out.println("Cadastro de '" + nome + "' removido com sucesso!");
                    } else {
                        System.out.println("ERRO!" + "\nNenhum cliente com o nome de '" + nome + 
                        "' encontrado no sistema." + "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                    break;
                    
                    
                case 3: // mostrar clientes
                System.out.print('\u000C'); 
                System.out.println("OPÇÃO ESCOLHIDA – Mostrar clientes");
                
                    System.out.println("\n • Clientes cadastrados na empresa: • ");
                    clientes.mostraClientes();
                    esperarEnter(teclado);
                    break;
                    
                    
                case 4: // pesquisar cliente por nome
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Pesquisar cliente por nome");
                
                    System.out.println("\nInforme o nome do cliente que deseja pesquisar: ");
                    nome = teclado.nextLine();
                    Cliente clientePesquisado = clientes.buscaClientePeloNome(nome);
                    if (clientePesquisado != null) {
                        System.out.println("Cliente encontrado:\n" + clientePesquisado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    esperarEnter(teclado);
                    break;
                    
                    
                 case 5: // incluir equipamento
                    System.out.print('\u000C');
                    System.out.println("OPÇÃO ESCOLHIDA – Adicionar equipamento");
                    
                    System.out.println("\nInforme o tipo do equipamento que deseja adicionar: ");
                    System.out.println("1 - Notebook");
                    System.out.println("2 - Impressora");
                    System.out.println("3 - Desktop");
                    int tipoInput = teclado.nextInt();
                    teclado.nextLine(); 
                
                    // Validar o input do tipo
                    if (tipoInput < 1 || tipoInput > 3) {
                        System.out.println("ERRO: Tipo inválido. Escolha 1 (Notebook), 2 (Impressora) ou 3 (Desktop).");
                        esperarEnter(teclado);
                        break;
                    }
                
                    System.out.println("\nInforme o nome do equipamento: ");
                    String nomeEquipamento = teclado.nextLine();
                    System.out.println("Informe a quantidade de equipamentos no estoque: ");
                    int quantidade = teclado.nextInt();
                    System.out.println("Crie um código para o cadastro do equipamento: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine(); 
                
                    System.out.println("Informe o valor base para o empréstimo por 1 semana (em R$): ");
                    double valorBase = teclado.nextDouble();
                    teclado.nextLine(); 
                
                    System.out.println("Deseja incluir seguro para este equipamento? (1 - Sim, 0 - Não): ");
                    int seguroInput = teclado.nextInt();
                    teclado.nextLine();
                    
            
                
                    // Validar o input do seguro
                    if (seguroInput < 0 || seguroInput > 1) {
                        System.out.println("ERRO: Opção de seguro inválida. Escolha 1 (Sim) ou 0 (Não).");
                        esperarEnter(teclado);
                        break;
                    }
                    boolean seguro = (seguroInput == 1);
                
                    System.out.println("Por quantos dias você deseja alugar este equipamento?");
                    int dias = teclado.nextInt();
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
    
                    
                    // Criação do novo equipamento
                    Equipamento novoEquipamento = new Equipamento(codigo, nomeEquipamento, quantidade, tipoInput, valorBase, seguro);
                    if (equipamentos.adicionaEquipamento(novoEquipamento)) {
                        System.out.println("Equipamento adicionado com sucesso!");
                        System.out.println(novoEquipamento);
                        System.out.println("Valor acrescido com o seguro: R$" + valor);
                    } else {
                        System.out.println("ERRO" + 
                        "\nNão foi possível cadastrar o equipamento '" + nomeEquipamento + "'." +
                        "\nVerifique se você digitou corretamente e tente novamente!");
                    }
                    esperarEnter(teclado);
                break;
        
                            
                case 6: // excluir equipamentos
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Excluir equipamento");
                    
                System.out.println ("\nInforme o nome do equipamento que precisa ser apagado:");
                nomeEquipamento = teclado.nextLine();
                if (equipamentos.apagaEquipamento(nomeEquipamento)) {
                    System.out.println ("O equipamento cadastrado foi removido com sucesso!");
                } else {
                    System.out.println ("ERRO" + 
                    "\nNão foi possível remover o cadastro do equipamento '" + nomeEquipamento + "'." + 
                    "\nVerifique se você digitou corretamente e tente novamente!");
                }
                break;
                
                    
                case 7: // mostrar equipamentos
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Mostrar equipamentos");
                    
                    System.out.println("\n • Estoque • ");
                    equipamentos.mostraEquipamentos();
                    esperarEnter(teclado);
                    break;
                    
                    
                case 8: // pesquisar nome do equipamento
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Pesquisar equipamento por nome");
                    
                    System.out.println("\nInforme o nome do equipamento que deseja pesquisar: ");
                    nomeEquipamento = teclado.nextLine();
                    Equipamento equipamentoPesquisado = equipamentos.buscaEquipamentoPeloNome(nomeEquipamento);
                    if (equipamentoPesquisado == null) {
                        System.out.println("O equipamento \"" + nomeEquipamento + "\" não foi encontrado no sistema.");
                    } else {
                        System.out.println("O equipamento foi encontrado\n" + equipamentoPesquisado);
                    }
                    esperarEnter(teclado);
                    break;
                    
                    
                case 9: // retirar equipamento
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Retirar equipamento");
                
                System.out.println ("\nInforme o nome do cliente que deseja retirar um equipamento: ");
                nome = teclado.nextLine();
                System.out.println ("Informe o nome do equipamento que o cliente deseja retirar: ");
                nomeEquipamento = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome).getEquipamentoRetirado() != null) {
                    System.out.println ("O cliente já tem um equipamento em empréstimo com a empresa.\nCaso ele deseja retirar outro equipamento, deve devolver o outro antes.");
                } else {
                    clientes.buscaClientePeloNome(nome).setEquipamentoRetirado(equipamentos.buscaEquipamentoPeloNome(nomeEquipamento));
                    if (equipamentos.buscaEquipamentoPeloNome(nomeEquipamento).retirada()) {
                        System.out.println ("O equipamento foi retirado com sucesso!");
                    } else {
                        System.out.println ("Não foi possível retirar o equipamento!" + "\nO equipamento não possui cópias disponíveis.");
                    }
                }
                    esperarEnter(teclado);
                    break;
                    
                    
                case 10: // devolver equipamento
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Devolver equipamento");
                
                System.out.println("\nInforme o nome do cliente que deseja devolver um equipamento:");
                nome = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome).getEquipamentoRetirado() == null) {
                    System.out.println ("O cliente não tem nenhum empréstimo na empresa.");
                } else {
                    equipamentos.buscaEquipamentoPeloNome(clientes.buscaClientePeloNome(nome).getEquipamentoRetirado().getNomeEquipamento()).devolucao();
                    clientes.buscaClientePeloNome(nome).setEquipamentoRetirado(null);
                    System.out.println ("O equipamento foi devolvido com sucesso!");
                }
                    esperarEnter(teclado);
                    break;
                    
                    
                case 11: // quantidade total
                System.out.print('\u000C');
                System.out.println("OPÇÃO ESCOLHIDA – Quantidade disponíveis");
                
                    System.out.println("\nTotal de equipamentos disponíveis: " + equipamentos.totalQuantidade());
                    esperarEnter(teclado);
                    break;
                    
                    
                case 20:
                    System.out.print('\u000C');
                    System.out.println("   ___  _          _                 _       _ ");
                    System.out.println("  / _ \\| |__  _ __(_) __ _  __ _  __| | ___ | |");
                    System.out.println(" | | | | '_ \\| '__| |/ _` |/ _` |/ _` |/ _ \\| |");
                    System.out.println(" | |_| | |_) | |  | | (_| | (_| | (_| | (_) |_|");
                    System.out.println("  \\___/|_.__/|_|  |_|\\__, |\\__,_|\\__,_|\\___/(_)");
                    System.out.println("                     |___/                     ");
    
                    System.out.println("\n               Volte sempre! :)");
                    teclado.close();
                    System.exit(0);
                    break;
                    
                    
                default:
                    System.out.println("\n### Opção inválida! ###");
                    System.out.println("Verifique se o que foi digitado condiz com alguma das opções.");
                    esperarEnter(teclado);
            }
        }
    }
    
    
    // ingles
    public static void options (Scanner teclado, CadastroEquipamento equipamentos, CadastroCliente clientes) {
    Random matricula = new Random();
    while (true){
        showMenu();
        int opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1: // include reader
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Add reader");
                
                System.out.println("\nEnter the name of the new reader: ");
                String nome = teclado.nextLine();
                System.out.println("Enter the company of the new reader: ");
                String empresa = teclado.nextLine();
                int mat = matricula.nextInt(100);
                do {
                    mat = matricula.nextInt(100);
                } while (clientes.verificaMatricula(mat));
                Cliente novoCliente = new Cliente(mat, nome, empresa);
                if (clientes.adicionaCliente(novoCliente)) {
                    System.out.println("Client successfully added!");
                    System.out.println(novoCliente.toStringENG());
                } else {
                    System.out.println("ERROR" + 
                    "\nIt was not possible to register the reader '" + nome + "'." +
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 2: // remove reader
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Delete reader");
                
                System.out.println("\nEnter the name of the reader to be removed: ");
                nome = teclado.nextLine();
                if (clientes.retiraCliente(nome)) {
                    System.out.println("Client '" + nome + "' successfully removed!");
                } else {
                    System.out.println("ERROR!" + "\nNo reader with the name '" + nome + 
                    "' found in the system." + "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 3: // show readers
                System.out.print('\u000C'); 
                System.out.println("SELECTED OPTION – Show readers");
                
                System.out.println("\n • Registered readers: • ");
                clientes.showClients();
                waitForEnter(teclado);
                break;
            case 4: // search reader by name
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Search reader by name");
                
                System.out.println("\nEnter the name of the reader to search: ");
                nome = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome) != null) {
                    System.out.println("Client found:\n" + clientes.buscaClientePeloNome(nome).toStringENG());
                } else {
                    System.out.println("Client not found.");
                }
                waitForEnter(teclado);
                break;
            case 5: // include equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Add equipment");
            
                System.out.println("\nEnter the type of the equipment to add:");
                System.out.println("1 - Notebook");
                System.out.println("2 - Printer");
                System.out.println("3 - Desktop");
                int tipoInput = teclado.nextInt();
                teclado.nextLine(); // Clear the input buffer
            
                // Validate the type input
                if (tipoInput < 1 || tipoInput > 3) {
                    System.out.println("ERROR: Invalid type. Choose 1 (Notebook), 2 (Printer), or 3 (Desktop).");
                    waitForEnter(teclado);
                    break;
                }
            
                System.out.println("\nEnter the name of the equipment to add: ");
                String nomeEquipamento = teclado.nextLine();
                System.out.println("Enter the number of units for the equipment: ");
                int quantidade = teclado.nextInt();
                System.out.println("Create a code for the equipment: ");
                int codigo = teclado.nextInt();
                teclado.nextLine(); // Clear the input buffer
            
                System.out.println("Enter the base value for a 1-week rental (in $): ");
                double valorBase = teclado.nextDouble();
                teclado.nextLine(); // Clear the input buffer
            
                System.out.println("Do you want to include insurance for this equipment? (1 - Yes, 0 - No): ");
                int seguroInput = teclado.nextInt();
                teclado.nextLine(); // Clear the input buffer
            
                // Validate the insurance input
                if (seguroInput < 0 || seguroInput > 1) {
                    System.out.println("ERROR: Invalid insurance option. Choose 1 (Yes) or 0 (No).");
                    waitForEnter(teclado);
                    break;
                }
                boolean seguro = (seguroInput == 1);
            
                // Create the new equipment
                Equipamento novoEquipamento = new Equipamento(codigo, nomeEquipamento, quantidade, tipoInput, valorBase, seguro);
                if (equipamentos.adicionaEquipamento(novoEquipamento)) {
                    System.out.println("Equipment successfully added!");
                    System.out.println(novoEquipamento.toStringENG());
                } else {
                    System.out.println("ERROR" +
                    "\nIt was not possible to register the equipment '" + nomeEquipamento + "'." +
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
            break;


            case 6: // remove equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Delete equipment");
                
                System.out.println("\nEnter the name of the equipment to be removed:");
                nomeEquipamento = teclado.nextLine();
                if (equipamentos.apagaEquipamento(nomeEquipamento)) {
                    System.out.println("The equipment was successfully removed!");
                } else {
                    System.out.println("ERROR" + 
                    "\nIt was not possible to remove the equipment '" + nomeEquipamento + "'." + 
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 7: // show equipments
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Show equipments");
                
                System.out.println("\n • Equipment Stock • ");
                equipamentos.showEquipments();
                waitForEnter(teclado);
                break;
            case 8: // search equipment by name
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Search equipment by name");
                
                System.out.println("\nEnter the name of the equipment to search: ");
                nomeEquipamento = teclado.nextLine();
                Equipamento equipamentoPesquisado = equipamentos.buscaEquipamentoPeloNome(nomeEquipamento);
                if (equipamentoPesquisado == null) {
                    System.out.println("The equipment \"" + nomeEquipamento + "\" was not found in the system.");
                } else {
                    System.out.println("The equipment was found\n" + equipamentos.buscaEquipamentoPeloNome(nomeEquipamento).toStringENG());
                }
                waitForEnter(teclado);
                break;
            case 9: // borrow equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Borrow equipment");
                
                System.out.println("\nEnter the name of the reader who wants to borrow a equipment: ");
                nome = teclado.nextLine();
                System.out.println("Enter the name of the equipment the reader wants to borrow: ");
                nomeEquipamento = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome).getEquipamentoRetirado() != null) {
                    System.out.println("The reader already has already borrowed a equipment.\nIf they want to borrow another equipment, they must return the current one first.");
                } else {
                    clientes.buscaClientePeloNome(nome).setEquipamentoRetirado(equipamentos.buscaEquipamentoPeloNome(nomeEquipamento));
                    if (equipamentos.buscaEquipamentoPeloNome(nomeEquipamento).retirada()) {
                        System.out.println("The equipment was successfully borrowed!");
                    } else {
                        System.out.println("The equipment doesn't have equipments available.");
                    }
                }
                waitForEnter(teclado);
                break;
            case 10: // return equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Return equipment");
                
                System.out.println("\nEnter the name of the reader who wants to return a equipment:");
                nome = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome).getEquipamentoRetirado() == null) {
                    System.out.println("The reader does not have any equipments on loan.");
                } else {
                    equipamentos.buscaEquipamentoPeloNome(clientes.buscaClientePeloNome(nome).getEquipamentoRetirado().getNomeEquipamento()).devolucao();
                    clientes.buscaClientePeloNome(nome).setEquipamentoRetirado(null);
                    System.out.println("The equipment was successfully returned!");
                }
                waitForEnter(teclado);
                break;
            case 11: // total equipments
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Available equipments");
                
                System.out.println("\nTotal available equipments: " + equipamentos.totalQuantidade());
                waitForEnter(teclado);
                break;
            case 20:
                System.out.print('\u000C');
                System.out.println("  _____ _                 _     __   __          _ ");
                System.out.println(" |_   _| |__   __ _ _ __ | | __ \\ \\ / /__  _   _| |");
                System.out.println("   | | | '_ \\ / _` | '_ \\| |/ /  \\ V / _ \\| | | | |");
                System.out.println("   | | | | | | (_| | | | |   <    | | (_) | |_| |_|");
                System.out.println("   |_| |_| |_|\\__,_|_| |_|_|\\_\\   |_|\\___/ \\__,_(_)");
                System.out.println("                                                   ");
                
                System.out.println("\n               Come back anytime! :)");
                teclado.close();
                System.exit(0);
                break;
            default:
                System.out.println("\n### Invalid option! ###");
                System.out.println("Please check if the option entered matches any available options.");
                waitForEnter(teclado);
        }
    }
}

    // portugues
    private static void exibirMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Digite o nº da opção que deseja executar:");
        System.out.println("\n-• CLIENTES •-");
        System.out.println("\n1 – Adicionar cliente");
        System.out.println("2 – Excluir cliente");
        System.out.println("3 – Mostrar clientes");
        System.out.println("4 – Pesquisar cliente por nome");
        System.out.println("\n-----------------------------------------");
        System.out.println("-• EQUIPAMENTOS •-");
        System.out.println("\n5 – Adicionar equipamento");
        System.out.println("6 – Excluir equipamento");
        System.out.println("7 – Mostrar equipamentos");
        System.out.println("8 – Pesquisar equipamento por nome");
        System.out.println("9 – Retirar equipamento");
        System.out.println("10 – Devolver equipamento");
        System.out.println("11 – Quantidade de equipamentos disponíveis");
        System.out.println("-----------------------------------------");
        System.out.println("\n20 – Sair do programa");
    }
    
    // ingles
    private static void showMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Enter the number of the option you want to execute:");
        System.out.println("\n-• CLIENTS •-");
        System.out.println("\n1 – Add reader");
        System.out.println("2 – Delete reader");
        System.out.println("3 – Show readers");
        System.out.println("4 – Search reader by name");
        System.out.println("\n-----------------------------------------");
        System.out.println("-• EQUIPMENTS •-");
        System.out.println("\n5 – Add equipment");
        System.out.println("6 – Delete equipment");
        System.out.println("7 – Show equipments");
        System.out.println("8 – Search equipment by name");
        System.out.println("9 – Borrow equipment");
        System.out.println("10 – Return equipment");
        System.out.println("11 – Available equipments");
        System.out.println("-----------------------------------------");
        System.out.println("\n20 – Exit the program");
    }


    private static void esperarEnter(Scanner teclado) {
        System.out.println("\nPressione a tecla Enter para acessar o menu...");
        teclado.nextLine();
        System.out.print('\u000C');
    }

    private static void waitForEnter(Scanner teclado) {
        System.out.println("\nPress the Enter key to display the menu...");
        teclado.nextLine();
        System.out.print('\u000C');
    }
}
