import java.util.Scanner;
import java.util.Random;

public class Emprestimo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroCliente clientes = new CadastroCliente();
        CadastroEquipamento equipamentos = new CadastroEquipamento();
        // Equipamentos adicionados previamente:
            equipamentos.adicionaEquipamento(new Equipamento(101, "Notebook Vaio", 5, 1, 200.0));
            equipamentos.adicionaEquipamento(new Equipamento(102, "Notebook Dell", 4, 1, 180.0));
            equipamentos.adicionaEquipamento(new Equipamento(201, "Impressora Epson", 3, 2, 100.0));
            equipamentos.adicionaEquipamento(new Equipamento(202, "Impressora HP", 2, 2, 120.0));
            equipamentos.adicionaEquipamento(new Equipamento(301, "Desktop Gamer | Ryzen 5", 6, 3, 250.0));
            equipamentos.adicionaEquipamento(new Equipamento(302, "Desktop Gamer | Ryzen 7", 3, 3, 220.0));
        
        
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
                "      ,\"                      ,\"|        ,\"        ,\"  |      Welcome to LESS IS MORE!\n" +
                "     +-----------------------+  |      ,\"        ,\"    |\n" +
                "     |  .-----------------.  |  |     +---------+      |       We're here to offer you the very best when\n" +
                "     |  |                 |  |  |     | -==----'|      |       it comes to electronics!\n" +
                "     |  |  LESS IS MORE!  |  |  |     |         |      |\n" +
                "     |  | Insert a number:|  |  |/----|`---=    |      |       To start, follow the instructions below:\n" +
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
                
                    System.out.println("Informe o valor base para o aluguel do equipamento:");
                    double valorBase = teclado.nextDouble();
                    teclado.nextLine(); 
    
                    
                    // Criação do novo equipamento
                    Equipamento novoEquipamento = new Equipamento(codigo, nomeEquipamento, quantidade, tipoInput, valorBase);
                    if (equipamentos.adicionaEquipamento(novoEquipamento)) {
                        System.out.println("\nEquipamento adicionado com sucesso!");
                        System.out.println(novoEquipamento);
                        
                    } else {
                        System.out.println("\nERRO" + 
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
                
                System.out.println("\nInforme o nome do cliente que deseja retirar um equipamento: ");
                nome = teclado.nextLine();
                
                
                System.out.println("Informe o código do equipamento que o cliente deseja retirar: ");
                System.out.println("\n • Estoque • ");
                equipamentos.mostraEquipamentos();
                
                codigo = teclado.nextInt();
            
                // Buscar cliente e equipamento
                Cliente cliente = clientes.buscaClientePeloNome(nome);
                Equipamento equipamento = equipamentos.buscaEquipamentoPeloCodigo(codigo);
            
                if (cliente == null) {
                    System.out.println("ERRO: Cliente não encontrado.");
                } else if (equipamento == null) {
                    System.out.println("ERRO: Equipamento não encontrado.");
                } else if (cliente.getEquipamentoRetirado() != null) {
                    System.out.println("O cliente já tem um equipamento em empréstimo com a empresa." +
                                       "\nCaso deseje retirar outro equipamento, deve devolver o anterior.");
                } else {
                    System.out.println("Deseja incluir seguro para este equipamento? (1 - Sim, 0 - Não): ");
                    int seguroInput = teclado.nextInt();
                    if (seguroInput < 0 || seguroInput > 1) {
                        System.out.println("ERRO: Opção de seguro inválida. Escolha 1 (Sim) ou 0 (Não).");
                        esperarEnter(teclado);
                        break;
                    }
                    boolean seguro = (seguroInput == 1);
                    teclado.nextLine();
            
                    System.out.println("Por quantos dias você deseja alugar este equipamento?");
                    int dias = teclado.nextInt();
                    teclado.nextLine();
            
                    // Obter o valor base do equipamento
                    valorBase = equipamento.getValorBase();
            
                    // Calcular o valor final
                    double valor = valorBase;
                    if (dias == 7) {
                        valor *= 1.0; // Sem desconto
                    } else if (dias > 7 || dias <= 15) {
                        valor *= 0.95; // Desconto de 5%
                    } else if (dias > 15 || dias <= 30) {
                        valor *= 0.90; // Desconto de 10%
                    } else {
                        System.out.println("ERRO: Duração inválida. Escolha 7, 15 ou 30 dias.");
                        esperarEnter(teclado);
                        break;
                    }
                    if (seguro) {
                        valor *= 1.02; // Acrescentar 2% pelo seguro
                    }
            
                    System.out.println("Valor final: R$" + String.format("%.2f", valor));
            
                    // Registrar retirada
                    cliente.setEquipamentoRetirado(equipamento);
                    if (equipamento.retirada()) {
                        System.out.println("O equipamento foi retirado com sucesso!");
                    } else {
                        System.out.println("Não foi possível retirar o equipamento!" +
                                           "\nO equipamento não possui cópias disponíveis.");
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
            case 1: // include client
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Add client");
                
                System.out.println("\nEnter the name of the new client: ");
                String nome = teclado.nextLine();
                System.out.println("Enter the company of the new client: ");
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
                    "\nIt was not possible to register the client '" + nome + "'." +
                    "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 2: // remove client
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Delete client");
                
                System.out.println("\nEnter the name of the client to be removed: ");
                nome = teclado.nextLine();
                if (clientes.retiraCliente(nome)) {
                    System.out.println("Client '" + nome + "' successfully removed!");
                } else {
                    System.out.println("ERROR!" + "\nNo client with the name '" + nome + 
                    "' found in the system." + "\nPlease check the information entered and try again!");
                }
                waitForEnter(teclado);
                break;
            case 3: // show clients
                System.out.print('\u000C'); 
                System.out.println("SELECTED OPTION – Show clients");
                
                System.out.println("\n • Registered clients: • ");
                clientes.showClients();
                waitForEnter(teclado);
                break;
            case 4: // search client by name
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Search client by name");
                
                System.out.println("\nEnter the name of the client to search: ");
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
                
                System.out.println("\nEnter the type of the equipment you want to add:");
                System.out.println("1 - Notebook");
                System.out.println("2 - Printer");
                System.out.println("3 - Desktop");
                int tipoInput = teclado.nextInt();
                teclado.nextLine(); 
            
                // Validate the type input
                if (tipoInput < 1 || tipoInput > 3) {
                    System.out.println("ERROR: Invalid type. Choose 1 (Notebook), 2 (Printer), or 3 (Desktop).");
                    waitForEnter(teclado);
                    break;
                }
            
                System.out.println("\nEnter the name of the equipment:");
                String nomeEquipamento = teclado.nextLine();
                System.out.println("Enter the quantity of the equipment in stock:");
                int quantidade = teclado.nextInt();
                System.out.println("Create a code for the equipment:");
                int codigo = teclado.nextInt();
                teclado.nextLine(); 
            
                System.out.println("Enter the base value for the equipment rental:");
                double valorBase = teclado.nextDouble();
                teclado.nextLine(); 
            
                // Create the new equipment
                Equipamento novoEquipamento = new Equipamento(codigo, nomeEquipamento, quantidade, tipoInput, valorBase);
                if (equipamentos.adicionaEquipamento(novoEquipamento)) {
                    System.out.println("\nEquipment successfully added!");
                    System.out.println(novoEquipamento);
                    
                } else {
                    System.out.println("\nERROR" + 
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
            case 9: // rent equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Rent equipment");
                
                System.out.println("\nEnter the name of the client who wants to rent equipment:");
                nome = teclado.nextLine();
                
                System.out.println("Enter the code of the equipment the client wants to rent:");
                System.out.println("\n • Stock • ");
                equipamentos.mostraEquipamentos();
                
                codigo = teclado.nextInt();
            
                // Search for client and equipment
                Cliente cliente = clientes.buscaClientePeloNome(nome);
                Equipamento equipamento = equipamentos.buscaEquipamentoPeloCodigo(codigo);
            
                if (cliente == null) {
                    System.out.println("ERROR: Client not found.");
                } else if (equipamento == null) {
                    System.out.println("ERROR: Equipment not found.");
                } else if (cliente.getEquipamentoRetirado() != null) {
                    System.out.println("The client already has equipment rented from the company." +
                                       "\nIf they want to rent another piece of equipment, they must return the previous one.");
                } else {
                    System.out.println("Would you like to include insurance for this equipment? (1 - Yes, 0 - No):");
                    int seguroInput = teclado.nextInt();
                    if (seguroInput < 0 || seguroInput > 1) {
                        System.out.println("ERROR: Invalid insurance option. Choose 1 (Yes) or 0 (No).");
                        waitForEnter(teclado);
                        break;
                    }
                    boolean seguro = (seguroInput == 1);
                    teclado.nextLine();
            
                    System.out.println("For how many days do you want to rent this equipment?");
                    int dias = teclado.nextInt();
                    teclado.nextLine();
            
                    // Get the base value of the equipment
                    valorBase = equipamento.getValorBase();
            
                    // Calculate the final value
                    double valor = valorBase;
                    if (dias == 7) {
                        valor *= 1.0; // No discount
                    } else if (dias > 7 || dias <= 15) {
                        valor *= 0.95; // 5% discount
                    } else if (dias > 15 || dias <= 30) {
                        valor *= 0.90; // 10% discount
                    } else {
                        System.out.println("ERROR: Invalid duration. Choose 7, 15, or 30 days.");
                        waitForEnter(teclado);
                        break;
                    }
                    if (seguro) {
                        valor *= 1.02; // Add 2% for insurance
                    }
            
                    System.out.println("Final value: $" + String.format("%.2f", valor));
            
                    // Register rental
                    cliente.setEquipamentoRetirado(equipamento);
                    if (equipamento.retirada()) {
                        System.out.println("The equipment was successfully rentn!");
                    } else {
                        System.out.println("Unable to rent the equipment!" +
                                           "\nThe equipment is not available on stock.");
                    }
                }
                waitForEnter(teclado);
                break;

            case 10: // return equipment
                System.out.print('\u000C');
                System.out.println("SELECTED OPTION – Return equipment");
                
                System.out.println("\nEnter the name of the client who wants to return a equipment:");
                nome = teclado.nextLine();
                if (clientes.buscaClientePeloNome(nome).getEquipamentoRetirado() == null) {
                    System.out.println("The client does not have any equipments on loan.");
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
        System.out.println("\n1 – Add client");
        System.out.println("2 – Delete client");
        System.out.println("3 – Show clients");
        System.out.println("4 – Search client by name");
        System.out.println("\n-----------------------------------------");
        System.out.println("-• EQUIPMENTS •-");
        System.out.println("\n5 – Add equipment");
        System.out.println("6 – Delete equipment");
        System.out.println("7 – Show equipments");
        System.out.println("8 – Search equipment by name");
        System.out.println("9 – Rent equipment");
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
