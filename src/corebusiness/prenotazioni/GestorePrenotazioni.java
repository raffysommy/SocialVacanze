package corebusiness.prenotazioni;



public class GestorePrenotazioni implements IGestorePrenotazioni {

	@Override
	public void PrenotaPianoVacanze(Prenotazione P) {
		// TODO Auto-generated method stub
		
	}
	private static GestorePrenotazioni istance;
	protected GestorePrenotazioni(){};
	public static GestorePrenotazioni getistance(){
		if(istance==null){
			istance=new GestorePrenotazioni();
		}
		return istance;
	}


}
