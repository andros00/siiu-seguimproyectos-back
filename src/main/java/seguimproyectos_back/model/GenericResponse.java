package seguimproyectos_back.model;

import java.io.Serializable;


public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Object data;

	public GenericResponse() {
		super();
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Set Success Response
	 */
	public void setSuccessResponse() {
		this.code = "200";
		this.message = "OK";
	}

	/**
	 * Set Error Response
	 */
	public void setErrorResponse() {
		this.code = "400";
		this.message = "400";
	}

}
