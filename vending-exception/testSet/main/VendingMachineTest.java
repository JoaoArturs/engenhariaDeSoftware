package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vend;
	
	@Before
	public void SetUp() {
		vend = new VendingMachine();
	}
	@Test
	public void inicializarMaquinaTest() {
		assertEquals("Inicializando currValue com 0", 0,  vend.currValue);
		assertEquals("Inicialinzando totValue com 0", 0,  vend.totValue);
		assertTrue(vend.d != null);
		assertTrue(vend.d instanceof Dispenser);
	}
	
	@Test
	public void deveriaInserir25() {
		vend.insertCoin();
		assertTrue("Guardando moeda de 25", vend.currValue==25); 
	}
	
	@Test
	//colocando 3 entradas de 25 centavos, esperamos que seja igual a 75 centavos
	public void deveriaRetornar75MoedasTest() {
		vend.insertCoin();
		vend.insertCoin();
		vend.insertCoin();
		assertTrue("Retornando o valor depositado", vend.returnCoin() == 75);
	}
	@Test
	public void deveriaZerarCurrValueTest() {
		vend.insertCoin();
		vend.insertCoin();
		vend.returnCoin();
		assertTrue("Zerando CurrValue", vend.currValue==0);
	}
	@Test
	public void deveriaAumentar50TotValueTest() {
		vend.insertCoin();
		vend.insertCoin();
		vend.vendItem(1);
		assertEquals("Depositando o valor de compra", 50, vend.totValue);
	}
}
