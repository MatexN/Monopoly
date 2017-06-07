package karty;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.Ustawienia;
import wyjatki.BoardCreatingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Talia kart Szanasa, z której losowane bêd¹ karty po wejœciu na pole Szansa.
 */
public class TaliaKartSzansa {
	/**
	 * Lista kart w talii. Talia zawiera karty typu IdzDo,
	 * IdzDoWiezienia,Pieniadze
	 */
	private List<KartaSzansa> talia;
	private static TaliaKartSzansa instance;

	/**
	 * Prywatny konstruktor klasy. Generuje karty zawarte w talii. Iloœæ kart
	 * jest okreœlona przez odpowiadaj¹ce im pola w pliku Ustawienia.java
	 * Wykorzystuje parser DOM.
	 *
	 * @throws BoardCreatingException
	 *             jezeli utworzenie talii kart sie nie powiodlo
	 */
	private TaliaKartSzansa() throws BoardCreatingException {
		this.talia = new LinkedList<>();

		// dodanie kart typu Idz do
		for (int i = 0; i < Ustawienia.iloscSzansaIdzDo; i++)
			talia.add(new SzansaIdzDo());
		// dodanie kart typu Idz do wiezienia
		for (int i = 0; i < Ustawienia.iloscSzansaDoWiezienia; i++)
			talia.add(new SzansaIdzDoWiezienia());

		// wczytanie kart typu Pieniadze z pliku
		try {
			File inputFile = new File(Ustawienia.plikKartSzansa);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("kartaSzansaKwota");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String tekst = eElement.getElementsByTagName("opis").item(0).getTextContent();
					int kwota = Integer.parseInt(eElement.getElementsByTagName("kwota").item(0).getTextContent());
					talia.add(new SzansaPieniadze(kwota, tekst));
				}
			}
		} catch (Exception e) {
			throw new BoardCreatingException("B³¹d generowania kart szansy");
		}
	}

	/**
	 * Metoda losuje i zwraca jedn¹ kartê z talii. Korzysta z prywantej
	 * instancji klasy, je¿eli instancja nie istnieje to jest tworzona.
	 *
	 * @return wylosowana karta
	 * @throws BoardCreatingException
	 * 		je¿eli wyst¹pi³ b³¹t przy tworzeniu Talii kart.
	 */
	public static KartaSzansa LosujKarte() throws BoardCreatingException {
		if (instance == null) {
			TaliaKartSzansa.instance = new TaliaKartSzansa();
		}

		int indeks = (int) (Math.random() * instance.talia.size());
		KartaSzansa wylosowanaKarta = instance.talia.get(indeks);
		return wylosowanaKarta;
	}
}