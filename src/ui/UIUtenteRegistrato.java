package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import corebusiness.pianiVacanze.GestorePianiVacanze;
import corebusiness.pianiVacanze.PianoVacanza;
import corebusiness.pianiVacanze.Porto;
public class UIUtenteRegistrato {
	/**
     * 
     */
    public UIUtenteRegistrato() {
    	
    }

    /**
     * 
     */
    public void RicercaPianoVacanze() {    	
        Porto portodipartenza=SelezionaPorto();
        Date datadipartenza=SelezionaData();
        System.out.println("Hai Scelto di partire in data "+ datadipartenza.toString()+ " Dal Porto di "+portodipartenza.getNome());
        GestorePianiVacanze gestore=GestorePianiVacanze.getistance();
        ArrayList<PianoVacanza> listapiani = gestore.RicercaVacanza(datadipartenza, portodipartenza);
        System.out.println("Trovati "+ listapiani.size()+" Piani Vacanze Disponibili");
        for(int i=0;i<listapiani.size();i++){
        	PianoVacanza piano=listapiani.get(i);
        	System.out.println("Piano Vacanza ID:"+piano.getIDPianoVacanza()+" Data Partenza: "+ piano.getDataPartenza().toString()+" Data Arrivo: " + piano.getDataArrivo().toString() + " Costo: "+piano.getCosto()+" Porto Partenza: " + piano.getPortoPartenza().getNome()+ " Porto Arrivo: " + piano.getPortoArrivo().getNome() );
        }
    }

    /**
     * 
     */
    public void getListaPorti() {
        // TODO implement here
    }

    /**
     * @return 
     * 
     */
    public Porto SelezionaPorto() {
        System.out.println("Scegli il porto di partenza da questa lista");
        GestorePianiVacanze gestore=GestorePianiVacanze.getistance();
        ArrayList<Porto> listaporti = gestore.ListaPorti();
        for(int i=0;i<listaporti.size();i++){
        	System.out.println(i+" Nome: "+listaporti.get(i).getNome());
        }
        System.out.println("Digita il numero del Porto Corrispondente");
        Integer i = getFormattedInteger();
        if(i>=listaporti.size()){
        	System.err.println("Scelta non valida");
        	SelezionaPorto();
        	return null;
        }
        else{
        	return listaporti.get(i);
        }
        	
    }
    public Integer getFormattedInteger(){
    	Integer intero=null;
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean WFI = true;
		try {
			while (WFI) {
					String bufferinput = bufferedReader.readLine();
					intero = Integer.parseInt(bufferinput);
					WFI = false;
			}
			return intero;
		} catch (NumberFormatException | IOException e) {
			System.err.println("Errore nell'inserimento del Numero");
		}
		return null;
    }
    /**
     * @return 
     * 
     */
    @SuppressWarnings("deprecation")
	public Date SelezionaData() {
    	System.out.println("Inserisci il giorno di Partenza");
    	Integer Giorno = getFormattedInteger();
    	System.out.println("Inserisci il mese di Partenza in formato decimale");
    	Integer Mese = getFormattedInteger();
    	System.out.println("Inserisci l'anno di Partenza");
    	Integer Anno=getFormattedInteger();
    	Date DataPartenza = FormattaData(Anno,Mese,Giorno);
    	return DataPartenza;
    }
    public Date FormattaData(Integer year,Integer month,Integer day) {
       	Calendar cal = GregorianCalendar.getInstance();
    	cal.set(year, month-1, day);
    	//return cal.getTime();
    	return new java.sql.Date(year-1900, month-1, day);
    }

}
