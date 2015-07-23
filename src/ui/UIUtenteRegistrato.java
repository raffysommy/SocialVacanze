package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import corebusiness.pianiVacanze.GestorePianiVacanze;
import corebusiness.pianiVacanze.PianoVacanza;
import corebusiness.pianiVacanze.Porto;
import corebusiness.pianiVacanze.exception.PortoNotFound;
import dao.Porto_DAO;
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
    	getListaPorti();
    	System.out.println("Digita l'ID del Porto Corrispondente");
        Integer i = getFormattedInteger();
        Porto portodipartenza=SelezionaPorto(i);
        if(portodipartenza==null){
        	return;
        }
        Date datadipartenza=SelezionaData();
        if(datadipartenza==null){
        	return;
        }
        System.out.println("Hai Scelto di partire in data "+ datadipartenza.toString()+ " Dal Porto di "+portodipartenza.getNome());
        GestorePianiVacanze gestore=GestorePianiVacanze.getistance();
        ArrayList<PianoVacanza> listapiani = gestore.RicercaVacanza(datadipartenza, portodipartenza);
        System.out.println("Trovati "+ listapiani.size()+" Piani Vacanze Disponibili");
        for(int j=0;j<listapiani.size();j++){
        	PianoVacanza piano=listapiani.get(j);
        	System.out.println("Piano Vacanza ID:"+piano.getIDPianoVacanza()+" Data Partenza: "+ piano.getDataPartenza().toString()+" Data Arrivo: " + piano.getDataArrivo().toString() + " Costo: "+piano.getCosto()+" Porto Partenza: " + piano.getPortoPartenza().getNome()+ " Porto Arrivo: " + piano.getPortoArrivo().getNome() );
        }
    }

    /**
     * 
     */
    public void getListaPorti() {
        System.out.println("Scegli il porto di partenza da questa lista");
        GestorePianiVacanze gestore=GestorePianiVacanze.getistance();
        ArrayList<Porto> listaporti = gestore.ListaPorti();
        for(int i=0;i<listaporti.size();i++){
        	System.out.println("ID: "+listaporti.get(i).getIDPorto()+" Nome: "+listaporti.get(i).getNome());
        }
    }

    /**
     * @return 
     * 
     */
    public Porto SelezionaPorto(Integer i) {
        try {
        	return GestorePianiVacanze.getistance().getPorto(i);
		} catch (PortoNotFound e) {
			// TODO Auto-generated catch block
			e.printErrorMessage();
		}
		return null;
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
		return Integer.MAX_VALUE;
    }
    /**
     * @return 
     * 
     */
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
    	if(year<=0 || month<1 || month>12 || day<=0 || day>31){
    		System.err.println("Valori Invalidi per La Data");
    		return null;
    	}
    	return new java.sql.Date(year-1900, month-1, day);
    }

}
