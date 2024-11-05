package residuo;

public class Executavel {
    public static void main(String[] args) {
        Residuo rc = new ResiduoComum(true, 5435, 99.9, "Papelao");
        Residuo rp = new ResiduoPerigoso(1, 3453, 300, "Oleo Queimado");
        
        rc.coletar(400);
        if(rc.destinar(360) == true){
            System.out.println("Ok");
        }else{
            System.out.println("Não OK");
        }
        Relatorio.gerarRelatorio((DAOResiduo) rc);
        Relatorio.gerarRelatorio((DAOResiduo) rc);
        
        rp.coletar(1000);
        rp.destinar(500);
        Relatorio.gerarRelatorio((DAOResiduo) rp);
        
        System.out.println("----------------------");
        Relatorio.gerarRelatorio((DAOResiduo) rc);
        Relatorio.gerarRelatorio((DAOResiduo) rp);
    }
}
