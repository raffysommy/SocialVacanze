/**
 * 
 */
package corebusiness.pianiVacanze;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import corebusiness.prenotazioni.GestorePrenotazioni;
import dao.PianoVacanza_DAO;
import dao.Porto_DAO;




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
	public ArrayList<PianoVacanza> RicercaVacanza(Date D, Porto P) {
		GestorePrenotazioni gestore=GestorePrenotazioni.getistance();
		ArrayList<PianoVacanza> listapiani=new ArrayList<PianoVacanza>();
		try {
			ArrayList<PianoVacanza> piano=PianoVacanza_DAO.allread();
			for(int i=0;i<piano.size();i++){
				if(piano.get(i).getDataPartenza().equals(D) && piano.get(i).getPortoPartenza().equals(P)){
					if((piano.get(i).getNumeroMassimo()-gestore.PostiPrenotatiperPiano(piano.get(i)))>0){
						listapiani.add(piano.get(i));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listapiani;
	}
	
	private static GestorePianiVacanze istance;
	
	protected GestorePianiVacanze(){};
	
	public static GestorePianiVacanze getistance(){
		if (istance == null) {
			GestorePianiVacanze.istance = new GestorePianiVacanze();
		}
		return istance;
	}

	@Override
	public ArrayList<Porto> ListaPorti() {
		try {
			return Porto_DAO.allread();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}


	
}
