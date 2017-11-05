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
    public void konstruktoriNegatiivinen(){
        Varasto varasto2 = new Varasto(-1);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test 
    public void konstruktoriTuplaNegatiivinen(){
        Varasto varasto2 = new Varasto(-1,-1);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test 
    public void konstruktoriTupla(){
        Varasto varasto2 = new Varasto(4,2);
        assertEquals(2, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(4, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test 
    public void konstruktoriTupla2(){
        Varasto varasto2 = new Varasto(1,2);
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(1, varasto2.getTilavuus(), vertailuTarkkuus);
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
    public void lisääLikaaTavaraa() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(3);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisääNegatiivinen() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void OtaNegatiivinen() {
        varasto.otaVarastosta(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }


    @Test
    public void OtaLiikaaTavaraa() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }


    @Test
    public void testToString(){
        varasto.lisaaVarastoon(2);
        assertEquals("saldo = 2.0, vielä tilaa 8.0",varasto.toString());
    }


    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

}
