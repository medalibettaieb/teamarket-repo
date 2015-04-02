package mBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class BasicTimerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void onTimeout() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "BOOM", null));
	}

}