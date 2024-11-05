package residuo;

import java.util.ArrayList;
import java.util.List;

public class DAOResiduoImp implements DAOResiduo {
    private List<Residuo> residuos;

    public DAOResiduoImp() {
        this.residuos = new ArrayList<>();
    }
    
    public void inserir(Residuo cb){
        this.residuos.add(cb);
    }
    
    public void remover(Residuo cb){
        this.residuos.remove(cb);
    }
    
    public Residuo procurarResiduo(int nResiduo){
        for (Residuo residuo : residuos) {
            if(residuo.getnResiduo() == nResiduo)
                return residuo;
        }
        return null;
    }

    @Override
    public void mostraDados() {
        for (Residuo residuo : residuos) {
            Relatorio.gerarRelatorio((DAOResiduo) residuo);
        }
    }
    
    @Override
    public void mostraGrauPericulosidade() {
        for (Residuo residuo : residuos) {
            Relatorio.gerarRelatorioGrauPericulosidade((DAOResiduo) residuo);
        }
    }
    
    @Override
    public void mostraReciclaveis() {
        for (Residuo residuo : residuos) {
            Relatorio.gerarRelatorioReciclaveis((DAOResiduo) residuo);
        }
    }

    public List<Residuo> getResiduos() {
        return residuos;
    }
}
