package residuo;

public class Relatorio {
    public static void gerarRelatorio(DAOResiduo imp){
        imp.mostraDados();
    }
    
    public static void gerarRelatorioGrauPericulosidade(DAOResiduo imp){
        imp.mostraGrauPericulosidade();
    }
    
    public static void gerarRelatorioReciclaveis(DAOResiduo imp){
        imp.mostraReciclaveis();
    }
}
