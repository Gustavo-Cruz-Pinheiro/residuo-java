package residuo;

public abstract class Residuo {
    private int nResiduo;
    private double kg;
    private String nome;

    public Residuo(int nResiduo, double kg, String nome) {
        this.nResiduo = nResiduo;
        this.kg = kg;
        this.nome = nome;
    }

    public int getnResiduo() {
        return nResiduo;
    }

    public void setnResiduo(int nResiduo) {
        this.nResiduo = nResiduo;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean coletar(double valor) {
        if(valor > 0){
            double valorFinal = this.getKg() + valor;
            this.setKg(valorFinal);
            System.out.println("Coleta efetuada com sucesso!");
            return true;
        }else{
            System.out.println("Valor Invalido!");
            return false;
        }
    }
    
    public boolean destinar(double valor) {
        if(this.getKg() >= valor){
            double valorFinal = this.getKg() - valor;
            this.setKg(valorFinal);
            System.out.println("Destinacao efetuada com sucesso!");
            return true;
        }else{
            System.out.println("Valor maior que o estoque!");
            return false;
        }
    }
}