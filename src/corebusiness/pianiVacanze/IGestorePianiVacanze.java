/**
 * 
 */
package corebusiness.pianiVacanze;

import java.util.Date;

/**
 * @author Raffaele
 *
 */
public interface IGestorePianiVacanze {

    /**
     * @param P
     */
    public void InserisciPianoVacanza(PianoVacanza P);

    /**
     * @param P
     */
    public void ModificaPianoVacanza(PianoVacanza P);

    /**
     * @param P
     */
    public void EliminaPianoVacanza(PianoVacanza P);

    /**
     * @param P
     */
    public void VerificaDate(PianoVacanza P);

    /**
     * @param D 
     * @param P 
     * @return
     */
    public PianoVacanza[] RicercaVacanza(Date D, Porto P);
}
