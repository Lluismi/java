package Enz
/Enzilium/
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		ricknillos = new TokenContract(rick);
		ricknillos.setTotalSupply(90);
		ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
		ricknillos.setName("Mis entradillas");
		ricknillos.setSymbol("POG");

		assertEquals(1, ricknillos.numOwners());
	}

	@Test
	public void toStringTest() {
		System.out.println(ricknillos.toString());
	}

	@Test
	public void balanceOfTest() {
		double delta = 0.001;
		assertEquals(90, ricknillos.balanceOf(rick.getPK()), delta);
	}

	@Test
	public void balanceOfTestWithNoOwner() {
		double delta = 0.001;
		assertEquals(0, ricknillos.balanceOf(morty.getPK()), delta);
	}

	@Test
	public void transferTest() {
		double delta = 0.001;
		ricknillos.transfer(morty.getPK(), 5d);
		assertEquals(5, ricknillos.balanceOf(morty.getPK()), delta);
		assertEquals(85, ricknillos.balanceOf(rick.getPK()), delta);
	}

	@Test
	public void transferTestFallaPorRequire() {
		morty.generateKeyPair();
		double delta = 0.001;
		ricknillos.transfer(morty.getPK(), 200d);
		assertEquals(0, ricknillos.balanceOf(morty.getPK()), delta);
	}

	@Test
	public void transferTestCon3Argumentos() {
		double delta = 0.001;
		ricknillos.transfer(rick.getPK(), morty.getPK(), 80d);
		assertEquals(80, ricknillos.balanceOf(morty.getPK()), delta);
		assertEquals(10, ricknillos.balanceOf(rick.getPK()), delta);
	}

	@Test
	public void ownersAndTotalTokenSellTest() {
		double delta = 0.001;
		ricknillos.transfer(rick.getPK(), morty.getPK(), 80d);
		ricknillos.transfer(rick.getPK(), lluismi.getPK(), 5d);
		ricknillos.owners();
		assertEquals(85, ricknillos.totalTokensSold(), delta);
	}
}
