package ec.gob.sri.comprobantes.modelo.reportes;

public class FormasPago {

    private String valor;
    private String formaPago;

    public FormasPago(String formaPago, String valor) {
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
}
