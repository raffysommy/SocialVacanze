package corebusiness.pianiVacanze;

public class Porto {
	/**
     * 
     */
	private Integer IDPorto;
	/**
     * 
     */
	private String Nome;
	/**
	 * @param iDPorto
	 * @param nome
	 */
	public Porto(Integer iDPorto, String nome) {
		IDPorto = iDPorto;
		Nome = nome;
	}
	public Porto(Integer iDPorto2) {
		this.IDPorto=iDPorto2;
	}
	/**
	 * @return the iDPorto
	 */
	public Integer getIDPorto() {
		return IDPorto;
	}
	/**
	 * @param iDPorto the iDPorto to set
	 */
	public void setIDPorto(Integer iDPorto) {
		IDPorto = iDPorto;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return Nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		Nome = nome;
	}

}
