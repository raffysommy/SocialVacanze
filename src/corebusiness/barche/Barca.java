package corebusiness.barche;


/**
 * 
 */
public class Barca {

    /**
     * 
     */
    public Barca() {
    }

    /**
	 * @param idBarca
	 * @param nome
	 * @param lunghezza
	 * @param targa
	 * @param numeroPosti
	 */
	public Barca(Integer idBarca, String nome, Integer lunghezza, String targa, Integer numeroPosti) {
		this.IdBarca = idBarca;
		this.Nome = nome;
		this.Lunghezza = lunghezza;
		this.Targa = targa;
		this.NumeroPosti = numeroPosti;
	}

	/**
     * 
     */
    private Integer IdBarca;

    /**
     * 
     */
    private String Nome;

    /**
     * 
     */
    private Integer Lunghezza;

    /**
     * 
     */
    private String Targa;

    /**
     * 
     */
    private Integer NumeroPosti;

	/**
	 * @return the idBarca
	 */
	public Integer getIdBarca() {
		return IdBarca;
	}

	/**
	 * @param idBarca the idBarca to set
	 */
	public void setIdBarca(Integer idBarca) {
		IdBarca = idBarca;
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

	/**
	 * @return the lunghezza
	 */
	public Integer getLunghezza() {
		return Lunghezza;
	}

	/**
	 * @param lunghezza the lunghezza to set
	 */
	public void setLunghezza(Integer lunghezza) {
		Lunghezza = lunghezza;
	}

	/**
	 * @return the targa
	 */
	public String getTarga() {
		return Targa;
	}

	/**
	 * @param targa the targa to set
	 */
	public void setTarga(String targa) {
		Targa = targa;
	}

	/**
	 * @return the numeroPosti
	 */
	public Integer getNumeroPosti() {
		return NumeroPosti;
	}

	/**
	 * @param numeroPosti the numeroPosti to set
	 */
	public void setNumeroPosti(Integer numeroPosti) {
		NumeroPosti = numeroPosti;
	}




}

