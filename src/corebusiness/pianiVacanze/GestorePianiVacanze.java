/**
 * 
 */
package corebusiness.pianiVacanze;

import java.util.Date;




/**
 * @author Raffaele
 *
 */
public class GestorePianiVacanze implements IGestorePianiVacanze {

	@Override
	public void InserisciPianoVacanza(PianoVacanza P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificaPianoVacanza(PianoVacanza P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminaPianoVacanza(PianoVacanza P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VerificaDate(PianoVacanza P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PianoVacanza[] RicercaVacanza(Date D, Porto P) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static GestorePianiVacanze istance;
	
	protected GestorePianiVacanze(){};
	
	public static GestorePianiVacanze getistance(){
		if (istance == null) {
			GestorePianiVacanze.istance = new GestorePianiVacanze();
		}
		return istance;
	}


	
}
