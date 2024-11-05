package residuo;

import java.util.Scanner;

public class MenuExecutavel {

    public void menu() {
        DAOResiduoImp daor = new DAOResiduoImp();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---Gerenciador de Residuos---");
            System.out.println("1 - Criar Residuo");
            System.out.println("2 - Selecionar Residuo");
            System.out.println("3 - Remover Residuo");
            System.out.println("4 - Gerar Relatorio");
            System.out.println("5 - Gerar Grau Periculosidade");
            System.out.println("6 - Gerar Reciclaveis");
            System.out.println("7 - Finalizar\n>>");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("---Criar Residuo---");
                    Residuo r;
                    System.out.println("Qual tipo de Residuo deseja criar? (RC|RP)");
                    String st = sc.nextLine();
                    if (st.equals("RC")) {
                        System.out.println("Nome");
                        String nome = sc.nextLine();
                        System.out.println("E Reciclavel?");
                        boolean reciclavel = sc.nextBoolean();
                        System.out.println("Numero do residuo");
                        int nResiduo = sc.nextInt();
                        System.out.println("Estoque inicial");
                        double kg = sc.nextDouble();
                        r = new ResiduoComum(reciclavel, nResiduo, kg, nome);
                        daor.inserir(r);
                    } else if (st.equals("RP")) {
                        System.out.println("Nome");
                        String nome = sc.nextLine();
                        System.out.println("Grau de Periculosidade");
                        int grauPericulosidade = sc.nextInt();
                        System.out.println("Numero do residuo");
                        int nResiduo = sc.nextInt();
                        System.out.println("Estoque inicial");
                        double kg = sc.nextDouble();
                        r = new ResiduoPerigoso(grauPericulosidade, nResiduo, kg, nome);
                        daor.inserir(r);
                    }
                    break;
                case 2:
                    System.out.println("---Selecione um residuo---");
                    System.out.println("Entre com o numero do residuo: ");
                    int numero = sc.nextInt();
                    Residuo r1;
                    r1 = daor.procurarResiduo(numero);
                    if (r1 != null) {
                        System.out.println("---Residuo Encontrado---");
                        int repete;
                        do{
                            repete = subMenu(daor, r1, sc);
                        }while(repete != 5);
                    } else {
                        System.out.println("Residuo não encontrada!");
                    }
                    break;
                case 3:
                    System.out.println("---Remover Residuo---");
                    System.out.println("Entre com o numero da conta: ");
                    int nResiduo = sc.nextInt();
                    Residuo r2;
                    r2 = daor.procurarResiduo(nResiduo);
                    if (r2 != null) {
                        daor.remover(r2);
                    } else {
                        System.out.println("Residuo nao encontrada!");
                    }
                    break;
                case 4:
                    System.out.println("---Gerar Relatorio---");
                    daor.mostraDados();
                    break;
                case 5:
                    System.out.println("---Gerar Relatorio Grau Periculosidade---");
                    daor.mostraGrauPericulosidade();
                    break;
                case 6:
                    System.out.println("---Gerar Relatorio Reciclaveis---");
                    daor.mostraReciclaveis();
                    break;
                case 7:
                    System.out.println("---Adeus, Obrigado pela preferencia!---");
                    break;
                default:
                    System.out.println("Entrada invalida!");
            }
        } while (opcao != 7);

    }

    private int subMenu(DAOResiduoImp daor, Residuo r, Scanner sc) {
            int indice = daor.getResiduos().indexOf(r);
            System.out.println("---Menu de Residuo Selecionada---");
            System.out.println("1 - Coletar");
            System.out.println("2 - Destinar");
            System.out.println("4 - Gerar relatorio");
            System.out.println("5 - Retornar ao menu anterior");
            int op = sc.nextInt();
            switch (op) {
            case 1:
                System.out.println("--Coleta---");
                System.out.println("Entre com o valor:");
                double valor = sc.nextDouble();
                daor.getResiduos().get(indice).coletar(valor);
                break;
            case 2:
                System.out.println("--Destinacao---");
                System.out.println("Entre com o valor:");
                double valorS = sc.nextDouble();
                if(daor.getResiduos().get(indice).destinar(valorS)){
                    System.out.println("Destinacao efetuada com sucesso!");
                }else{
                    System.out.println("Ocorreu um problema...");
                }
                break;
            case 4:
                System.out.println("--Relatorio do Residuo---");
                Relatorio.gerarRelatorio((DAOResiduo) daor.getResiduos().get(indice));
                break;
            case 5:
                System.out.println("retornando ao menu...");
            default:
                System.out.println("Opção inválida!");
        }
            return op;
    }

    public static void main(String[] args) {
        MenuExecutavel me = new MenuExecutavel();
        me.menu();
    }
}
