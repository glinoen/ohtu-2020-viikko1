package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaaLiikaa() {
        assertEquals(0, varasto.otaVarastosta(5), vertailuTarkkuus);
    }

    @Test
    public void ottaaMinus() {
        assertEquals(0, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }

    @Test
    public void lisaaLiika() {
        varasto.lisaaVarastoon(1000);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaaMinus() {
        varasto.lisaaVarastoon(-1000);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void tulostus() {
        assertEquals(varasto.toString() ,"saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu());
    }

    @Test
    public void liika() {
        varasto = new Varasto(-1);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void liika2() {
        varasto = new Varasto(-1, -1);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void okVarasto() {
        varasto = new Varasto(10, 11);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void okVarasto2() {
        varasto = new Varasto(10, 10);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

}