package csp;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ViewScoped
public class Csp implements Serializable {

    private boolean cspEnabled;
    private String userSuppliedInput;

    public Csp() {
//        cspEnabled = PrimeApplicationContext.getCurrentInstance(FacesContext.getCurrentInstance()).getConfig().isCsp();
        cspEnabled = true;
        userSuppliedInput = "<b>Huhu</b><script>window.cspScriptExecuted=true;alert('XSS');</script>";
    }

    public void check() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Success", "PASS"));
    }

    public String getUserSuppliedInput() {
        return userSuppliedInput;
    }

    public void setUserSuppliedInput(String userSuppliedInput) {
        this.userSuppliedInput = userSuppliedInput;
    }

    public boolean isCspEnabled() {
        return cspEnabled;
    }

    public void executeScript() {
//        PrimeFaces.current().executeScript("alert('PASS');");
    }
}
