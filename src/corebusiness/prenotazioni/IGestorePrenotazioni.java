/**
 * 
 */
package corebusiness.prenotazioni;

import corebusiness.pianiVacanze.PianoVacanza;

/**
 * @author Raffaele
 *
 */
public interface IGestorePrenotazioni {
	/**
     * @param P
     */
    public void PrenotaPianoVacanze(Prenotazione P);
    public Integer PostiPrenotatiperPiano(PianoVacanza piano);
}
