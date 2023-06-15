package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DispenserTest {
	
	Dispenser dispen;
	
	@Before
	public void SetUp() {
		dispen = new Dispenser();
	}
	@Test
	//verificando se o selecionado realmente tem VAL== 50
	public void deveriaRetornarPrecoTest() {
		assertEquals(50, dispen.dispense(50, 1));
	}
	@Test
	//pegando um produto indisponivel no estoque, esperamos um False
	public void deveriaRetornarFalseAvaliableTest() {
		assertFalse(dispen.available(20));
	}
}
