/**
 * 
 */
package corebusiness.pianiVacanze;

import java.util.ArrayList;
import java.util.Date;

import corebusiness.barche.Barca;

/**
 * @author Raffaele
 *
 */
public class PianoVacanza {


    /**
     * 
     */
    private Integer IDPianoVacanza;

    /**
	 * @param iDPianoVacanza
	 * @param dataPartenza
	 * @param numeroMassimo
	 * @param costo
	 * @param dataArrivo
	 * @param barche
	 * @param portoPartenza
	 * @param portoArrivo
	 */
	public PianoVacanza(Integer iDPianoVacanza, Date dataPartenza, Integer numeroMassimo, Integer costo,
			Date dataArrivo, Barca barca, Porto portoPartenza, Porto portoArrivo) {
		super();
		this.IDPianoVacanza = iDPianoVacanza;
		this.DataPartenza = dataPartenza;
		this.NumeroMassimo = numeroMassimo;
		this.Costo = costo;
		this.DataArrivo = dataArrivo;
		this.barca = barca;
		this.PortoPartenza = portoPartenza;
		this.PortoArrivo = portoArrivo;
	}

	public PianoVacanza(Integer iDPianoVacanza){
		this.IDPianoVacanza=iDPianoVacanza;
	}

	/**
     * 
     */
    private Date DataPartenza;

    /**
     * 
     */
    private Integer NumeroMassimo;

    /**
     * 
     */
    private Integer Costo;

    /**
     * 
     */
    private Date DataArrivo;


    private Barca barca;
    
    private Porto PortoPartenza;
    private Porto PortoArrivo;




    /**
     * @return
     */
    public Integer calcolaPostiDisponibili() {
        // TODO implement here
        return null;
    }




	/**
	 * @return the iDPianoVacanza
	 */
	public Integer getIDPianoVacanza() {
		return IDPianoVacanza;
	}




	/**
	 * @param iDPianoVacanza the iDPianoVacanza to set
	 */
	public void setIDPianoVacanza(Integer iDPianoVacanza) {
		IDPianoVacanza = iDPianoVacanza;
	}




	/**
	 * @return the dataPartenza
	 */
	public Date getDataPartenza() {
		return DataPartenza;
	}




	/**
	 * @param dataPartenza the dataPartenza to set
	 */
	public void setDataPartenza(Date dataPartenza) {
		DataPartenza = dataPartenza;
	}




	/**
	 * @return the numeroMassimo
	 */
	public Integer getNumeroMassimo() {
		return NumeroMassimo;
	}




	/**
	 * @param numeroMassimo the numeroMassimo to set
	 */
	public void setNumeroMassimo(Integer numeroMassimo) {
		NumeroMassimo = numeroMassimo;
	}




	/**
	 * @return the costo
	 */
	public Integer getCosto() {
		return Costo;
	}




	/**
	 * @param costo the costo to set
	 */
	public void setCosto(Integer costo) {
		Costo = costo;
	}




	/**
	 * @return the dataArrivo
	 */
	public Date getDataArrivo() {
		return DataArrivo;
	}




	/**
	 * @param dataArrivo the dataArrivo to set
	 */
	public void setDataArrivo(Date dataArrivo) {
		DataArrivo = dataArrivo;
	}






	/**
	 * @return the portoPartenza
	 */
	public Porto getPortoPartenza() {
		return PortoPartenza;
	}




	/**
	 * @param portoPartenza the portoPartenza to set
	 */
	public void setPortoPartenza(Porto portoPartenza) {
		PortoPartenza = portoPartenza;
	}




	/**
	 * @return the portoArrivo
	 */
	public Porto getPortoArrivo() {
		return PortoArrivo;
	}




	/**
	 * @param portoArrivo the portoArrivo to set
	 */
	public void setPortoArrivo(Porto portoArrivo) {
		PortoArrivo = portoArrivo;
	}

	/**
	 * @return the barca
	 */
	public Barca getBarca() {
		return barca;
	}

	/**
	 * @param barca the barca to set
	 */
	public void setBarca(Barca barca) {
		this.barca = barca;
	}

}
