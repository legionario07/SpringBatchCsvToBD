package br.com.dmsexpurgo.model;

import java.io.Serializable;

public class FileGeneratedContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	//@Id
	private String invoiceId;
	
	//@Id 
	private Long customerId;
	
	//@Column 
	private String type;
	
	//@Column
	private String csId;
	
	//@Column
	private Long generatedId;
	
	//@Column
	private String isUnlimitedServices;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public Long getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(Long generatedId) {
		this.generatedId = generatedId;
	}

	public String getIsUnlimitedServices() {
		return isUnlimitedServices;
	}

	public void setIsUnlimitedServices(String isUnlimitedServices) {
		this.isUnlimitedServices = isUnlimitedServices;
	}

	@Override
	public String toString() {
		return "FileGeneratedContent [invoiceId=" + invoiceId + ", isUnlimitedServices=" + isUnlimitedServices + "]";
	}

}
