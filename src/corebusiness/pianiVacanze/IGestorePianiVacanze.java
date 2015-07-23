/**
 * 
 */
package corebusiness.pianiVacanze;

import java.util.ArrayList;
import java.util.Date;

import corebusiness.pianiVacanze.exception.PortoNotFound;

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
    public ArrayList<Porto> ListaPorti();
    /**
     * @param D 
     * @param P 
     * @return
     */
    public ArrayList<PianoVacanza> RicercaVacanza(Date D, Porto P);
    public Porto getPorto(Integer id) throws PortoNotFound;
}
