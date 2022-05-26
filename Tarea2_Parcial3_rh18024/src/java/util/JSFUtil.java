package util;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JSFUtil {
    public static void addGlobalErrorMessage(String message) {
        FacesContext conteXt = FacesContext.getCurrentInstance();
        conteXt.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message,"ERROR"));
    }
    
    public static void addGlobalMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message,"Info"));
    }
}
