package monopoly;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pola.Pole;
import pola.PoleDworzec;
import pola.PoleIdzDoWiezienia;
import pola.PolePodatek;
import pola.PoleSpecjalne;
import pola.PoleSzansa;
import pola.PoleUlica;
import pola.PoleUzytecznosciPublicznej;
import util.Ustawienia;
import wyjatki.BoardCreatingException;

/**
 * Plansza do gry. Plansza składa się z 40 pól.
 */
public class Plansza {
	private Pole[] plansza;

	/**
	 * Tworzy planszę na podstawie pliku xml, którego nazwa znajduje się w
	 * {@link util.Ustawienia#plikPlansza}. Metoda wykorzystuje parser DOM do
	 * obsługi pliku.
	 *
	 * @throws BoardCreatingException
	 *             jeżeli utworzenie planszy się nie powiodło
	 */
	public Plansza() throws BoardCreatingException {
		plansza = new Pole[40];

		try {
			File inputFile = new File(Ustawienia.plikPlansza);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// wczytanie pol specjalnych
			NodeList nList = doc.getElementsByTagName("poleSpecjalne");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					plansza[indeks] = new PoleSpecjalne(nazwa);

					// System.out.println(indeks + " " + nazwa);
				}
			}

			// wczytanie pol szansza
			nList = doc.getElementsByTagName("poleSzansa");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					plansza[indeks] = new PoleSzansa(nazwa);

					// System.out.println(indeks + " " + nazwa);
				}
			}

			// wczytanie pol dworzec
			nList = doc.getElementsByTagName("poleDworzec");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					int cena = Integer.parseInt(eElement.getElementsByTagName("cena").item(0).getTextContent());
					plansza[indeks] = new PoleDworzec(nazwa, cena);

					// System.out.println(indeks + " " + nazwa);
				}
			}

			// wczytanie pol Ulica
			nList = doc.getElementsByTagName("poleUlica");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					int[] tablicaCzynszy = new int[6];
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();

					int cena = Integer.parseInt(eElement.getElementsByTagName("cena").item(0).getTextContent());
					tablicaCzynszy[0] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz0").item(0).getTextContent());
					tablicaCzynszy[1] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz1").item(0).getTextContent());
					tablicaCzynszy[2] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz2").item(0).getTextContent());
					tablicaCzynszy[3] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz3").item(0).getTextContent());
					tablicaCzynszy[4] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz4").item(0).getTextContent());
					tablicaCzynszy[5] = Integer
							.parseInt(eElement.getElementsByTagName("czynsz5").item(0).getTextContent());
					int cenaDomu = Integer.parseInt(eElement.getElementsByTagName("cenaDomu").item(0).getTextContent());
					plansza[indeks] = new PoleUlica(nazwa, cena, tablicaCzynszy, cenaDomu);

					/*
					 * System.out.println(indeks + " " + nazwa + " " + cenaDomu
					 * + " " + tablicaCzynszy[0] + " " + tablicaCzynszy[1] + " "
					 * + tablicaCzynszy[2] + " " + tablicaCzynszy[3] + " " +
					 * tablicaCzynszy[4] + " " + tablicaCzynszy[5]);
					 */
				}
			}

			// wczytanie pol podatek
			nList = doc.getElementsByTagName("polePodatek");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					int kwotaPodatku = Integer
							.parseInt(eElement.getElementsByTagName("kwotaPodatku").item(0).getTextContent());
					plansza[indeks] = new PolePodatek(nazwa, kwotaPodatku);

					// System.out.println(indeks + " " + nazwa);
				}
			}

			// wczytanie pol uzytecznosci publicznej
			nList = doc.getElementsByTagName("poleUzytecznosciPublicznej");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					int cena = Integer.parseInt(eElement.getElementsByTagName("cena").item(0).getTextContent());
					plansza[indeks] = new PoleUzytecznosciPublicznej(nazwa, cena);

					// System.out.println(indeks + " " + nazwa);
				}
			}

			// wczytanie pol idz do wiezienia
			nList = doc.getElementsByTagName("poleIdzDoWiezienia");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int indeks = Integer.parseInt(eElement.getAttribute("id"));
					String nazwa = eElement.getElementsByTagName("nazwa").item(0).getTextContent();
					plansza[indeks] = new PoleIdzDoWiezienia(nazwa);

					// System.out.println(indeks + " " + nazwa);
				}
			}

		} catch (Exception e) {
			throw new BoardCreatingException("Błąd tworzenia planszy");
		}
	}

	/**
	 * Zwraca pole planszy o zadanym indeksie.
	 * 
	 * @param indeks
	 *            indeks pola, ktore ma zwrócić metoda
	 * @return pole o zadanym indeksie
	 */
	public Pole getPole(int indeks) {
		if (indeks < 40)
			return plansza[indeks];
		else
			throw new IllegalArgumentException("Indeks większy od rozmiaru planszy");
	}
}
