package residuo;

public class ResiduoPerigoso extends Residuo implements DAOResiduo {
    private int grauPericulosidade;

    public ResiduoPerigoso(int grauPericulosidade, int nResiduo, double kg, String nome) {
        super(nResiduo, kg, nome);
        this.grauPericulosidade = grauPericulosidade;
    }

    public int getGrauPericulosidade() {
        return grauPericulosidade;
    }

    public void setGrauPericulosidade(int grauPericulosidade) {
        this.grauPericulosidade = grauPericulosidade;
    }
    
    @Override
    public void mostraDados() {
        System.out.println("---Residuo Perigoso---");
        System.out.println("Codigo do Residuo: " + this.getnResiduo());
        System.out.println("Kg em estoque: " + this.getKg());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Grau Periculosidade: " + this.getGrauPericulosidade());
    }
    
    @Override
    public void mostraGrauPericulosidade() {
        System.out.println("---Residuo Perigoso---");
        System.out.println("Codigo do Residuo: " + this.getnResiduo());
        System.out.println("Kg em estoque: " + this.getKg());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Periculosidade: " + this.getGrauPericulosidade());
    }
    
    @Override
    public void mostraReciclaveis() {
    }
}
