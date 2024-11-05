package residuo;

public class ResiduoComum extends Residuo implements DAOResiduo {
    private boolean reciclavel;

    public ResiduoComum(boolean reciclavel, int nResiduo, double kg, String nome) {
        super(nResiduo, kg, nome);
        this.reciclavel = reciclavel;
    }

    public boolean isReciclavel() {
        return reciclavel;
    }

    public void setReciclavel(boolean reciclavel) {
        this.reciclavel = reciclavel;
    }
    
    @Override
    public void mostraDados() {
        System.out.println("---Residuo Comum---");
        System.out.println("Codigo do Residuo: " + this.getnResiduo());
        System.out.println("Kg em estoque: " + this.getKg());
        System.out.println("Nome: " + this.getNome());
        System.out.println("E reciclavel: " + this.isReciclavel());
    }
    
    @Override
    public void mostraGrauPericulosidade() {
        System.out.println("---Residuo Comum---");
        System.out.println("Codigo do Residuo: " + this.getnResiduo());
        System.out.println("Kg em estoque: " + this.getKg());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Periculosidade: 0");
    }
    
    @Override
    public void mostraReciclaveis() {
        if(this.isReciclavel() == true) {
            System.out.println("---------");
            System.out.println("Codigo do Residuo: " + this.getnResiduo());
            System.out.println("Kg em estoque: " + this.getKg());
            System.out.println("Nome: " + this.getNome());    
        }
    }
}
