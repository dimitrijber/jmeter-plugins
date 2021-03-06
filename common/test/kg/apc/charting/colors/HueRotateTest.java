package kg.apc.charting.colors;

import kg.apc.charting.ColorsDispatcher;
import kg.apc.charting.ColorsDispatcherFactory;
import org.apache.jmeter.util.JMeterUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.awt.*;
import java.io.*;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { JMeterUtils.class })
public class HueRotateTest {

    /**
     *
     */
    public HueRotateTest() {
    }

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass()
            throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass()
            throws Exception {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test factory retrieves huerotate with null options
     */
    @Test
    public void testFactoryNullPaletteNull() {
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn(null);
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        PowerMockito.verifyStatic();
        assertEquals("HueRotatePalette", instance.getClass().getSimpleName());
    }

    /**
     * Test factory retrieves huerotate with empty options
     */
    @Test
    public void testFactoryEmptyPaletteEmpty() {
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("");
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        PowerMockito.verifyStatic();
        assertEquals("HueRotatePalette", instance.getClass().getSimpleName());
    }

    /**
     * Test factory retrieves huerotate with partial options
     */
    @Test
    public void testFactoryEmptyPalettePartial1() {
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("9C27B0");
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        PowerMockito.verifyStatic();
        assertEquals("HueRotatePalette", instance.getClass().getSimpleName());
    }

    /**
     * Test factory retrieves huerotate with partial options
     */
    @Test
    public void testFactoryEmptyPalettePartial2() {
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("9C27B0,8");
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        PowerMockito.verifyStatic();
        assertEquals("HueRotatePalette", instance.getClass().getSimpleName());
    }

    /**
     * Test of getNextColor method, of class ColorsDispatcher.
     */
    @Test
    public void testGetNextColor() {
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("9C27B0,8,4");
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        PowerMockito.verifyStatic();
        for (int n = 0; n < 2000; n++) {
            Color c = instance.getNextColor();
            System.out.println(c);
            assertNotNull(c);
        }
    }

    /**
     * Test of reset method, of class ColorsDispatcher.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        mockStatic(JMeterUtils.class);
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
        when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("9C27B0,8,4");
        ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
        Color first = instance.getNextColor();
        assertNotNull(first);
        instance.getNextColor();
        instance.getNextColor();
        instance.reset();
        assertEquals(first, instance.getNextColor());
    }

    /**
     * Test that the object is serializable
     */
    @Test
    public void testSerialization() {
        try {
            mockStatic(JMeterUtils.class);
            when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher")).thenReturn("huerotate");
            when(JMeterUtils.getProperty("jmeterPlugin.customColorsDispatcher.options")).thenReturn("9C27B0,8,4");
            ColorsDispatcher instance = ColorsDispatcherFactory.getColorsDispatcher();
            new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(instance);
            assertTrue(true);
        } catch (IOException e) {
            fail(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
