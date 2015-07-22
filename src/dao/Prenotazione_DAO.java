package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import corebusiness.pianiVacanze.exception.PianoVacanzaNotFound;
import corebusiness.prenotazioni.Prenotazione;
import corebusiness.prenotazioni.exception.PrenotazioneNotFound;

public class Prenotazione_DAO {
	protected static java.util.Map<Integer,Prenotazione> restoredObjects= new java.util.HashMap<Integer,Prenotazione>();
	public static Prenotazione create(Integer IDPrenotazione) throws SQLException{
		Connection c = DBManager.getConnection();
		PreparedStatement preparedstat = c.prepareStatement("INSERT INTO Prenotazione (IDPrenotazione) VALUES (?)");
		preparedstat.setInt(1, IDPrenotazione);
		preparedstat.executeUpdate();
		preparedstat.close();
		Prenotazione prenotazion=new Prenotazione(IDPrenotazione);
		restoredObjects.put(IDPrenotazione, prenotazion);
		return prenotazion;

	}
	public static Prenotazione create() throws SQLException{
		Connection c = DBManager.getConnection();
		Statement stat = c.createStatement();
		int id;
		try {
			stat.executeUpdate("INSERT INTO Prenotazione (Nome) VALUES ('')");
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next() == false) {
				throw new SQLException("ID value was not autogenerated!");
			}
			id = rs.getInt(1);
		} finally {
			stat.close();	
		}
		
		Prenotazione prenotazion=new Prenotazione(id);
		restoredObjects.put(id, prenotazion);
		return prenotazion;

	}
	public static Prenotazione read(Integer IDPrenotazione) throws SQLException, PrenotazioneNotFound{
		if(restoredObjects.containsKey(IDPrenotazione)){
			return restoredObjects.get(IDPrenotazione);
		}
		Connection connessione=DBManager.getConnection();
		PreparedStatement preparedStatement = connessione.prepareStatement("SELECT * FROM Prenotazione WHERE IdPrenotazione=?");
		preparedStatement.setInt(1, IDPrenotazione);
		Prenotazione prenotazion = null;
		ResultSet rs= preparedStatement.executeQuery();
		if(rs.first()){
			if (!rs.wasNull()){
				try {
					prenotazion=new Prenotazione(rs.getInt("IDPrenotazione"),rs.getDate("DataPrenotazione"),rs.getInt("NumeroPasseggeri"),PianoVacanza_DAO.read(rs.getInt("PianoVacanze")),null);
				} catch (PianoVacanzaNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				restoredObjects.put(IDPrenotazione, prenotazion);
			}
		}
		else {
			throw new PrenotazioneNotFound();
		}
		rs.close();
		preparedStatement.close();
		return prenotazion;
	}
	public static void update(Prenotazione Prenotazione) throws SQLException, PrenotazioneNotFound{
		if(Prenotazione.getIDPrenotazione()==null){
			Prenotazione prenotazion = Prenotazione_DAO.create(); // Ottengo un nuovo id
			Prenotazione.setIDPrenotazione(prenotazion.getIDPrenotazione());
			restoredObjects.put(Prenotazione.getIDPrenotazione(), Prenotazione); 

		}
		Connection connessione=DBManager.getConnection();
		PreparedStatement preparedStatement=connessione.prepareStatement("UPDATE Prenotazione SET DataPrenotazione=?,NumeroPasseggeri=?,PianoVacanza=?,Utente=? WHERE IdPrenotazione=?");
		preparedStatement.setDate(1, new Date(Prenotazione.getDataPrenotazione().getTime()));
		preparedStatement.setInt(2, Prenotazione.getNumeroPasseggeri());
		preparedStatement.setInt(3, Prenotazione.getPianoVacanza().getIDPianoVacanza());
		preparedStatement.setString(4, Prenotazione.getUtente().getUsername());
		preparedStatement.setInt(5, Prenotazione.getIDPrenotazione());
		boolean rowaffected = preparedStatement.execute();
		if(!rowaffected){
			throw new PrenotazioneNotFound();
		}
		DBManager.closeConnection();
	}	
	public static void delete(Prenotazione Prenotazione) throws SQLException {
		Integer id=Prenotazione.getIDPrenotazione();
		if(id != null){
			Connection connection = DBManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Prenotazione WHERE IDPrenotazione=?");
			preparedStatement.setInt(1, Prenotazione.getIDPrenotazione());
			preparedStatement.executeUpdate();
			restoredObjects.remove(id);			
			Prenotazione.setIDPrenotazione(null);
			preparedStatement.close();
		}
	}
	public static ArrayList<Prenotazione> allread() throws SQLException{
		Connection connessione=DBManager.getConnection();
		PreparedStatement preparedStatement = connessione.prepareStatement("SELECT * FROM Prenotazione");
		ArrayList<Prenotazione> listaPrenotazione = new ArrayList<Prenotazione>();
		ResultSet rs= preparedStatement.executeQuery();
		while(rs.next()){
				try {
					listaPrenotazione.add(new Prenotazione(rs.getInt("IDPrenotazione"),rs.getDate("DataPrenotazione"),rs.getInt("NumeroPasseggeri"),PianoVacanza_DAO.read(rs.getInt("PianoVacanze")),null));
				} catch (PianoVacanzaNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		rs.close();
		preparedStatement.close();
		return listaPrenotazione;
	}
}
