package model.exceptions;
	
	//Excess�es personalizadas
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
		//Fiz isto pois assim eu permito que eu possa instanciar minha excess�o personaliazda
		//passando uma mensagem para ela
	}

}
