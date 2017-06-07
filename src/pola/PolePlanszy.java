package pola;

import util.Ustawienia;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Element graficzny - pojedyncze pole na planszy.
 */
public class PolePlanszy extends JPanel
{
	/**
	 * Domyœlny numer seryjny.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * parametry pola planszy potrzebne do narysowania planszy.
	 */
	private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage background;
    boolean czyPionek1;
    boolean czyPionek2;
    boolean czyPionek3;
    boolean czyPionek4;

    /**
     * Tworzy pole w zadanym miejscu planszy, o podanych rozmiarach i tle.
     * @param x wspó³rzêdna x pola
     * @param y wspó³rzêdna y pola
     * @param width szerokoœæ pola
     * @param height wysokoœæ pola
     * @param background obraz wyœwietlany jako t³o
     */
    public PolePlanszy(int x, int y, int width, int height, BufferedImage background)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.background = background;
        this.czyPionek1 = false;
        this.setBounds(x, y, width, height);
        this.czyPionek1 = this.czyPionek2 = this.czyPionek3 = this.czyPionek4 = false;
    }

    /**
     * Metoda rysuj¹ca pola planszy.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        if (this.czyPionek1)
        {
            g.setColor(Ustawienia.koloryGraczy[0]);
            g.fillOval(0, 0, 12, 12);
            g.setColor(Color.white);
            g.drawOval(3, 3, 6, 6);
        }
        if (this.czyPionek2)
        {
            g.setColor(Ustawienia.koloryGraczy[1]);
            g.fillOval(12, 0, 12, 12);
            g.setColor(Color.white);
            g.drawOval(15, 3, 6, 6);
        }
        if (this.czyPionek3)
        {
            g.setColor(Ustawienia.koloryGraczy[2]);
            g.fillOval(24, 0, 12, 12);
            g.setColor(Color.white);
            g.drawOval(27, 3, 6, 6);
        }
        if (this.czyPionek4)
        {
            g.setColor(Ustawienia.koloryGraczy[3]);
            g.fillOval(36, 0, 12, 12);
            g.setColor(Color.white);
            g.drawOval(39, 3, 6, 6);
        }
    }

    /**
     * Rysuje pionek danego gracza na polu.
     * @param ktoryGracz który pionek narysowaæ
     */
    public void wyswietlPionek(int ktoryGracz)
    {
        switch (ktoryGracz)
        {
            case 0:
                this.czyPionek1 = true;
                break;
            case 1:
                this.czyPionek2 = true;
                break;
            case 2:
                this.czyPionek3 = true;
                break;
            case 3:
                this.czyPionek4 = true;
                break;
        }
        this.repaint();
    }

    /**
     * Usuwa pionek danego gracza z pola.
     *
     * @param ktoryGracz który pionek usun¹æ
     */
    public void skasujPionek(int ktoryGracz)
    {
        switch (ktoryGracz)
        {
            case 0:
                this.czyPionek1 = false;
                break;
            case 1:
                this.czyPionek2 = false;
                break;
            case 2:
                this.czyPionek3 = false;
                break;
            case 3:
                this.czyPionek4 = false;
                break;
        }
        this.repaint();
    }
}
