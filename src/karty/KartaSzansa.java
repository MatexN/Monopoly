package karty;

import monopoly.Gracz;

/**
 * Interfejs KartaSzansa dostarcza metodę wykonywaną przez gracza
 * po wylosowaniu danej karty.
 */
public interface KartaSzansa
{
    /**
     *
     * @param gracz Osoba, która wylosowała daną kartę
     * @see SzansaIdzDo
     * @see SzansaIdzDoWiezienia
     * @see SzansaPieniadze
     */
    void WykonajCzynnosc(Gracz gracz);
}
