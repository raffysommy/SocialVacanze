/**
 * 
 */
package corebusiness.prenotazioni;

import corebusiness.pianiVacanze.PianoVacanza;
import corebusiness.pianiVacanze.exception.PianoVacanzaNotFound;
import corebusiness.pianiVacanze.exception.PortoNotFound;

/**
 * @author Raffaele
 *
 */
public interface IGestorePrenotazioni {
	/**
     * @param P
     */
    public void prenotaPianoVacanze(Prenotazione P);
    public Integer postiPrenotatiperPiano(PianoVacanza piano) throws PianoVacanzaNotFound, PortoNotFound;
}
